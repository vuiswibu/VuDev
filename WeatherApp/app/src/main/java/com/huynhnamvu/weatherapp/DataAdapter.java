package com.huynhnamvu.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends ArrayAdapter<Data> {
    private List<Data> dataList;
    private LayoutInflater inflater;

    public DataAdapter(Context context, List<Data> dataList) {
        super(context, R.layout.item_city, dataList);
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    public List<Data> getDataList() {
        return dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_city, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        Data data = dataList.get(position);
        nameTextView.setText(data.getName());

        return convertView;
    }
}
