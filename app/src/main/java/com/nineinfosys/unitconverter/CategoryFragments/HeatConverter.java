package com.nineinfosys.unitconverter.CategoryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewAdapter;
import com.nineinfosys.unitconverter.Adapters.RecyclerViewEnggAdapter;
import com.nineinfosys.unitconverter.Adapters.RecyclerViewHeatAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


public class HeatConverter extends Fragment {

    ViewPager viewPager;
    private RecyclerView rView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.layout_common_converter, null);

        //set title to toolbar
        // getActivity().setTitle("Common Converter");
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Common Converter");

        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);

        List<ItemObject> rowListItem = getAllItemList();

        //Initializing Views
        rView = (RecyclerView)v.findViewById(R.id.recyclerViewCommon);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(getContext(),2));

        //Initializing our superheroes list
        RecyclerViewHeatAdapter rcAdapter = new RecyclerViewHeatAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){


        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Fuel Efficiency - Mass ", R.drawable.fuelmaass));
        allItems.add(new ItemObject("Fuel Efficiency - Volume ", R.drawable.fueleffiency));
        allItems.add(new ItemObject("Temperature Interval ", R.drawable.ic_tempertureinterval));
        allItems.add(new ItemObject("Thermal Expansion ", R.drawable.thermalexpansion));
        allItems.add(new ItemObject("Thermal Resistance ", R.drawable.resistance));
        allItems.add(new ItemObject("Thermal Conductivity ", R.drawable.ic_thermalconducitivity));
        allItems.add(new ItemObject("Specific Heat Capacity ", R.drawable.specificheat));
        allItems.add(new ItemObject("Heat Density ", R.drawable.heatcapacity));
        allItems.add(new ItemObject("Heat Flux Density ", R.drawable.heat));
        allItems.add(new ItemObject("Heat Transfer Coefficient ", R.drawable.ic_heattransfer));



        return allItems;
    }
}
