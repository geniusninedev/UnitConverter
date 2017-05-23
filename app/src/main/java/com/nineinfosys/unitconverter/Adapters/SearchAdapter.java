package com.nineinfosys.unitconverter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.TextView;

import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.SearchItemObject;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class SearchAdapter extends ArrayAdapter<SearchItemObject> {

        ArrayList<SearchItemObject> list;

public SearchAdapter(Context context,  ArrayList<SearchItemObject> objects) {
        super(context, R.layout.list, objects);
        this.list = objects;
        }

private class ViewHolder{
    Button icon;
    TextView name;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list, parent, false);
            viewHolder.icon = (Button) convertView.findViewById(R.id.round_icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.icon.setText(list.get(position).getName().substring(0, 2));
        viewHolder.name.setText(list.get(position).getName());

        return convertView;
    }

}