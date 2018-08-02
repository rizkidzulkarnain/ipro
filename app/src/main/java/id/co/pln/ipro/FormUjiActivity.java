package id.co.pln.ipro;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import id.co.pln.ipro.api.ApiGenerator;
import id.co.pln.ipro.api.IproClient;
import id.co.pln.ipro.clsumum.AlertDialogClass2;
import id.co.pln.ipro.clsumum.CalculateDataUji;
import id.co.pln.ipro.clsumum.CalculateDataUjiParameter;
import id.co.pln.ipro.clsumum.SaveFormUji;
import id.co.pln.ipro.clsumum.config;
import id.co.pln.ipro.clsumum.CreateFormFunc;
import id.co.pln.ipro.model.DataUjiClass;
import id.co.pln.ipro.model.InsertClass;
import id.co.pln.ipro.model.UjiClass;
import id.co.pln.ipro.model.UjiOutputClass;
import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormUjiActivity extends AppCompatActivity {

    CreateFormFunc mCreateFormFunc = new CreateFormFunc();
    private ProgressDialog mProgreesDialog;
    FormBuilder mFormBuilderDet, mFormBuilderHeader, mFormBuilderPemutus1, mFormBuilderPemutus2, mFormBuilderPemutus3;
    UjiClass mUjiClass;
    CalculateDataUjiParameter mCalculateDataUjiParameter;


    private String mPenyulang, mRele, mNamaPemutus1, mNamaPemutus2, mNamaPemutus3;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_uji_layout);

        mProgreesDialog = new ProgressDialog(this);
        mProgreesDialog.setMessage("Loading...");

        changeActionBarFont();
        setupFormHeader();
        setupFormDetail();

        Button abtn_searc = (Button) findViewById(R.id.btn_search);
        abtn_searc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgreesDialog.show();
                config.getVibrate(FormUjiActivity.this);
                callUjiAPI();
            }
        });

        Button abtn_process = (Button) findViewById(R.id.btn_process);
        abtn_process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                }, 2000);
            }
        });

        Button abtn_save = (Button) findViewById(R.id.btn_save);
        abtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgreesDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startSave();
                        } catch (Exception e) {
                            mProgreesDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }, 2000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            case R.id.process:
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
                }, 2000);
            case R.id.save:
                mProgreesDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startSave();
                            mProgreesDialog.dismiss();
                        } catch (Exception e) {
                            mProgreesDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }, 2000);
        }
        return super.onOptionsItemSelected(item);
    }

    private void startProcess() {
        config.getVibrate(FormUjiActivity.this);
        CalculateDataUji calculateDataUji = new CalculateDataUji();
        calculateDataUji.setmListItemHeader(mCreateFormFunc.getmListItem1());
        calculateDataUji.setmListItemGI(mCreateFormFunc.getmListItem2());
        calculateDataUji.setmListItemPemutus1(mCreateFormFunc.getmListItemPemutus1());
        calculateDataUji.setmListItemPemutus2(mCreateFormFunc.getmListItemPemutus2());
        calculateDataUji.setmListItemPemutus3(mCreateFormFunc.getmListItemPemutus3());
        calculateDataUji.setContext(FormUjiActivity.this);
        UjiOutputClass ujiOutputClass = calculateDataUji.Calculate();
        setParam(calculateDataUji);

        mProgreesDialog.dismiss();

        Intent intent = new Intent(getApplicationContext(), FormUjiOutputActivity.class);
        intent.putExtra("output", (Serializable) ujiOutputClass);
        startActivity(intent);
    }

    private void startSave() throws JSONException {
        final String[] message = new String[2];

        SaveFormUji saveFormUji = new SaveFormUji(FormUjiActivity.this);
        saveFormUji.setmNamaPemutus1(mNamaPemutus1);
        saveFormUji.setmNamaPemutus2(mNamaPemutus2);
        saveFormUji.setmNamaPemutus3(mNamaPemutus3);
        saveFormUji.setmListItemHeader(mCreateFormFunc.getmListItem1());
        saveFormUji.setmListItemGI(mCreateFormFunc.getmListItem2());
        saveFormUji.setmListItemPemutus1(mCreateFormFunc.getmListItemPemutus1());
        saveFormUji.setmListItemPemutus2(mCreateFormFunc.getmListItemPemutus2());
        saveFormUji.setmListItemPemutus3(mCreateFormFunc.getmListItemPemutus3());

        String ajsonparam = saveFormUji.CallSaveUjiAPI(mProgreesDialog);
        IproClient aSourceClient = ApiGenerator.createService(IproClient.class);
        final Call<InsertClass> call = aSourceClient.insertDataUji(ajsonparam);
        call.enqueue(new Callback<InsertClass>() {
            @Override
            public void onResponse(Response<InsertClass> response) {
                InsertClass insertClass = response.body();
                if (insertClass != null) {
                    if (insertClass.getStatus() == 1) {
                        message[0] = insertClass.getMessage();
                        message[1] = insertClass.getStatus().toString();
                    } else {
                        message[0] = insertClass.getMessage();
                        message[1] = insertClass.getStatus().toString();
                    }
                } else {
                    message[0] = "Tidak mendapatkan data !";
                    message[1] = "0";
                }
                if(message[1].equals("1")) {
                    runAlertDialog(message[0], 2);
                }else{
                    runAlertDialog(message[0], 1);
                }
                mProgreesDialog.dismiss();
                callUjiAPI();
            }

            @Override
            public void onFailure(Throwable t) {
                message[0] = "Akses web service gagal !";
                message[1] = "0";
                if(message[1].equals("1")) {
                    runAlertDialog(message[0], 2);
                }else{
                    runAlertDialog(message[0], 1);
                }
                mProgreesDialog.dismiss();
            }
        });
    }

    private void setParam(CalculateDataUji iCalculateDataUji) {
        mCalculateDataUjiParameter = new CalculateDataUjiParameter();

        mCalculateDataUjiParameter.setmPenyulang(mPenyulang);
        mCalculateDataUjiParameter.setmRele(mRele);
        mCalculateDataUjiParameter.setNamaPemutus1(mNamaPemutus1);
        mCalculateDataUjiParameter.setNamaPemutus2(mNamaPemutus2);
        mCalculateDataUjiParameter.setNamaPemutus3(mNamaPemutus3);

        mCalculateDataUjiParameter.setAhash_itemGI(iCalculateDataUji.getAhash_itemGI());
        mCalculateDataUjiParameter.setAhash_pemutus1(iCalculateDataUji.getAhash_pemutus1());
        mCalculateDataUjiParameter.setAhash_pemutus2(iCalculateDataUji.getAhash_pemutus2());
        mCalculateDataUjiParameter.setAhash_pemutus3(iCalculateDataUji.getAhash_pemutus3());

        mCalculateDataUjiParameter.setTcb_gi(iCalculateDataUji.getTcb_gi());
        mCalculateDataUjiParameter.setTcb_pmt1(iCalculateDataUji.getTcb_pmt1());
        mCalculateDataUjiParameter.setTcb_pmt2(iCalculateDataUji.getTcb_pmt2());
        mCalculateDataUjiParameter.setTcb_pmt3(iCalculateDataUji.getTcb_pmt3());

        mCalculateDataUjiParameter.setTrele_gi(iCalculateDataUji.getTrele_gi());
        mCalculateDataUjiParameter.setTrele_pmt1(iCalculateDataUji.getTrele_pmt1());
        mCalculateDataUjiParameter.setTrele_pmt2(iCalculateDataUji.getTrele_pmt2());
        mCalculateDataUjiParameter.setTrele_pmt3(iCalculateDataUji.getTrele_pmt3());
    }

    private void setupFormHeader() {
        mCreateFormFunc.formHeader();

        RecyclerView aRecyclerView = (RecyclerView) findViewById(R.id.rv_header);
        mFormBuilderHeader = new FormBuilder(this, aRecyclerView);
        mFormBuilderHeader.addFormElements(mCreateFormFunc.getmListItem1());
    }

    private void setupFormDetail() {
        mCreateFormFunc.formDetail();
        RecyclerView aRecyclerView = (RecyclerView) findViewById(R.id.rv_detail);
        mFormBuilderDet = new FormBuilder(this, aRecyclerView);
        mFormBuilderDet.addFormElements(mCreateFormFunc.getmListItem2());

        mCreateFormFunc.formDetailPemutus1();
        RecyclerView bRecyclerView = (RecyclerView) findViewById(R.id.rv_detail_pemutus1);
        mFormBuilderPemutus1 = new FormBuilder(this, bRecyclerView);
        mFormBuilderPemutus1.addFormElements(mCreateFormFunc.getmListItemPemutus1());

        mCreateFormFunc.formDetailPemutus2();
        RecyclerView cRecyclerView = (RecyclerView) findViewById(R.id.rv_detail_pemutus2);
        mFormBuilderPemutus2 = new FormBuilder(this, cRecyclerView);
        mFormBuilderPemutus2.addFormElements(mCreateFormFunc.getmListItemPemutus2());

        mCreateFormFunc.formDetailPemutus3();
        RecyclerView dRecyclerView = (RecyclerView) findViewById(R.id.rv_detail_pemutus3);
        mFormBuilderPemutus3 = new FormBuilder(this, dRecyclerView);
        mFormBuilderPemutus3.addFormElements(mCreateFormFunc.getmListItemPemutus3());
    }

    public void callUjiAPI() {
        IproClient iproClient = ApiGenerator.createService(IproClient.class);

        List<BaseFormElement> listItem1 = mCreateFormFunc.getmListItem1();

        mPenyulang = listItem1.get(1).getValue();
        mRele = listItem1.get(2).getValue();

        final Call<UjiClass> call = iproClient.getDataUjiProteksi(mPenyulang, mRele);
        call.enqueue(new Callback<UjiClass>() {
            @Override
            public void onResponse(Response<UjiClass> response) {
                mUjiClass = response.body();
                if (mUjiClass != null) {
                    if (mUjiClass.getStatus() != 0) {
                        try {
                            setGIData(mUjiClass.getData_gi());
                            setPemutus1Data(mUjiClass.getData_pemutus1());
                            setPemutus2Data(mUjiClass.getData_pemutus2());
                            setPemutus3Data(mUjiClass.getData_pemutus3());
                        } catch (Exception ex) {
                            Toast.makeText(FormUjiActivity.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(FormUjiActivity.this, mUjiClass.getMessage(), Toast.LENGTH_LONG).show();
                        clearData();
                    }
                } else {
                    Toast.makeText(FormUjiActivity.this, "API Connection Problem", Toast.LENGTH_LONG).show();
                }

                mProgreesDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                mProgreesDialog.dismiss();
            }
        });
    }

    private void setGIData(DataUjiClass iDataGI) {
        List<BaseFormElement> listItem = mCreateFormFunc.getmListItem2();

        listItem.get(1).setValue(iDataGI.getFungsi3());
        listItem.get(2).setValue(iDataGI.getIset3());
        listItem.get(3).setValue(iDataGI.getDelay3());
        listItem.get(5).setValue(iDataGI.getFungsi2());
        listItem.get(6).setValue(iDataGI.getIset2());
        listItem.get(7).setValue(iDataGI.getDelay2());
        listItem.get(8).setValue(iDataGI.getKurva2());
        listItem.get(10).setValue(iDataGI.getFungsi1());
        listItem.get(11).setValue(iDataGI.getIset1());
        listItem.get(12).setValue(iDataGI.getDelay1());
        listItem.get(13).setValue(iDataGI.getKurva1());
        listItem.get(15).setValue(iDataGI.getFungsiHasil());
        listItem.get(16).setValue(iDataGI.getUjiCb());
        listItem.get(17).setValue(iDataGI.getUjiRelay());
        mFormBuilderDet.addFormElements(listItem);
    }

    private void setPemutus1Data(DataUjiClass iDataPemutus1) {
        TextView txt_pemutus1 = (TextView) findViewById(R.id.nama_pemutus1);
        mNamaPemutus1 = iDataPemutus1.getNama().equals("") ? "-" : iDataPemutus1.getNama();
        txt_pemutus1.setText(mNamaPemutus1);

        List<BaseFormElement> listItem = mCreateFormFunc.getmListItemPemutus1();

        listItem.get(1).setValue(iDataPemutus1.getFungsi3());
        listItem.get(2).setValue(iDataPemutus1.getIset3());
        listItem.get(3).setValue(iDataPemutus1.getDelay3());
        listItem.get(5).setValue(iDataPemutus1.getFungsi2());
        listItem.get(6).setValue(iDataPemutus1.getIset2());
        listItem.get(7).setValue(iDataPemutus1.getDelay2());
        listItem.get(8).setValue(iDataPemutus1.getKurva2());
        listItem.get(10).setValue(iDataPemutus1.getFungsi1());
        listItem.get(11).setValue(iDataPemutus1.getIset1());
        listItem.get(12).setValue(iDataPemutus1.getDelay1());
        listItem.get(13).setValue(iDataPemutus1.getKurva1());
        listItem.get(15).setValue(iDataPemutus1.getFungsiHasil());
        listItem.get(16).setValue(iDataPemutus1.getUjiCb());
        listItem.get(17).setValue(iDataPemutus1.getUjiRelay());
        mFormBuilderPemutus1.addFormElements(listItem);
    }

    private void setPemutus2Data(DataUjiClass iDataPemutus2) {
        TextView txt_pemutus2 = (TextView) findViewById(R.id.nama_pemutus2);
        mNamaPemutus2 = iDataPemutus2.getNama().equals("") ? "-" : iDataPemutus2.getNama();
        txt_pemutus2.setText(mNamaPemutus2);

        List<BaseFormElement> listItem = mCreateFormFunc.getmListItemPemutus2();

        listItem.get(1).setValue(iDataPemutus2.getFungsi3());
        listItem.get(2).setValue(iDataPemutus2.getIset3());
        listItem.get(3).setValue(iDataPemutus2.getDelay3());
        listItem.get(5).setValue(iDataPemutus2.getFungsi2());
        listItem.get(6).setValue(iDataPemutus2.getIset2());
        listItem.get(7).setValue(iDataPemutus2.getDelay2());
        listItem.get(8).setValue(iDataPemutus2.getKurva2());
        listItem.get(10).setValue(iDataPemutus2.getFungsi1());
        listItem.get(11).setValue(iDataPemutus2.getIset1());
        listItem.get(12).setValue(iDataPemutus2.getDelay1());
        listItem.get(13).setValue(iDataPemutus2.getKurva1());
        listItem.get(15).setValue(iDataPemutus2.getFungsiHasil());
        listItem.get(16).setValue(iDataPemutus2.getUjiCb());
        listItem.get(17).setValue(iDataPemutus2.getUjiRelay());
        mFormBuilderPemutus2.addFormElements(listItem);
    }

    private void setPemutus3Data(DataUjiClass iDataPemutus3) {
        TextView txt_pemutus3 = (TextView) findViewById(R.id.nama_pemutus3);
        mNamaPemutus3 = iDataPemutus3.getNama().equals("") ? "-" : iDataPemutus3.getNama();
        txt_pemutus3.setText(mNamaPemutus3);

        List<BaseFormElement> listItem = mCreateFormFunc.getmListItemPemutus3();

        listItem.get(1).setValue(iDataPemutus3.getFungsi3());
        listItem.get(2).setValue(iDataPemutus3.getIset3());
        listItem.get(3).setValue(iDataPemutus3.getDelay3());
        listItem.get(5).setValue(iDataPemutus3.getFungsi2());
        listItem.get(6).setValue(iDataPemutus3.getIset2());
        listItem.get(7).setValue(iDataPemutus3.getDelay2());
        listItem.get(8).setValue(iDataPemutus3.getKurva2());
        listItem.get(10).setValue(iDataPemutus3.getFungsi1());
        listItem.get(11).setValue(iDataPemutus3.getIset1());
        listItem.get(12).setValue(iDataPemutus3.getDelay1());
        listItem.get(13).setValue(iDataPemutus3.getKurva1());
        listItem.get(15).setValue(iDataPemutus3.getFungsiHasil());
        listItem.get(16).setValue(iDataPemutus3.getUjiCb());
        listItem.get(17).setValue(iDataPemutus3.getUjiRelay());
        mFormBuilderPemutus3.addFormElements(listItem);
    }

    public void clearData() {
        mCreateFormFunc.formDetail();
        mFormBuilderDet.addFormElements(mCreateFormFunc.getmListItem2());

        mCreateFormFunc.formDetail();
        mFormBuilderPemutus1.addFormElements(mCreateFormFunc.getmListItem2());
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

    //default function
    public void runAlertDialog(String imsg, int itipe) { //1 error, 2 sukses, 3 info
        AlertDialog alertDialog = AlertDialogClass2.alertDialog(imsg, itipe, this);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
