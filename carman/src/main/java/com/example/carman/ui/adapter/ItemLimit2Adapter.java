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
import com.example.carman.entity.LimitCar2;

public class ItemLimit2Adapter extends BaseAdapter {

    private List<LimitCar2.ResultBean.DesBean> objects = new ArrayList<LimitCar2.ResultBean.DesBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemLimit2Adapter(Context context,List<LimitCar2.ResultBean.DesBean> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public LimitCar2.ResultBean.DesBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_limit2, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((LimitCar2.ResultBean.DesBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(LimitCar2.ResultBean.DesBean object, ViewHolder holder) {
        holder.limitTimeTv.setText(object.getTime());
        holder.limitAreaTv.setText(object.getPlace());
        holder.limitInfoTv.setText(object.getInfo());
    }

    protected class ViewHolder {
        private TextView limitTimeTv;
    private TextView limitAreaTv;
    private TextView limitInfoTv;

        public ViewHolder(View view) {
            limitTimeTv = (TextView) view.findViewById(R.id.limit_time_tv);
            limitAreaTv = (TextView) view.findViewById(R.id.limit_area_tv);
            limitInfoTv = (TextView) view.findViewById(R.id.limit_info_tv);
        }
    }
}
