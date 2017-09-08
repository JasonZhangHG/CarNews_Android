package com.example.carman.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.carman.ui.adapter.ItemCar3LvAdapter;
import com.example.library.net.NetCallBack;
import com.example.library.net.NetForJson;

import java.util.ArrayList;
import java.util.List;

public class Car3Activity extends CarBaseActivity {

    private NetForJson netForJson;
    private String id1;
    private ListView lv;

    @Override
    public int initLayout() {
        return R.layout.activity_car3;
    }

    @Override
    public void initView() {
        setCenterText("车型");
        Intent intent = getIntent();
        CarsListEntity.ResultBean resultBean = (CarsListEntity.ResultBean) intent.getSerializableExtra("data");
        List<CarsListEntity.ResultBean.CarlistBean> carlist = resultBean.getCarlist();
        lv = (ListView) this.findViewById(R.id.car3_content_lv);
        ItemCar3LvAdapter adapter = new ItemCar3LvAdapter(this, carlist);
        lv.setAdapter(adapter);


    }

    @Override
    public void initData() {

    }
}
