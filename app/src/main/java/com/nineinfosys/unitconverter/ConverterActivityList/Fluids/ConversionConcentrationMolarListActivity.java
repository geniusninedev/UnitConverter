package com.nineinfosys.unitconverter.ConverterActivityList.Fluids;

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
import com.nineinfosys.unitconverter.ConverterActivityList.Engineering.ConversionVelocityAngularListActivity;
import com.nineinfosys.unitconverter.Engines.Fluids.ConcentrationMolarConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionConcentrationMolarListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strmolpercubicmeter=null,strmolperliter=null,strmolpercubiccm=null,strmolcubicmm=null,strkilomolcubicmeter=null,strkilomolliter=null,strkilomolcubiccm=null,strkilomolcubicmm=null,
            strmilimolcubicmeter=null,strmilimolliter=null,strmilimolcubiccm=null,strmilimolcubicmm=null;

    DecimalFormat formatter = null;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0bdbea")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Concentration Molar");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#00a9b8"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionConcentrationMolarListActivity.this, getString(R.string.ads_app_id));
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
            case "Mol/cubic meter -mol/m^3":
                textconversionFrom.setText("Mol/cubic meter ");                 textViewConversionShortform.setText("mol/m^3");
                break;
            case "Mol/liter -mol/L":
                textconversionFrom.setText("Mol/liter ");                 textViewConversionShortform.setText("mol/L");
                break;
            case "Mol/cubic centimeter -mol/cm^3":
                textconversionFrom.setText("Mol/cubic centimeter ");                 textViewConversionShortform.setText("mol/cm^3");
                break;
            case "Mol/cubic millimeter -mol/mm^3":
                textconversionFrom.setText("Mol/cubic millimeter ");                 textViewConversionShortform.setText("mol/mm^3");
                break;
            case "Kilomol/cubic meter -kmol/m^3":
                textconversionFrom.setText("Kilomol/cubic meter ");                 textViewConversionShortform.setText("kmol/m^3");
                break;
            case "Kilomol/liter -kmol/L":
                textconversionFrom.setText("Kilomol/liter ");                 textViewConversionShortform.setText("kmol/L");
                break;
            case "Kilomol/cubic centimeter -kmol/cm^3":
                textconversionFrom.setText("Kilomol/cubic centimeter ");                 textViewConversionShortform.setText("kmol/cm^3");
                break;
            case "Kilomol/cubic millimeter -kmol/mm^3":
                textconversionFrom.setText("Kilomol/cubic millimeter ");                 textViewConversionShortform.setText("kmol/mm^3");
                break;
            case "Millimol/cubic meter -mmol/m^3":
                textconversionFrom.setText("Millimol/cubic meter ");                 textViewConversionShortform.setText("mmol/m^3");
                break;
            case "Millimol/liter -mmol/L":
                textconversionFrom.setText("Millimol/liter ");                 textViewConversionShortform.setText("mmol/L");
                break;
            case "Millimol/cubic centimeter -mmol/cm^3":
                textconversionFrom.setText("Millimol/cubic centimeter ");                 textViewConversionShortform.setText("mmol/cm^3");
                break;
            case "Millimol/cubic millimeter -mmol/mm^3":
                textconversionFrom.setText("Millimol/cubic millimeter ");                 textViewConversionShortform.setText("mmol/mm^3");
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

        ConcentrationMolarConverter c = new  ConcentrationMolarConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<ConcentrationMolarConverter.ConversionResults> results = c.calculateConcentrationConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ConcentrationMolarConverter.ConversionResults item = results.get(i);


            strmolpercubicmeter=String.valueOf(formatter.format(item.getMolpercubicmeter()));
            strmolperliter=String.valueOf(formatter.format(item.getMolperliter()));
            strmolpercubiccm=String.valueOf(formatter.format(item.getMolpercubiccm()));
            strmolcubicmm=String.valueOf(formatter.format(item.getMolcubicmm()));
            strkilomolcubicmeter=String.valueOf(formatter.format(item.getKilomolcubicmeter()));
            strkilomolliter=String.valueOf(formatter.format(item.getKilomolliter()));
            strkilomolcubiccm=String.valueOf(formatter.format(item.getKilomolcubiccm()));
            strkilomolcubicmm=String.valueOf(formatter.format(item.getKilomolcubicmm()));
            strmilimolcubicmeter=String.valueOf(formatter.format(item.getMilimolcubicmeter()));
            strmilimolliter=String.valueOf(formatter.format(item.getMilimolliter()));
            strmilimolcubiccm=String.valueOf(formatter.format(item.getMilimolcubiccm()));
            strmilimolcubicmm=String.valueOf(formatter.format(item.getMilimolcubicmm()));

            list.add(new ItemList("mol/m^3","Mol/cubic meter ",strmolpercubicmeter,"mol/m^3"));
            list.add(new ItemList("mol/L","Mol/liter ",strmolperliter,"mol/L"));
            list.add(new ItemList("mol/cm^3","Mol/cubic centimeter ",strmolpercubiccm,"mol/cm^3"));
            list.add(new ItemList("mol/mm^3","Mol/cubic millimeter ",strmolcubicmm,"mol/mm^3"));
            list.add(new ItemList("kmol/m^3","Kilomol/cubic meter ",strkilomolcubicmeter,"kmol/m^3"));
            list.add(new ItemList("kmol/L","Kilomol/liter ",strkilomolliter,"kmol/L"));
            list.add(new ItemList("kmol/cm^3","Kilomol/cubic centimeter ",strkilomolcubiccm,"kmol/cm^3"));
            list.add(new ItemList("kmol/mm^3","Kilomol/cubic millimeter ",strkilomolcubicmm,"kmol/mm^3"));
            list.add(new ItemList("mmol/m^3","Millimol/cubic meter ",strmilimolcubicmeter,"mmol/m^3"));
            list.add(new ItemList("mmol/L","Millimol/liter ",strmilimolliter,"mmol/L"));
            list.add(new ItemList("mmol/cm^3","Millimol/cubic centimeter ",strmilimolcubiccm,"mmol/cm^3"));
            list.add(new ItemList("mmol/mm^3","Millimol/cubic millimeter ",strmilimolcubicmm,"mmol/mm^3"));



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
        printhelper=new PrintHelper(ConversionConcentrationMolarListActivity.this);
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

