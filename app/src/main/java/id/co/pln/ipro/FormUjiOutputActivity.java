package id.co.pln.ipro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import id.co.pln.ipro.api.ApiGenerator;
import id.co.pln.ipro.api.IproClient;
import id.co.pln.ipro.clsumum.CalculateDataUji;
import id.co.pln.ipro.clsumum.CalculateDataUjiParameter;
import id.co.pln.ipro.clsumum.CalculateSimulasiGangguan;
import id.co.pln.ipro.clsumum.CreateFormFunc;
import id.co.pln.ipro.clsumum.CreateFormOutputUji;
import id.co.pln.ipro.clsumum.config;
import id.co.pln.ipro.model.DataUjiClass;
import id.co.pln.ipro.model.UjiClass;
import id.co.pln.ipro.model.UjiOutputClass;
import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormUjiOutputActivity extends AppCompatActivity {

    CreateFormOutputUji mCreateFormFunc = new CreateFormOutputUji();
    private ProgressDialog mProgreesDialog;
    FormBuilder mFormBuilderDetOutput;
    UjiClass mUjiClass;
    UjiOutputClass mUjiOutputClass;
    CalculateDataUjiParameter mCalculateDataUjiParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_uji_output_layout);

        mUjiOutputClass = (UjiOutputClass) getIntent().getSerializableExtra("output");

        changeActionBarFont();
        setupFormDetail();
        setUjiOutputData();

        Button abtn_simulasi = (Button) findViewById(R.id.simulasi);
        abtn_simulasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.getVibrate(FormUjiOutputActivity.this);

                Intent intent = new Intent(getApplicationContext(), SimulasiGangguanActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_output, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.logo:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupFormDetail() {
        mCreateFormFunc.formDetail();
        RecyclerView aRecyclerView = (RecyclerView) findViewById(R.id.rv_detail);
        mFormBuilderDetOutput = new FormBuilder(this, aRecyclerView);
        mFormBuilderDetOutput.addFormElements(mCreateFormFunc.getmListItemUjiOutput());
    }

    private void setUjiOutputData() {
        List<BaseFormElement> listItem = mCreateFormFunc.getmListItemUjiOutput();

        /*GI*/
        listItem.get(1).setValue(mUjiOutputClass.getK1a());
        listItem.get(2).setValue(mUjiOutputClass.getK1b());
        listItem.get(3).setValue(mUjiOutputClass.getK1c());
        listItem.get(4).setValue(mUjiOutputClass.getK5());
        listItem.get(5).setValue(mUjiOutputClass.getK5k());

        /*pemutus 1*/
        listItem.get(7).setValue(mUjiOutputClass.getK2a());
        listItem.get(8).setValue(mUjiOutputClass.getK2b());
        listItem.get(9).setValue(mUjiOutputClass.getK2c());
        listItem.get(10).setValue(mUjiOutputClass.getK6());
        listItem.get(11).setValue(mUjiOutputClass.getK6k());

        /*pemutus 2*/
        listItem.get(13).setValue(mUjiOutputClass.getK3a());
        listItem.get(14).setValue(mUjiOutputClass.getK3b());
        listItem.get(15).setValue(mUjiOutputClass.getK3c());
        listItem.get(16).setValue(mUjiOutputClass.getK7());
        listItem.get(17).setValue(mUjiOutputClass.getK7k());

        /*pemutus 3*/
        listItem.get(19).setValue(mUjiOutputClass.getK4a());
        listItem.get(20).setValue(mUjiOutputClass.getK4b());
        listItem.get(21).setValue(mUjiOutputClass.getK4c());
        listItem.get(22).setValue(mUjiOutputClass.getK8());
        listItem.get(23).setValue(mUjiOutputClass.getK8k());

        mFormBuilderDetOutput.addFormElements(listItem);
    }

    public void clearData() {
        /*mCreateFormFunc.formDetail();
        mFormBuilderDet.addFormElements(mCreateFormFunc.getmListItem2());

        mCreateFormFunc.formDetail();
        mFormBuilderPemutus1.addFormElements(mCreateFormFunc.getmListItem2());*/
    }

    public void changeActionBarFont() {
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, android.app.ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText("IPRO");
        tv.setTextSize(14);
        tv.setTextColor(getResources().getColor(R.color.colorBlack));
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        tv.setTypeface(tf);
        getSupportActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.back);
        upArrow.setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }
}
