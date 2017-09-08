package com.example.carman.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.carman.R;
import com.example.carman.db.ConstKey;
import com.example.carman.entity.CarTypes;
import com.example.carman.ui.adapter.ItemMainLvAdapter;
import com.example.carman.ui.fragment.CarFragment;
import com.example.carman.ui.fragment.FindFragment;
import com.example.carman.ui.fragment.HomeFragment;
import com.example.library.base.BaseApp;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private CarFragment carFragment;
    private FindFragment findFragment;
    private HomeFragment homeFragment;
    private ListView CarLv;
    private NetForJson netForJson;
    List<CarTypes.ResultBean> carResult;
    private TwinklingRefreshLayout trlMainActivity;

    private TextView UserNametv;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editor = BaseApp.editor;
        CarLv = (ListView) findViewById(R.id.main_content_lv);
        trlMainActivity = (TwinklingRefreshLayout) findViewById(R.id.trlMainActivity);

        getDataFromService();

        CarLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String id = carResult.get(i).getId();
                Intent intent = new Intent(MainActivity.this, Car2Activity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setRefreshData();

        initData();


    }

    public void initData() {
    }

    public void getDataFromService(){

        String url = "http://api.jisuapi.com/car/brand?appkey=df82b49ccf8503fc";
        netForJson = new NetForJson(url, CarTypes.class, new NetCallBack<CarTypes>() {
            @Override
            public void netOk(CarTypes o) {

                //给ListView设置数据
                initListView(o);
                Toast.makeText(MainActivity.this, "联网成功了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netError() {
                Toast.makeText(MainActivity.this, "联网失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netfinish() {

            }
        });

        netForJson.doNet();
    }

    private void initListView(CarTypes car) {
        carResult = car.getResult();

        ItemMainLvAdapter adapter = new ItemMainLvAdapter(this, carResult);
        CarLv.setAdapter(adapter);
    }

    public void setRefreshData(){

        ProgressLayout headerView = new ProgressLayout(MainActivity.this);
        trlMainActivity.setHeaderView(headerView);
        trlMainActivity.setOverScrollRefreshShow(false);
        trlMainActivity.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getDataFromService();
                        refreshLayout.finishRefreshing();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadmore();
                    }
                }, 1000);
            }
        });
    }

    /**
     * 对侧边栏按钮进行处理，打开侧边栏
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.drawer_layout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivityForResult(intent,0);
        } else if (id == R.id.nav_about) {

            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivityForResult(intent,0);

        } else if (id == R.id.nav_collection) {
            //点击查看收藏
            SharedPreferences pref = getSharedPreferences(ConstKey.KEY_WIFI_REMIND_Shared_Preference,MODE_PRIVATE);
            String userName = pref.getString(ConstKey.KEY_SAVE_USER_NAME, "");
            if ((TextUtils.isEmpty(userName))|| ("请登录".equals(userName))){
                Toast.makeText(MainActivity.this, "请登录后再去查看收藏", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                startActivity(intent);
            }

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, shouyeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("注销");
            builder.setMessage("确定要注销吗？");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //登录成功后执行方法  接收数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UserNametv = (TextView) findViewById(R.id.UserName_tv);
        UserNametv.setText(data.getStringExtra("data"));
        editor.putString(ConstKey.KEY_SAVE_USER_NAME,data.getStringExtra("data"));//把用户名记录在SharedPreferences中
        editor.commit();
        Log.i("aaa","当前用户名为：  "+data.getStringExtra("data"));
    }

    /**
     * 对返回键进行处理，如果侧边栏打开则关闭侧边栏，否则关闭 activity
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}