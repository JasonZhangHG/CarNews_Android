package com.example.carman.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.carman.R;
import com.example.carman.entity.CarsListEntity;

public class ItemCar3LvAdapter extends BaseAdapter {
    //    List<CarsListEntity.ResultBean.CarlistBean> carlist
    private List<CarsListEntity.ResultBean.CarlistBean> objects = new ArrayList<CarsListEntity.ResultBean.CarlistBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemCar3LvAdapter(Context context, List<CarsListEntity.ResultBean.CarlistBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CarsListEntity.ResultBean.CarlistBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_car3_lv, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CarsListEntity.ResultBean.CarlistBean) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CarsListEntity.ResultBean.CarlistBean object, ViewHolder holder) {
        holder.fullNameTv.setText(object.getFullname());
        holder.salestateTv.setText(object.getSalestate());
        Glide.with(context).load(object.getLogo()).into(holder.iv);

    }

    protected class ViewHolder {
        private TextView fullNameTv;
        private TextView salestateTv;
        private ImageView iv;

        public ViewHolder(View view) {
            fullNameTv = (TextView) view.findViewById(R.id.full_name_tv);
            salestateTv = (TextView) view.findViewById(R.id.salestate_tv);
            iv= (ImageView) view.findViewById(R.id.logo_lv);
        }
    }
}
