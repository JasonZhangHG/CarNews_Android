package com.example.carman.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.carman.R;
import com.example.carman.entity.LimitCar2;
import com.example.carman.ui.adapter.ItemLimit2Adapter;
import com.example.library.base.BaseActivity;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;

import java.util.List;

public class Limit2Activity extends BaseActivity {

    private ListView CarNewsLv;
    private NetForJson netForJson;
    List<LimitCar2.ResultBean.DesBean> list;
    String city;

//    private String date;
//    private String week;
//    private String cityname;
//    private String fine;
//    private String remarks;
//    private List<Integer> xxweihao;

    private TextView limit_data;
    private TextView limit_week;
    private TextView limit_cityname;
    private TextView limit_fine;
    private TextView limit_remarks;
    private TextView limit_xxweihao1;
    private TextView limit_xxweihao2;

    @Override
    public int initLayout() {
        return R.layout.activity_limit2;
    }

    @Override
    public void initView() {
        setCenterText("限行详情");
        CarNewsLv = (ListView)findViewById(R.id.limit_listview);
        city = getIntent().getStringExtra("data");
        limit_data = (TextView) this.findViewById(R.id.limit_data_tv);
        limit_week = (TextView) this.findViewById(R.id.limit_week_tv);
        limit_cityname = (TextView) this.findViewById(R.id.limit_city_tv);
        limit_fine = (TextView) this.findViewById(R.id.limit_fine_tv);
        limit_remarks = (TextView) this.findViewById(R.id.limit_remarks_tv);
        limit_xxweihao1 = (TextView) this.findViewById(R.id.limit_xxweihao1_tv);
        limit_xxweihao2 = (TextView) this.findViewById(R.id.limit_xxweihao2_tv);



    }

    @Override
    public void initData() {
        String url = "http://v.juhe.cn/xianxing/index?key=3eea37360fcd3cb40e9ae4c40e158087&type=1&city="+city;
        netForJson = new NetForJson(url, LimitCar2.class, new NetCallBack<LimitCar2>() {
            @Override
            public void netOk(LimitCar2 o) {

                //给ListView设置数据
                initListView(o);
//                Toast.makeText(HomeFragment., "联网成功了", Toast.LENGTH_SHORT).show();

                String date = o.getResult().getDate();
                String week = o.getResult().getWeek();
                String cityname = o.getResult().getCityname();
                String fine = o.getResult().getFine();
                String remarks = o.getResult().getRemarks();
                List<Integer> xxweihao1 = o.getResult().getXxweihao();

                limit_data.setText(date);
                limit_week.setText(week);
                limit_cityname.setText(cityname);
                limit_fine.setText(fine);
                limit_remarks.setText(remarks);
                limit_xxweihao1.setText(xxweihao1.get(0).toString());
                limit_xxweihao2.setText(xxweihao1.get(1).toString());
//                limit_xxweihao1.setText();

//                String[] a = new String[xxweihao1.size()];
//                a = (String[]) xxweihao1.toArray(a);
//
//                Log.e("xxx",xxweihao1+"  ");
//                int[] d = new int[xxweihao1.size()];
//                for(int i = 0;i<xxweihao1.size();i++){
//                    d[i] = xxweihao1.get(i);
//                    Log.e("xxx",d[i]+"  ");
//
//                }

//                Object[] tObject =  null ;
//
//                for(Object obj1:xxweihao1){
//
//                    tObject = (Object[])obj1;
//
//                    Log.e("xxx",obj1+"  ");
//                }
//
//                for (int i=0 ; i < tObject.length ; i++){
//
//                    Integer tInteger = Integer.parseInt(tObject[i].toString()) ;
//                    if (i == 0){
//                        limit_xxweihao1.setText(tInteger);
//                    }
//
//                    if(i == 1){
//                        limit_xxweihao2.setText(tInteger);
//                    }
//
//                }
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

    private void initListView(LimitCar2 car) {
        list  = car.getResult().getDes();
        ItemLimit2Adapter adapter = new ItemLimit2Adapter(this, list);
        CarNewsLv.setAdapter(adapter);



    }
}
