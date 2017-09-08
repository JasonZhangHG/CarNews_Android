package com.example.carman.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.carman.R;
import com.example.carman.db.ConstKey;
import com.example.carman.db.DBSheQuBean;
import com.example.carman.db.DBSheQuBeanUtils;
import com.example.carman.db.DataSaveEvent;
import com.example.carman.db.RxBus;
import com.example.carman.entity.CarNews;
import com.example.library.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

//收藏页
public class CollectionActivity extends BaseActivity {

  private ListView mlvCollectionActivity;
  private String userName;//当前用户名字
  private Subscription rxSubscription;
  private List<DBSheQuBean> dbSheQuBeanList = new ArrayList<>();
  private MyKindAdapter myKindAdapter;

  @Override
  public int initLayout() {
    return R.layout.activity_collection;
  }

  @Override
  public void initView() {
    mlvCollectionActivity = (ListView) findViewById(R.id.mlvCollectionActivity);

    SharedPreferences pref = getSharedPreferences(ConstKey.KEY_WIFI_REMIND_Shared_Preference, MODE_PRIVATE);
    userName = pref.getString(ConstKey.KEY_SAVE_USER_NAME, "");

    Log.i("aaa", "CollectionActivity 用户名为：" + userName);

    dbSheQuBeanList = DBSheQuBeanUtils.getInstance().queryDataDependUserName(userName);
    if (dbSheQuBeanList != null && dbSheQuBeanList.size() == 0) {
      Toast.makeText(CollectionActivity.this, "亲，还未添加任何收藏哦", Toast.LENGTH_SHORT).show();
    } else {
      myKindAdapter = new MyKindAdapter();
      myKindAdapter.setLists(dbSheQuBeanList);
      mlvCollectionActivity.setAdapter(myKindAdapter);
    }
    refreshMediaUpdateEvent();

    setListViewClick();

  }

  @Override
  public void initData() {

  }

  public void setListViewClick(){
    mlvCollectionActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String id2 = dbSheQuBeanList.get(position).getId();
        String title = dbSheQuBeanList.get(position).getTitle();
        String firstImg = dbSheQuBeanList.get(position).getFirstImg();
        String url = dbSheQuBeanList.get(position).getUrl();
        String source = dbSheQuBeanList.get(position).getSource();

        Intent intent = new Intent(CollectionActivity.this,Home2Activity.class);
        intent.putExtra("id",id2);
        intent.putExtra("title",title);
        intent.putExtra("firstImg",firstImg);
        intent.putExtra("url",url);
        intent.putExtra("source",source);
        startActivity(intent);

      }
    });
  }

  public void refreshMediaUpdateEvent() {
    rxSubscription = RxBus.getDefault()
            .toObservable(DataSaveEvent.class)
            .subscribe(new Action1<DataSaveEvent>() {
              @Override
              public void call(DataSaveEvent dataSaveEvent) {
                if (ConstKey.KEY_SAVE_DATA_SUCCESS.equals(dataSaveEvent.getDataSaveEvent())) {
                  dbSheQuBeanList = DBSheQuBeanUtils.getInstance().queryDataDependInfoURl(userName);
                  if (dbSheQuBeanList != null && dbSheQuBeanList.size() == 0) {
                    Toast.makeText(CollectionActivity.this, "亲，还未添加任何收藏哦", Toast.LENGTH_SHORT).show();
                  } else {
                    myKindAdapter.setLists(dbSheQuBeanList);
                    mlvCollectionActivity.setAdapter(myKindAdapter);
                    myKindAdapter.notifyDataSetChanged();
                  }
                }
              }
            });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unregisterRxBus();
  }

  private void unregisterRxBus() {
    if (rxSubscription != null && !rxSubscription.isUnsubscribed()) {
      rxSubscription.unsubscribe();
    }
  }

  class MyKindAdapter extends BaseAdapter {

    private List<DBSheQuBean> dbUserInvestmentList;
    private LayoutInflater inflater;
    private MyVidewHolder myViewHolder;

    public MyKindAdapter() {
      inflater = LayoutInflater.from(CollectionActivity.this);
    }

    public void setLists(List<DBSheQuBean> dbUserInvestmentList) {
      this.dbUserInvestmentList = dbUserInvestmentList;

    }

    @Override
    public int getCount() {
      return dbUserInvestmentList.size();
    }

    @Override
    public Object getItem(int position) {
      return dbUserInvestmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      if (convertView == null) {
        convertView = inflater.inflate(R.layout.item_carnews_lv, null);
        myViewHolder = new MyVidewHolder(convertView);
        convertView.setTag(myViewHolder);
      } else {
        myViewHolder = (MyVidewHolder) convertView.getTag();
      }

      myViewHolder.item_carnews_title_lv.setText(dbUserInvestmentList.get(position).getTitle());
      myViewHolder.item_carnews_source_lv.setText(dbUserInvestmentList.get(position).getSource());
      Glide.with(CollectionActivity.this).load(dbUserInvestmentList.get(position).getFirstImg()).into( myViewHolder.item_carnews_firstImg_lv);
      return convertView;
    }

    class MyVidewHolder {

      ImageView item_carnews_firstImg_lv;
      TextView  item_carnews_title_lv;
      TextView item_carnews_source_lv;

      MyVidewHolder(View view) {
        item_carnews_firstImg_lv = (ImageView) view.findViewById(R.id.item_carnews_firstImg_lv);
        item_carnews_title_lv = (TextView) view.findViewById(R.id.item_carnews_title_lv);
        item_carnews_source_lv = (TextView) view.findViewById(R.id.item_carnews_source_lv);
      }
    }
  }
}
