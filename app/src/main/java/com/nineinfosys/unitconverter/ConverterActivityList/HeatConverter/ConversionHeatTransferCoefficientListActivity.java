package com.nineinfosys.unitconverter.ConverterActivityList.HeatConverter;

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
import com.nineinfosys.unitconverter.Engines.Heat.HeatTransferCoefficientConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.ItemList;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionHeatTransferCoefficientListActivity extends AppCompatActivity implements TextWatcher {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e64a19")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#ac0800"));
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
            case "Watt/square meter/K -W/m^2/K":
                textconversionFrom.setText("Watt/square meter/K ");                 textViewConversionShortform.setText("W/m^2/K");
                break;
            case "Watt/square meter/%b0C -W/m^2/%b0C":
                textconversionFrom.setText("Watt/square meter/%b0C ");                 textViewConversionShortform.setText("W/m^2/%b0C");
                break;
            case "Joule/second/square meter/K -J/s/m^2/K":
                textconversionFrom.setText("Joule/second/square meter/K ");                 textViewConversionShortform.setText("J/s/m^2/K");
                break;
            case "Calorie (IT)/second/square centimeter/%b0C -cal(IT)/s/cm^2/%b0C":
                textconversionFrom.setText("Calorie (IT)/second/square centimeter/%b0C ");                 textViewConversionShortform.setText("cal(IT)/s/cm^2/%b0C");
                break;
            case "Kilocalorie (IT)/hour/square meter/%b0C -kcal(IT)/h/m^2/%b0C":
                textconversionFrom.setText("Kilocalorie (IT)/hour/square meter/%b0C ");                 textViewConversionShortform.setText("kcal(IT)/h/m^2/%b0C");
                break;
            case "Kilocalorie (IT)/hour/square foot/%b0C -kcal(IT)/h/ft^2/%b0C":
                textconversionFrom.setText("Kilocalorie (IT)/hour/square foot/%b0C ");                 textViewConversionShortform.setText("kcal(IT)/h/ft^2/%b0C");
                break;
            case "Btu (IT)/second/square foot/%b0F -Btu(IT)/s/ft^2/%b0F":
                textconversionFrom.setText("Btu (IT)/second/square foot/%b0F ");                 textViewConversionShortform.setText("Btu(IT)/s/ft^2/%b0F");
                break;
            case "Btu (th)/second/square foot/%b0F -Btu(th)/s/ft^2/%b0F":
                textconversionFrom.setText("Btu (th)/second/square foot/%b0F ");                 textViewConversionShortform.setText("Btu(th)/s/ft^2/%b0F");
                break;
            case "Btu (IT)/hour/square foot/%b0F -Btu(IT)/h/ft^2/%b0F":
                textconversionFrom.setText("Btu (IT)/hour/square foot/%b0F ");                 textViewConversionShortform.setText("Btu(IT)/h/ft^2/%b0F");
                break;
            case "Btu (th)/hour/square foot/%b0F -Btu(th)/h/ft^2/%b0F":
                textconversionFrom.setText("Btu (th)/hour/square foot/%b0F ");                 textViewConversionShortform.setText("Btu(th)/h/ft^2/%b0F");
                break;
            case "CHU/hour/square foot/%b0C -CHU/h/ft^2/%b0C":
                textconversionFrom.setText("CHU/hour/square foot/%b0C ");                 textViewConversionShortform.setText("CHU/h/ft^2/%b0C");
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

        HeatTransferCoefficientConverter c = new  HeatTransferCoefficientConverter(strSpinnerFrom,doubleEdittextvalue1);
        ArrayList<HeatTransferCoefficientConverter.ConversionResults> results = c.calculateHeatTransferCoefficientConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            HeatTransferCoefficientConverter.ConversionResults item = results.get(i);
            String strwattpersquaremeterperK=null,strwattpersquaremeterperb0C=null,strjoulepersecondpersquaremeterperK=null,strcalorieITpersecondpersquarecentimeterperb0C=null,
                    strkilocalorieITperhourpersquaremeterperb0C=null, strkilocalorieITperhourpersquarefootperb0C=null,strBtuITpersecondpersquarefootperb0F=null,strBtuthpersecondpersquarefootperb0F=null,
                    strBtuITperhourpersquarefootperb0F=null,strBtuthperhourpersquarefootperb0F=null, strCHUperhourpersquarefootperb0C=null;


            strwattpersquaremeterperK=String.valueOf(formatter.format(item.getWattpersquaremeterperK()));
            strwattpersquaremeterperb0C=String.valueOf(formatter.format(item.getWattpersquaremeterperb0C()));
            strjoulepersecondpersquaremeterperK=String.valueOf(formatter.format(item.getJoulepersecondpersquaremeterperK()));
            strcalorieITpersecondpersquarecentimeterperb0C=String.valueOf(formatter.format(item.getCalorieITpersecondpersquarecentimeterperb0C()));
            strkilocalorieITperhourpersquaremeterperb0C=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquaremeterperb0C()));
            strkilocalorieITperhourpersquarefootperb0C=String.valueOf(formatter.format(item.getKilocalorieITperhourpersquarefootperb0C()));
            strBtuITpersecondpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuITpersecondpersquarefootperb0F()));
            strBtuthpersecondpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuthpersecondpersquarefootperb0F()));
            strBtuITperhourpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuITperhourpersquarefootperb0F()));
            strBtuthperhourpersquarefootperb0F=String.valueOf(formatter.format(item.getBtuthperhourpersquarefootperb0F()));
            strCHUperhourpersquarefootperb0C=String.valueOf(formatter.format(item.getCHUperhourpersquarefootperb0C()));

            list.add(new ItemList("W/m^2/K","Watt/square meter/K ",strwattpersquaremeterperK,"W/m^2/K"));
            list.add(new ItemList("W/m^2/%b0C","Watt/square meter/%b0C ",strwattpersquaremeterperb0C,"W/m^2/%b0C"));
            list.add(new ItemList("J/s/m^2/K","Joule/second/square meter/K ",strjoulepersecondpersquaremeterperK,"J/s/m^2/K"));
            list.add(new ItemList("cal(IT)/s/cm^2/%b0C","Calorie (IT)/second/square centimeter/%b0C ",strcalorieITpersecondpersquarecentimeterperb0C,"cal(IT)/s/cm^2/%b0C"));
            list.add(new ItemList("kcal(IT)/h/m^2/%b0C","Kilocalorie (IT)/hour/square meter/%b0C ",strkilocalorieITperhourpersquaremeterperb0C,"kcal(IT)/h/m^2/%b0C"));
            list.add(new ItemList("kcal(IT)/h/ft^2/%b0C","Kilocalorie (IT)/hour/square foot/%b0C ",strkilocalorieITperhourpersquarefootperb0C,"kcal(IT)/h/ft^2/%b0C"));
            list.add(new ItemList("Btu(IT)/s/ft^2/%b0F","Btu (IT)/second/square foot/%b0F ",strBtuITpersecondpersquarefootperb0F,"Btu(IT)/s/ft^2/%b0F"));
            list.add(new ItemList("Btu(th)/s/ft^2/%b0F","Btu (th)/second/square foot/%b0F ",strBtuthpersecondpersquarefootperb0F,"Btu(th)/s/ft^2/%b0F"));
            list.add(new ItemList("Btu(IT)/h/ft^2/%b0F","Btu (IT)/hour/square foot/%b0F ",strBtuITperhourpersquarefootperb0F,"Btu(IT)/h/ft^2/%b0F"));
            list.add(new ItemList("Btu(th)/h/ft^2/%b0F","Btu (th)/hour/square foot/%b0F ",strBtuthperhourpersquarefootperb0F,"Btu(th)/h/ft^2/%b0F"));
            list.add(new ItemList("CHU/h/ft^2/%b0C","CHU/hour/square foot/%b0C ",strCHUperhourpersquarefootperb0C,"CHU/h/ft^2/%b0C"));
           



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
        printhelper=new PrintHelper(ConversionHeatTransferCoefficientListActivity.this);
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


