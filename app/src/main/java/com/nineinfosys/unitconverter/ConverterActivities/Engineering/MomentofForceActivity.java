package com.nineinfosys.unitconverter.ConverterActivities.Engineering;

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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.unitconverter.ConverterActivities.ActivitySetting;
import com.nineinfosys.unitconverter.ConverterActivities.Electricity.ConductanceConverterActivity;
import com.nineinfosys.unitconverter.ConverterActivityList.Engineering.ConversionMomentofForceListActivity;
import com.nineinfosys.unitconverter.ConverterActivityList.Engineering.ConversionVelocityAngularListActivity;
import com.nineinfosys.unitconverter.Engines.Engineering.MomentofForceConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MomentofForceActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;

    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listtempFirstfrom, listFirsttempTo, listtempfrom, listtempTo;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 5;
    private int allunit = 12;
    private static final int REQUEST_CODE = 100;
    DecimalFormat formatter = null;


    MomentofForceConverter.ConversionResults item;
    String strnewtonmeter=null,strkilonewtonmeter=null,strmillinewtonmeter=null,strmicronewtonmeter=null,strtonforceshortmeter=null,strtonforcelongmeter=null,strtonforcemetricmeter=null,
            strkilogramforcemeter =null,strgramforcecentimeter=null,strpoundforcefoot=null,strpoundalfoot=null,strpoundalinch=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1976d2")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Moment Of Force");

        formatsetting();

        MobileAds.initialize(MomentofForceActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBlue)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#004ba0"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Newton meter -N*m");
        listtempFirstfrom.add("Kilonewton meter -kN*m");
        listtempFirstfrom.add("Millinewton meter -mN*m");
        listtempFirstfrom.add("Micronewton meter -μN*m");

        //for first time running spinner
        listFirsttempTo.add("Newton meter -N*m");
        listFirsttempTo.add("Kilonewton meter -kN*m");
        listFirsttempTo.add("Millinewton meter -mN*m");
        listFirsttempTo.add("Micronewton meter -μN*m");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(MomentofForceActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(MomentofForceActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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

                listtempfrom = new ArrayList<String>();
                listtempTo = new ArrayList<String>();
                String stringSwitchSate = String.valueOf(isChecked);
                String strBasic = "Basic";
                String strAdvance = "All";
                switch (stringSwitchSate) {

                    case "false":
                        Snackbar.make(buttonView, "You switched to " + strBasic + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Newton meter -N*m");
                        listtempfrom.add("Kilonewton meter -kN*m");
                        listtempfrom.add("Millinewton meter -mN*m");
                        listtempfrom.add("Micronewton meter -μN*m");


                        //2 spinner
                        listtempTo.add("Newton meter -N*m");
                        listtempTo.add("Kilonewton meter -kN*m");
                        listtempTo.add("Millinewton meter -mN*m");
                        listtempTo.add("Micronewton meter -μN*m");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Newton meter -N*m");
                        listtempfrom.add("Kilonewton meter -kN*m");
                        listtempfrom.add("Millinewton meter -mN*m");
                        listtempfrom.add("Micronewton meter -μN*m");
                        listtempfrom.add("Ton-force (short) meter -ton*m");
                        listtempfrom.add("Ton-force (long) meter -ton*m");
                        listtempfrom.add("Ton-force (metric) meter -ton*m");
                        listtempfrom.add("Kilogram-force meter -kgf*m");
                        listtempfrom.add("Gram-force centimeter -gf*cm");
                        listtempfrom.add("Pound-force foot -lbf*ft");
                        listtempfrom.add("Poundal foot -pdl*ft");
                        listtempfrom.add("Poundal inch -pdl*in");


                        //second spinner
                        listtempTo.add("Newton meter -N*m");
                        listtempTo.add("Kilonewton meter -kN*m");
                        listtempTo.add("Millinewton meter -mN*m");
                        listtempTo.add("Micronewton meter -μN*m");
                        listtempTo.add("Ton-force (short) meter -ton*m");
                        listtempTo.add("Ton-force (long) meter -ton*m");
                        listtempTo.add("Ton-force (metric) meter -ton*m");
                        listtempTo.add("Kilogram-force meter -kgf*m");
                        listtempTo.add("Gram-force centimeter -gf*cm");
                        listtempTo.add("Pound-force foot -lbf*ft");
                        listtempTo.add("Poundal foot -pdl*ft");
                        listtempTo.add("Poundal inch -pdl*in");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(MomentofForceActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(MomentofForceActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionMomentofForceListActivity.class);
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


  /* @Override
   protected void onResume() {
       Intent intent = new Intent(TempertureActivity.this, TempertureActivity.class);
       TempertureActivity.this.startActivity(intent);
       finish();
       super.onResume();
   }*/
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

            MomentofForceConverter c = new MomentofForceConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<MomentofForceConverter.ConversionResults> results = c.calculateMomentofForceConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strnewtonmeter=String.valueOf(formatter.format(item.getNewtonmeter()));
                strkilonewtonmeter=String.valueOf(formatter.format(item.getKilonewtonmeter()));
                strmillinewtonmeter=String.valueOf(formatter.format(item.getMillinewtonmeter()));
                strmicronewtonmeter=String.valueOf(formatter.format(item.getMicronewtonmeter()));
                strtonforceshortmeter=String.valueOf(formatter.format(item.getTonforceshortmeter()));
                strtonforcelongmeter=String.valueOf(formatter.format(item.getTonforcelongmeter()));
                strtonforcemetricmeter=String.valueOf(formatter.format(item.getTonforcemetricmeter()));
                strkilogramforcemeter=String.valueOf(formatter.format(item.getKilogramforcemeter()));
                strgramforcecentimeter=String.valueOf(formatter.format(item.getGramforcecentimeter()));
                strpoundforcefoot=String.valueOf(formatter.format(item.getPoundforcefoot()));
                strpoundalfoot=String.valueOf(formatter.format(item.getPoundalfoot()));
                strpoundalinch=String.valueOf(formatter.format(item.getPoundalinch()));



                switch (strSpinnerFromvalue1) {
                    case "Newton meter -N*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilonewton meter -kN*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millinewton meter -mN*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Micronewton meter -μN*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ton-force (short) meter -ton*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ton-force (long) meter -ton*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ton-force (metric) meter -ton*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram-force meter -kgf*m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram-force centimeter -gf*cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound-force foot -lbf*ft":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Poundal foot -pdl*ft":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Poundal inch -pdl*in":
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
            
            case "Newton meter -N*m":
                editTextValueTo.setText(strnewtonmeter);
                break;
            case "Kilonewton meter -kN*m":
                editTextValueTo.setText(strkilonewtonmeter);
                break;
            case "Millinewton meter -mN*m":
                editTextValueTo.setText(strmillinewtonmeter);
                break;
            case "Micronewton meter -μN*m":
                editTextValueTo.setText(strmicronewtonmeter);
                break;
            case "Ton-force (short) meter -ton*m":
                editTextValueTo.setText(strtonforceshortmeter);
                break;
            case "Ton-force (long) meter -ton*m":
                editTextValueTo.setText(strtonforcelongmeter);
                break;
            case "Ton-force (metric) meter -ton*m":
                editTextValueTo.setText(strtonforcemetricmeter);
                break;
            case "Kilogram-force meter -kgf*m":
                editTextValueTo.setText(strkilogramforcemeter);
                break;
            case "Gram-force centimeter -gf*cm":
                editTextValueTo.setText(strgramforcecentimeter);
                break;
            case "Pound-force foot -lbf*ft":
                editTextValueTo.setText(strpoundforcefoot);
                break;
            case "Poundal foot -pdl*ft":
                editTextValueTo.setText(strpoundalfoot);
                break;
            case "Poundal inch -pdl*in":
                editTextValueTo.setText(strpoundalinch);
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