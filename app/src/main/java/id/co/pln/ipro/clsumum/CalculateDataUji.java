package id.co.pln.ipro.clsumum;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import id.co.pln.ipro.model.UjiOutputClass;
import me.riddhimanadib.formmaster.model.BaseFormElement;

public class CalculateDataUji {
    final static double KSI = 0.14, KVI = 13.5, ASI = 0.02;
    final static int KXI = 80, AVI = 1, AXI = 2;
    final static String ON = "ON", OFF = "OFF";

    HashMap<String, BaseFormElement> ahash_itemGI;
    HashMap<String, BaseFormElement> ahash_pemutus1;
    HashMap<String, BaseFormElement> ahash_pemutus2;
    HashMap<String, BaseFormElement> ahash_pemutus3;

    double tcb_gi, tcb_pmt1, tcb_pmt2, tcb_pmt3;
    double trele_gi, trele_pmt1, trele_pmt2, trele_pmt3;

    public CalculateDataUji(Parcel in) {
        tcb_gi = in.readDouble();
        tcb_pmt1 = in.readDouble();
        tcb_pmt2 = in.readDouble();
        tcb_pmt3 = in.readDouble();
        trele_gi = in.readDouble();
        trele_pmt1 = in.readDouble();
        trele_pmt2 = in.readDouble();
        trele_pmt3 = in.readDouble();
    }

    public CalculateDataUji() {

    }

    //region
    public double getTcb_gi() {
        return tcb_gi;
    }

    public double getTcb_pmt1() {
        return tcb_pmt1;
    }

    public double getTcb_pmt2() {
        return tcb_pmt2;
    }

    public double getTcb_pmt3() {
        return tcb_pmt3;
    }

    public double getTrele_gi() {
        return trele_gi;
    }

    public double getTrele_pmt1() {
        return trele_pmt1;
    }

    public double getTrele_pmt2() {
        return trele_pmt2;
    }

    public double getTrele_pmt3() {
        return trele_pmt3;
    }
    //end region

