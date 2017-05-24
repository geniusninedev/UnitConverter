package com.nineinfosys.unitconverter.ConverterActivityList.Light;

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
import com.nineinfosys.unitconverter.ConverterActivityList.HeatConverter.ConversionHeatFluxDensityListActivity;
import com.nineinfosys.unitconverter.Engines.Light.LuminousIntensity;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionLuminousIntensityListActivity extends AppCompatActivity implements TextWatcher {

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

    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

   private String strcandleinternational=null,strcandleGerman=null,strcandleUK=null,strdecimalcandle=null,strcandlepentane=null,strpentanecandlecandlepower=null,strhefnercandle=null,strcarcelunit=null,
            strbougiedecimal=null,strlumenpersteradian=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e546bd")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Luminous Intensity ");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#af008d"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionLuminousIntensityListActivity.this, getString(R.string.ads_app_id));
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
            case "Candle (international) -cd(international)":
                textconversionFrom.setText("Candle (international) ");                 textViewConversionShortform.setText("cd(international)");
                break;
            case "Candle (German) -cd(German)":
                textconversionFrom.setText("Candle (German) ");                 textViewConversionShortform.setText("cd(German)");
                break;
            case "Candle (UK) -cd(UK)":
                textconversionFrom.setText("Candle (UK) ");                 textViewConversionShortform.setText("cd(UK)");
                break;
            case "Decimal candle -.cd":
                textconversionFrom.setText("Decimal candle ");                 textViewConversionShortform.setText(".cd");
                break;
            case "Candle (pentane) -cd(pentane)":
                textconversionFrom.setText("Candle (pentane) ");                 textViewConversionShortform.setText("cd(pentane)");
                break;
            case "Pentane candle (10 candle power) -pentane cd(10 cd power)":
                textconversionFrom.setText("Pentane candle (10 candle power) ");                 textViewConversionShortform.setText("pentane cd(10 cd power)");
                break;
            case "Hefner candle -he cd":
                textconversionFrom.setText("Hefner candle ");                 textViewConversionShortform.setText("he cd");
                break;
            case "Carcel unit -car u":
                textconversionFrom.setText("Carcel unit ");                 textViewConversionShortform.setText("car u");
                break;
            case "Bougie decimal -bo.":
                textconversionFrom.setText("Bougie decimal ");                 textViewConversionShortform.setText("bo.");
                break;
            case "Lumen/steradian -l/srad":
                textconversionFrom.setText("Lumen/steradian ");                 textViewConversionShortform.setText("l/srad");
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

        LuminousIntensity c = new  LuminousIntensity(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<LuminousIntensity.ConversionResults> results = c.calculateLuminousIntensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            LuminousIntensity.ConversionResults item = results.get(i);

            strcandleinternational=String.valueOf(formatter.format(item.getCandleinternational()));
            strcandleGerman=String.valueOf(formatter.format(item.getCandleGerman()));
            strcandleUK=String.valueOf(formatter.format(item.getCandleUK()));
            strdecimalcandle=String.valueOf(formatter.format(item.getDecimalcandle()));
            strcandlepentane=String.valueOf(formatter.format(item.getCandlepentane()));
            strpentanecandlecandlepower=String.valueOf(formatter.format(item.getPentanecandlecandlepower()));
            strhefnercandle=String.valueOf(formatter.format(item.getHefnercandle()));
            strcarcelunit=String.valueOf(formatter.format(item.getCarcelunit()));
            strbougiedecimal=String.valueOf(formatter.format(item.getBougiedecimal()));
            strlumenpersteradian=String.valueOf(formatter.format(item.getLumenpersteradian()));

            list.add(new ItemList("","Candle (international) ",strcandleinternational,"cd(international)"));
            list.add(new ItemList("","Candle (German) ",strcandleGerman,"cd(German)"));
            list.add(new ItemList("","Candle (UK) ",strcandleUK,"cd(UK)"));
            list.add(new ItemList("","Decimal candle ",strdecimalcandle,".cd"));
            list.add(new ItemList("","Candle (pentane) ",strcandlepentane,"cd(pentane)"));
            list.add(new ItemList("","Pentane candle (10 candle power) ",strpentanecandlecandlepower,"pentane cd(10 cd power)"));
            list.add(new ItemList("","Hefner candle ",strhefnercandle,"he cd"));
            list.add(new ItemList("","Carcel unit ",strcarcelunit,"car u"));
            list.add(new ItemList("","Bougie decimal ",strbougiedecimal,"bo."));
            list.add(new ItemList("","Lumen/steradian ",strlumenpersteradian,"l/srad"));



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
        printhelper=new PrintHelper(ConversionLuminousIntensityListActivity.this);
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

