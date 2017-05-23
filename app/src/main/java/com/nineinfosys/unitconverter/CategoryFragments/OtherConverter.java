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
import com.nineinfosys.unitconverter.Adapters.RecyclerViewOtherAdapter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.ArrayList;
import java.util.List;


public class OtherConverter extends Fragment {

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
        RecyclerViewOtherAdapter rcAdapter = new RecyclerViewOtherAdapter(getActivity(),rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<ItemObject> getAllItemList(){


        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Prefixes", R.drawable.prefix));
        allItems.add(new ItemObject("Data Transfer", R.drawable.datatransfer));
        allItems.add(new ItemObject("Sound", R.drawable.sound));
        allItems.add(new ItemObject("Typography", R.drawable.typographic));
        allItems.add(new ItemObject("Hardness", R.drawable.hardness));
        allItems.add(new ItemObject("Volume-Lumber", R.drawable.volumelumber));
        allItems.add(new ItemObject("Metrology", R.drawable.metrology));
        allItems.add(new ItemObject("Metric Weight", R.drawable.metricweight));
        allItems.add(new ItemObject("Image", R.drawable.image));
        allItems.add(new ItemObject("Cooking", R.drawable.cooking));
        allItems.add(new ItemObject("Work", R.drawable.work));





        return allItems;
    }
}
