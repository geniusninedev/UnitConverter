package com.nineinfosys.unitconverter.ConverterActivityList.Common;

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
import com.nineinfosys.unitconverter.Engines.Common.SpeedConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionSpeedListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    private String strMetersecond = null, strKilometerhour = null, strMilehour = null, strMeterhour = null, strMeterminute = null, strKilometerminute = null, strKilometersecond = null, strCentimeterhour= null,
            strCentimeterminute= null, strCentimetersecond= null, strMillimeterhour= null, strMillimeterminute= null, strMillimetersecond= null, strFoothour= null, strFootminute= null, strFootsecond= null,
            strYardhour= null, strYardminute= null, strYardsecond= null, strMileminute= null, strMilesecond= null, strKnot= null, strKnotUK= null, strVelocityoflightinvacuum= null,
            strCosmicvelocityfirsthom= null, strCosmicvelocitysecondcosmic= null, strCosmicvelocitythirdcosmic= null, strEarthsvelocityearth= null, strVelocityofsoundinpurewater= null,
            strVelocityofsoundinseawater= null, strMach= null, strMachSIstandard= null;


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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#48e2be")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#00af8e"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionSpeedListActivity.this, getString(R.string.ads_app_id));
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

            case "Meter/second - m/s":
                textconversionFrom.setText("Meter/second");
                textViewConversionShortform.setText("m/s");
                break;
            case "Kilometer/hour - km/h":
                textconversionFrom.setText("Kilometer/hour");
                textViewConversionShortform.setText("km/h");
                break;
            case "Mile/hour - mi/h":
                textconversionFrom.setText("Mile/hour");
                textViewConversionShortform.setText("mi/h");
                break;
            case "Meter/hour - m/h":
                textconversionFrom.setText("Meter/hour");
                textViewConversionShortform.setText("m/h");
                break;
            case "Meter/minute - m/min":
                textconversionFrom.setText("Meter/minute");
                textViewConversionShortform.setText("m/min");
                break;
            case "Kilometer/minute - km/min":
                textconversionFrom.setText("Kilometer/minute");
                textViewConversionShortform.setText("km/min");
                break;
            case "Kilometer/second - km/s":
                textconversionFrom.setText("Kilometer/second");
                textViewConversionShortform.setText("km/s");
                break;
            case "Centimeter/hour - cm/h":
                textconversionFrom.setText("Centimeter/hour");
                textViewConversionShortform.setText("cm/h");
                break;
            case "Centimeter/minute - cm/min":
                textconversionFrom.setText("Centimeter/minute");
                textViewConversionShortform.setText("cm/min");
                break;
            case "Centimeter/second - cm/s":
                textconversionFrom.setText("Centimeter/second");
                textViewConversionShortform.setText("cm/s");
                break;
            case "Millimeter/hour - mm/h":
                textconversionFrom.setText("Millimeter/hour");
                textViewConversionShortform.setText("mm/h");
                break;
            case "Millimeter/minute - mm/min":
                textconversionFrom.setText("Millimeter/minute");
                textViewConversionShortform.setText("mm/min");
                break;
            case "Millimeter/second - mm/s":
                textconversionFrom.setText("Millimeter/second");
                textViewConversionShortform.setText("mm/s");
                break;
            case "Foot/hour - ft/h":
                textconversionFrom.setText("Foot/hour");
                textViewConversionShortform.setText("ft/h");
                break;
            case "Foot/minute - ft/min":
                textconversionFrom.setText("Foot/minute");
                textViewConversionShortform.setText("ft/min");
                break;
            case "Foot/second - ft/s":
                textconversionFrom.setText("Foot/second");
                textViewConversionShortform.setText("ft/s");
                break;
            case "Yard/hour - yd/h":
                textconversionFrom.setText("Yard/hour");
                textViewConversionShortform.setText("yd/h");
                break;
            case "Yard/minute - yd/min":
                textconversionFrom.setText("Yard/minute");
                textViewConversionShortform.setText("yd/min");
                break;
            case "Yard/second - yd/s":
                textconversionFrom.setText("Yard/second");
                textViewConversionShortform.setText("yd/s");
                break;
            case "Mile/minute - mi/min":
                textconversionFrom.setText("Mile/minute");
                textViewConversionShortform.setText("mi/min");
                break;
            case "Mile/second - mi/s":
                textconversionFrom.setText("Mile/second");
                textViewConversionShortform.setText("mi/s");
                break;
            case "Knot - knots":
                textconversionFrom.setText("Knot");
                textViewConversionShortform.setText("knots");
                break;
            case "Knot (UK) - knots(UK)":
                textconversionFrom.setText("Knot (UK)");
                textViewConversionShortform.setText("knots(UK)");
                break;
            case "Velocity of light in vacuum - c":
                textconversionFrom.setText("Velocity of light in vacuum");
                textViewConversionShortform.setText("c");
                break;
            case "Cosmic velocity - first - hom":
                textconversionFrom.setText("Cosmic velocity - first");
                textViewConversionShortform.setText("hom");
                break;
            case "Cosmic velocity - second - cosmic":
                textconversionFrom.setText("Cosmic velocity - second");
                textViewConversionShortform.setText("cosmic");
                break;
            case "Cosmic velocity - third - cosmic":
                textconversionFrom.setText("Cosmic velocity - third");
                textViewConversionShortform.setText("cosmic");
                break;
            case "Earth's velocity - earth":
                textconversionFrom.setText("Earth's velocity");
                textViewConversionShortform.setText("earth");
                break;
            case "Velocity of sound in pure water - sound":
                textconversionFrom.setText("Velocity of sound in pure water");
                textViewConversionShortform.setText("sound");
                break;
            case "Velocity of sound in sea water - sound":
                textconversionFrom.setText("Velocity of sound in sea water");
                textViewConversionShortform.setText("sound");
                break;
            case "Mach - mach":
                textconversionFrom.setText("Mach");
                textViewConversionShortform.setText("mach");
                break;
            case "Mach (SI standard) - mach":
                textconversionFrom.setText("Mach (SI standard)");
                textViewConversionShortform.setText("mach");
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

        SpeedConverter c = new  SpeedConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<SpeedConverter.ConversionResults> results = c.calculateSpeedConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            SpeedConverter.ConversionResults item = results.get(i);


            strMetersecond = String.valueOf(formatter.format(item.getMeterpersecond()));
            strMeterhour= String.valueOf(formatter.format(item.getMeterperhour()));
            strMilehour = String.valueOf(formatter.format(item.getMileperhour()));
            strKilometerhour  = String.valueOf(formatter.format(item.getKilometerperhour()));
            strMeterminute = String.valueOf(formatter.format(item.getMeterperminute()));
            strKilometerminute = String.valueOf(formatter.format(item.getKilometerpersecond()));
            strKilometersecond = String.valueOf(formatter.format(item.getKilometerpersecond()));
            strCentimeterhour = String.valueOf(formatter.format(item.getCentimeterperhour()));
            strCentimeterminute = String.valueOf(formatter.format(item.getCentimeterperminute()));
            strCentimetersecond = String.valueOf(formatter.format(item.getCentimeterpersecond()));
            strMillimeterhour = String.valueOf(formatter.format(item.getMillimeterperhour()));
            strMillimeterminute = String.valueOf(formatter.format(item.getMillimeterperminute()));
            strMillimetersecond = String.valueOf(formatter.format(item.getMillimeterpersecond()));
            strFoothour = String.valueOf(formatter.format(item.getFootperhour()));
            strFootminute = String.valueOf(formatter.format(item.getFootperminute()));
            strFootsecond = String.valueOf(formatter.format(item.getFootpersecond()));
            strYardhour = String.valueOf(formatter.format(item.getYardperhour()));
            strYardminute = String.valueOf(formatter.format(item.getYardperminute()));
            strYardsecond = String.valueOf(formatter.format(item.getYardpersecond()));
            strMileminute = String.valueOf(formatter.format(item.getMileperminute()));
            strMilesecond = String.valueOf(formatter.format( item.getMilepersecond()));
            strKnot = String.valueOf(formatter.format(item.getKnot()));
            strKnotUK = String.valueOf(formatter.format( item.getKnotUK()));
            strVelocityoflightinvacuum = String.valueOf(formatter.format(item.getVelocotyLVacuum()));
            strCosmicvelocityfirsthom = String.valueOf(formatter.format(item.getCosmicvfirst() ));
            strCosmicvelocitysecondcosmic = String.valueOf(formatter.format(item.getCosmicvsecond()));
            strCosmicvelocitythirdcosmic = String.valueOf(formatter.format( item.getCosmicvthird()));
            strEarthsvelocityearth = String.valueOf(formatter.format(item.getEarthv()));
            strVelocityofsoundinpurewater = String.valueOf(formatter.format( item.getVsoundpurewater()));
            strVelocityofsoundinseawater = String.valueOf(formatter.format(item.getVsoundseawater()));
            strMach = String.valueOf(formatter.format( item.getMach20()));
            strMachSIstandard = String.valueOf(formatter.format(item.getMachsistandard()));







            list.add(new ItemList("m/s","Meter/second",strMetersecond,"m/s"));
            list.add(new ItemList("km/h","Kilometer/hour",strKilometerhour,"km/h"));
            list.add(new ItemList("mi/h","Mile/hour",strMilehour,"mi/h"));
            list.add(new ItemList("m/h","Meter/hour",strMeterhour,"m/h"));
            list.add(new ItemList("m/min","Meter/minute",strMeterminute,"m/min"));
            list.add(new ItemList("km/min","Kilometer/minute",strKilometerminute,"km/min"));
            list.add(new ItemList("km/s","Kilometer/second",strKilometersecond,"km/s"));
            list.add(new ItemList("cm/h","Centimeter/hour",strCentimeterhour,"cm/h"));
            list.add(new ItemList("cm/min","Centimeter/minute",strCentimeterminute,"cm/min"));
            list.add(new ItemList("cm/s","Centimeter/second",strCentimetersecond,"cm/s"));
            list.add(new ItemList("mm/h",",Millimeter/hour",strMillimeterhour,"mm/h"));
            list.add(new ItemList("mm/min","Millimeter/minute",strMillimeterminute,"mm/min"));
            list.add(new ItemList("mm/s","Millimeter/second",strMillimetersecond,"mm/s"));
            list.add(new ItemList("ft/h","Foot/hour",strFoothour,"ft/h"));
            list.add(new ItemList("ft/min","Foot/minute",strFootminute,"ft/min"));
            list.add(new ItemList("ft/s","Foot/second",strFootsecond,"ft/s"));
            list.add(new ItemList("yd/h","Yard/hour",strYardhour,"yd/h"));
            list.add(new ItemList("yd/min","Yard/minute",strYardminute,"yd/min"));
            list.add(new ItemList("yd/s" ,"Yard/second",strYardsecond,"yd/s"));
            list.add(new ItemList("mi/min","Mile/minute",strMileminute,"mi/min"));
            list.add(new ItemList("mi/s","Mile/second",strMilesecond,"mi/s"));
            list.add(new ItemList("knots","Knot ",strKnot,"knots"));
            list.add(new ItemList("knots(UK)","Knot (UK) ",strKnotUK,"knots(UK)"));
            list.add(new ItemList("c","Velocity of light in vacuum ",strVelocityoflightinvacuum,"c"));
            list.add(new ItemList("hom","Cosmic velocity - first ",strCosmicvelocityfirsthom,"hom"));
            list.add(new ItemList("cosmic","Cosmic velocity - second ",strCosmicvelocitysecondcosmic,"cosmic"));
            list.add(new ItemList("cosmic","Cosmic velocity - third ",strCosmicvelocitythirdcosmic,"cosmic"));
            list.add(new ItemList("earth","Earth's velocity ",strEarthsvelocityearth,"earth"));
            list.add(new ItemList("sound","Velocity of sound in pure water ",strVelocityofsoundinpurewater,"sound"));
            list.add(new ItemList("sound","Velocity of sound in sea water ",strVelocityofsoundinseawater,"sound"));
            list.add(new ItemList("mach","Mach",strMach,"mach"));
            list.add(new ItemList("mach","Mach (SI standard)",strMachSIstandard,"mach"));



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
        printhelper=new PrintHelper(ConversionSpeedListActivity.this);
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
