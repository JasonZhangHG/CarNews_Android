package com.example.carman.ui.fragment;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.carman.R;
import com.example.carman.base.CarBaseFragment;
import com.example.carman.entity.CarNews;
import com.example.carman.entity.JingNews;
import com.example.carman.ui.activity.Find2Activity;
import com.example.carman.ui.activity.Jingx3Activity;
import com.example.carman.ui.adapter.ItemFindIvAdapter;
import com.example.carman.ui.views.CustomBanner;
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
//精选Fragment
public class FindFragment extends CarBaseFragment {

    private ListView CarNewsLv;
    private NetForJson netForJson;
    List<JingNews.ResultBean.DataBean> list;
    private TwinklingRefreshLayout trlFindFragment;

    @Override
    public int initLayout() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView() {

        setCenterText("精选");
        CarNewsLv = (ListView) view.findViewById(R.id.find_lv);
        trlFindFragment = (TwinklingRefreshLayout) view.findViewById(R.id.trlFindFragment);

        getDataFromService();

        CarNewsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = list.get(i).getUrl();
                gotoActivity(Jingx3Activity.class,url);

            }
        });

        setRefresh();//下拉刷新

    }

    @Override
    public void initData() {

    }

    public void getDataFromService(){

        String url = "http://v.juhe.cn/toutiao/index?type=keji&key=9172e60ba9596f85ea6e2c1c96d41a82";
        netForJson = new NetForJson(url, JingNews.class, new NetCallBack<JingNews>() {
            @Override
            public void netOk(JingNews o) {
                initListView(o); //给ListView设置数据
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

    private void initListView(JingNews car) {
        list = car.getResult().getData();
        ItemFindIvAdapter adapter = new ItemFindIvAdapter(activity, list);
        CarNewsLv.setAdapter(adapter);
    }

    private void setRefresh(){
        ProgressLayout headerView = new ProgressLayout(getActivity());
        trlFindFragment.setHeaderView(headerView);
        trlFindFragment.setOverScrollRefreshShow(false);
        trlFindFragment.setOnRefreshListener(new RefreshListenerAdapter() {
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

}
