package com.bilalkarademir.istanbulharikalar2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<Model> list;
    Context context;

    public Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        ImageView img = layout.findViewById(R.id.resim);
        TextView baslik = layout.findViewById(R.id.baslik);
        TextView icerik = layout.findViewById(R.id.icerik);
        img.setImageResource(list.get(position).getResimId());
        baslik.setText(list.get(position).getBaslik());
        icerik.setText(list.get(position).getIcerik());


        return layout;
    }
}
