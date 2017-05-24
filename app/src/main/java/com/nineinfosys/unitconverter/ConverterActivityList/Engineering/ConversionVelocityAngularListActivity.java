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
import com.nineinfosys.unitconverter.Engines.Engineering.VelocityAngularConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionVelocityAngularListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
  private  String strradianpersecond=null,strradianperday=null,strradianperhour=null,strradianperminute=null,strdegreeperday=null,strdegreeperhour=null,strdegreeperminute=null,strdegreepersecond =null,
            strrevolutionperday=null,strrevolutionperhour=null,strrevolutionperminute=null,strrevolutionpersecond=null;


    DecimalFormat formatter = null;

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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Velocity Angular");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionVelocityAngularListActivity.this, getString(R.string.ads_app_id));
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

            case "Radian/second -rad/s":
                textconversionFrom.setText("Radian/second");                 textViewConversionShortform.setText("rad/s");
                break;
            case "Radian/day -rad/d":
                textconversionFrom.setText("Radian/day");                 textViewConversionShortform.setText("rad/d");
                break;
            case "Radian/hour -rad/h":
                textconversionFrom.setText("Radian/hour");                 textViewConversionShortform.setText("rad/h");
                break;
            case "Radian/minute -rad/min":
                textconversionFrom.setText("Radian/minute");                 textViewConversionShortform.setText("rad/min");
                break;
            case "Degree/day -°/d":
                textconversionFrom.setText("Degree/day");                 textViewConversionShortform.setText("°/d");
                break;
            case "Degree/hour -°/h":
                textconversionFrom.setText("Degree/hour");                 textViewConversionShortform.setText("°/h");
                break;
            case "Degree/minute -°/min":
                textconversionFrom.setText("Degree/minute");                 textViewConversionShortform.setText("°/min");
                break;
            case "Degree/second -°/s":
                textconversionFrom.setText("Degree/second");                 textViewConversionShortform.setText("°/s");
                break;
            case "Revolution/day -r/d":
                textconversionFrom.setText("Revolution/day");                 textViewConversionShortform.setText("r/d");
                break;
            case "Revolution/hour -r/h":
                textconversionFrom.setText("Revolution/hour");                 textViewConversionShortform.setText("r/h");
                break;
            case "Revolution/minute -r/min":
                textconversionFrom.setText("Revolution/minute");                 textViewConversionShortform.setText("r/min");
                break;
            case "Revolution/second -r/s":
                textconversionFrom.setText("Revolution/second");                 textViewConversionShortform.setText("r/s");
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

        VelocityAngularConverter c = new  VelocityAngularConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<VelocityAngularConverter.ConversionResults> results = c.calculateVelocityAngularConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            VelocityAngularConverter.ConversionResults item = results.get(i);


            strradianpersecond=String.valueOf(formatter.format(item.getRadianpersecond()));
            strradianperday=String.valueOf(formatter.format(item.getRadianperday()));
            strradianperhour=String.valueOf(formatter.format(item.getRadianperhour()));
            strradianperminute=String.valueOf(formatter.format(item.getRadianperminute()));
            strdegreeperday=String.valueOf(formatter.format(item.getDegreeperday()));
            strdegreeperhour=String.valueOf(formatter.format(item.getDegreeperhour()));
            strdegreeperminute=String.valueOf(formatter.format(item.getDegreeperminute()));
            strdegreepersecond=String.valueOf(formatter.format(item.getDegreepersecond()));
            strrevolutionperday=String.valueOf(formatter.format(item.getRevolutionperday()));
            strrevolutionperhour=String.valueOf(formatter.format(item.getRevolutionperhour()));
            strrevolutionperminute=String.valueOf(formatter.format(item.getRevolutionperminute()));
            strrevolutionpersecond=String.valueOf(formatter.format(item.getRevolutionpersecond()));


            list.add(new ItemList("rad/s","Radian/second ",strradianpersecond,"rad/s"));
            list.add(new ItemList("rad/d","Radian/day ",strradianperday,"rad/d"));
            list.add(new ItemList("rad/h","Radian/hour ",strradianperhour,"rad/h"));
            list.add(new ItemList("rad/min","Radian/minute ",strradianperminute,"rad/min"));
            list.add(new ItemList("°/d","Degree/day ",strdegreeperday,"°/d"));
            list.add(new ItemList("°/h","Degree/hour ",strdegreeperhour,"°/h"));
            list.add(new ItemList("°/min","Degree/minute ",strdegreeperminute,"°/min"));
            list.add(new ItemList("°/s","Degree/second ",strdegreepersecond,"°/s"));
            list.add(new ItemList("r/d","Revolution/day ",strrevolutionperday,"r/d"));
            list.add(new ItemList("r/h","Revolution/hour ",strrevolutionperhour,"r/h"));
            list.add(new ItemList("r/min","Revolution/minute ",strrevolutionperminute,"r/min"));
            list.add(new ItemList("r/s","Revolution/second ",strrevolutionpersecond,"r/s"));

        }
        return list;

    }
   /* @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(ConversionTempListActivity.this, ConversionTempListActivity.class);
        i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
        i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
        startActivity(i);
        finish();

    }*/

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

        getMenuInflater().inflate(R.menu.main_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            case R.id.action_saveaspdf:
                creatPdf();
                Toast.makeText(this,"File saved successfully" + "\n File Path: "+imageFile,Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                shareIt();
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


    private void creatPdf() {
        pdf();
        printhelper.printBitmap("Your list",bitmap);
    }

    private void shareIt() {
        pdf();
        Uri uri = Uri.fromFile(imageFile);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        String shareBody = "List of all Unit values.";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "List of Units");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }

    private void pdf() {
        printhelper=new PrintHelper(ConversionVelocityAngularListActivity.this);
        printhelper.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        // image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".JPEG";
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        RelativeLayout root = (RelativeLayout) inflater.inflate(R.layout.activity_conversion_list, null); //RelativeLayout is root view of my UI(xml) file.
        root.setDrawingCacheEnabled(true);
        bitmap= getBitmapFromView(this.getWindow().findViewById(R.id.relativelayout));
        imageFile = new File(mPath);
        try{
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            // Toast.makeText(ConversionEnergyListActivity.this,"Image path : "+imageFile,Toast.LENGTH_LONG).show();
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            // openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }
    }

    //create bitmap from view and returns it
    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}
