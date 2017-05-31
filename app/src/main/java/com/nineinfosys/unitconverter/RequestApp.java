package com.nineinfosys.unitconverter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by AndriodDev5 on 16-03-2017.
 */

public class RequestApp  extends AppCompatActivity {

    private OrderApp orderApp;
    private EditText editTextdevice;
    private EditText editTextOS;
    private EditText editTextApplication;
    private EditText editTextIndustry;
    private EditText editTextAppDescription;
    private EditText editTextPhoneNumber;
    private EditText editTextContactEmail;
    private Button buttonGetQuote;

    //Azure Database connection for contact uploading
    private MobileServiceClient mobileServiceClientOrderApp;
    private MobileServiceTable<OrderApp> mobileServiceTableOrderApp;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_app);


        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Request Your Customized App");


        editTextdevice = (EditText)findViewById(R.id.editTextDevice);
        editTextOS = (EditText)findViewById(R.id.editTextOS);
        editTextApplication = (EditText)findViewById(R.id.editTextApplication);
        editTextIndustry = (EditText)findViewById(R.id.editTextIndustry);
        editTextAppDescription = (EditText)findViewById(R.id.editTextAppDescription);
        editTextPhoneNumber = (EditText)findViewById(R.id.editTextContactPhoneNumber);
        editTextContactEmail = (EditText)findViewById(R.id.editTextContactEmail);
        buttonGetQuote = (Button)findViewById(R.id.buttonGetQuote);
        buttonGetQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeAzureTable();
                uploadOrder();
            }
        });


    }


    private void initializeAzureTable() {
        try {
            mobileServiceClientOrderApp = new MobileServiceClient(
                    getString(R.string.web_address),
                    this);
            mobileServiceClientOrderApp.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });
            mobileServiceTableOrderApp = mobileServiceClientOrderApp.getTable(OrderApp.class);


        } catch (MalformedURLException e) {

        } catch (Exception e) {

        }
    }
    private void uploadOrder() {
        firebaseAuth = FirebaseAuth.getInstance();
        orderApp = new OrderApp();
        orderApp.setFirebaseid(firebaseAuth.getCurrentUser().getUid());
        orderApp.setAppid(getString(R.string.app_name));
        orderApp.setDevice(editTextdevice.getText().toString());
        orderApp.setOs(editTextOS.getText().toString());
        orderApp.setApptype(editTextApplication.getText().toString());
        orderApp.setIndustry(editTextIndustry.getText().toString());
        orderApp.setDescription(editTextAppDescription.getText().toString());
        orderApp.setPhone(editTextPhoneNumber.getText().toString());
        orderApp.setEmail(editTextContactEmail.getText().toString());

        try {
            mobileServiceTableOrderApp.insert(orderApp);
            editTextdevice.setText("");
            editTextOS.setText("");
            editTextApplication.setText("");
            editTextIndustry.setText("");
            editTextAppDescription.setText("");
            editTextPhoneNumber.setText("");
            editTextContactEmail.setText("");

            Toast.makeText(RequestApp.this, "Submitted", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Log.e("feedback ", e.toString());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent=new Intent(RequestApp.this,MainActivity.class);
            finish();
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent(RequestApp.this,MainActivity.class);
                finish();
                startActivity(intent);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //used this when mobile orientaion is changed
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
    }
}
