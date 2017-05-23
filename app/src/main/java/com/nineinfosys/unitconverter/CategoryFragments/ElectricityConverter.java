package com.nineinfosys.unitconverter.CategoryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewElectricityAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


public class ElectricityConverter  extends Fragment {

    ViewPager viewPager;

    private RecyclerView rView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.layout_common_converter, null);


        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);

        List<ItemObject> rowListItem = getAllItemList();

        //Initializing Views
        rView = (RecyclerView)v.findViewById(R.id.recyclerViewCommon);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(getContext(),3));

        //Initializing our superheroes list
        RecyclerViewElectricityAdapter rcAdapter = new RecyclerViewElectricityAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){


        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Charge ", R.drawable.charge));
        allItems.add(new ItemObject("Linear Charge Density", R.drawable.linearcharge));
        allItems.add(new ItemObject("Surface Charge Density", R.drawable.surfacecharge));
        allItems.add(new ItemObject("Volume Charge Density", R.drawable.volumecharge));
        allItems.add(new ItemObject("Current", R.drawable.current));
        allItems.add(new ItemObject("Linear Current Density ", R.drawable.linearcurrentdensity));
        allItems.add(new ItemObject("Surface Current Density", R.drawable.surfacecurrent));
        allItems.add(new ItemObject("Electric Field Strength", R.drawable.electricfieldstrength));
        allItems.add(new ItemObject("Electric Potential", R.drawable.electricpotential));
        allItems.add(new ItemObject("Electric Resistance", R.drawable.resistance));
        allItems.add(new ItemObject("Electric Resistivity", R.drawable.electricresistivity));
        allItems.add(new ItemObject("Electric Conductance ", R.drawable.conducatance));
        allItems.add(new ItemObject("Electric Conductivity", R.drawable.conducativity));
        allItems.add(new ItemObject("Electrostatic Capacitance", R.drawable.capaciatance));
        allItems.add(new ItemObject("Inductance", R.drawable.inducatance));





        return allItems;
    }
}