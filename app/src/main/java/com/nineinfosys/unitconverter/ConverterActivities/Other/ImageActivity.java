package com.nineinfosys.unitconverter.ConverterActivities.Other;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nineinfosys.unitconverter.ConverterActivities.ActivitySetting;
import com.nineinfosys.unitconverter.ConverterActivityList.Other.ConversionHardnessListActivity;
import com.nineinfosys.unitconverter.ConverterActivityList.Other.ConversionImageListActivity;
import com.nineinfosys.unitconverter.Engines.Other.Hardness;
import com.nineinfosys.unitconverter.Engines.Other.Image;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listFirstfrom, listFirstTo, listfrom, listTo;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 6;
    private int allunit = 12;
    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;

   private Image.ConversionResults item;
    private String strtwip=null,strmeter=null,strcentimeter=null,strmillimeter=null,strcharacterx=null,strcharactery=null,
            strpixelx=null,strpixely=null,strinch=null,strpica=null,strpoint=null,stren=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1e88e5")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Image");

        formatsetting();

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit = (TextView) findViewById(R.id.textViewBasicUnit);
        textViewAllUnit = (TextView) findViewById(R.id.textViewAllUnit);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        editTextValue = (EditText) findViewById(R.id.edittextFrom);
        editTextValueTo = (EditText) findViewById(R.id.edittextTo);
        buttonCopy = (FloatingActionButton) findViewById(R.id.button_copy);
        buttonList = (FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare = (FloatingActionButton) findViewById(R.id.button_list_share);
        buttonMail = (FloatingActionButton) findViewById(R.id.button_list_mail);
        switchChangeType = (SwitchCompat) findViewById(R.id.switchButton);

        //changing color dynamically
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightBlue)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#005cb2"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));

        //adding value to spinner
        listFirstfrom = new ArrayList<String>();
        listFirstTo = new ArrayList<String>();


        //for first time running spinner
        listFirstfrom.add("Meter - m");
        listFirstfrom.add("Centimeter - cm");
        listFirstfrom.add("Millimeter - mm");
        listFirstfrom.add("Inch - in");
        listFirstfrom.add("Pixel(X) - pixel(x)");
        listFirstfrom.add("Pixel(Y) - pixel(y)");


        listFirstTo.add("Meter - m");
        listFirstTo.add("Centimeter - cm");
        listFirstTo.add("Millimeter - mm");
        listFirstTo.add("Inch - in");
        listFirstTo.add("Pixel(X) - pixel(x)");
        listFirstTo.add("Pixel(Y) - pixel(y)");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ImageActivity.this, android.R.layout.simple_spinner_item, listFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ImageActivity.this, android.R.layout.simple_spinner_item, listFirstTo);


        // Drop down layout style - list view with radio button
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        AdapterTempTo.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        // attaching data adapter to spinner
        spinnerConvertFrom.setAdapter(Adapter);
        spinnerConvertTo.setAdapter(AdapterTempTo);

        //switch converttype
        switchChangeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                listfrom = new ArrayList<String>();
                listTo = new ArrayList<String>();
                String stringSwitchSate = String.valueOf(isChecked);
                String strBasic = "Basic";
                String strAdvance = "All";
                switch (stringSwitchSate) {

                    case "false":
                        Snackbar.make(buttonView, "You switched to " + strBasic + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listfrom.clear();
                        listTo.clear();
                        listfrom.add("Meter - m");
                        listfrom.add("Centimeter - cm");
                        listfrom.add("Millimeter - mm");
                        listfrom.add("Inch - in");
                        listfrom.add("Pixel(X) - pixel(x)");
                        listfrom.add("Pixel(Y) - pixel(y)");


                        //2 spinner

                        listTo.add("Meter - m");
                        listTo.add("Centimeter - cm");
                        listTo.add("Millimeter - mm");
                        listTo.add("Inch - in");
                        listTo.add("Pixel(X) - pixel(x)");
                        listTo.add("Pixel(Y) - pixel(y)");

                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listfrom.clear();
                        listTo.clear();
                        listfrom.add("Twip - twip");
                        listfrom.add("Meter - m");
                        listfrom.add("Centimeter - cm");
                        listfrom.add("Millimeter - mm");
                        listfrom.add("Inch - in");
                        listfrom.add("Pixel(X) - pixel(x)");
                        listfrom.add("Pixel(Y) - pixel(y)");
                        listfrom.add("Character(X) - character(x)");
                        listfrom.add("Character(Y) - character(y)");
                        listfrom.add("Pica - P");
                        listfrom.add("Point - pt");
                        listfrom.add("En - en");

                        //2 spinner
                        listTo.add("Twip - twip");
                        listTo.add("Meter - m");
                        listTo.add("Centimeter - cm");
                        listTo.add("Millimeter - mm");
                        listTo.add("Inch - in");
                        listTo.add("Pixel(X) - pixel(x)");
                        listTo.add("Pixel(Y) - pixel(y)");
                        listTo.add("Character(X) - character(x)");
                        listTo.add("Character(Y) - character(y)");
                        listTo.add("Pica - P");
                        listTo.add("Point - pt");
                        listTo.add("En - en");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ImageActivity.this, android.R.layout.simple_spinner_item, listfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ImageActivity.this, android.R.layout.simple_spinner_item, listTo);


                // Drop down layout style - list view with radio button
                Adapter2.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                AdapterTempTo2.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                // attaching data adapter to spinner
                spinnerConvertFrom.setAdapter(Adapter2);
                spinnerConvertTo.setAdapter(AdapterTempTo2);

            }
        });

        editTextValue.addTextChangedListener(this);
        buttonList.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonCopy.setOnClickListener(this);
        textViewConvert.setOnClickListener(this);


        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences = this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF, "Thousands separator");
        String DecimalplaceString = sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF, "2");
        Settings settings = new Settings(FormattedString, DecimalplaceString);
        formatter = settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i = new Intent(this, ConversionImageListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text = editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                break;

            case R.id.button_list_share:
                String textTo = editTextValueTo.getText().toString().trim();
                String textFrom = editTextValueTo.getText().toString().trim();

                String shareMessage = textFrom + " " + stringSpinnerFrom + ": " + textTo + " " + stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
             break;

            case R.id.button_list_mail:
                String textmailTo = editTextValueTo.getText().toString().trim();
                String textmailFrom = editTextValueTo.getText().toString().trim();
                String message = textmailTo + " " + stringSpinnerFrom + " :  " + textmailFrom + "  " + stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));
                break;

        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
            stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
            stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();
            calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);

        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    public void calcualteValue(String strSpinnerFromvalue1, String strSpinnerTovalue2, double doubleEdittextvalue1) {
        try {

            Image c = new Image(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<Image.ConversionResults> results = c.calculateimageConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strtwip= String.valueOf(formatter.format(item.getTwip()));
                strmeter= String.valueOf(formatter.format(item.getMeter()));
                strcentimeter= String.valueOf(formatter.format(item.getCentimeter()));
                strmillimeter= String.valueOf(formatter.format(item.getMillimeter()));
                strcharacterx= String.valueOf(formatter.format(item.getCharacterx()));
                strcharactery= String.valueOf(formatter.format(item.getCharactery()));
                strpixelx= String.valueOf(formatter.format(item.getPixelx()));
                strpixely= String.valueOf(formatter.format(item.getPixely()));
                strinch= String.valueOf(formatter.format(item.getInch()));
                strpica= String.valueOf(formatter.format(item.getPica()));
                strpoint= String.valueOf(formatter.format(item.getPoint()));
                stren= String.valueOf(formatter.format(item.getEn()));

               
                switch (strSpinnerFromvalue1) {
                    case "Twip - twip":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Meter - m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Centimeer - cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millimeter - mm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Inch - in":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pixel(X) - pixel(x)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pixel(Y) - pixel(y)":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Character(X) - character(x)":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Character(Y) - character(y)":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Pica - P":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Point - pt":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "En - en":
                        conversion(strSpinnerTovalue2);
                        break;

                }
            }


        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    private void conversion(String strSpinnerTovalue2) {

        switch (strSpinnerTovalue2) {
           
            case "Twip - twip":
              editTextValueTo.setText(strtwip);
                break;
            case "Meter - m":
              editTextValueTo.setText(strmeter);
                break;
            case "Centimeer - cm":
              editTextValueTo.setText(strcentimeter);
                break;
            case "Millimeter - mm":
              editTextValueTo.setText(strmillimeter);
                break;
            case "Inch - in":
              editTextValueTo.setText(strinch);
                break;
            case "Pixel(X) - pixel(x)":
              editTextValueTo.setText(strpixelx);
                break;
            case "Pixel(Y) - pixel(y)":
              editTextValueTo.setText(strpixely);
                break;
            case "Character(X) - character(x)":
              editTextValueTo.setText(strcharacterx);
                break;
            case "Character(Y) - character(y)":
              editTextValueTo.setText(strcharactery);
                break;
            case "Pica - P":
              editTextValueTo.setText(strpica);
                break;
            case "Point - pt":
              editTextValueTo.setText(strpoint);
                break;
            case "En - en":
              editTextValueTo.setText(stren);
                break;
        }


    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
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