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

import com.nineinfosys.unitconverter.ConverterActivities.ActivitySetting;
import com.nineinfosys.unitconverter.ConverterActivityList.Engineering.ConversionMomentOfInertiaListActivity;
import com.nineinfosys.unitconverter.Engines.Engineering.MomentOfInertiaConverter;
import com.nineinfosys.unitconverter.R;
import com.nineinfosys.unitconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MomentOfInertiaActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private static final int REQUEST_CODE = 100;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listtempFirstfrom, listFirsttempTo, listtempfrom, listtempTo;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 4;
    private int allunit = 14;
    DecimalFormat formatter = null;


    MomentOfInertiaConverter.ConversionResults item;
   private String strkilosqmt=null,strkilosqcm=null,strkilosqmm=null,strgmsqcm=null,strgmsqmm=null,strkilogmforcemt=null,strkilogramforcecm=null,strouncesqinch=null,strounceforceinch=null,
            strpoundsqfoot=null,strpoundforcefoot=null,strpoundsqinch=null,strpoundforceinch=null,strslugsqfoot=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#81c784")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Moment Of Inertia");

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
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));
       // DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getTrackDrawable()), ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreenish)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#519657"));
        }

        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listtempFirstfrom = new ArrayList<String>();
        listFirsttempTo = new ArrayList<String>();


        //for first time running spinner
        listtempFirstfrom.add("Kilogram square meter -kg*M^2");
        listtempFirstfrom.add("Kilogram square centimeter -kg*cm^2");
        listtempFirstfrom.add("Kilogram square millimeter -kg*mm^2");
        listtempFirstfrom.add("Gram square centimeter -g*cm^2");

        //for first time running spinner
        listFirsttempTo.add("Kilogram square meter -kg*M^2");
        listFirsttempTo.add("Kilogram square centimeter -kg*cm^2");
        listFirsttempTo.add("Kilogram square millimeter -kg*mm^2");
        listFirsttempTo.add("Gram square centimeter -g*cm^2");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(MomentOfInertiaActivity.this, android.R.layout.simple_spinner_item, listtempFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(MomentOfInertiaActivity.this, android.R.layout.simple_spinner_item, listFirsttempTo);


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
                        listtempfrom.add("Kilogram square meter -kg*M^2");
                        listtempfrom.add("Kilogram square centimeter -kg*cm^2");
                        listtempfrom.add("Kilogram square millimeter -kg*mm^2");
                        listtempfrom.add("Gram square centimeter -g*cm^2");


                        //2 spinner
                        listtempTo.add("Kilogram square meter -kg*M^2");
                        listtempTo.add("Kilogram square centimeter -kg*cm^2");
                        listtempTo.add("Kilogram square millimeter -kg*mm^2");
                        listtempTo.add("Gram square centimeter -g*cm^2");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listtempfrom.clear();
                        listtempTo.clear();
                        listtempfrom.add("Kilogram square meter -kg*M^2");
                        listtempfrom.add("Kilogram square centimeter -kg*cm^2");
                        listtempfrom.add("Kilogram square millimeter -kg*mm^2");
                        listtempfrom.add("Gram square centimeter -g*cm^2");
                        listtempfrom.add("Gram square millimeter -g*mm^2");
                        listtempfrom.add("Kilogram-force meter square second -kgfM*s^2");
                        listtempfrom.add("Kilogram-force centimeter square second -kgfcm*s^2");
                        listtempfrom.add("Ounce square inch -oz*in^2");
                        listtempfrom.add("Ounce-force inch sq. second -ozfin*s^2");
                        listtempfrom.add("Pound square foot -lb*ft^2");
                        listtempfrom.add("Pound-force foot sq. second -lbfft*s^2");
                        listtempfrom.add("Pound square inch -lb*in^2");
                        listtempfrom.add("Pound-force inch sq. second -lbfin*s^2");
                        listtempfrom.add( "Slug square foot -slug*ft^2");


                        //second spinner
                        listtempTo.add("Kilogram square meter -kg*M^2");
                        listtempTo.add("Kilogram square centimeter -kg*cm^2");
                        listtempTo.add("Kilogram square millimeter -kg*mm^2");
                        listtempTo.add("Gram square centimeter -g*cm^2");
                        listtempTo.add("Gram square millimeter -g*mm^2");
                        listtempTo.add("Kilogram-force meter square second -kgfM*s^2");
                        listtempTo.add("Kilogram-force centimeter square second -kgfcm*s^2");
                        listtempTo.add("Ounce square inch -oz*in^2");
                        listtempTo.add("Ounce-force inch sq. second -ozfin*s^2");
                        listtempTo.add("Pound square foot -lb*ft^2");
                        listtempTo.add("Pound-force foot sq. second -lbfft*s^2");
                        listtempTo.add("Pound square inch -lb*in^2");
                        listtempTo.add("Pound-force inch sq. second -lbfin*s^2");
                        listtempTo.add( "Slug square foot -slug*ft^2");

                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(MomentOfInertiaActivity.this, android.R.layout.simple_spinner_item, listtempfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(MomentOfInertiaActivity.this, android.R.layout.simple_spinner_item, listtempTo);


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
                Intent i = new Intent(this, ConversionMomentOfInertiaListActivity.class);
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

            MomentOfInertiaConverter c = new MomentOfInertiaConverter(strSpinnerFromvalue1, doubleEdittextvalue1);
            ArrayList<MomentOfInertiaConverter.ConversionResults> results = c.calculateinertiaConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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


                switch (strSpinnerFromvalue1) {
                    case "Kilogram square meter -kg*M^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram square centimeter -kg*cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram square millimeter -kg*mm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram square centimeter -g*cm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gram square millimeter -g*mm^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram-force meter square second -kgfM*s^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogram-force centimeter square second -kgfcm*s^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ounce square inch -oz*in^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ounce-force inch sq. second -ozfin*s^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound square foot -lb*ft^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound-force foot sq. second -lbfft*s^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound square inch -lb*in^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Pound-force inch sq. second -lbfin*s^2":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Slug square foot -slug*ft^2":
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
            case "Kilogram square meter -kg*M^2":
                editTextValueTo.setText(strkilosqmt);
                break;
            case "Kilogram square centimeter -kg*cm^2":
                editTextValueTo.setText(strkilosqcm);
                break;
            case "Kilogram square millimeter -kg*mm^2":
                editTextValueTo.setText(strkilosqmm);
                break;
            case "Gram square centimeter -g*cm^2":
                editTextValueTo.setText(strgmsqcm);
                break;
            case "Gram square millimeter -g*mm^2":
                editTextValueTo.setText(strgmsqmm);
                break;
            case "Kilogram-force meter square second -kgfM*s^2":
                editTextValueTo.setText(strkilogmforcemt);
                break;
            case "Kilogram-force centimeter square second -kgfcm*s^2":
                editTextValueTo.setText(strkilogramforcecm);
                break;
            case "Ounce square inch -oz*in^2":
                editTextValueTo.setText(strouncesqinch);
                break;
            case "Ounce-force inch sq. second -ozfin*s^2":
                editTextValueTo.setText(strounceforceinch);
                break;
            case "Pound square foot -lb*ft^2":
                editTextValueTo.setText(strpoundsqfoot);
                break;
            case "Pound-force foot sq. second -lbfft*s^2":
                editTextValueTo.setText(strpoundforcefoot);
                break;
            case "Pound square inch -lb*in^2":
                editTextValueTo.setText(strpoundsqinch);
                break;
            case "Pound-force inch sq. second -lbfin*s^2":
                editTextValueTo.setText(strpoundforceinch);
                break;
            case "Slug square foot -slug*ft^2":
                editTextValueTo.setText(strslugsqfoot);
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