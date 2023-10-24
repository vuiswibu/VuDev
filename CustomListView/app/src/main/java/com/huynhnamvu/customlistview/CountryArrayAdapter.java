package com.huynhnamvu.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {

    List<Country> lstDataSource;
    LayoutInflater inflater;
    Context context;
    //Constructor
    public CountryArrayAdapter(List<Country> lstDataSource, Context context) {
        this.lstDataSource = lstDataSource;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }
    //inner class
    class ViewHolder{
        ImageView flagview;
        TextView countryNameView;
        TextView populationView;
    }

    @Override
    public int getCount() {
        return lstDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder itemViewHolder;
        if(view == null)
        {
            //XML -->
            view = inflater.inflate(R.layout.country_item_layout, null);
            itemViewHolder = new ViewHolder();
            itemViewHolder.flagview=view.findViewById(R.id.imagviewFlag);
            itemViewHolder.countryNameView=view.findViewById(R.id.textView);
            itemViewHolder.populationView=view.findViewById(R.id.textView2);
            //
            view.setTag(itemViewHolder);
        }
        else
        {
            itemViewHolder = (ViewHolder)view.getTag();
        }
        Country countryItem = lstDataSource.get(i);
        itemViewHolder.countryNameView.setText(countryItem.getCountryName());
        itemViewHolder.populationView.setText("Population: " +countryItem.getCountryName());
        //
        int flaID = getImgIDByResName(countryItem.getCountryFlag());
        itemViewHolder.flagview.setImageResource(flaID);

        return view;
    }
    //Get Image function
    public int getImgIDByResName(String resName)
    {
        String packageName= context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName,"mipmap",packageName);
        return imgId;
    }
}
