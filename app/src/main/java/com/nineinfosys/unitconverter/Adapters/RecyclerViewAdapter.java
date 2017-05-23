package com.nineinfosys.unitconverter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.AngleActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.AreaActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.DataStorageActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.EnergyActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.ForceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.FuelActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.LengthActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.PowerActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.PressureActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.RomanNumbersActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.SpeedActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.TempertureActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.TimeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.VolumeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.VolumeDryActivity;
import com.nineinfosys.unitconverter.ConverterActivities.CommonConverter.WeightActivity;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView countryName;
        public ImageView countryPhoto;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            countryName = (TextView)itemView.findViewById(R.id.country_name);
            countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

        }

        @Override
        public void onClick(View view) {

            switch (getPosition())
            {
                case 0:
                   /* Intent i=new Intent(context,TimeZone.class);
                    context.startActivity(i);*/
                    break;
                case 1:
                    Intent i1=new Intent(context,LengthActivity.class);
                    context.startActivity(i1);
                    break;
                case 2:
                    Intent i2=new Intent(context,WeightActivity.class);
                    context.startActivity(i2);
                    break;
                case 3:
                    Intent i3=new Intent(context,VolumeActivity.class);
                    context.startActivity(i3);
                    break;
                case 4:
                    Intent i4=new Intent(context,TempertureActivity.class);
                    context.startActivity(i4);

                    break;
                case 5:
                    Intent i5=new Intent(context,AreaActivity.class);
                    context.startActivity(i5);
                    break;
                case 6:
                    Intent i6=new Intent(context,PressureActivity.class);
                    context.startActivity(i6);
                    break;
                case 7:
                    Intent i7=new Intent(context,EnergyActivity.class);
                    context.startActivity(i7);
                    break;
                case 8:
                    Intent i8=new Intent(context,PowerActivity.class);
                    context.startActivity(i8);
                    break;
                case 9:
                    Intent i9=new Intent(context,ForceActivity.class);
                    context.startActivity(i9);
                    break;
                case 10:
                    Intent i10=new Intent(context,TimeActivity.class);
                    context.startActivity(i10);
                    break;
                case 11:
                    Intent i11=new Intent(context,SpeedActivity.class);
                    context.startActivity(i11);
                    break;
                case 12:
                    Intent i12=new Intent(context,AngleActivity.class);
                    context.startActivity(i12);
                    break;

                case 13:
                    Intent i13=new Intent(context,FuelActivity.class);
                    context.startActivity(i13);
                    break;

                case 14:
                    Intent i14=new Intent(context,RomanNumbersActivity.class);
                    context.startActivity(i14);
                    break;
                case 15:
                    Intent i15=new Intent(context,DataStorageActivity.class);
                    context.startActivity(i15);
                    break;
                case 16:
                    Intent i16=new Intent(context,VolumeDryActivity.class);
                    context.startActivity(i16);
                    break;


            }


        }



    }
}