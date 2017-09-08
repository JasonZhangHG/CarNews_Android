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
import com.example.carman.entity.CarNews;

public class ItemCarnewsLvAdapter extends BaseAdapter {

    private List<CarNews.ResultBean.ListBean> objects = new ArrayList<CarNews.ResultBean.ListBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemCarnewsLvAdapter(Context context,List<CarNews.ResultBean.ListBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CarNews.ResultBean.ListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_carnews_lv, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CarNews.ResultBean.ListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CarNews.ResultBean.ListBean object, ViewHolder holder) {
        holder.itemCarnewsTitleLv.setText(object.getTitle());
        holder.itemCarnewsSourceLv.setText(object.getSource());
        Glide.with(context).load(object.getFirstImg()).into(holder.itemCarnewsFirstImgLv);
    }

    protected class ViewHolder {
        private ImageView itemCarnewsFirstImgLv;
    private TextView itemCarnewsTitleLv;
    private TextView itemCarnewsSourceLv;

        public ViewHolder(View view) {
            itemCarnewsFirstImgLv = (ImageView) view.findViewById(R.id.item_carnews_firstImg_lv);
            itemCarnewsTitleLv = (TextView) view.findViewById(R.id.item_carnews_title_lv);
            itemCarnewsSourceLv = (TextView) view.findViewById(R.id.item_carnews_source_lv);
        }
    }
}
