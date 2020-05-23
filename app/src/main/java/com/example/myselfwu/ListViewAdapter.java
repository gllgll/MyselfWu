package com.example.myselfwu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<String> data;
    private LayoutInflater inflater;
    public ListViewAdapter(Context context, List<String> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
//    数据源长度
    public int getCount() {
        return data.size();
    }

    @Override
//    每一行绑定数据源
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
//    获取每一行的view
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            ViewHolder.text1 = (TextView)convertView.findViewById(android.R.id.text1) ;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ViewHolder.text1.setText(data.get(position));
        return convertView;
    }

    private static class ViewHolder{
        private static TextView text1;
    }
}
