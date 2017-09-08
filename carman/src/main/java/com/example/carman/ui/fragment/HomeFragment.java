package com.example.carman.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.bumptech.glide.Glide;
import com.example.carman.R;
import com.example.carman.entity.CarNews;
import com.example.carman.ui.activity.Home2Activity;
import com.example.carman.ui.adapter.ItemCarnewsLvAdapter;
import com.example.carman.ui.views.CustomBanner;
import com.example.library.base.BaseFragment;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
//社区Fragment
public class HomeFragment extends BaseFragment {

    private CustomBanner<String> mBanner;
    private ListView CarNewsLv;
    private NetForJson netForJson;
    List<CarNews.ResultBean.ListBean> list;
    private TwinklingRefreshLayout trlHomeFragment;
    private  ItemCarnewsLvAdapter adapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        setCenterText("社区");

        trlHomeFragment = (TwinklingRefreshLayout) view.findViewById(R.id.trlHomeFragment);

        CarNewsLv = (ListView) view.findViewById(R.id.home_fragment_lv);

        getDataFromNet();

        CarNewsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String id = list.get(i).getId();
                String title = list.get(i).getTitle();
                String firstImg = list.get(i).getFirstImg();
                String url = list.get(i).getUrl();
                String source = list.get(i).getSource();

                Intent intent = new Intent(getActivity(), Home2Activity.class);
                intent.putExtra("id", id);
                intent.putExtra("title", title);
                intent.putExtra("firstImg", firstImg);
                intent.putExtra("url", url);
                intent.putExtra("source", source);
                startActivity(intent);
            }
        });

        setRefresh();
    }


    private void setRefresh(){

        ProgressLayout headerView = new ProgressLayout(getActivity());
        trlHomeFragment.setHeaderView(headerView);
        View exHeader = View.inflate(getActivity(),R.layout.home_fragment_baner, null);

        //添加banner作为头部 Start
        mBanner = (CustomBanner)  exHeader.findViewById(R.id.banner);
        ArrayList<String> images = new ArrayList<>();
        images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3778456200,3076998411&fm=23&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3535338527,4000198595&fm=23&gp=0.jpg");
        images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1017904219,2460650030&fm=23&gp=0.jpg");
        images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2863927798,667335035&fm=23&gp=0.jpg");
        images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3885596348,1190704919&fm=23&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1597254274,1405139366&fm=23&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3513269361,2662598514&fm=23&gp=0.jpg");
        setBean(images);
        trlHomeFragment.addFixedExHeader(exHeader);
        trlHomeFragment.setOverScrollRefreshShow(false);
        //添加banner作为头部 End

        trlHomeFragment.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getDataFromNet();
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

    @Override
    public void initData() {

    }

    public void getDataFromNet(){

        String url = "http://v.juhe.cn/weixin/query?key=c69c273cf7bf831b8cc24c33d70395ce";
        netForJson = new NetForJson(url, CarNews.class, new NetCallBack<CarNews>() {
            @Override
            public void netOk(CarNews o) {
                //给ListView设置数据
                initListView(o);

            }

            @Override
            public void netError() {

            }

            @Override
            public void netfinish() {

            }
        });

        netForJson.doNet();
    }

    private void initListView(CarNews car) {
        list  = car.getResult().getList();
        adapter = new ItemCarnewsLvAdapter(activity, list);
        CarNewsLv.setAdapter(adapter);
    }

    //设置普通指示器
    private void setBean(final ArrayList beans) {
        mBanner.setPages(new CustomBanner.ViewCreator<String>() {
            @Override
            public View createView(Context context, int position) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }

            @Override
            public void updateUI(Context context, View view, int position, String entity) {
                Glide.with(context).load(entity).into((ImageView) view);
            }
        }, beans)
                //设置指示器为普通指示器
                .setIndicatorStyle(CustomBanner.IndicatorStyle.NUMBER)
                //设置指示器的方向
                .setIndicatorGravity(CustomBanner.IndicatorGravity.RIGHT)
                //设置自动翻页
                .startTurning(5000);
    }


}