    public HashMap<String, BaseFormElement> getAhash_itemGI() {
        return ahash_itemGI;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus1() {
        return ahash_pemutus1;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus2() {
        return ahash_pemutus2;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus3() {
        return ahash_pemutus3;
    }

    Context mContext;

    List<BaseFormElement> mListItemHeader;
    List<BaseFormElement> mListItemGI, mListItemPemutus1, mListItemPemutus2, mListItemPemutus3;

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

    public void setContext(Context icontext) {
        mContext = icontext;
    }

    public UjiOutputClass Calculate() {
        ahash_itemGI = new HashMap<>();
        ahash_pemutus1 = new HashMap<>();
        ahash_pemutus2 = new HashMap<>();
        ahash_pemutus3 = new HashMap<>();

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

        tcb_gi = A12.toUpperCase().equals("ON") && !A13.toUpperCase().equals("0") ? Double.valueOf(A13) : 55;
        tcb_pmt1 = B12.toUpperCase().equals("ON") && !B13.toUpperCase().equals("0") ? Double.valueOf(B13) : 55;
        tcb_pmt2 = C12.toUpperCase().equals("ON") && !C13.toUpperCase().equals("0") ? Double.valueOf(C13) : 55;
        tcb_pmt3 = D12.toUpperCase().equals("ON") && !D13.toUpperCase().equals("0") ? Double.valueOf(D13) : 55;

        trele_gi = A12.toUpperCase().equals("ON") && !A14.toUpperCase().equals("0") ? Double.valueOf(A14) : 25;
        trele_pmt1 = B12.toUpperCase().equals("ON") && !B14.toUpperCase().equals("0") ? Double.valueOf(B14) : 25;
        trele_pmt2 = C12.toUpperCase().equals("ON") && !C14.toUpperCase().equals("0") ? Double.valueOf(C14) : 25;
        trele_pmt3 = D12.toUpperCase().equals("ON") && !D14.toUpperCase().equals("0") ? Double.valueOf(D14) : 25;

        double if1_pmt1 = 0.0, if1_pmt2 = 0.0, if1_pmt3 = 0.0;
        double if2_pmt1 = 0.0, if2_pmt2 = 0.0, if2_pmt3 = 0.0;

        if (B4.toUpperCase().equals("ON")) {
            if1_pmt1 = Double.valueOf(B5);
        } else if (A4.toUpperCase().equals("ON")) {
            if1_pmt1 = Double.valueOf(A5);
        } else if (B1.toUpperCase().equals("ON")) {
            if1_pmt1 = Double.valueOf(B2);
        } else if (A1.toUpperCase().equals("ON")) {
            if1_pmt1 = Double.valueOf(A2);
        } else {
            if1_pmt1 = 6 * Double.valueOf(B9);
        }

        if (C4.toUpperCase().equals("ON")) {
            if1_pmt2 = Double.valueOf(C5);
        } else if (B4.toUpperCase().equals("ON")) {
            if1_pmt2 = Double.valueOf(B5);
        } else if (C1.toUpperCase().equals("ON")) {
            if1_pmt2 = Double.valueOf(C2);
        } else if (B1.toUpperCase().equals("ON")) {
            if1_pmt2 = Double.valueOf(B2);
        } else {
            if1_pmt2 = 6 * Double.valueOf(C9);
        }

        if (D4.toUpperCase().equals("ON")) {
            if1_pmt3 = Double.valueOf(D5);
        } else if (C4.toUpperCase().equals("ON")) {
            if1_pmt3 = Double.valueOf(C5);
        } else if (D1.toUpperCase().equals("ON")) {
            if1_pmt3 = Double.valueOf(D4);
        } else if (C1.toUpperCase().equals("ON")) {
            if1_pmt3 = Double.valueOf(C2);
        } else {
            if1_pmt3 = 6 * Double.valueOf(D9);
        }

        if (B1.toUpperCase().equals("ON")) {
            if2_pmt1 = Double.valueOf(B2);
        } else if (A1.toUpperCase().equals("ON")) {
            if2_pmt1 = Double.valueOf(A2);
        } else {
            if2_pmt1 = 5 * Double.valueOf(B5);
        }

        if (C1.toUpperCase().equals("ON")) {
            if2_pmt2 = Double.valueOf(C2);
        } else if (B1.toUpperCase().equals("ON")) {
            if2_pmt2 = Double.valueOf(B2);
        } else {
            if2_pmt2 = 5 * Double.valueOf(C5);
        }

        if (D1.toUpperCase().equals("ON")) {
            if2_pmt3 = Double.valueOf(D2);
        } else if (C1.toUpperCase().equals("ON")) {
            if2_pmt3 = Double.valueOf(C2);
        } else {
            if2_pmt3 = 5 * Double.valueOf(D5);
        }

        double t1_si1_GI = 0.0, t1_vi1_GI = 0.0, t1_xi1_GI = 0.0, t1_def1_GI = 0.0;
        if (B4.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("OFF")) {
            Double pers1 = KSI * Double.valueOf(A6);
            Double pers2 = if1_pmt1 / Double.valueOf(A5);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_si1_GI = ahasil;
            //t1_si1_GI = (KSI * Double.valueOf(A6)) / ((((Math.pow(Double.valueOf(if1_pmt1) / Double.valueOf(A5), KSI))) - 1));
        } else if (B4.toUpperCase().equals("OFF") && B1.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("ON")) {
            t1_si1_GI = convDouble(A3);
        } else {
            Double pers1 = KSI * convDouble(A10);
            Double pers2 = if1_pmt1 / convDouble(A9);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_si1_GI = ahasil;
            //t1_si1_GI = ((KSI * convDouble(A10))) / ((Math.pow((if1_pmt1 / convDouble(A9)), ASI) - 1));
        }

        if (B4.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("OFF")) {
            Double pers1 = KVI * Double.valueOf(A6);
            Double pers2 = if1_pmt1 / Double.valueOf(A5);
            pers2 = Math.pow(pers2, AVI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_vi1_GI = ahasil;
            //t1_si1_GI = (KSI * Double.valueOf(A6)) / ((((Math.pow(Double.valueOf(if1_pmt1) / Double.valueOf(A5), KSI))) - 1));
        } else if (B4.toUpperCase().equals("OFF") && B1.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("ON")) {
            t1_vi1_GI = convDouble(A3);
        } else {
            Double pers1 = KVI * convDouble(A10);
            Double pers2 = if1_pmt1 / convDouble(A9);
            pers2 = Math.pow(pers2, AVI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_vi1_GI = ahasil;
            //t1_si1_GI = ((KSI * convDouble(A10))) / ((Math.pow((if1_pmt1 / convDouble(A9)), ASI) - 1));
        }

        if (B4.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("OFF")) {
            Double pers1 = KXI * Double.valueOf(A6);
            Double pers2 = if1_pmt1 / Double.valueOf(A5);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_xi1_GI = ahasil;
            //t1_si1_GI = (KSI * Double.valueOf(A6)) / ((((Math.pow(Double.valueOf(if1_pmt1) / Double.valueOf(A5), KSI))) - 1));
        } else if (B4.toUpperCase().equals("OFF") && B1.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("ON")) {
            t1_vi1_GI = convDouble(A3);
        } else {
            Double pers1 = KXI * convDouble(A10);
            Double pers2 = if1_pmt1 / convDouble(A9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            Double ahasil = pers1 / pers2;
            t1_xi1_GI = ahasil;
            //t1_si1_GI = ((KSI * convDouble(A10))) / ((Math.pow((if1_pmt1 / convDouble(A9)), ASI) - 1));
        }

        if (B4.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("OFF")) {
            t1_def1_GI = convDouble(A6);
        } else if (B4.toUpperCase().equals("OFF") && B1.toUpperCase().equals("OFF") && A4.toUpperCase().equals("ON") && A1.toUpperCase().equals("ON")) {
            t1_def1_GI = convDouble(A3);
        } else {
            t1_def1_GI = convDouble(A10);
        }

        double t1_si1_pmt1, t1_vi1_pmt1, t1_xi1_pmt1, t1_def1_pmt1;
        if (isEqual(A4, ON) && isEqual(B4, OFF)) {
            Double pers1 = KSI * convDouble(B10);
            Double pers2 = (5 * if1_pmt1) / convDouble(B9);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_si1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((5 * if1_pmt1) / convDouble(B9)), ASI) - 1);
        } else {
            Double pers1 = KSI * convDouble(B10);
            Double pers2 = if1_pmt1 / convDouble(B9);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_si1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((if1_pmt1) / convDouble(B9)), ASI) - 1);
        }

        if (isEqual(A4, ON) && isEqual(B4, OFF)) {
            Double pers1 = KXI * convDouble(B10);
            Double pers2 = (5 * if1_pmt1) / convDouble(B9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_vi1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((5 * if1_pmt1) / convDouble(B9)), ASI) - 1);
        } else {
            Double pers1 = KXI * convDouble(B10);
            Double pers2 = if1_pmt1 / convDouble(B9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_vi1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((if1_pmt1) / convDouble(B9)), ASI) - 1);
        }

        if (isEqual(A4, ON) && isEqual(B4, OFF)) {
            Double pers1 = KXI * convDouble(B10);
            Double pers2 = (5 * if1_pmt1) / convDouble(B9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_xi1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((5 * if1_pmt1) / convDouble(B9)), ASI) - 1);
        } else {
            Double pers1 = KXI * convDouble(B10);
            Double pers2 = if1_pmt1 / convDouble(B9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_xi1_pmt1 = hasil;
            //t1_si1_pmt1 = (KSI * convDouble(B10)) / (Math.pow(((if1_pmt1) / convDouble(B9)), ASI) - 1);
        }
        t1_def1_pmt1 = convDouble(B10);

        double t1_si2_pmt1, t1_vi2_pmt1, t1_xi2_pmt1, t1_def2_pmt1;
        if (isEqual(C4, OFF) && isEqual(B4, ON) && isEqual(B1, OFF)) {
            double pers1 = KSI * convDouble(B6);
            double pers2 = if1_pmt2 / convDouble(B5);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_si2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B6)) / ((Math.pow((if1_pmt2 / convDouble(B5)), ASI) - 1));
        } else if (isEqual(C4, OFF) && isEqual(C1, OFF) && isEqual(B4, ON) && isEqual(B1, ON)) {
            t1_si2_pmt1 = convDouble(B3);
        } else {
            double pers1 = KSI * convDouble(B10);
            double pers2 = if1_pmt2 / convDouble(B9);
            pers2 = Math.pow(pers2, ASI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_si2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B10)) / ((Math.pow((if1_pmt2 / convDouble(B9)), ASI) - 1));
        }

        if (isEqual(C4, OFF) && isEqual(B4, ON) && isEqual(B1, OFF)) {
            double pers1 = KVI * convDouble(B6);
            double pers2 = if1_pmt2 / convDouble(B5);
            pers2 = Math.pow(pers2, AVI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_vi2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B6)) / ((Math.pow((if1_pmt2 / convDouble(B5)), ASI) - 1));
        } else if (isEqual(C4, OFF) && isEqual(C1, OFF) && isEqual(B4, ON) && isEqual(B1, ON)) {
            t1_vi2_pmt1 = convDouble(B3);
        } else {
            double pers1 = KVI * convDouble(B10);
            double pers2 = if1_pmt2 / convDouble(B9);
            pers2 = Math.pow(pers2, AVI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_vi2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B10)) / ((Math.pow((if1_pmt2 / convDouble(B9)), ASI) - 1));
        }

        if (isEqual(C4, OFF) && isEqual(B4, ON) && isEqual(B1, OFF)) {
            double pers1 = KXI * convDouble(B6);
            double pers2 = if1_pmt2 / convDouble(B5);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_xi2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B6)) / ((Math.pow((if1_pmt2 / convDouble(B5)), ASI) - 1));
        } else if (isEqual(C4, OFF) && isEqual(C1, OFF) && isEqual(B4, ON) && isEqual(B1, ON)) {
            t1_xi2_pmt1 = convDouble(B3);
        } else {
            double pers1 = KXI * convDouble(B10);
            double pers2 = if1_pmt2 / convDouble(B9);
            pers2 = Math.pow(pers2, AXI);
            pers2 = pers2 - 1;
            double hasil = pers1 / pers2;
            t1_xi2_pmt1 = hasil;
            //t1_si2_pmt1 = (KSI * convDouble(B10)) / ((Math.pow((if1_pmt2 / convDouble(B9)), ASI) - 1));
        }

        if (isEqual(C4, OFF) && isEqual(B4, ON) && isEqual(B1, OFF)) {
            t1_def2_pmt1 = convDouble(B6);
        } else if (isEqual(C4, OFF) && isEqual(C1, OFF) && isEqual(B4, ON) && isEqual(B1, ON)) {
            t1_def2_pmt1 = convDouble(B3);
        } else {
            t1_def2_pmt1 = convDouble(B10);
        }

        double t1_si2_pmt2 = 0.0, t1_vi2_pmt2 = 0.0, t1_xi2_pmt2 = 0.0, t1_def2_pmt2 = 0.0;
        if (isEqual(B4, ON) && isEqual(C4, OFF)) {
            double pers1 = KSI * convDouble(C10);
            double pers2 = (5 * if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            double hasil = pers1 / pers2;
            t1_si2_pmt2 = hasil;
        } else {
            double pers1 = KSI * convDouble(C10);
            double pers2 = (if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            double hasil = pers1 / pers2;
            t1_si2_pmt2 = hasil;
        }

        if (isEqual(B4, ON) && isEqual(C4, OFF)) {
            double pers1 = KVI * convDouble(C10);
            double pers2 = (5 * if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            double hasil = pers1 / pers2;
            t1_vi2_pmt2 = hasil;
        } else {
            double pers1 = KVI * convDouble(C10);
            double pers2 = (if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            double hasil = pers1 / pers2;
            t1_vi2_pmt2 = hasil;
        }

        if (isEqual(B4, ON) && isEqual(C4, OFF)) {
            double pers1 = KVI * convDouble(C10);
            double pers2 = (5 * if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            double hasil = pers1 / pers2;
            t1_xi2_pmt2 = hasil;
        } else {
            double pers1 = KXI * convDouble(C10);
            double pers2 = (if1_pmt2) / convDouble(C9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            double hasil = pers1 / pers2;
            t1_xi2_pmt2 = hasil;
        }
        t1_def2_pmt2 = convDouble(C10);

        double t1_si3_pmt2 = 0.0, t1_vi3_pmt2 = 0.0, t1_xi3_pmt2 = 0.0, t1_def3_pmt2 = 0.0;
        if (isEqual(D4, OFF) && isEqual(C4, ON) && isEqual(C1, OFF)) {
            double pers1 = KSI * convDouble(C6);
            double pers2 = if1_pmt3 / convDouble(C5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            double hasil = pers1 / pers2;
            t1_si3_pmt2 = hasil;
        } else if (isEqual(D4, OFF) && isEqual(D1, OFF) && isEqual(C4, ON) && isEqual(C1, ON)) {
            t1_si3_pmt2 = convDouble(C3);
        } else {
            double pers1 = KSI * convDouble(C10);
            double pers2 = if1_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            double hasil = pers1 / pers2;
            t1_si3_pmt2 = hasil;
        }

        if (isEqual(D4, OFF) && isEqual(C4, ON) && isEqual(C1, OFF)) {
            double pers1 = KVI * convDouble(C6);
            double pers2 = if1_pmt3 / (convDouble(C5));
            pers2 = (Math.pow(pers2, AVI)) - 1;
            double hasil = pers1 / pers2;
            t1_vi3_pmt2 = hasil;
        } else if (isEqual(D4, OFF) && isEqual(D1, OFF) && isEqual(C4, ON) && isEqual(C1, ON)) {
            t1_vi3_pmt2 = convDouble(C3);
        } else {
            double pers1 = KVI * convDouble(C10);
            double pers2 = if1_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            double hasil = pers1 / pers2;
            t1_vi3_pmt2 = hasil;
        }

        if (isEqual(D4, OFF) && isEqual(C4, ON) && isEqual(C1, OFF)) {
            double pers1 = KXI * convDouble(C6);
            double pers2 = if1_pmt3 / convDouble(C5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            double hasil = pers1 / pers2;
            t1_xi3_pmt2 = hasil;
        } else if (isEqual(D4, OFF) && isEqual(D1, OFF) && isEqual(C4, ON) && isEqual(C1, ON)) {
            t1_xi3_pmt2 = convDouble(C3);
        } else {
            double pers1 = KVI * convDouble(C10);
            double pers2 = if1_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            double hasil = pers1 / pers2;
            t1_xi3_pmt2 = hasil;
        }

        if (isEqual(D4, OFF) && isEqual(C4, ON) && isEqual(C1, OFF)) {
            t1_def3_pmt2 = convDouble(C6);
        } else if (isEqual(D4, OFF) && isEqual(D1, OFF) && isEqual(C4, ON) && isEqual(C1, ON)) {
            t1_def3_pmt2 = convDouble(C3);
        } else {
            t1_def3_pmt2 = convDouble(C10);
        }

        Double t1_si3_pmt3, t1_vi3_pmt3, t1_xi3_pmt3, t1_def3_pmt3;
        if (isEqual(C4, ON) && isEqual(D4, OFF)) {
            double pers1 = KSI * convDouble(D10);
            double pers2 = (5 * if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t1_si3_pmt3 = pers1 / pers2;
        } else {
            double pers1 = KSI * convDouble(D10);
            double pers2 = (if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t1_si3_pmt3 = pers1 / pers2;
        }

        if (isEqual(C4, ON) && isEqual(D4, OFF)) {
            double pers1 = KVI * convDouble(D10);
            double pers2 = (5 * if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t1_vi3_pmt3 = pers1 / pers2;
        } else {
            double pers1 = KVI * convDouble(D10);
            double pers2 = (if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t1_vi3_pmt3 = pers1 / pers2;
        }

        if (isEqual(C4, ON) && isEqual(D4, OFF)) {
            double pers1 = KXI * convDouble(D10);
            double pers2 = (5 * if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t1_xi3_pmt3 = pers1 / pers2;
        } else {
            double pers1 = KXI * convDouble(D10);
            double pers2 = (if1_pmt3) / convDouble(D9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t1_xi3_pmt3 = pers1 / pers2;
        }
        t1_def3_pmt3 = convDouble(D10);

        double t2_si1_GI, t2_vi1_GI, t2_xi1_GI, t2_def1_GI;
        if (isEqual(A4, ON) && isEqual(A1, ON) && isEqual(B1, OFF)) {
            t2_si1_GI = convDouble(A3);
        } else if (isEqual(A4, ON)) {
            double pers1 = KSI * convDouble(A6);
            double pers2 = if2_pmt1 / convDouble(A5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si1_GI = pers1 / pers2;
        } else {
            double pers1 = KSI * convDouble(A10);
            double pers2 = if2_pmt1 / convDouble(A9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si1_GI = pers1 / pers2;
        }

        if (isEqual(A4, ON) && isEqual(A1, ON) && isEqual(B1, OFF)) {
            t2_vi1_GI = convDouble(A3);
        } else if (isEqual(A4, ON)) {
            double pers1 = KVI * convDouble(A6);
            double pers2 = if2_pmt1 / convDouble(A5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi1_GI = pers1 / pers2;
        } else {
            double pers1 = KVI * convDouble(A10);
            double pers2 = if2_pmt1 / convDouble(A9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi1_GI = pers1 / pers2;
        }

        if (isEqual(A4, ON) && isEqual(A1, ON) && isEqual(B1, OFF)) {
            t2_xi1_GI = convDouble(A3);
        } else if (isEqual(A4, ON)) {
            double pers1 = KXI * convDouble(A6);
            double pers2 = if2_pmt1 / convDouble(A5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi1_GI = pers1 / pers2;
        } else {
            double pers1 = KXI * convDouble(A10);
            double pers2 = if2_pmt1 / convDouble(A9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi1_GI = pers1 / pers2;
        }

        if (isEqual(A4, ON) && isEqual(A1, ON) && isEqual(B1, OFF)) {
            t2_def1_GI = convDouble(A3);
        } else if (isEqual(A4, ON)) {
            t2_def1_GI = convDouble(A6);
        } else {
            t2_def1_GI = convDouble(A10);
        }

        double t2_si1_pmt1, t2_vi1_pmt1, t2_xi1_pmt1, t2_def1_pmt1;
        double apers1 = KSI * convDouble(B6);
        double apers2 = if1_pmt1 / convDouble(B5);
        apers2 = (Math.pow(apers2, ASI)) - 1;
        t2_si1_pmt1 = apers1 / apers2;

        double apers3 = KVI * convDouble(B6);
        double apers4 = if1_pmt1 / convDouble(B5);
        apers4 = (Math.pow(apers4, AVI)) - 1;
        t2_vi1_pmt1 = apers3 / apers4;

        double apers5 = KXI * convDouble(B6);
        double apers6 = if1_pmt1 / convDouble(B5);
        apers6 = (Math.pow(apers6, AXI)) - 1;
        t2_xi1_pmt1 = apers3 / apers6;

        t2_def1_pmt1 = convDouble(B6);

        double t2_si2_pmt1, t2_vi2_pmt1, t2_xi2_pmt1, t2_def2_pmt1;
        if (isEqual(B4, ON) && isEqual(B1, ON) && isEqual(C1, OFF)) {
            t2_si2_pmt1 = convDouble(B3);
        } else if (isEqual(B4, ON)) {
            double pers1 = KSI * convDouble(B6);
            double pers2 = if2_pmt2 / convDouble(B5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si2_pmt1 = pers1 / pers2;
        } else {
            double pers1 = KSI * convDouble(B10);
            double pers2 = if2_pmt2 / convDouble(B9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si2_pmt1 = pers1 / pers2;
        }

        if (isEqual(B4, ON) && isEqual(B1, ON) && isEqual(C1, OFF)) {
            t2_vi2_pmt1 = convDouble(B3);
        } else if (isEqual(B4, ON)) {
            double pers1 = KVI * convDouble(B6);
            double pers2 = if2_pmt2 / convDouble(B5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi2_pmt1 = pers1 / pers2;
        } else {
            double pers1 = KVI * convDouble(B10);
            double pers2 = if2_pmt2 / convDouble(B9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi2_pmt1 = pers1 / pers2;
        }

        if (isEqual(B4, ON) && isEqual(B1, ON) && isEqual(C1, OFF)) {
            t2_xi2_pmt1 = convDouble(B3);
        } else if (isEqual(B4, ON)) {
            double pers1 = KXI * convDouble(B6);
            double pers2 = if2_pmt2 / convDouble(B5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi2_pmt1 = pers1 / pers2;
        } else {
            double pers1 = KXI * convDouble(B10);
            double pers2 = if2_pmt2 / convDouble(B9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi2_pmt1 = pers1 / pers2;
        }

        if (isEqual(B4, ON) && isEqual(B1, ON) && isEqual(C1, OFF)) {
            t2_def2_pmt1 = convDouble(B3);
        } else if (isEqual(B4, ON)) {
            t2_def2_pmt1 = convDouble(B6);
        } else {
            t2_def2_pmt1 = convDouble(B10);
        }

        double t2_si2_pmt2, t2_vi2_pmt2, t2_xi2_pmt2, t2_def2_pmt2;
        double bpers1 = KSI * convDouble(C6);
        double bpers2 = if1_pmt2 / convDouble(C5);
        bpers2 = (Math.pow(bpers2, ASI)) - 1;
        t2_si2_pmt2 = bpers1 / bpers2;

        double bpers3 = KVI * convDouble(C6);
        double bpers4 = if1_pmt2 / convDouble(C5);
        bpers4 = (Math.pow(bpers4, AVI)) - 1;
        t2_vi2_pmt2 = bpers3 / bpers4;

        double bpers5 = KXI * convDouble(C6);
        double bpers6 = if1_pmt2 / convDouble(C5);
        bpers6 = (Math.pow(bpers6, AXI)) - 1;
        t2_xi2_pmt2 = bpers5 / bpers6;

        t2_def2_pmt2 = convDouble(C6);

        double t2_si3_pmt2, t2_vi3_pmt2, t2_xi3_pmt2, t2_def3_pmt2;
        if (isEqual(C4, ON) && isEqual(C1, ON) && isEqual(D1, OFF)) {
            t2_si3_pmt2 = convDouble(C3);
        } else if (isEqual(C4, ON)) {
            double pers1 = KSI * convDouble(C6);
            double pers2 = if2_pmt3 / convDouble(C5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si3_pmt2 = pers1 / pers2;
        } else {
            double pers1 = KSI * convDouble(C10);
            double pers2 = if2_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t2_si3_pmt2 = pers1 / pers2;
        }

        if (isEqual(C4, ON) && isEqual(C1, ON) && isEqual(D1, OFF)) {
            t2_vi3_pmt2 = convDouble(C3);
        } else if (isEqual(C4, ON)) {
            double pers1 = KVI * convDouble(C6);
            double pers2 = if2_pmt3 / convDouble(C5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi3_pmt2 = pers1 / pers2;
        } else {
            double pers1 = KVI * convDouble(C10);
            double pers2 = if2_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t2_vi3_pmt2 = pers1 / pers2;
        }

        if (isEqual(C4, ON) && isEqual(C1, ON) && isEqual(D1, OFF)) {
            t2_xi3_pmt2 = convDouble(C3);
        } else if (isEqual(C4, ON)) {
            double pers1 = KXI * convDouble(C6);
            double pers2 = if2_pmt3 / convDouble(C5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi3_pmt2 = pers1 / pers2;
        } else {
            double pers1 = KXI * convDouble(C10);
            double pers2 = if2_pmt3 / convDouble(C9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t2_xi3_pmt2 = pers1 / pers2;
        }

        if (isEqual(C4, ON) && isEqual(C1, ON) && isEqual(D1, OFF)) {
            t2_def3_pmt2 = convDouble(C3);
        } else if (isEqual(C4, ON)) {
            t2_def3_pmt2 = convDouble(C6);
        } else {
            t2_def3_pmt2 = convDouble(C10);
        }

        double t2_si3_pmt3, t2_vi3_pmt3, t2_xi3_pmt3, t2_def3_pmt3;
        double cpers1 = KSI * convDouble(D6);
        double cpers2 = if2_pmt3 / convDouble(D5);
        cpers2 = (Math.pow(cpers2, ASI)) - 1;
        t2_si3_pmt3 = cpers1 / cpers2;

        double cpers3 = KVI * convDouble(D6);
        double cpers4 = if2_pmt3 / convDouble(D5);
        cpers4 = (Math.pow(cpers4, AVI)) - 1;
        t2_vi3_pmt3 = cpers3 / cpers4;

        double cpers5 = KXI * convDouble(D6);
        double cpers6 = if2_pmt3 / convDouble(D5);
        cpers6 = (Math.pow(cpers6, AXI)) - 1;
        t2_xi3_pmt3 = cpers5 / cpers6;

        t2_def3_pmt3 = convDouble(D6);

        double t3_si1_GI, t3_vi1_GI, t3_xi1_GI, t3_def1_GI;
        if (isEqual(A1, ON)) {
            t3_si1_GI = convDouble(A3);
        } else if (convDouble(B2) > convDouble(A5)) {
            double pers1 = KSI * convDouble(A6);
            double pers2 = convDouble(B2) / convDouble(A5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si1_GI = pers1 / pers2;
        } else if (convDouble(B2) == convDouble(A5)) {
            double pers1 = KSI * convDouble(A6);
            double pers2 = (1.1 * convDouble(B2)) / convDouble(A5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si1_GI = pers1 / pers2;
        } else {
            t3_si1_GI = 99;
        }

        if (isEqual(A1, ON)) {
            t3_vi1_GI = convDouble(A3);
        } else if (convDouble(B2) > convDouble(A5)) {
            double pers1 = KVI * convDouble(A6);
            double pers2 = convDouble(B2) / convDouble(A5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi1_GI = pers1 / pers2;
        } else if (convDouble(B2) == convDouble(A5)) {
            double pers1 = KVI * convDouble(A6);
            double pers2 = (1.1 * convDouble(B2)) / convDouble(A5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi1_GI = pers1 / pers2;
        } else {
            t3_vi1_GI = 99;
        }

        if (isEqual(A1, ON)) {
            t3_xi1_GI = convDouble(A3);
        } else if (convDouble(B2) > convDouble(A5)) {
            double pers1 = KXI * convDouble(A6);
            double pers2 = convDouble(B2) / convDouble(A5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi1_GI = pers1 / pers2;
        } else if (convDouble(B2) == convDouble(A5)) {
            double pers1 = KXI * convDouble(A6);
            double pers2 = (1.1 * convDouble(B2)) / convDouble(A5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi1_GI = pers1 / pers2;
        } else {
            t3_xi1_GI = 99;
        }

        if (isEqual(A1, ON)) {
            t3_def1_GI = convDouble(A3);
        } else {
            t3_def1_GI = convDouble(A6);
        }

        double t3_def1_pmt1 = convDouble(B3);

        double t3_si2_pmt1, t3_vi2_pmt1, t3_xi2_pmt1, t3_def2_pmt1;
        if (isEqual(B1, ON)) {
            t3_si2_pmt1 = convDouble(B3);
        } else if (convDouble(C2) > convDouble(B5)) {
            double pers1 = KSI * convDouble(B6);
            double pers2 = convDouble(C2) / convDouble(B5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si2_pmt1 = pers1 / pers2;
        } else if (convDouble(C2) == convDouble(B5)) {
            double pers1 = KSI * convDouble(B6);
            double pers2 = (1.1 * convDouble(C2)) / convDouble(B5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si2_pmt1 = pers1 / pers2;
        } else {
            t3_si2_pmt1 = 99;
        }

        if (isEqual(B1, ON)) {
            t3_vi2_pmt1 = convDouble(B3);
        } else if (convDouble(C2) > convDouble(B5)) {
            double pers1 = KVI * convDouble(B6);
            double pers2 = convDouble(C2) / convDouble(B5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi2_pmt1 = pers1 / pers2;
        } else if (convDouble(C2) == convDouble(B5)) {
            double pers1 = KVI * convDouble(B6);
            double pers2 = (1.1 * convDouble(C2)) / convDouble(B5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi2_pmt1 = pers1 / pers2;
        } else {
            t3_vi2_pmt1 = 99;
        }

        if (isEqual(B1, ON)) {
            t3_xi2_pmt1 = convDouble(B3);
        } else if (convDouble(C2) > convDouble(B5)) {
            double pers1 = KXI * convDouble(B6);
            double pers2 = convDouble(C2) / convDouble(B5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi2_pmt1 = pers1 / pers2;
        } else if (convDouble(C2) == convDouble(B5)) {
            double pers1 = KXI * convDouble(B6);
            double pers2 = (1.1 * convDouble(C2)) / convDouble(B5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi2_pmt1 = pers1 / pers2;
        } else {
            t3_xi2_pmt1 = 99;
        }

        if (isEqual(B1, ON)) {
            t3_def2_pmt1 = convDouble(B3);
        } else {
            t3_def2_pmt1 = convDouble(B6);
        }

        double t3_def2_pmt2 = convDouble(C3);

        double t3_si3_pmt2, t3_vi3_pmt2, t3_xi3_pmt2, t3_def3_pmt2;
        if (isEqual(C1, ON)) {
            t3_si3_pmt2 = convDouble(C3);
        } else if (convDouble(D2) > convDouble(C5)) {
            double pers1 = KSI * convDouble(C6);
            double pers2 = convDouble(D2) / convDouble(C5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si3_pmt2 = pers1 / pers2;
        } else if (convDouble(D2) == convDouble(C5)) {
            double pers1 = KSI * convDouble(C6);
            double pers2 = (1.1 * convDouble(D2)) / convDouble(C5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            t3_si3_pmt2 = pers1 / pers2;
        } else {
            t3_si3_pmt2 = 99;
        }

        if (isEqual(C1, ON)) {
            t3_vi3_pmt2 = convDouble(C3);
        } else if (convDouble(D2) > convDouble(C5)) {
            double pers1 = KVI * convDouble(C6);
            double pers2 = convDouble(D2) / convDouble(C5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi3_pmt2 = pers1 / pers2;
        } else if (convDouble(D2) == convDouble(C5)) {
            double pers1 = KVI * convDouble(C6);
            double pers2 = (1.1 * convDouble(D2)) / convDouble(C5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            t3_vi3_pmt2 = pers1 / pers2;
        } else {
            t3_vi3_pmt2 = 99;
        }

        if (isEqual(C1, ON)) {
            t3_xi3_pmt2 = convDouble(C3);
        } else if (convDouble(D2) > convDouble(C5)) {
            double pers1 = KXI * convDouble(C6);
            double pers2 = convDouble(D2) / convDouble(C5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi3_pmt2 = pers1 / pers2;
        } else if (convDouble(D2) == convDouble(C5)) {
            double pers1 = KXI * convDouble(C6);
            double pers2 = (1.1 * convDouble(D2)) / convDouble(C5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            t3_xi3_pmt2 = pers1 / pers2;
        } else {
            t3_xi3_pmt2 = 99;
        }

        if (isEqual(C1, ON)) {
            t3_def3_pmt2 = convDouble(C3);
        } else {
            t3_def3_pmt2 = convDouble(C6);
        }

        double t3_def3_pmt3 = convDouble(D3);


        /*BELUM*/
        double t1_GI;
        if (isEqual(A11, "SI")) {
            t1_GI = t1_si1_GI;
        } else if (isEqual(A11, "VI")) {
            t1_GI = t1_vi1_GI;
        } else if (isEqual(A11, "XI")) {
            t1_GI = t1_xi1_GI;
        } else {
            t1_GI = t1_def1_GI;
        }

        double t1_pmt1a;
        if (isEqual(B11, "SI")) {
            t1_pmt1a = t1_si1_pmt1;
        } else if (isEqual(B11, "VI")) {
            t1_pmt1a = t1_vi1_pmt1;
        } else if (isEqual(B11, "XI")) {
            t1_pmt1a = t1_xi1_pmt1;
        } else {
            t1_pmt1a = t1_def1_pmt1;
        }

        double t1_pmt1b;
        if (isEqual(B11, "SI")) {
            t1_pmt1b = t1_si2_pmt1;
        } else if (isEqual(B11, "VI")) {
            t1_pmt1b = t1_vi2_pmt1;
        } else if (isEqual(B11, "XI")) {
            t1_pmt1b = t1_xi2_pmt1;
        } else {
            t1_pmt1b = t1_def2_pmt1;
        }

        double t1_pmt2a;
        if (isEqual(C11, "SI")) {
            t1_pmt2a = t1_si2_pmt2;
        } else if (isEqual(C11, "VI")) {
            t1_pmt2a = t1_vi2_pmt2;
        } else if (isEqual(C11, "XI")) {
            t1_pmt2a = t1_xi2_pmt2;
        } else {
            t1_pmt2a = t1_def2_pmt2;
        }

        double t1_pmt2b;
        if (C11.equals("SI")) {
            t1_pmt2b = t1_si3_pmt2;
        } else if (C11.equals("VI")) {
            t1_pmt2b = t1_vi3_pmt2;
        } else if (C11.equals("XI")) {
            t1_pmt2b = t1_xi3_pmt2;
        } else {
            t1_pmt2b = t1_def3_pmt2;
        }

        double t1_pmt3;
        if (isEqual(D11, "SI")) {
            t1_pmt3 = t1_si3_pmt3;
        } else if (isEqual(D11, "VI")) {
            t1_pmt3 = t1_vi1_pmt1;
        } else if (isEqual(D11, "XI")) {
            t1_pmt3 = t1_xi3_pmt3;
        } else {
            t1_pmt3 = t1_def3_pmt3;
        }

        double dt1_pmt1, dt1_pmt2, dt1_pmt3;
        dt1_pmt1 = (tcb_pmt1 + trele_pmt1) / 1000;
        dt1_pmt1 = t1_GI - (t1_pmt1a + dt1_pmt1);

        dt1_pmt2 = (tcb_pmt2 + trele_pmt2) / 1000;
        dt1_pmt2 = t1_pmt1b - (t1_pmt2a + dt1_pmt2);

        dt1_pmt3 = (tcb_pmt3 + trele_pmt3) / 1000;
        dt1_pmt3 = t1_pmt2b - (t1_pmt3 + dt1_pmt3);

        double t2_GI;
        if (isEqual(A4, ON) && isEqual(A7, "SI")) {
            t2_GI = t2_si1_GI;
        } else if (isEqual(A4, ON) && isEqual(A7, "VI")) {
            t2_GI = t2_vi1_GI;
        } else if (isEqual(A4, ON) && isEqual(A7, "XI")) {
            t2_GI = t2_xi1_GI;
        } else if (isEqual(A4, ON) && isEqual(A7, "DEF")) {
            t2_GI = t2_def1_GI;
        } else if (isEqual(A4, OFF) && isEqual(A11, "SI")) {
            t2_GI = t2_si1_GI;
        } else if (isEqual(A4, OFF) && isEqual(A11, "VI")) {
            t2_GI = t2_vi1_GI;
        } else if (isEqual(A4, OFF) && isEqual(A11, "XI")) {
            t2_GI = t2_xi1_GI;
        } else {
            t2_GI = t2_def1_GI;
        }

        double t2_pmt1a;
        if (isEqual(B4, ON) && isEqual(B7, "SI")) {
            t2_pmt1a = t2_si1_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "VI")) {
            t2_pmt1a = t2_vi1_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "XI")) {
            t2_pmt1a = t2_xi1_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "DEF")) {
            t2_pmt1a = t2_def1_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "SI")) {
            t2_pmt1a = t2_si1_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "VI")) {
            t2_pmt1a = t2_vi1_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "XI")) {
            t2_pmt1a = t2_xi1_pmt1;
        } else {
            t2_pmt1a = t2_def1_pmt1;
        }

        double t2_pmt1b;
        if (isEqual(B4, ON) && isEqual(B7, "SI")) {
            t2_pmt1b = t2_si2_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "VI")) {
            t2_pmt1b = t2_vi2_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "XI")) {
            t2_pmt1b = t2_xi2_pmt1;
        } else if (isEqual(B4, ON) && isEqual(B7, "DEF")) {
            t2_pmt1b = t2_def2_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "SI")) {
            t2_pmt1b = t2_si2_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "VI")) {
            t2_pmt1b = t2_vi2_pmt1;
        } else if (isEqual(B4, OFF) && isEqual(B11, "XI")) {
            t2_pmt1b = t2_xi2_pmt1;
        } else {
            t2_pmt1b = t2_def2_pmt1;
        }

        double t2_pmt2a;
        if (isEqual(C4, ON) && isEqual(C7, "SI")) {
            t2_pmt2a = t2_si2_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "VI")) {
            t2_pmt2a = t2_vi2_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "XI")) {
            t2_pmt2a = t2_xi2_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "DEF")) {
            t2_pmt2a = t2_def2_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "SI")) {
            t2_pmt2a = t2_si2_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "VI")) {
            t2_pmt2a = t2_vi2_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "XI")) {
            t2_pmt2a = t2_xi2_pmt2;
        } else {
            t2_pmt2a = t2_def2_pmt2;
        }

        double t2_pmt2b;
        if (isEqual(C4, ON) && isEqual(C7, "SI")) {
            t2_pmt2b = t2_si3_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "VI")) {
            t2_pmt2b = t2_vi3_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "XI")) {
            t2_pmt2b = t2_xi3_pmt2;
        } else if (isEqual(C4, ON) && isEqual(C7, "DEF")) {
            t2_pmt2b = t2_def3_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "SI")) {
            t2_pmt2b = t2_si3_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "VI")) {
            t2_pmt2b = t2_vi3_pmt2;
        } else if (isEqual(C4, OFF) && isEqual(C11, "XI")) {
            t2_pmt2b = t2_xi3_pmt2;
        } else {
            t2_pmt2b = t2_def3_pmt2;
        }

        double t2_pmt3;
        if (isEqual(D4, ON) && isEqual(D7, "SI")) {
            t2_pmt3 = t2_si3_pmt3;
        } else if (isEqual(D4, ON) && isEqual(D7, "VI")) {
            t2_pmt3 = t2_vi3_pmt3;
        } else if (isEqual(D4, ON) && isEqual(D7, "XI")) {
            t2_pmt3 = t2_xi3_pmt3;
        } else if (isEqual(D4, ON) && isEqual(D7, "DEF")) {
            t2_pmt3 = t2_def3_pmt3;
        } else if (isEqual(D4, OFF) && isEqual(D11, "SI")) {
            t2_pmt3 = t2_si3_pmt3;
        } else if (isEqual(D4, OFF) && isEqual(D11, "VI")) {
            t2_pmt3 = t2_vi3_pmt3;
        } else if (isEqual(D4, OFF) && isEqual(D11, "XI")) {
            t2_pmt3 = t2_xi3_pmt3;
        } else {
            t2_pmt3 = t2_def3_pmt3;
        }

        double dt2_pmt1, dt2_pmt2, dt2_pmt3;
        dt2_pmt1 = (tcb_pmt1 + trele_pmt1) / 1000;
        dt2_pmt1 = t2_GI - (t2_pmt1a + dt2_pmt1);

        dt2_pmt2 = (tcb_pmt2 + trele_pmt2) / 1000;
        dt2_pmt2 = t2_pmt1b - (t2_pmt2a + dt2_pmt2);

        dt2_pmt3 = (tcb_pmt3 + trele_pmt3) / 1000;
        dt2_pmt3 = t2_pmt2b - (t2_pmt3 + dt2_pmt3);

        double t3_GI;
        if (isEqual(A1, ON)) {
            t3_GI = t3_def1_GI;
        } else if (isEqual(A1, OFF) && isEqual(A7, "SI")) {
            t3_GI = t3_si1_GI;
        } else if (isEqual(A1, OFF) && isEqual(A7, "VI")) {
            t3_GI = t3_vi1_GI;
        } else if (isEqual(A1, OFF) && isEqual(A7, "XI")) {
            t3_GI = t3_xi1_GI;
        } else {
            t3_GI = t3_def1_GI;
        }

        double t3_pmt1a = t3_def1_pmt1;

        double t3_pmt1b;
        if (isEqual(B1, ON)) {
            t3_pmt1b = t3_def2_pmt1;
        } else if (isEqual(B1, OFF) && isEqual(B7, "SI")) {
            t3_pmt1b = t3_si2_pmt1;
        } else if (isEqual(B1, OFF) && isEqual(B7, "VI")) {
            t3_pmt1b = t3_vi2_pmt1;
        } else if (isEqual(B1, OFF) && isEqual(B7, "XI")) {
            t3_pmt1b = t3_xi2_pmt1;
        } else {
            t3_pmt1b = t3_def2_pmt1;
        }

        double t3_pmt2a = t3_def2_pmt2;

        double t3_pmt2b;
        if (isEqual(C1, ON)) {
            t3_pmt2b = t3_def3_pmt2;
        } else if (isEqual(C1, OFF) && isEqual(C7, "SI")) {
            t3_pmt2b = t3_si3_pmt2;
        } else if (isEqual(C1, OFF) && isEqual(C7, "VI")) {
            t3_pmt2b = t3_vi3_pmt2;
        } else if (isEqual(C1, OFF) && isEqual(C7, "XI")) {
            t3_pmt2b = t3_xi3_pmt2;
        } else {
            t3_pmt2b = t3_def3_pmt2;
        }

        double t3_pmt3 = t3_def3_pmt3;

        double dt3_pmt1, dt3_pmt2, dt3_pmt3;
        dt3_pmt1 = (tcb_pmt1 + trele_pmt1) / 1000;
        dt3_pmt1 = t3_GI - (t3_pmt1a + dt3_pmt1);

        dt3_pmt2 = (tcb_pmt2 + trele_pmt2) / 1000;
        dt3_pmt2 = t3_pmt1b - (t3_pmt2a + dt3_pmt2);

        dt3_pmt3 = (tcb_pmt3 + trele_pmt3) / 1000;
        dt3_pmt3 = t3_pmt2b - (t3_pmt3 + dt3_pmt3);

        /*HASIL AKHIR START*/
        UjiOutputClass akhir = new UjiOutputClass();

        String K1a, K1b, K1c;
        String K2a, K2b, K2c;
        String K3a, K3b, K3c;
        String K4a, K4b, K4c;
        String K5 = "", K5k = "";
        String K6 = "", K6k = "";
        String K7 = "", K7k = "";
        String K8 = "", K8k = "";

        if (A9.equals("0")) {
            K1a = "-";
        } else if (isEqual(A8, "ON")) {
            K1a = "OK";
        } else {
            K1a = "NOK";
        }
        akhir.setK1a(K1a);

        if (A5.equals("0")) {
            K1b = "-";
        } else if (isEqual(A4, "ON")) {
            K1b = "OK";
        } else {
            K1b = "OFF";
        }
        akhir.setK1b(K1b);

        if (A2.equals("0")) {
            K1c = "-";
        } else if (isEqual(A1, "ON")) {
            K1c = "OK";
        } else {
            K1c = "OFF";
        }
        akhir.setK1c(K1c);

        if (B5.equals("0")) {
            K2a = "-";
        } else if (isEqual(B4, "OFF")) {
            K2a = "OFF";
        } else if (isEqual(B4, "ON") && dt1_pmt1 > 0) {
            K2a = "OK";
        } else {
            K2a = "NOK";
        }
        akhir.setK2a(K2a);

        if (B9.equals("0")) {
            K2b = "-";
        } else if (isEqual(B8, "OFF")) {
            K2b = "OFF";
        } else if (isEqual(B8, "ON") && dt1_pmt1 > 0) {
            K2b = "OK";
        } else {
            K2b = "NOK";
        }
        akhir.setK2b(K2b);

        if (B2.equals("0")) {
            K2c = "-";
        } else if (isEqual(B1, "OFF")) {
            K2c = "OFF";
        } else if (isEqual(B1, "ON") && dt3_pmt1 > 0) {
            K2c = "OK";
        } else {
            K2c = "NOK";
        }
        akhir.setK2c(K2c);

        if (C9.equals("0")) {
            K3a = "-";
        } else if (isEqual(C8, "OFF")) {
            K3a = "OFF";
        } else if (isEqual(C8, "ON") && dt1_pmt2 > 0) {
            K3a = "OK";
        } else {
            K3a = "NOK";
        }
        akhir.setK3a(K3a);

        if (C5.equals("0")) {
            K3b = "-";
        } else if (isEqual(C4, "OFF")) {
            K3b = "OFF";
        } else if (isEqual(C4, "ON") && dt2_pmt2 > 0) {
            K3b = "OK";
        } else {
            K3b = "NOK";
        }
        akhir.setK3b(K3b);

        if (C2.equals("0")) {
            K3c = "-";
        } else if (isEqual(C1, "OFF")) {
            K3c = "OFF";
        } else if (isEqual(C1, "ON") && dt3_pmt2 > 0) {
            K3c = "OK";
        } else {
            K3c = "NOK";
        }
        akhir.setK3c(K3c);

        if (D9.equals("0")) {
            K4a = "-";
        } else if (isEqual(D8, "OFF")) {
            K4a = "OFF";
        } else if (isEqual(D8, "ON") && dt1_pmt3 > 0) {
            K4a = "OK";
        } else {
            K4a = "NOK";
        }
        akhir.setK4a(K4a);

        if (D5.equals("0")) {
            K4b = "-";
        } else if (isEqual(D4, "OFF")) {
            K4b = "OFF";
        } else if (isEqual(D4, "ON") && dt2_pmt3 > 0) {
            K4b = "OK";
        } else {
            K4b = "NOK";
        }
        akhir.setK4b(K4b);

        if (D2.equals("0")) {
            K4c = "-";
        } else if (isEqual(D1, "OFF")) {
            K4c = "OFF";
        } else if (isEqual(D1, "ON") && dt3_pmt3 > 0) {
            K4c = "OK";
        } else {
            K4c = "NOK";
        }
        akhir.setK4c(K4c);

        if (isEqual(K1a, "-")) {
            K5 = "-";
        } else if (isNotEqual(K1a, "NOK") && isNotEqual(K1b, "NOK")) {
            K5 = "SUKSES PROTEKSI";
        }
        akhir.setK5(K5);

        if (isEqual(K2a, "-")) {
            K6 = "-";
        } else if (isNotEqual(K2a, "NOK") && isNotEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6 = "SUKSES PROTEKSI";
        /*} else if (isNotEqual(K2a, "–") && isNotEqual(K2b, "OK ") && isNotEqual(K2c, "OK ")) {
            K6 = "GAGAL PROTEKSI";*/
        } else if (isNotEqual(K2a, "OK") && isNotEqual(K2b, "OK ") && isNotEqual(K2c, "OK")) {
            K6 = "GAGAL PROTEKSI";
        } else if (isEqual(K2a, "OK") && isEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6 = "WARNING";
        } else if (isEqual(K2a, "OK") && isNotEqual(K2b, "NOK") && isEqual(K2c, "NOK")) {
            K6 = "WARNING";
        } else if (isEqual(K2a, "OK ") && isEqual(K2b, "NOK") && isEqual(K2c, "NOK")) {
            K6 = "WARNING";
        } else if (isEqual(K2a, "NOK ") && isNotEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6 = "WARNING";
        } else if (isEqual(K2a, "NOK ") && isEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6 = "WARNING";
        }
        akhir.setK6(K6);

        if (isEqual(K3a, "-")) {
            K7 = "-";
        } else if (isNotEqual(K3a, "NOK") && isNotEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7 = "SUKSES PROTEKSI";
        /*} else if (isNotEqual(K3a, "–") && isNotEqual(K3b, "OK ") && isNotEqual(K3c, "OK ")) {
            K7 = "GAGAL PROTEKSI";*/
        } else if (isNotEqual(K3a, "OK") && isNotEqual(K3b, "OK ") && isNotEqual(K3c, "OK")) {
            K7 = "GAGAL PROTEKSI";
        } else if (isEqual(K3a, "OK") && isEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7 = "WARNING";
        } else if (isEqual(K3a, "OK") && isNotEqual(K3b, "NOK") && isEqual(K3c, "NOK")) {
            K7 = "WARNING";
        } else if (isEqual(K3a, "OK ") && isEqual(K3b, "NOK") && isEqual(K3c, "NOK")) {
            K7 = "WARNING";
        } else if (isEqual(K3a, "NOK ") && isNotEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7 = "WARNING";
        } else if (isEqual(K3a, "NOK ") && isEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7 = "WARNING";
        }
        akhir.setK7(K7);

        if (isEqual(K4a, "-")) {
            K8 = "-";
        } else if (isNotEqual(K4a, "NOK") && isNotEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8 = "SUKSES PROTEKSI";
        /*} else if (isNotEqual(K4a, "–") && isNotEqual(K4b, "OK ") && isNotEqual(K4c, "OK ")) {
            K8 = "GAGAL PROTEKSI";*/
        } else if (isNotEqual(K4a, "OK") && isNotEqual(K4b, "OK ") && isNotEqual(K4c, "OK")) {
            K8 = "GAGAL PROTEKSI";
        } else if (isEqual(K4a, "OK") && isEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8 = "WARNING";
        } else if (isEqual(K4a, "OK") && isNotEqual(K4b, "NOK") && isEqual(K4c, "NOK")) {
            K8 = "WARNING";
        } else if (isEqual(K4a, "OK ") && isEqual(K4b, "NOK") && isEqual(K4c, "NOK")) {
            K8 = "WARNING";
        } else if (isEqual(K4a, "NOK ") && isNotEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8 = "WARNING";
        } else if (isEqual(K4a, "NOK ") && isEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8 = "WARNING";
        }
        akhir.setK8(K8);

        K5k = "–";
        akhir.setK5k(K5k);

        if (isEqual(K2a, "-")) {
            K6k = "-";
        } else if (isNotEqual(K2a, "NOK") && isNotEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6k = "-";
        /*} else if (isNotEqual(K2a, "–") && isNotEqual(K2b, "OK") && isNotEqual(K2c, "OK")) {
            K6k = "-";*/
        } else if (isNotEqual(K2a, "OK") && isNotEqual(K2b, "OK") && isNotEqual(K2c, "OK ")) {
            K6k = "-";
        } else if (isEqual(K2a, "OK") && isEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6k = "SETTING TAHAP 2 GAGAL PROTEKSI";
        } else if (isEqual(K2a, "OK") && isNotEqual(K2b, "NOK") && isEqual(K2c, "NOK")) {
            K6k = "SETTING TAHAP 3 GAGAL PROTEKSI";
        } else if (isEqual(K2a, "OK") && isEqual(K2b, "NOK") && isEqual(K2c, "NOK")) {
            K6k = "SETTING TAHAP 2 & 3 GAGAL PROTEKSI";
        } else if (isEqual(K2a, "NOK") && isNotEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6k = "SETTING TAHAP 1 GAGAL PROTEKSI";
        } else if (isEqual(K2a, "NOK") && isEqual(K2b, "NOK") && isNotEqual(K2c, "NOK")) {
            K6k = "SETTING TAHAP 1 & 2 GAGAL PROTEKSI";
        }
        akhir.setK6k(K6k);

        if (isEqual(K3a, "-")) {
            K7k = "-";
        } else if (isNotEqual(K3a, "NOK") && isNotEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7k = "-";
        /*} else if (isNotEqual(K3a, "–") && isNotEqual(K3b, "OK") && isNotEqual(K3c, "OK")) {
            K7k = "-";*/
        } else if (isNotEqual(K3a, "OK") && isNotEqual(K3b, "OK") && isNotEqual(K3c, "OK ")) {
            K7k = "-";
        } else if (isEqual(K3a, "OK") && isEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7k = "SETTING TAHAP 2 GAGAL PROTEKSI";
        } else if (isEqual(K3a, "OK") && isNotEqual(K3b, "NOK") && isEqual(K3c, "NOK")) {
            K7k = "SETTING TAHAP 3 GAGAL PROTEKSI";
        } else if (isEqual(K3a, "OK") && isEqual(K3b, "NOK") && isEqual(K3c, "NOK")) {
            K7k = "SETTING TAHAP 2 & 3 GAGAL PROTEKSI";
        } else if (isEqual(K3a, "NOK") && isNotEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7k = "SETTING TAHAP 1 GAGAL PROTEKSI";
        } else if (isEqual(K3a, "NOK") && isEqual(K3b, "NOK") && isNotEqual(K3c, "NOK")) {
            K7k = "SETTING TAHAP 1 & 2 GAGAL PROTEKSI";
        }
        akhir.setK7k(K7k);

        if (isEqual(K4a, "-")) {
            K8k = "-";
        } else if (isNotEqual(K4a, "NOK") && isNotEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8k = "-";
        /*} else if (isNotEqual(K4a, "–") && isNotEqual(K4b, "OK") && isNotEqual(K4c, "OK")) {
            K8k = "-";*/
        } else if (isNotEqual(K4a, "OK") && isNotEqual(K4b, "OK") && isNotEqual(K4c, "OK ")) {
            K8k = "-";
        } else if (isEqual(K4a, "OK") && isEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8k = "SETTING TAHAP 2 GAGAL PROTEKSI";
        } else if (isEqual(K4a, "OK") && isNotEqual(K4b, "NOK") && isEqual(K4c, "NOK")) {
            K8k = "SETTING TAHAP 3 GAGAL PROTEKSI";
        } else if (isEqual(K4a, "OK") && isEqual(K4b, "NOK") && isEqual(K4c, "NOK")) {
            K8k = "SETTING TAHAP 2 & 3 GAGAL PROTEKSI";
        } else if (isEqual(K4a, "NOK") && isNotEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8k = "SETTING TAHAP 1 GAGAL PROTEKSI";
        } else if (isEqual(K4a, "NOK") && isEqual(K4b, "NOK") && isNotEqual(K4c, "NOK")) {
            K8k = "SETTING TAHAP 1 & 2 GAGAL PROTEKSI";
        }
        akhir.setK8k(K8k);
        /*HASIL AKHIR END*/
        return akhir;
    }

    private Double convDouble(String istring) {
        Double adouble = Double.valueOf(istring);
        return adouble;
    }

    private String convString(Double idouble) {
        String astring = String.valueOf(idouble);
        return astring;
    }

    private Boolean isEqual(String istring, String iparam) {
        boolean astat = false;
        String astring = istring.toUpperCase();
        String aparam = iparam.toUpperCase();
        if (astring.equals(aparam)) {
            astat = true;
        }
        return astat;
    }

    private Boolean isNotEqual(String istring, String iparam) {
        boolean astat = false;
        String astring = istring.toUpperCase();
        String aparam = iparam.toUpperCase();
        if (!astring.equals(aparam)) {
            astat = true;
        }
        return astat;
    }


    //default function
    public void runAlertDialog(String imsg, int itipe) { //1 error, 2 sukses, 3 info
        AlertDialog alertDialog = AlertDialogClass2.alertDialog(imsg, itipe, mContext);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
