package com.nineinfosys.unitconverter.CategoryFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewRadiologyAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Divya on 15-4-2017.
 */

public class RadiologyConverter extends Fragment {

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
        rView.setLayoutManager(new GridLayoutManager(getContext(),1));

        //Initializing our superheroes list
        RecyclerViewRadiologyAdapter rcAdapter = new RecyclerViewRadiologyAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){


        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Radiation", R.drawable.radiology));
        allItems.add(new ItemObject("Radiation-Activity", R.drawable.radiationactivity));
        allItems.add(new ItemObject("Radiation-Exposure", R.drawable.radiationexplore));
        allItems.add(new ItemObject("Radiation-Absorbed Dose", R.drawable.radiationobserved));

        return allItems;
    }
}
