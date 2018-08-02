package id.co.pln.ipro.clsumum;

import java.io.Serializable;
import java.util.HashMap;

import me.riddhimanadib.formmaster.model.BaseFormElement;

public class CalculateDataUjiParameter {
    public static String mPenyulang, mRele, namaPemutus1, namaPemutus2, namaPemutus3;

    public static HashMap<String, BaseFormElement> ahash_itemGI;
    public static HashMap<String, BaseFormElement> ahash_pemutus1;
    public static HashMap<String, BaseFormElement> ahash_pemutus2;
    public static HashMap<String, BaseFormElement> ahash_pemutus3;

    public static double tcb_gi, tcb_pmt1, tcb_pmt2, tcb_pmt3;
    public static double trele_gi, trele_pmt1, trele_pmt2, trele_pmt3;

    public static String getmPenyulang() {
        return mPenyulang;
    }

    public static void setmPenyulang(String mPenyulang) {
        CalculateDataUjiParameter.mPenyulang = mPenyulang;
    }

    public static String getmRele() {
        return mRele;
    }

    public static void setmRele(String mRele) {
        CalculateDataUjiParameter.mRele = mRele;
    }

    public static String getNamaPemutus1() {
        return namaPemutus1;
    }

    public static void setNamaPemutus1(String namaPemutus1) {
        CalculateDataUjiParameter.namaPemutus1 = namaPemutus1;
    }

    public static String getNamaPemutus2() {
        return namaPemutus2;
    }

    public static void setNamaPemutus2(String namaPemutus2) {
        CalculateDataUjiParameter.namaPemutus2 = namaPemutus2;
    }

    public static String getNamaPemutus3() {
        return namaPemutus3;
    }

    public static void setNamaPemutus3(String namaPemutus3) {
        CalculateDataUjiParameter.namaPemutus3 = namaPemutus3;
    }

    public HashMap<String, BaseFormElement> getAhash_itemGI() {
        return ahash_itemGI;
    }

    public void setAhash_itemGI(HashMap<String, BaseFormElement> ahash_itemGI) {
        this.ahash_itemGI = ahash_itemGI;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus1() {
        return ahash_pemutus1;
    }

    public void setAhash_pemutus1(HashMap<String, BaseFormElement> ahash_pemutus1) {
        this.ahash_pemutus1 = ahash_pemutus1;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus2() {
        return ahash_pemutus2;
    }

    public void setAhash_pemutus2(HashMap<String, BaseFormElement> ahash_pemutus2) {
        this.ahash_pemutus2 = ahash_pemutus2;
    }

    public HashMap<String, BaseFormElement> getAhash_pemutus3() {
        return ahash_pemutus3;
    }

    public void setAhash_pemutus3(HashMap<String, BaseFormElement> ahash_pemutus3) {
        this.ahash_pemutus3 = ahash_pemutus3;
    }

    public double getTcb_gi() {
        return tcb_gi;
    }

    public void setTcb_gi(double tcb_gi) {
        this.tcb_gi = tcb_gi;
    }

    public double getTcb_pmt1() {
        return tcb_pmt1;
    }

    public void setTcb_pmt1(double tcb_pmt1) {
        this.tcb_pmt1 = tcb_pmt1;
    }

    public double getTcb_pmt2() {
        return tcb_pmt2;
    }

    public void setTcb_pmt2(double tcb_pmt2) {
        this.tcb_pmt2 = tcb_pmt2;
    }

    public double getTcb_pmt3() {
        return tcb_pmt3;
    }

    public void setTcb_pmt3(double tcb_pmt3) {
        this.tcb_pmt3 = tcb_pmt3;
    }

    public double getTrele_gi() {
        return trele_gi;
    }

    public void setTrele_gi(double trele_gi) {
        this.trele_gi = trele_gi;
    }

    public double getTrele_pmt1() {
        return trele_pmt1;
    }

    public void setTrele_pmt1(double trele_pmt1) {
        this.trele_pmt1 = trele_pmt1;
    }

    public double getTrele_pmt2() {
        return trele_pmt2;
    }

    public void setTrele_pmt2(double trele_pmt2) {
        this.trele_pmt2 = trele_pmt2;
    }

    public double getTrele_pmt3() {
        return trele_pmt3;
    }

    public void setTrele_pmt3(double trele_pmt3) {
        this.trele_pmt3 = trele_pmt3;
    }
}
