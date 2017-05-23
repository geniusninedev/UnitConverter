package com.nineinfosys.unitconverter.CategoryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewEnggAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


public class EnggConverter  extends Fragment {

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
        RecyclerViewEnggAdapter rcAdapter = new RecyclerViewEnggAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){



        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Velocity - Angular ", R.drawable.velocity));
        allItems.add(new ItemObject("Acceleration", R.drawable.accleration));
        allItems.add(new ItemObject("Acceleration - Angular", R.drawable.angularaccelation));
        allItems.add(new ItemObject("Density", R.drawable.desity));
        allItems.add(new ItemObject("Specific Volume", R.drawable.specificvolume));
        allItems.add(new ItemObject("Moment of Inertia", R.drawable.intertia));
        allItems.add(new ItemObject("Moment of Force ", R.drawable.momentofforce));
        allItems.add(new ItemObject("Torque", R.drawable.ic_torque));
        return allItems;
    }
}

