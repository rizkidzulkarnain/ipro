package id.co.pln.ipro.clsumum;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import id.co.pln.ipro.FormUjiActivity;
import id.co.pln.ipro.LoginActivity;
import id.co.pln.ipro.MenuActivity;
import id.co.pln.ipro.api.ApiGenerator;
import id.co.pln.ipro.api.IproClient;
import id.co.pln.ipro.model.InsertClass;
import id.co.pln.ipro.model.LoginClass;
import id.co.pln.ipro.model.UjiClass;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveFormUji {
    Activity mActivity;
    String mPenyulang, mRele;
    String mNamaPemutus1, mNamaPemutus2, mNamaPemutus3;
    List<BaseFormElement> mListItemHeader;
    List<BaseFormElement> mListItemGI, mListItemPemutus1, mListItemPemutus2, mListItemPemutus3;

    public SaveFormUji(Activity iActivity){
        this.mActivity = iActivity;
    }
    public String getmPenyulang() {
        return mPenyulang;
    }

    public void setmPenyulang(String mPenyulang) {
        this.mPenyulang = mPenyulang;
    }

    public String getmRele() {
        return mRele;
    }

    public void setmRele(String mRele) {
        this.mRele = mRele;
    }

    public String getmNamaPemutus1() {
        return mNamaPemutus1;
    }

    public void setmNamaPemutus1(String mNamaPemutus1) {
        this.mNamaPemutus1 = mNamaPemutus1;
    }

    public String getmNamaPemutus2() {
        return mNamaPemutus2;
    }

    public void setmNamaPemutus2(String mNamaPemutus2) {
        this.mNamaPemutus2 = mNamaPemutus2;
    }

    public String getmNamaPemutus3() {
        return mNamaPemutus3;
    }

    public void setmNamaPemutus3(String mNamaPemutus3) {
        this.mNamaPemutus3 = mNamaPemutus3;
    }

    public List<BaseFormElement> getmListItemHeader() {
        return mListItemHeader;
    }

    public void setmListItemHeader(List<BaseFormElement> mListItemHeader) {
        this.mListItemHeader = mListItemHeader;
    }

    public List<BaseFormElement> getmListItemGI() {
        return mListItemGI;
    }

    public void setmListItemGI(List<BaseFormElement> mListItemGI) {
        this.mListItemGI = mListItemGI;
    }

    public List<BaseFormElement> getmListItemPemutus1() {
        return mListItemPemutus1;
    }

    public void setmListItemPemutus1(List<BaseFormElement> mListItemPemutus1) {
        this.mListItemPemutus1 = mListItemPemutus1;
    }

    public List<BaseFormElement> getmListItemPemutus2() {
        return mListItemPemutus2;
    }

    public void setmListItemPemutus2(List<BaseFormElement> mListItemPemutus2) {
        this.mListItemPemutus2 = mListItemPemutus2;
    }

    public List<BaseFormElement> getmListItemPemutus3() {
        return mListItemPemutus3;
    }

    public void setmListItemPemutus3(List<BaseFormElement> mListItemPemutus3) {
        this.mListItemPemutus3 = mListItemPemutus3;
    }

    public String CallSaveUjiAPI(final ProgressDialog iProgressDialog) throws JSONException {
        JSONObject ajsonobj = new JSONObject();

        mPenyulang = mListItemHeader.get(1).getValue();
        mRele = mListItemHeader.get(2).getValue();
        HashMap<String, BaseFormElement> ahash_itemGI = new HashMap<>();
        HashMap<String, BaseFormElement> ahash_pemutus1 = new HashMap<>();
        HashMap<String, BaseFormElement> ahash_pemutus2 = new HashMap<>();
        HashMap<String, BaseFormElement> ahash_pemutus3 = new HashMap<>();

        String alist_key[] = {"tahap3_header", "tahap3_fungsi", "tahap3_iset", "tahap3_delay",
                "tahap2_header", "tahap2_fungsi", "tahap2_iset", "tahap2_delay", "tahap2_kurva",
                "tahap1_header", "tahap1_fungsi", "tahap1_iset", "tahap1_delay", "tahap1_kurva",
                "hasil_header,", "hasil_fungsi", "hasil_ujicb", "hasil_relay"
        };

        int i = 0;
        for (String astring : alist_key) {
            ahash_itemGI.put(astring, mListItemGI.get(i));
            ahash_pemutus1.put(astring, mListItemPemutus1.get(i));
            ahash_pemutus2.put(astring, mListItemPemutus2.get(i));
            ahash_pemutus3.put(astring, mListItemPemutus3.get(i));
            i++;
        }

        //setItemOutputGIClass(ahash_itemGI);

        //GI
        String A1 = ahash_itemGI.get("tahap3_fungsi").getValue();
        String A2 = ahash_itemGI.get("tahap3_iset").getValue();
        String A3 = ahash_itemGI.get("tahap3_delay").getValue();
        String A4 = ahash_itemGI.get("tahap2_fungsi").getValue();
        String A5 = ahash_itemGI.get("tahap2_iset").getValue();
        String A6 = ahash_itemGI.get("tahap2_delay").getValue();
        String A7 = ahash_itemGI.get("tahap2_kurva").getValue();
        String A8 = ahash_itemGI.get("tahap1_fungsi").getValue();
        String A9 = ahash_itemGI.get("tahap1_iset").getValue();
        String A10 = ahash_itemGI.get("tahap1_delay").getValue();
        String A11 = ahash_itemGI.get("tahap1_kurva").getValue();
        String A12 = ahash_itemGI.get("hasil_fungsi").getValue();
        String A13 = ahash_itemGI.get("hasil_ujicb").getValue();
        String A14 = ahash_itemGI.get("hasil_relay").getValue();

        JSONObject GIjsonObj = new JSONObject();
        GIjsonObj.put("tahap3_fungsi", A1);
        GIjsonObj.put("tahap3_iset", A2);
        GIjsonObj.put("tahap3_delay", A3);
        GIjsonObj.put("tahap2_fungsi", A4);
        GIjsonObj.put("tahap2_iset", A5);
        GIjsonObj.put("tahap2_delay", A6);
        GIjsonObj.put("tahap2_kurva", A7);
        GIjsonObj.put("tahap1_fungsi", A8);
        GIjsonObj.put("tahap1_iset", A9);
        GIjsonObj.put("tahap1_delay", A10);
        GIjsonObj.put("tahap1_kurva", A11);
        GIjsonObj.put("hasil_fungsi", A12);
        GIjsonObj.put("hasil_ujicb", A13);
        GIjsonObj.put("hasil_relay", A14);

        ajsonobj.put("penyulang", mPenyulang);
        ajsonobj.put("rele", mRele);
        ajsonobj.put("gi", GIjsonObj);

        //Pemutus1
        String B1 = ahash_pemutus1.get("tahap3_fungsi").getValue();
        String B2 = ahash_pemutus1.get("tahap3_iset").getValue();
        String B3 = ahash_pemutus1.get("tahap3_delay").getValue();
        String B4 = ahash_pemutus1.get("tahap2_fungsi").getValue();
        String B5 = ahash_pemutus1.get("tahap2_iset").getValue();
        String B6 = ahash_pemutus1.get("tahap2_delay").getValue();
        String B7 = ahash_pemutus1.get("tahap2_kurva").getValue();
        String B8 = ahash_pemutus1.get("tahap1_fungsi").getValue();
        String B9 = ahash_pemutus1.get("tahap1_iset").getValue();
        String B10 = ahash_pemutus1.get("tahap1_delay").getValue();
        String B11 = ahash_pemutus1.get("tahap1_kurva").getValue();
        String B12 = ahash_pemutus1.get("hasil_fungsi").getValue();
        String B13 = ahash_pemutus1.get("hasil_ujicb").getValue();
        String B14 = ahash_pemutus1.get("hasil_relay").getValue();

        JSONObject PMT1jsonObj = new JSONObject();
        PMT1jsonObj.put("tahap3_fungsi", B1);
        PMT1jsonObj.put("tahap3_iset", B2);
        PMT1jsonObj.put("tahap3_delay", B3);
        PMT1jsonObj.put("tahap2_fungsi", B4);
        PMT1jsonObj.put("tahap2_iset", B5);
        PMT1jsonObj.put("tahap2_delay", B6);
        PMT1jsonObj.put("tahap2_kurva", B7);
        PMT1jsonObj.put("tahap1_fungsi", B8);
        PMT1jsonObj.put("tahap1_iset", B9);
        PMT1jsonObj.put("tahap1_delay", B10);
        PMT1jsonObj.put("tahap1_kurva", B11);
        PMT1jsonObj.put("hasil_fungsi", B12);
        PMT1jsonObj.put("hasil_ujicb", B13);
        PMT1jsonObj.put("hasil_relay", B14);

        PMT1jsonObj.put("namapemutus1",mNamaPemutus1);
        ajsonobj.put("pemutus1", PMT1jsonObj);

        //Pemutus2
        String C1 = ahash_pemutus2.get("tahap3_fungsi").getValue();
        String C2 = ahash_pemutus2.get("tahap3_iset").getValue();
        String C3 = ahash_pemutus2.get("tahap3_delay").getValue();
        String C4 = ahash_pemutus2.get("tahap2_fungsi").getValue();
        String C5 = ahash_pemutus2.get("tahap2_iset").getValue();
        String C6 = ahash_pemutus2.get("tahap2_delay").getValue();
        String C7 = ahash_pemutus2.get("tahap2_kurva").getValue();
        String C8 = ahash_pemutus2.get("tahap1_fungsi").getValue();
        String C9 = ahash_pemutus2.get("tahap1_iset").getValue();
        String C10 = ahash_pemutus2.get("tahap1_delay").getValue();
        String C11 = ahash_pemutus2.get("tahap1_kurva").getValue();
        String C12 = ahash_pemutus2.get("hasil_fungsi").getValue();
        String C13 = ahash_pemutus2.get("hasil_ujicb").getValue();
        String C14 = ahash_pemutus2.get("hasil_relay").getValue();

        JSONObject PMT2jsonObj = new JSONObject();
        PMT2jsonObj.put("tahap3_fungsi", C1);
        PMT2jsonObj.put("tahap3_iset", C2);
        PMT2jsonObj.put("tahap3_delay", C3);
        PMT2jsonObj.put("tahap2_fungsi", C4);
        PMT2jsonObj.put("tahap2_iset", C5);
        PMT2jsonObj.put("tahap2_delay", C6);
        PMT2jsonObj.put("tahap2_kurva", C7);
        PMT2jsonObj.put("tahap1_fungsi", C8);
        PMT2jsonObj.put("tahap1_iset", C9);
        PMT2jsonObj.put("tahap1_delay", C10);
        PMT2jsonObj.put("tahap1_kurva", C11);
        PMT2jsonObj.put("hasil_fungsi", C12);
        PMT2jsonObj.put("hasil_ujicb", C13);
        PMT2jsonObj.put("hasil_relay", C14);

        PMT2jsonObj.put("namapemutus2",mNamaPemutus2);
        ajsonobj.put("pemutus2", PMT2jsonObj);

        //Pemutus3
        String D1 = ahash_pemutus3.get("tahap3_fungsi").getValue();
        String D2 = ahash_pemutus3.get("tahap3_iset").getValue();
        String D3 = ahash_pemutus3.get("tahap3_delay").getValue();
        String D4 = ahash_pemutus3.get("tahap2_fungsi").getValue();
        String D5 = ahash_pemutus3.get("tahap2_iset").getValue();
        String D6 = ahash_pemutus3.get("tahap2_delay").getValue();
        String D7 = ahash_pemutus3.get("tahap2_kurva").getValue();
        String D8 = ahash_pemutus3.get("tahap1_fungsi").getValue();
        String D9 = ahash_pemutus3.get("tahap1_iset").getValue();
        String D10 = ahash_pemutus3.get("tahap1_delay").getValue();
        String D11 = ahash_pemutus3.get("tahap1_kurva").getValue();
        String D12 = ahash_pemutus3.get("hasil_fungsi").getValue();
        String D13 = ahash_pemutus3.get("hasil_ujicb").getValue();
        String D14 = ahash_pemutus3.get("hasil_relay").getValue();

        JSONObject PMT3jsonObj = new JSONObject();
        PMT3jsonObj.put("tahap3_fungsi", D1);
        PMT3jsonObj.put("tahap3_iset", D2);
        PMT3jsonObj.put("tahap3_delay", D3);
        PMT3jsonObj.put("tahap2_fungsi", D4);
        PMT3jsonObj.put("tahap2_iset", D5);
        PMT3jsonObj.put("tahap2_delay", D6);
        PMT3jsonObj.put("tahap2_kurva", D7);
        PMT3jsonObj.put("tahap1_fungsi", D8);
        PMT3jsonObj.put("tahap1_iset", D9);
        PMT3jsonObj.put("tahap1_delay", D10);
        PMT3jsonObj.put("tahap1_kurva", D11);
        PMT3jsonObj.put("hasil_fungsi", D12);
        PMT3jsonObj.put("hasil_ujicb", D13);
        PMT3jsonObj.put("hasil_relay", D14);

        PMT3jsonObj.put("namapemutus3",mNamaPemutus3);
        ajsonobj.put("pemutus3", PMT3jsonObj);

        return ajsonobj.toString();
    }
}
