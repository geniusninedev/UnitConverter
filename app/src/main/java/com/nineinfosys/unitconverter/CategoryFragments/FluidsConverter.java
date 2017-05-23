package com.nineinfosys.unitconverter.CategoryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewFluidAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class FluidsConverter extends Fragment {

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
        rView.setLayoutManager(new GridLayoutManager(getContext(),2));

        //Initializing our superheroes list
        RecyclerViewFluidAdapter rcAdapter = new RecyclerViewFluidAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Flow", R.drawable.flow));
        allItems.add(new ItemObject("Flow-Mass", R.drawable.flowmass));
        allItems.add(new ItemObject("Flow-Molar", R.drawable.flowmolar));
        allItems.add(new ItemObject("Mass Flux Density", R.drawable.massfluxdensity));
        allItems.add(new ItemObject("Concentration-Molar", R.drawable.concentrationmolar));
        allItems.add(new ItemObject("Concentration-Solution", R.drawable.concentrationsolution));
        allItems.add(new ItemObject("Viscosity-Dynamic", R.drawable.viscositydynamic));
        allItems.add(new ItemObject("Viscosity-Kinematic", R.drawable.viscocitykinetic));
        allItems.add(new ItemObject("Surface Tension", R.drawable.surface));
        allItems.add(new ItemObject("Permeability", R.drawable.permeability));

        return allItems;
    }
}
