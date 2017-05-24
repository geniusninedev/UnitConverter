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
import com.nineinfosys.unitconverter.Engines.Engineering.MomentOfInertiaConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionMomentOfInertiaListActivity extends AppCompatActivity implements TextWatcher {

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
    private String strkilosqmt=null,strkilosqcm=null,strkilosqmm=null,strgmsqcm=null,strgmsqmm=null,strkilogmforcemt=null,strkilogramforcecm=null,strouncesqinch=null,strounceforceinch=null,
            strpoundsqfoot=null,strpoundforcefoot=null,strpoundsqinch=null,strpoundforceinch=null,strslugsqfoot=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#81c784")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Moment Of Inertia");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#519657"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionMomentOfInertiaListActivity.this, getString(R.string.ads_app_id));
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
            case "Kilogram square meter -kg*M^2":
                textconversionFrom.setText("Kilogram square meter ");                 textViewConversionShortform.setText("kg*M^2");
                break;
            case "Kilogram square centimeter -kg*cm^2":
                textconversionFrom.setText("Kilogram square centimeter ");                 textViewConversionShortform.setText("kg*cm^2");
                break;
            case "Kilogram square millimeter -kg*mm^2":
                textconversionFrom.setText("Kilogram square millimeter ");                 textViewConversionShortform.setText("kg*mm^2");
                break;
            case "Gram square centimeter -g*cm^2":
                textconversionFrom.setText("Gram square centimeter ");                 textViewConversionShortform.setText("g*cm^2");
                break;
            case "Gram square millimeter -g*mm^2":
                textconversionFrom.setText("Gram square millimeter ");                 textViewConversionShortform.setText("g*mm^2");
                break;
            case "Kilogram-force meter square second -kgfM*s^2":
                textconversionFrom.setText("Kilogram-force meter square second ");                 textViewConversionShortform.setText("kgfM*s^2");
                break;
            case "Kilogram-force centimeter square second -kgfcm*s^2":
                textconversionFrom.setText("Kilogram-force centimeter square second ");                 textViewConversionShortform.setText("kgfcm*s^2");
                break;
            case "Ounce square inch -oz*in^2":
                textconversionFrom.setText("Ounce square inch ");                 textViewConversionShortform.setText("oz*in^2");
                break;
            case "Ounce-force inch sq. second -ozfin*s^2":
                textconversionFrom.setText("Ounce-force inch sq. second ");                 textViewConversionShortform.setText("ozfin*s^2");
                break;
            case "Pound square foot -lb*ft^2":
                textconversionFrom.setText("Pound square foot ");                 textViewConversionShortform.setText("lb*ft^2");
                break;
            case "Pound-force foot sq. second -lbfft*s^2":
                textconversionFrom.setText("Pound-force foot sq. second ");                 textViewConversionShortform.setText("lbfft*s^2");
                break;
            case "Pound square inch -lb*in^2":
                textconversionFrom.setText("Pound square inch ");                 textViewConversionShortform.setText("lb*in^2");
                break;
            case "Pound-force inch sq. second -lbfin*s^2":
                textconversionFrom.setText("Pound-force inch sq. second ");                 textViewConversionShortform.setText("lbfin*s^2");
                break;
            case "Slug square foot -slug*ft^2":
                textconversionFrom.setText("Slug square foot ");                 textViewConversionShortform.setText("slug*ft^2");
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

        MomentOfInertiaConverter c = new MomentOfInertiaConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<MomentOfInertiaConverter.ConversionResults> results = c.calculateinertiaConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            MomentOfInertiaConverter.ConversionResults item = results.get(i);


            strkilosqmt=String.valueOf(formatter.format(item.getKilosqmt()));
            strkilosqcm=String.valueOf(formatter.format(item.getKilosqcm()));
            strkilosqmm=String.valueOf(formatter.format(item.getKilosqmm()));
            strgmsqcm=String.valueOf(formatter.format(item.getGmsqcm()));
            strgmsqmm=String.valueOf(formatter.format(item.getGmsqmm()));
            strkilogmforcemt=String.valueOf(formatter.format(item.getKilogmforcemt()));
            strkilogramforcecm=String.valueOf(formatter.format(item.getKilogramforcecm()));
            strouncesqinch=String.valueOf(formatter.format(item.getOuncesqinch()));
            strounceforceinch=String.valueOf(formatter.format(item.getOunceforceinch()));
            strpoundsqfoot=String.valueOf(formatter.format(item.getPoundsqfoot()));
            strpoundforcefoot=String.valueOf(formatter.format(item.getPoundforcefoot()));
            strpoundsqinch=String.valueOf(formatter.format(item.getPoundsqinch()));
            strpoundforceinch=String.valueOf(formatter.format(item.getPoundforceinch()));
            strslugsqfoot=String.valueOf(formatter.format(item.getSlugsqfoot()));


            list.add(new ItemList("","Kilogram square meter ",strkilosqmt,"kg*M^2"));
            list.add(new ItemList("","Kilogram square centimeter ",strkilosqcm,"kg*cm^2"));
            list.add(new ItemList("","Kilogram square millimeter ",strkilosqmm,"kg*mm^2"));
            list.add(new ItemList("","Gram square centimeter ",strgmsqcm,"g*cm^2"));
            list.add(new ItemList("","Gram square millimeter ",strgmsqmm,"g*mm^2"));
            list.add(new ItemList("","Kilogram-force meter square second ",strkilogmforcemt,"kgfM*s^2"));
            list.add(new ItemList("","Kilogram-force centimeter square second ",strkilogramforcecm,"kgfcm*s^2"));
            list.add(new ItemList("","Ounce square inch ",strouncesqinch,"oz*in^2"));
            list.add(new ItemList("","Ounce-force inch sq. second ",strounceforceinch,"ozfin*s^2"));
            list.add(new ItemList("","Pound square foot ",strpoundsqfoot,"lb*ft^2"));
            list.add(new ItemList("","Pound-force foot sq. second ",strpoundforcefoot,"lbfft*s^2"));
            list.add(new ItemList("","Pound square inch ",strpoundsqinch,"lb*in^2"));
            list.add(new ItemList("","Pound-force inch sq. second ",strpoundforceinch,"lbfin*s^2"));
            list.add(new ItemList("","Slug square foot ",strslugsqfoot,"slug*ft^2"));
            



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
        printhelper=new PrintHelper(ConversionMomentOfInertiaListActivity.this);
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
