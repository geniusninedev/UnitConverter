package com.nineinfosys.unitconverter.CategoryFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.nineinfosys.unitconverter.Adapters.RecyclerViewAdapter;

import com.nineinfosys.unitconverter.MainActivity;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


public class CommonConverter extends Fragment {

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
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
        }

    private List<ItemObject> getAllItemList(){


        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Time Zone", R.drawable.timezone));
        allItems.add(new ItemObject("Length", R.drawable.lenght));
        allItems.add(new ItemObject("Weight", R.drawable.weight));
        allItems.add(new ItemObject("Volume", R.drawable.volume));
        allItems.add(new ItemObject("Temperature", R.drawable.tempature));
        allItems.add(new ItemObject("Area", R.drawable.area1));
        allItems.add(new ItemObject("Pressure", R.drawable.pressure));
        allItems.add(new ItemObject("Energy", R.drawable.energy));
        allItems.add(new ItemObject("Power", R.drawable.power));
        allItems.add(new ItemObject("Force", R.drawable.force1));
        allItems.add(new ItemObject("Time", R.drawable.time));
        allItems.add(new ItemObject("Speed", R.drawable.speed));
        allItems.add(new ItemObject("Angle", R.drawable.angle));
        allItems.add(new ItemObject("Fuel", R.drawable.fuel));
        allItems.add(new ItemObject("Roman Numbers", R.drawable.numbers));
        allItems.add(new ItemObject("Data Storage", R.drawable.storage));
        allItems.add(new ItemObject("volume-Dry", R.drawable.measuringcup));



        return allItems;
    }
    }
