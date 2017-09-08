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
import com.example.carman.entity.JingNews;

public class ItemFindIvAdapter extends BaseAdapter {

    private List<JingNews.ResultBean.DataBean> objects = new ArrayList<JingNews.ResultBean.DataBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemFindIvAdapter(Context context,List<JingNews.ResultBean.DataBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public JingNews.ResultBean.DataBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_find_iv, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((JingNews.ResultBean.DataBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(JingNews.ResultBean.DataBean object, ViewHolder holder) {
        holder.titleTv.setText(object.getTitle());
        holder.sourceTv.setText(object.getAuthor_name());
        Glide.with(context).load(object.getThumbnail_pic_s()).into(holder.picLv);
    }

    protected class ViewHolder {
        private ImageView picLv;
    private TextView titleTv;
    private TextView sourceTv;

        public ViewHolder(View view) {
            picLv = (ImageView) view.findViewById(R.id.pic_lv);
            titleTv = (TextView) view.findViewById(R.id.title_tv);
            sourceTv = (TextView) view.findViewById(R.id.source_tv);
        }
    }
}
