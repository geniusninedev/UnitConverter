package com.nineinfosys.unitconverter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineinfosys.unitconverter.ConverterActivities.Engineering.AccelerationActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.AccelerationAngularActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.DensityConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.MomentOfInertiaActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.MomentofForceActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.SpecificVolumeActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.TorqueActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Engineering.VelocityAngularActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.CookingActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.DataTransferConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.HardnessActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.ImageActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.MetricWeightConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.MetrologyUnitConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.PrefixActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.SoundActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.TypographyConversionActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.VolumeLumberConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivities.Other.WorkConverterActivity;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemObject;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewOtherAdapter extends RecyclerView.Adapter<RecyclerViewOtherAdapter.RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewOtherAdapter(Context context, List<ItemObject> itemList) {
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
          //  Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            switch (getPosition())
            {
                case 0:
                    Intent i=new Intent(context,PrefixActivity.class);
                    context.startActivity(i);
                    break;
                case 1:
                    Intent i1=new Intent(context,DataTransferConverterActivity.class);
                    context.startActivity(i1);
                    break;
                case 2:
                    Intent i2=new Intent(context,SoundActivity.class);
                    context.startActivity(i2);
                    break;
                case 3:
                    Intent i3=new Intent(context,TypographyConversionActivity.class);
                    context.startActivity(i3);

                    break;
                case 4:
                    Intent i5=new Intent(context,HardnessActivity.class);
                    context.startActivity(i5);
                    break;
                case 5:
                    Intent i4=new Intent(context,VolumeLumberConverterActivity.class);
                    context.startActivity(i4);
                    break;

                case 6:
                    Intent i6=new Intent(context,MetrologyUnitConverterActivity.class);
                    context.startActivity(i6);
                    break;
                case 7:
                    Intent i7=new Intent(context,MetricWeightConverterActivity.class);
                    context.startActivity(i7);
                    break;
                case 8:
                    Intent i8=new Intent(context,ImageActivity.class);
                    context.startActivity(i8);
                    break;

                case 9:
                    Intent i9=new Intent(context,CookingActivity.class);
                    context.startActivity(i9);
                    break;
                case 10:
                    Intent i10=new Intent(context,WorkConverterActivity.class);
                    context.startActivity(i10);
                    break;



            }


        }



    }
}