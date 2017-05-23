package com.nineinfosys.unitconverter.ConverterActivityList.Other;

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

import com.nineinfosys.unitconverter.Adapters.RecyclerViewConversionListAdapter;
import com.nineinfosys.unitconverter.ConverterActivities.ActivitySetting;
import com.nineinfosys.unitconverter.Engines.Other.Hardness;
import com.nineinfosys.unitconverter.Engines.Other.Prefixes;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionPrefixListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    private Prefixes.ConversionResults item;
    private String strnone=null,stryotta=null,strzetta=null,strexa=null,strpeta=null,strtera=null,strgiga=null,strmega=null,strkilo=null,strhecto=null,strdeka=null,strdeci=null,
            strcenti=null,strmilli=null,strmicro=null,strnano=null,strpico=null,strfemto=null,stratto=null,strzepto=null,stryocto=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9cc409")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#699300"));
        }

        //format of decimal pint
        formatsetting();
        

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
            case "None - none":
                 textconversionFrom.setText("None");
                 textViewConversionShortform.setText("none");
                break;
            case "Yotta - Y":
                 textconversionFrom.setText("Yotta");
                 textViewConversionShortform.setText("Y");
                break;
            case "Zetta - Z":
                 textconversionFrom.setText("Zetta");
                 textViewConversionShortform.setText("Z");
                break;
            case "Exa - E":
                 textconversionFrom.setText("Exa");
                textViewConversionShortform.setText("E");
                break;
            case "Peta - P":
                 textconversionFrom.setText("Peta");
                 textViewConversionShortform.setText("P");
                break;
            case "Tera - T":
                 textconversionFrom.setText("Tera");
                 textViewConversionShortform.setText("T");
                break;
            case "Giga - G":
                 textconversionFrom.setText("Giga");
                 textViewConversionShortform.setText("G");
                break;
            case "Mega - M":
                 textconversionFrom.setText("Mega");
                 textViewConversionShortform.setText("M");
                break;
            case "Kilo - k":
                 textconversionFrom.setText("Kilo");
                 textViewConversionShortform.setText("k");
                break;

            case "Hecto - h":
                 textconversionFrom.setText("Hecto");
                 textViewConversionShortform.setText("h");
                break;
            case "Deka - da":
                 textconversionFrom.setText("Deka");
                 textViewConversionShortform.setText("da");
                break;
            case "Deci - d":
                 textconversionFrom.setText("Deci");
                 textViewConversionShortform.setText("d");
                break;
            case "Centi - c":
                 textconversionFrom.setText("Centi");
                 textViewConversionShortform.setText("c");
                break;
            case "Milli - m":
                 textconversionFrom.setText("Milli");
                 textViewConversionShortform.setText("m");
                break;

            case "Micro - µ":
                 textconversionFrom.setText("Micro");
                 textViewConversionShortform.setText("µ");
                break;
            case "Nano - n":
                 textconversionFrom.setText("Nano");
                 textViewConversionShortform.setText("n");
                break;
            case "Pico - p":
                 textconversionFrom.setText("Pico");
                 textViewConversionShortform.setText("p");
                break;
            case "Femto - f":
                 textconversionFrom.setText("Femto");
                 textViewConversionShortform.setText("f");
                break;
            case "Atto - a":
                 textconversionFrom.setText("Atto");
                textViewConversionShortform.setText("a");
                break;
            case "Zepto - z":
                 textconversionFrom.setText("Zepto");
                textViewConversionShortform.setText("z");
                break;
            case "Yocto - y":
                 textconversionFrom.setText("Yocto");
                textViewConversionShortform.setText("y");
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
        Prefixes c = new Prefixes(strSpinnerFrom, doubleEdittextvalue1);
        ArrayList<Prefixes.ConversionResults> results = c.calculateprefixConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            item = results.get(i);

            strnone= String.valueOf(formatter.format(item.getNone()));
            stryotta= String.valueOf(formatter.format(item.getYotta()));
            strzetta= String.valueOf(formatter.format(item.getZetta()));
            strexa= String.valueOf(formatter.format(item.getExa()));
            strpeta= String.valueOf(formatter.format(item.getPeta()));
            strtera= String.valueOf(formatter.format(item.getTera()));
            strgiga= String.valueOf(formatter.format(item.getGiga()));
            strmega= String.valueOf(formatter.format(item.getMega()));
            strkilo= String.valueOf(formatter.format(item.getKilo()));
            strhecto= String.valueOf(formatter.format(item.getHecto()));
            strdeka= String.valueOf(formatter.format(item.getDeka()));
            strdeci= String.valueOf(formatter.format(item.getDeci()));
            strcenti= String.valueOf(formatter.format(item.getCenti()));
            strmilli= String.valueOf(formatter.format(item.getMilli()));
            strmicro= String.valueOf(formatter.format(item.getMicro()));
            strnano= String.valueOf(formatter.format(item.getNano()));
            strpico= String.valueOf(formatter.format(item.getPico()));
            strfemto= String.valueOf(formatter.format(item.getFemto()));
            stratto= String.valueOf(formatter.format(item.getAtto()));
            strzepto= String.valueOf(formatter.format(item.getZepto()));
            stryocto= String.valueOf(formatter.format(item.getYocto()));


            list.add(new ItemList("none","None",strnone,"none"));
            list.add(new ItemList("Y","Yotta",stryotta,"Y"));
            list.add(new ItemList("Z","Zetta",strzetta,"Z"));
            list.add(new ItemList("E","Exa",strexa,"E"));
            list.add(new ItemList("P","Peta",strpeta,"P"));
            list.add(new ItemList("T","Tera",strtera,"T"));
            list.add(new ItemList("G","Giga",strgiga,"G"));

            list.add(new ItemList("M","Mega",strmega,"M"));
            list.add(new ItemList("k","Kilo",strkilo,"k"));
            list.add(new ItemList("h","Hecto",strhecto,"h"));
            list.add(new ItemList("da","Deka",strdeka,"da"));
            list.add(new ItemList("d","Deci",strdeci,"d"));
            list.add(new ItemList("c","Centi",strcenti,"c"));
            list.add(new ItemList("m","Milli",strmilli,"m"));

            list.add(new ItemList("µ","Micro",strmicro,"µ"));
            list.add(new ItemList("n","Nano",strnano,"n"));
            list.add(new ItemList("p","Pico",strpico,"p"));
            list.add(new ItemList("f","Femto",strfemto,"f"));
            list.add(new ItemList("a","Atto",stratto,"a"));
            list.add(new ItemList("z","Zepto",strzepto,"z"));
            list.add(new ItemList("y","Yocto",stryocto,"y"));




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
        printhelper=new PrintHelper(ConversionPrefixListActivity.this);
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
