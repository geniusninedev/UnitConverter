package com.nineinfosys.unitconverter.ConverterActivityList.Engineering;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.unitconverter.Adapters.RecyclerViewConversionListAdapter;

import com.nineinfosys.unitconverter.ConverterActivities.ActivitySetting;
import com.nineinfosys.unitconverter.ConverterActivityList.Electricity.SurfaceCurrentDensityListActivity;
import com.nineinfosys.unitconverter.Engines.Engineering.AccelerationAngularConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionAccelerationAngularListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;
   private String strradianpersquaresecond=null,strradianpersquareminute=null,strrevolutionpersquaresecond=null,strrevolutionperminutepersecond=null,strrevolutionpersquareminute=null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db290d")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a10000"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionAccelerationAngularListActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        edittextConversionListvalue=(EditText)findViewById(R.id.edittextConversionListvalue) ;
        textconversionFrom=(TextView) findViewById(R.id.textViewConversionFrom) ;
        textViewConversionShortform=(TextView) findViewById(R.id.textViewConversionShortform) ;

        //get the value from temperture activity
        stringSpinnerFrom = getIntent().getExtras().getString("stringSpinnerFrom");
        doubleEdittextvalue= getIntent().getExtras().getDouble("doubleEdittextvalue");
        edittextConversionListvalue.setText(String.valueOf(doubleEdittextvalue));

        NamesAndShortform(stringSpinnerFrom);

        //   Toast.makeText(this,"string1 "+stringSpinnerFrom,Toast.LENGTH_LONG).show();
        rowListItem = getAllunitValue(stringSpinnerFrom,doubleEdittextvalue);

        //Initializing Views
        rView = (RecyclerView) findViewById(R.id.recyclerViewConverterList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, 1));


        //Initializing our superheroes list
        rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem);
        rView.setAdapter(rcAdapter);

        edittextConversionListvalue.addTextChangedListener(this);



    }

    private void NamesAndShortform(String stringSpinnerFrom) {
        switch (stringSpinnerFrom) {
            case "Radian/square second -rad/s^2":
                textconversionFrom.setText("Radian/square second ");                 textViewConversionShortform.setText("rad/s^2");
                break;
            case "Radian/square minute -rad/min^2":
                textconversionFrom.setText("Radian/square minute ");                 textViewConversionShortform.setText("rad/min^2");
                break;
            case "Revolution/square second -r/s^2":
                textconversionFrom.setText("Revolution/square second ");                 textViewConversionShortform.setText("r/s^2");
                break;
            case "Revolution/minute/second -r/min/s":
                textconversionFrom.setText("Revolution/minute/second ");                 textViewConversionShortform.setText("r/min/s");
                break;
            case "Revolution/square minute -r/min^2":
                textconversionFrom.setText("Revolution/square minute ");                 textViewConversionShortform.setText("r/min^2");
                break;
        }
    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }

    private List<ItemList> getAllunitValue(String strSpinnerFrom,double doubleEdittextvalue1) {

        AccelerationAngularConverter c = new  AccelerationAngularConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<AccelerationAngularConverter.ConversionResults> results = c.calculateAccelerationAngularConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            AccelerationAngularConverter.ConversionResults item = results.get(i);



            strradianpersquaresecond=String.valueOf(formatter.format(item.getRadianpersquaresecond()));
            strradianpersquareminute=String.valueOf(formatter.format(item.getRadianpersquareminute()));
            strrevolutionpersquaresecond=String.valueOf(formatter.format(item.getRevolutionpersquaresecond()));
            strrevolutionperminutepersecond=String.valueOf(formatter.format(item.getRevolutionperminutepersecond()));
            strrevolutionpersquareminute=String.valueOf(formatter.format(item.getRevolutionpersquareminute()));


            list.add(new ItemList("rad/s^2","Radian/square second ",strradianpersquaresecond,"rad/s^2"));
            list.add(new ItemList("rad/min^2","Radian/square minute ",strradianpersquareminute,"rad/min^2"));
            list.add(new ItemList("r/s^2","Revolution/square second ",strrevolutionpersquaresecond,"r/s^2"));
            list.add(new ItemList("r/min/s","Revolution/minute/second ",strrevolutionperminutepersecond,"r/min/s"));
            list.add(new ItemList("r/min^2","Revolution/square minute ",strrevolutionpersquareminute,"r/min^2"));



        }
        return list;

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        rowListItem.clear();
        try {

           double value = Double.parseDouble(edittextConversionListvalue.getText().toString().trim());

            rowListItem1 = getAllunitValue(stringSpinnerFrom,value);


            rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem1);
            rView.setAdapter(rcAdapter);

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;


            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}


