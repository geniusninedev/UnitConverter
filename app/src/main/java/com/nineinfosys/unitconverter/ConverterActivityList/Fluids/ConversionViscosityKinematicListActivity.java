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
import com.nineinfosys.unitconverter.Engines.Fluids.ViscosityKinematic;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionViscosityKinematicListActivity extends AppCompatActivity implements TextWatcher {

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

   private String strsquaremeterpersecond=null,strsquaremeterperhour=null,strsquarecentimeterpersecond=null,strsquaremillimetersecond=null,strsquarefootsecond=null,strsquarefoothour=null,
            strsquareinchsecond=null,strstokes=null,strexastokes=null,strpetastokes=null,strterastokes=null,strgigastokes=null,strmegastokes=null,strkilostokes=null,strhectostokes=null,
            strdekastokes=null,strdecistokes=null,strcentistokes=null,strmillistokes=null,strmicrostokes=null,strnanostokes=null,strpicostokes=null,strfemtostokes=null,strattostokes=null;


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
        getSupportActionBar().setTitle("Viscosity Kinematic ");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        //format of decimal pint
        formatsetting();

        MobileAds.initialize(ConversionViscosityKinematicListActivity.this, getString(R.string.ads_app_id));
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
            case "Square meter/second -m^2/s":
                textconversionFrom.setText("Square meter/second ");                 textViewConversionShortform.setText("m^2/s");
                break;
            case "Square meter/hour -m^2/h":
                textconversionFrom.setText("Square meter/hour ");                 textViewConversionShortform.setText("m^2/h");
                break;
            case "Square centimeter/second -cm^2/s":
                textconversionFrom.setText("Square centimeter/second ");                 textViewConversionShortform.setText("cm^2/s");
                break;
            case "Square millimeter/second -mm^2/s":
                textconversionFrom.setText("Square millimeter/second ");                 textViewConversionShortform.setText("mm^2/s");
                break;
            case "Square foot/second -ft^2/s":
                textconversionFrom.setText("Square foot/second ");                 textViewConversionShortform.setText("ft^2/s");
                break;
            case "Square foot/hour -ft^2/h":
                textconversionFrom.setText("Square foot/hour ");                 textViewConversionShortform.setText("ft^2/h");
                break;
            case "Square inch/second -in^2/s":
                textconversionFrom.setText("Square inch/second ");                 textViewConversionShortform.setText("in^2/s");
                break;
            case "Stokes -St":
                textconversionFrom.setText("Stokes ");                 textViewConversionShortform.setText("St");
                break;
            case "Exastokes -ESt":
                textconversionFrom.setText("Exastokes ");                 textViewConversionShortform.setText("ESt");
                break;
            case "Petastokes -PSt":
                textconversionFrom.setText("Petastokes ");                 textViewConversionShortform.setText("PSt");
                break;
            case "Terastokes -TSt":
                textconversionFrom.setText("Terastokes ");                 textViewConversionShortform.setText("TSt");
                break;
            case "Gigastokes -GSt":
                textconversionFrom.setText("Gigastokes ");                 textViewConversionShortform.setText("GSt");
                break;
            case "Megastokes -MSt":
                textconversionFrom.setText("Megastokes ");                 textViewConversionShortform.setText("MSt");
                break;
            case "Kilostokes -kSt":
                textconversionFrom.setText("Kilostokes ");                 textViewConversionShortform.setText("kSt");
                break;
            case "Hectostokes -hSt":
                textconversionFrom.setText("Hectostokes ");                 textViewConversionShortform.setText("hSt");
                break;
            case "Dekastokes -daSt":
                textconversionFrom.setText("Dekastokes ");                 textViewConversionShortform.setText("daSt");
                break;
            case "Decistokes -dSt":
                textconversionFrom.setText("Decistokes ");                 textViewConversionShortform.setText("dSt");
                break;
            case "Centistokes -cSt":
                textconversionFrom.setText("Centistokes ");                 textViewConversionShortform.setText("cSt");
                break;
            case "Millistokes -mSt":
                textconversionFrom.setText("Millistokes ");                 textViewConversionShortform.setText("mSt");
                break;
            case "Microstokes -μSt":
                textconversionFrom.setText("Microstokes ");                 textViewConversionShortform.setText("μSt");
                break;
            case "Nanostokes -nSt":
                textconversionFrom.setText("Nanostokes ");                 textViewConversionShortform.setText("nSt");
                break;
            case "Picostokes -pSt":
                textconversionFrom.setText("Picostokes ");                 textViewConversionShortform.setText("pSt");
                break;
            case "Femtostokes -fSt":
                textconversionFrom.setText("Femtostokes ");                 textViewConversionShortform.setText("fSt");
                break;
            case "Attostokes -aSt":
                textconversionFrom.setText("Attostokes ");                 textViewConversionShortform.setText("aSt");
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

        ViscosityKinematic c = new ViscosityKinematic(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<ViscosityKinematic.ConversionResults> results = c.calculateViscosityKinematicConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ViscosityKinematic.ConversionResults item = results.get(i);


            strsquaremeterpersecond=String.valueOf(formatter.format(item.getSquaremeterpersecond()));
            strsquaremeterperhour=String.valueOf(formatter.format(item.getSquaremeterperhour()));
            strsquarecentimeterpersecond=String.valueOf(formatter.format(item.getSquarecentimeterpersecond()));
            strsquaremillimetersecond=String.valueOf(formatter.format(item.getSquaremillimetersecond()));
            strsquarefootsecond=String.valueOf(formatter.format(item.getSquarefootsecond()));
            strsquarefoothour=String.valueOf(formatter.format(item.getSquarefoothour()));
            strsquareinchsecond=String.valueOf(formatter.format(item.getSquareinchsecond()));
            strstokes=String.valueOf(formatter.format(item.getStokes()));
            strexastokes=String.valueOf(formatter.format(item.getExastokes()));
            strpetastokes=String.valueOf(formatter.format(item.getPetastokes()));
            strterastokes=String.valueOf(formatter.format(item.getTerastokes()));
            strgigastokes=String.valueOf(formatter.format(item.getGigastokes()));
            strmegastokes=String.valueOf(formatter.format(item.getMegastokes()));
            strkilostokes=String.valueOf(formatter.format(item.getKilostokes()));
            strhectostokes=String.valueOf(formatter.format(item.getHectostokes()));
            strdekastokes=String.valueOf(formatter.format(item.getDekastokes()));
            strdecistokes=String.valueOf(formatter.format(item.getDecistokes()));
            strcentistokes=String.valueOf(formatter.format(item.getCentistokes()));
            strmillistokes=String.valueOf(formatter.format(item.getMillistokes()));
            strmicrostokes=String.valueOf(formatter.format(item.getMicrostokes()));
            strnanostokes=String.valueOf(formatter.format(item.getNanostokes()));
            strpicostokes=String.valueOf(formatter.format(item.getPicostokes()));
            strfemtostokes=String.valueOf(formatter.format(item.getFemtostokes()));
            strattostokes=String.valueOf(formatter.format(item.getAttostokes()));


            list.add(new ItemList("m^2/s","Square meter/second ",strsquaremeterpersecond,"m^2/s"));
            list.add(new ItemList("m^2/h","Square meter/hour ",strsquaremeterperhour,"m^2/h"));
            list.add(new ItemList("cm^2/s","Square centimeter/second ",strsquarecentimeterpersecond,"cm^2/s"));
            list.add(new ItemList("mm^2/s","Square millimeter/second ",strsquaremillimetersecond,"mm^2/s"));
            list.add(new ItemList("ft^2/s","Square foot/second ",strsquarefootsecond,"ft^2/s"));
            list.add(new ItemList("ft^2/h","Square foot/hour ",strsquarefoothour,"ft^2/h"));
            list.add(new ItemList("in^2/s","Square inch/second ",strsquareinchsecond,"in^2/s"));
            list.add(new ItemList("St","Stokes ",strstokes,"St"));
            list.add(new ItemList("ESt","Exastokes ",strexastokes,"ESt"));
            list.add(new ItemList("PSt","Petastokes ",strpetastokes,"PSt"));
            list.add(new ItemList("TSt","Terastokes ",strterastokes,"TSt"));
            list.add(new ItemList("GSt","Gigastokes ",strgigastokes,"GSt"));
            list.add(new ItemList("MSt","Megastokes ",strmegastokes,"MSt"));
            list.add(new ItemList("kSt","Kilostokes ",strkilostokes,"kSt"));
            list.add(new ItemList("hSt","Hectostokes ",strhectostokes,"hSt"));
            list.add(new ItemList("daSt","Dekastokes ",strdekastokes,"daSt"));
            list.add(new ItemList("dSt","Decistokes ",strdecistokes,"dSt"));
            list.add(new ItemList("cSt","Centistokes ",strcentistokes,"cSt"));
            list.add(new ItemList("mSt","Millistokes ",strmillistokes,"mSt"));
            list.add(new ItemList("μSt","Microstokes ",strmicrostokes,"μSt"));
            list.add(new ItemList("nSt","Nanostokes ",strnanostokes,"nSt"));
            list.add(new ItemList("pSt","Picostokes ",strpicostokes,"pSt"));
            list.add(new ItemList("fSt","Femtostokes ",strfemtostokes,"fSt"));
            list.add(new ItemList("aSt","Attostokes ",strattostokes,"aSt"));



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
        printhelper=new PrintHelper(ConversionViscosityKinematicListActivity.this);
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

