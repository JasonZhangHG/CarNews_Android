package com.example.carman.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.carman.R;
import com.example.carman.entity.CarTypes;

public class ItemMainLvAdapter extends BaseAdapter {

    private List<CarTypes.ResultBean> objects = new ArrayList<CarTypes.ResultBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemMainLvAdapter(Context context, List<CarTypes.ResultBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CarTypes.ResultBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_main_lv, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CarTypes.ResultBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CarTypes.ResultBean object, ViewHolder holder) {
        String name = object.getName();
        holder.itemMainNameLv.setText(name);
        String pic = object.getLogo();
        Glide.with(context).load(pic).into(holder.itemMainPicLv);

    }

    protected class ViewHolder {
        private ImageView itemMainPicLv;
    private TextView itemMainNameLv;

        public ViewHolder(View view) {
            itemMainPicLv = (ImageView) view.findViewById(R.id.item_main_pic_lv);
            itemMainNameLv = (TextView) view.findViewById(R.id.item_main_name_lv);
        }
    }
}
