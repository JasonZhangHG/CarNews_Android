package com.example.carman.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.carman.R;
import com.example.carman.base.CarBaseFragment;
import com.example.carman.entity.LimitCar;
import com.example.carman.ui.activity.Find2Activity;
import com.example.carman.ui.activity.Jingx3Activity;
import com.example.carman.ui.activity.Limit2Activity;
import com.example.carman.ui.adapter.ItemLimitAdapter;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
//发现Fragment
public class CarFragment extends CarBaseFragment{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ListView LimitCarlv;
    private NetForJson netForJson;
    List<LimitCar.ResultBean> list;
    @Override
    public int initLayout() {
        return R.layout.fragment_car;

    }

    @Override
    public void initView() {
        setCenterText("发现");
        button1 = (Button)view.findViewById(R.id.button1);
        button2 = (Button)view.findViewById(R.id.button2);
        button3 = (Button)view.findViewById(R.id.button3);
        button4 = (Button)view.findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://m.46644.com/oil/?alliance=46644";
                gotoActivity(Jingx3Activity.class,url);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://m.46644.com/tianqi/?alliance=46644";
                gotoActivity(Jingx3Activity.class,url);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://wap.aidaijia.com/";
                gotoActivity(Jingx3Activity.class,url);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://m.rong360.com/express?from=sem2&utm_source=iapple123&utm_medium=cpa&utm_campaign=dh&abclass=4";
                gotoActivity(Jingx3Activity.class,url);
            }
        });

        LimitCarlv = (ListView) view.findViewById(R.id.limit_lv);
//
        LimitCarlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String city = list.get(i).getCity();
                gotoActivity(Limit2Activity.class,city);

            }
        });

    }

    @Override
    public void initData() {
        String url = "http://v.juhe.cn/xianxing/citys?key=3eea37360fcd3cb40e9ae4c40e158087";
        netForJson = new NetForJson(url, LimitCar.class, new NetCallBack<LimitCar>() {
            @Override
            public void netOk(LimitCar o) {

                //给ListView设置数据
                initListView(o);
//                Toast.makeText(HomeFragment., "联网成功了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netError() {
//                Toast.makeText(MainActivity.this, "联网失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netfinish() {

            }
        });

        netForJson.doNet();
    }
    private void initListView(LimitCar car) {
        list  = car.getResult();
        ItemLimitAdapter adapter = new ItemLimitAdapter(activity, list);
        LimitCarlv.setAdapter(adapter);


    }

}
