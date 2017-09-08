package com.example.carman.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carman.R;
import com.example.carman.entity.LimitCar;

public class ItemLimitAdapter extends BaseAdapter {

    private List<LimitCar.ResultBean> objects = new ArrayList<LimitCar.ResultBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemLimitAdapter(Context context, List<LimitCar.ResultBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public LimitCar.ResultBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_limit, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((LimitCar.ResultBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(LimitCar.ResultBean object, ViewHolder holder) {
        holder.cityTv.setText(object.getCityname());
    }

    protected class ViewHolder {
        private TextView cityTv;

        public ViewHolder(View view) {
            cityTv = (TextView) view.findViewById(R.id.city_tv);
        }
    }
}
