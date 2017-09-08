package com.example.carman.ui.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import com.example.carman.R;
import com.example.carman.db.ConstKey;
import com.example.carman.db.DBSheQuBean;
import com.example.carman.db.DBSheQuBeanUtils;
import com.example.carman.db.MediaUpdateEvent;
import com.example.carman.db.RxBus;
import com.example.library.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;
import rx.functions.Action1;

public class Home2Activity extends BaseActivity {
    private WebView webView;
    private Button btnHome2ActivitySave;

    private String userName;//当前用户名字
    private  String id ;
    private  String title ;
    private  String firstImg ;
    private  String url ;
    private  String source;
    private int state = 1;
    private  boolean isSave = false;;
    private Subscription rxSubscription;
    private List<DBSheQuBean> dbSheQuBeanList = new ArrayList<>();

    @Override
    public int initLayout() {
        return R.layout.activity_home2;
    }

    @Override
    public void initView() {
        webView = (WebView)findViewById(R.id.web_view);
        btnHome2ActivitySave = (Button) findViewById(R.id.btnHome2ActivitySave);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        SharedPreferences pref = getSharedPreferences(ConstKey.KEY_WIFI_REMIND_Shared_Preference,MODE_PRIVATE);
        userName = pref.getString(ConstKey.KEY_SAVE_USER_NAME, "");

        Log.i("aaa","Home2 用户名为："+userName);

        // 获取传过来的数据 start
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        firstImg = getIntent().getStringExtra("firstImg");
        url = getIntent().getStringExtra("url");
        source = getIntent().getStringExtra("source");
        // 获取传过来的数据 end

        dbSheQuBeanList = DBSheQuBeanUtils.getInstance().queryDataDependInfoURl(url);

        if (dbSheQuBeanList!=null&&dbSheQuBeanList.size()>0){
            for (int i=0;i<dbSheQuBeanList.size();i++){
                if (dbSheQuBeanList.get(i).getUserName().equals(userName)){
                    isSave = true;
                }
            }
            if (isSave){
                btnHome2ActivitySave.setText("点击取消收藏");
                state = 2;
            }else {
                btnHome2ActivitySave.setText("点击添加收藏");
                state = 1;
            }
        }else {
            btnHome2ActivitySave.setText("点击添加收藏");
            state = 1;
        }

        initWebView();

        btnHome2ActivitySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((TextUtils.isEmpty(userName))|| ("请登录".equals(userName))){
                    Toast.makeText(Home2Activity.this, "请登录后再收藏", Toast.LENGTH_SHORT).show();
                }else {
                    if (state == 1){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Home2Activity.this);
                        builder.setTitle("添加收藏");
                        builder.setMessage("您确定要添加收藏吗？");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                saveSheQuNewsDataToDB();
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();

                    }else if (state == 2){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Home2Activity.this);
                        builder.setTitle("取消注销");
                        builder.setMessage("您确定要取消收藏吗？");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteDataFromDB();
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                }
            }
        });

        refreshMediaUpdateEvent();

    }

    public void refreshMediaUpdateEvent() {
        rxSubscription = RxBus.getDefault()
                .toObservable(MediaUpdateEvent.class)
                .subscribe(new Action1<MediaUpdateEvent>() {
                    @Override
                    public void call(MediaUpdateEvent mediaUpdateEvent) {
                        if (ConstKey.KEY_SAVE_DATA_SUCCESS.equals(mediaUpdateEvent.getMediaUpdateEvent())) {

                            dbSheQuBeanList = DBSheQuBeanUtils.getInstance().queryDataDependInfoURl(url);

                            if (dbSheQuBeanList!=null&&dbSheQuBeanList.size()>0){
                                for (int i=0;i<dbSheQuBeanList.size();i++){
                                    if (dbSheQuBeanList.get(i).getUserName().equals(userName)){
                                        isSave = true;
                                    }
                                }
                                if (isSave){
                                    btnHome2ActivitySave.setText("点击取消收藏");
                                    state = 2;
                                }else {
                                    btnHome2ActivitySave.setText("点击添加收藏");
                                    state = 1;
                                }
                            }else {
                                btnHome2ActivitySave.setText("点击添加收藏");
                                state = 1;
                            }

                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (rxSubscription != null && !rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }

    public void initWebView(){
        webView.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings =  webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    @Override
    public void initData() {

    }


    public void saveSheQuNewsDataToDB(){
        DBSheQuBean dbSheQuBean = new  DBSheQuBean();
        dbSheQuBean.setCreatTimeAsId(getTime());
        dbSheQuBean.setId(id);
        dbSheQuBean.setTitle(title);
        dbSheQuBean.setSource(source);
        dbSheQuBean.setFirstImg(firstImg);
        dbSheQuBean.setUrl(url);
        dbSheQuBean.setUserName(userName);
        DBSheQuBeanUtils.getInstance().insertOneData(dbSheQuBean);
        isSave = true;
        RxBus.getDefault().post(new MediaUpdateEvent(ConstKey.KEY_SAVE_DATA_SUCCESS));
        Toast.makeText(Home2Activity.this, "恭喜您收藏成功", Toast.LENGTH_SHORT).show();

    }

    public long getTime() {
        return System.currentTimeMillis();//获取系统时间戳
    }

    public void deleteDataFromDB(){
        DBSheQuBeanUtils.getInstance().deleteOneData(dbSheQuBeanList.get(0));
        isSave = false;
        RxBus.getDefault().post(new MediaUpdateEvent(ConstKey.KEY_SAVE_DATA_SUCCESS));
        Toast.makeText(Home2Activity.this, "取消收藏成功", Toast.LENGTH_SHORT).show();
    }

}
