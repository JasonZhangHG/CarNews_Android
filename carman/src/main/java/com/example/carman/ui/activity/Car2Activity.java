package com.example.carman.ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carman.R;
import com.example.carman.base.CarBaseActivity;
import com.example.carman.entity.CarTypes;
import com.example.carman.entity.CarsListEntity;
import com.example.carman.ui.adapter.ItemMainLvAdapter;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;

import java.util.ArrayList;
import java.util.List;

public class Car2Activity extends CarBaseActivity {
    private ListView CarLv;
    private NetForJson netForJson;
    private String id1;
    private ListView lv;
    List<CarsListEntity.ResultBean> carResult;
    @Override
    public int initLayout() {
        return R.layout.activity_car2;
    }

    @Override
    public void initView() {
        id1 = getIntent().getStringExtra("id");
        lv = (ListView) this.findViewById(R.id.car2_content_lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                CarsListEntity.ResultBean resultBean = carResult.get(i);
//                Log.e("xxx",resultBean.toString()+"---------->");
                Intent intent = new Intent(Car2Activity.this, Car3Activity.class);
                intent.putExtra("data",resultBean);
                startActivity(intent);

            }
        });


    }



    @Override
    public void initData() {
        String url = "http://api.jisuapi.com/car/carlist?appkey=df82b49ccf8503fc&parentid="+id1;
        netForJson= new NetForJson(url, CarsListEntity.class, new NetCallBack<CarsListEntity>() {
            @Override
            public void netOk(CarsListEntity carsListEntity) {

                //给ListView设置数据
                initListView(carsListEntity);
                Toast.makeText(Car2Activity.this, "联网成功了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netError() {
                Toast.makeText(Car2Activity.this, "联网失败了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void netfinish() {

            }
        });

        netForJson.doNet();
    }

    private void initListView(CarsListEntity carsListEntity) {
         carResult = carsListEntity.getResult();
        Log.e("xxx",carResult.size()+"---->");
        ArrayList<String> strings = new ArrayList<>();
        for (CarsListEntity.ResultBean resultBean : carResult) {
            strings.add(resultBean.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        lv.setAdapter(adapter);


    }
}
