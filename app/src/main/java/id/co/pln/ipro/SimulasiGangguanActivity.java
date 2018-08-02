package id.co.pln.ipro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.co.pln.ipro.clsumum.CalculateDataUji;
import id.co.pln.ipro.clsumum.CalculateDataUjiParameter;
import id.co.pln.ipro.clsumum.CalculateSimulasiGangguan;
import id.co.pln.ipro.clsumum.CreateFormSimulasi;
import id.co.pln.ipro.clsumum.config;
import id.co.pln.ipro.model.DataUjiClass;
import id.co.pln.ipro.model.SimulasiOutputClass;
import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.BaseFormElement;

public class SimulasiGangguanActivity extends AppCompatActivity {

    CreateFormSimulasi mCreateFormSimulasi = new CreateFormSimulasi();
    FormBuilder mFormBuilderHeader, mFormBuilderDetail;
    SimulasiOutputClass mSimulasiOutput;
    private ProgressDialog mProgreesDialog;
    String mArus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulas_gangguan_layout);

        changeActionBarFont();
        setupFormHeader();
        setupFormDetail();
        setupLineAwal();

        mProgreesDialog = new ProgressDialog(this);
        mProgreesDialog.setMessage("Loading...");

        Button abtn_simulasi = (Button) findViewById(R.id.btn_process_simulasi);
        abtn_simulasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgreesDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            config.getVibrate(SimulasiGangguanActivity.this);
                            start_simulasi();
                            setupLinePemutus();
                            setSimulasiData();
                            mProgreesDialog.dismiss();
                        } catch (Exception e) {
                            mProgreesDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }, 2000);
            }
        });

        Button abtn_home = (Button) findViewById(R.id.btn_home);
        abtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormUjiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupFormHeader() {
        mCreateFormSimulasi.formHeader();

        RecyclerView aRecyclerView = (RecyclerView) findViewById(R.id.rv_header);
        mFormBuilderHeader = new FormBuilder(this, aRecyclerView);
        mFormBuilderHeader.addFormElements(mCreateFormSimulasi.getmListItemHeader());
    }

    private void setupFormDetail() {
        mCreateFormSimulasi.formDetail();

        RecyclerView aRecyclerView = (RecyclerView) findViewById(R.id.rv_detail);
        mFormBuilderDetail = new FormBuilder(this, aRecyclerView);
        mFormBuilderDetail.addFormElements(mCreateFormSimulasi.getmListItemDetail());
    }

    private void start_simulasi() {
        List<BaseFormElement> listItem1 = mCreateFormSimulasi.getmListItemHeader();

        mArus = listItem1.get(1).getValue();
        CalculateSimulasiGangguan calculateSimulasiGangguan = new CalculateSimulasiGangguan(mArus);
        mSimulasiOutput = calculateSimulasiGangguan.Calculate();
    }

    private void setupLineAwal() {
        HorizontalStepView stepView = (HorizontalStepView) findViewById(R.id.step_view);
        List<StepBean> stepsBeanList = new ArrayList<>();

        StepBean stepBean0 = new StepBean("default\ndefault", 0);
        StepBean stepBean1 = new StepBean("default\ndefault", 0);
        StepBean stepBean2 = new StepBean("default\ndefault", 0);
        StepBean stepBean3 = new StepBean("default\ndefault", 0);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);

        stepView
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepViewComplectedTextColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(SimulasiGangguanActivity.this, R.drawable.circle_open))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(SimulasiGangguanActivity.this, R.drawable.circle_close));
    }

    private void setupLinePemutus() {
        HorizontalStepView stepView = (HorizontalStepView) findViewById(R.id.step_view);
        List<StepBean> stepsBeanList = new ArrayList<>();

        int S1b = mSimulasiOutput.getS1b() == "KUNING" ? 1 : 0;
        int S2b = mSimulasiOutput.getS2b() == "KUNING" ? 1 : 0;
        int S3b = mSimulasiOutput.getS3b() == "KUNING" ? 1 : 0;
        int S4b = mSimulasiOutput.getS4b() == "KUNING" ? 1 : 0;

        StepBean stepBean0 = new StepBean(mSimulasiOutput.getS1a() + "\n" + mSimulasiOutput.getS1c(), S1b);
        StepBean stepBean1 = new StepBean(mSimulasiOutput.getS2a() + "\n" + mSimulasiOutput.getS2c(), S2b);
        StepBean stepBean2 = new StepBean(mSimulasiOutput.getS3a() + "\n" + mSimulasiOutput.getS3c(), S3b);
        StepBean stepBean3 = new StepBean(mSimulasiOutput.getS4a() + "\n" + mSimulasiOutput.getS4c(), S4b);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);

        stepView
                .setStepViewTexts(stepsBeanList)
                .setTextSize(12)
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepViewComplectedTextColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(SimulasiGangguanActivity.this, R.color.colorBlack))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(SimulasiGangguanActivity.this, R.drawable.circle_open))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(SimulasiGangguanActivity.this, R.drawable.circle_close));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.logo:
                return true;
           /* case R.id.process:
                //test aja biar gak jauh2 scroll tinggal di action menu
                mProgreesDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startProcess();
                        } catch (Exception e) {
                            mProgreesDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }, 2000);*/
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSimulasiData() {
        List<BaseFormElement> listItem = mCreateFormSimulasi.getmListItemDetail();

        if (mSimulasiOutput.getL1b().toUpperCase().contains("App".toUpperCase()) && mSimulasiOutput.getL1b().toUpperCase().contains("Gangguan".toUpperCase())) {
            listItem.get(1).setTitle(mSimulasiOutput.getL1a()).setValue("***" + mSimulasiOutput.getL1b() + "***");
        } else {
            listItem.get(1).setTitle(mSimulasiOutput.getL1a()).setValue(mSimulasiOutput.getL1b());
        }

        listItem.get(2).setTitle(mSimulasiOutput.getL2a()).setValue(mSimulasiOutput.getL2b());
        listItem.get(3).setTitle(mSimulasiOutput.getL3a()).setValue(mSimulasiOutput.getL3b());
        listItem.get(4).setTitle(mSimulasiOutput.getL4a()).setValue(mSimulasiOutput.getL4b());
        listItem.get(5).setTitle(mSimulasiOutput.getL5a()).setValue(mSimulasiOutput.getL5b());
        listItem.get(6).setTitle(mSimulasiOutput.getL6a()).setValue(mSimulasiOutput.getL6b());
        listItem.get(7).setTitle(mSimulasiOutput.getL7a()).setValue(mSimulasiOutput.getL7b());
        listItem.get(8).setTitle(mSimulasiOutput.getL8a()).setValue(mSimulasiOutput.getL8b());
        listItem.get(9).setTitle(mSimulasiOutput.getL9a()).setValue(mSimulasiOutput.getL9b());
        listItem.get(10).setTitle(mSimulasiOutput.getL10a()).setValue(mSimulasiOutput.getL10b());
        listItem.get(11).setTitle(mSimulasiOutput.getL11a()).setValue(mSimulasiOutput.getL11b());
        listItem.get(12).setTitle(mSimulasiOutput.getL12a()).setValue(mSimulasiOutput.getL12b());

        mFormBuilderDetail.addFormElements(listItem);
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
