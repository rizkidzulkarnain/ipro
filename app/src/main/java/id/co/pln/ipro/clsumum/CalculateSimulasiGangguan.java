package id.co.pln.ipro.clsumum;

import java.text.DecimalFormat;
import java.util.HashMap;

import id.co.pln.ipro.model.SimulasiOutputClass;
import me.riddhimanadib.formmaster.model.BaseFormElement;

public class CalculateSimulasiGangguan {
    final static double KSI = 0.14, KVI = 13.5, ASI = 0.02;
    final static int KXI = 80, AVI = 1, AXI = 2;
    final static String ON = "ON", OFF = "OFF";
    String mArus;

    public CalculateSimulasiGangguan(String iArus) {
        this.mArus = iArus;
    }

    public SimulasiOutputClass Calculate() {

        SimulasiOutputClass akhir = new SimulasiOutputClass();

        String X = CalculateDataUjiParameter.getmPenyulang();
        String Y = CalculateDataUjiParameter.getmRele();

        String X1 = CalculateDataUjiParameter.getNamaPemutus1();
        String X2 = CalculateDataUjiParameter.getNamaPemutus2();
        String X3 = CalculateDataUjiParameter.getNamaPemutus3();

        //GI
        String A1 = CalculateDataUjiParameter.ahash_itemGI.get("tahap3_fungsi").getValue();
        String A2 = CalculateDataUjiParameter.ahash_itemGI.get("tahap3_iset").getValue();
        String A3 = CalculateDataUjiParameter.ahash_itemGI.get("tahap3_delay").getValue();
        String A4 = CalculateDataUjiParameter.ahash_itemGI.get("tahap2_fungsi").getValue();
        String A5 = CalculateDataUjiParameter.ahash_itemGI.get("tahap2_iset").getValue();
        String A6 = CalculateDataUjiParameter.ahash_itemGI.get("tahap2_delay").getValue();
        String A7 = CalculateDataUjiParameter.ahash_itemGI.get("tahap2_kurva").getValue();
        String A8 = CalculateDataUjiParameter.ahash_itemGI.get("tahap1_fungsi").getValue();
        String A9 = CalculateDataUjiParameter.ahash_itemGI.get("tahap1_iset").getValue();
        String A10 = CalculateDataUjiParameter.ahash_itemGI.get("tahap1_delay").getValue();
        String A11 = CalculateDataUjiParameter.ahash_itemGI.get("tahap1_kurva").getValue();
        String A12 = CalculateDataUjiParameter.ahash_itemGI.get("hasil_fungsi").getValue();
        String A13 = CalculateDataUjiParameter.ahash_itemGI.get("hasil_ujicb").getValue();
        String A14 = CalculateDataUjiParameter.ahash_itemGI.get("hasil_relay").getValue();

        //Pemutus1
        String B1 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap3_fungsi").getValue();
        String B2 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap3_iset").getValue();
        String B3 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap3_delay").getValue();
        String B4 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap2_fungsi").getValue();
        String B5 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap2_iset").getValue();
        String B6 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap2_delay").getValue();
        String B7 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap2_kurva").getValue();
        String B8 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap1_fungsi").getValue();
        String B9 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap1_iset").getValue();
        String B10 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap1_delay").getValue();
        String B11 = CalculateDataUjiParameter.ahash_pemutus1.get("tahap1_kurva").getValue();
        String B12 = CalculateDataUjiParameter.ahash_pemutus1.get("hasil_fungsi").getValue();
        String B13 = CalculateDataUjiParameter.ahash_pemutus1.get("hasil_ujicb").getValue();
        String B14 = CalculateDataUjiParameter.ahash_pemutus1.get("hasil_relay").getValue();

        //Pemutus2
        String C1 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap3_fungsi").getValue();
        String C2 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap3_iset").getValue();
        String C3 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap3_delay").getValue();
        String C4 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap2_fungsi").getValue();
        String C5 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap2_iset").getValue();
        String C6 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap2_delay").getValue();
        String C7 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap2_kurva").getValue();
        String C8 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap1_fungsi").getValue();
        String C9 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap1_iset").getValue();
        String C10 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap1_delay").getValue();
        String C11 = CalculateDataUjiParameter.ahash_pemutus2.get("tahap1_kurva").getValue();
        String C12 = CalculateDataUjiParameter.ahash_pemutus2.get("hasil_fungsi").getValue();
        String C13 = CalculateDataUjiParameter.ahash_pemutus2.get("hasil_ujicb").getValue();
        String C14 = CalculateDataUjiParameter.ahash_pemutus2.get("hasil_relay").getValue();

        //Pemutus3
        String D1 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap3_fungsi").getValue();
        String D2 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap3_iset").getValue();
        String D3 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap3_delay").getValue();
        String D4 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap2_fungsi").getValue();
        String D5 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap2_iset").getValue();
        String D6 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap2_delay").getValue();
        String D7 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap2_kurva").getValue();
        String D8 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap1_fungsi").getValue();
        String D9 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap1_iset").getValue();
        String D10 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap1_delay").getValue();
        String D11 = CalculateDataUjiParameter.ahash_pemutus3.get("tahap1_kurva").getValue();
        String D12 = CalculateDataUjiParameter.ahash_pemutus3.get("hasil_fungsi").getValue();
        String D13 = CalculateDataUjiParameter.ahash_pemutus3.get("hasil_ujicb").getValue();
        String D14 = CalculateDataUjiParameter.ahash_pemutus3.get("hasil_relay").getValue();

        String E1 = mArus;
        akhir.setE1(E1);

        double Wk1_GI = 0;
        if (convDouble(E1) < convDouble(A9) || convDouble(A9) <= 0) {
            Wk1_GI = 1500;
        } else if (isEqual(A11, "SI") && convDouble(E1) > convDouble(A9)) {
            double pers1 = KSI * convDouble(A10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk1_GI = pers1 / pers2;
        } else if (isEqual(A11, "VI") && convDouble(E1) > convDouble(A9)) {
            double pers1 = KVI * convDouble(A10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk1_GI = pers1 / pers2;
        } else if (isEqual(A11, "XI") && convDouble(E1) > convDouble(A9)) {
            double pers1 = KXI * convDouble(A10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk1_GI = pers1 / pers2;
        } else if (isEqual(A11, "DEF") && convDouble(E1) > convDouble(A9)) {
            Wk1_GI = convDouble(A10);
        }

        double Wk2_GI = 0;
        if (convDouble(E1) < convDouble(A5) || convDouble(A5) <= 0) {
            Wk2_GI = 1500;
        } else if (isEqual(A7, "SI") && convDouble(E1) > convDouble(A5)) {
            double pers1 = KSI * convDouble(A6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk2_GI = pers1 / pers2;
        } else if (isEqual(A7, "VI") && convDouble(E1) > convDouble(A5)) {
            double pers1 = KVI * convDouble(A6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk2_GI = pers1 / pers2;
        } else if (isEqual(A7, "XI") && convDouble(E1) > convDouble(A5)) {
            double pers1 = KXI * convDouble(A6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(A5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk2_GI = pers1 / pers2;
        } else if (isEqual(A7, "DEF") && convDouble(E1) > convDouble(A5)) {
            Wk2_GI = convDouble(A6);
        }

        double Wk3_GI = 0;
        if (convDouble(E1) < convDouble(A2) || convDouble(A2) <= 0) {
            Wk3_GI = 1500;
        } else {
            Wk3_GI = convDouble(A3);
        }

        double Wk1_pmt1 = 0;
        if (convDouble(E1) < convDouble(B9) || convDouble(B9) <= 0) {
            Wk1_pmt1 = 1500;
        } else if (isEqual(B11, "SI") && convDouble(E1) > convDouble(B9)) {
            double pers1 = KSI * convDouble(B10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk1_pmt1 = pers1 / pers2;
        } else if (isEqual(B11, "VI") && convDouble(E1) > convDouble(B9)) {
            double pers1 = KVI * convDouble(B10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk1_pmt1 = pers1 / pers2;
        } else if (isEqual(B11, "XI") && convDouble(E1) > convDouble(B9)) {
            double pers1 = KXI * convDouble(B10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk1_pmt1 = pers1 / pers2;
        } else if (isEqual(B11, "DEF") && convDouble(E1) > convDouble(B9)) {
            Wk1_pmt1 = convDouble(B10);
        }

        double Wk2_pmt1 = 0;
        if (convDouble(E1) < convDouble(B5) || convDouble(B5) <= 0) {
            Wk2_pmt1 = 1500;
        } else if (isEqual(B7, "SI") && convDouble(E1) > convDouble(B5)) {
            double pers1 = KSI * convDouble(B6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk2_pmt1 = pers1 / pers2;
        } else if (isEqual(B7, "VI") && convDouble(E1) > convDouble(B5)) {
            double pers1 = KVI * convDouble(B6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk2_pmt1 = pers1 / pers2;
        } else if (isEqual(B7, "XI") && convDouble(E1) > convDouble(B5)) {
            double pers1 = KXI * convDouble(B6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(B5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk2_pmt1 = pers1 / pers2;
        } else if (isEqual(B7, "DEF") && convDouble(E1) > convDouble(B5)) {
            Wk2_pmt1 = convDouble(B6);
        }

        double Wk3_pmt1 = 0;
        if (convDouble(E1) < convDouble(B2) || convDouble(B2) <= 0) {
            Wk3_pmt1 = 1500;
        } else {
            Wk3_pmt1 = convDouble(B3);
        }

        double Wk1_pmt2 = 0;
        if (convDouble(E1) < convDouble(C9) || convDouble(C9) <= 0) {
            Wk1_pmt2 = 1500;
        } else if (isEqual(C11, "SI") && convDouble(E1) > convDouble(C9)) {
            double pers1 = KSI * convDouble(C10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk1_pmt2 = pers1 / pers2;
        } else if (isEqual(C11, "VI") && convDouble(E1) > convDouble(C9)) {
            double pers1 = KVI * convDouble(C10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk1_pmt2 = pers1 / pers2;
        } else if (isEqual(C11, "XI") && convDouble(E1) > convDouble(C9)) {
            double pers1 = KXI * convDouble(C10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk1_pmt2 = pers1 / pers2;
        } else if (isEqual(C11, "DEF") && convDouble(E1) > convDouble(C9)) {
            Wk1_pmt2 = convDouble(C10);
        }

        double Wk2_pmt2 = 0;
        if (convDouble(E1) < convDouble(C5) || convDouble(C5) <= 0) {
            Wk2_pmt2 = 1500;
        } else if (isEqual(C7, "SI") && convDouble(E1) > convDouble(C5)) {
            double pers1 = KSI * convDouble(C6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk2_pmt2 = pers1 / pers2;
        } else if (isEqual(C7, "VI") && convDouble(E1) > convDouble(C5)) {
            double pers1 = KVI * convDouble(C6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk2_pmt2 = pers1 / pers2;
        } else if (isEqual(C7, "XI") && convDouble(E1) > convDouble(C5)) {
            double pers1 = KXI * convDouble(C6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(C5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk2_pmt2 = pers1 / pers2;
        } else if (isEqual(C7, "DEF") && convDouble(E1) > convDouble(C5)) {
            Wk2_pmt2 = convDouble(C6);
        }

        double Wk3_pmt2 = 0;
        if (convDouble(E1) < convDouble(C2) || convDouble(C2) <= 0) {
            Wk3_pmt2 = 1500;
        } else {
            Wk3_pmt2 = convDouble(C3);
        }

        double Wk1_pmt3 = 0;
        if (convDouble(E1) < convDouble(D9) || convDouble(D9) <= 0) {
            Wk1_pmt3 = 1500;
        } else if (isEqual(D11, "SI") && convDouble(E1) > convDouble(D9)) {
            double pers1 = KSI * convDouble(D10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D9);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk1_pmt3 = pers1 / pers2;
        } else if (isEqual(D11, "VI") && convDouble(E1) > convDouble(D9)) {
            double pers1 = KVI * convDouble(D10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D9);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk1_pmt3 = pers1 / pers2;
        } else if (isEqual(D11, "XI") && convDouble(E1) > convDouble(D9)) {
            double pers1 = KXI * convDouble(D10);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D9);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk1_pmt3 = pers1 / pers2;
        } else if (isEqual(D11, "DEF") && convDouble(E1) > convDouble(D9)) {
            Wk1_pmt3 = convDouble(D10);
        }

        double Wk2_pmt3 = 0;
        if (convDouble(E1) < convDouble(D5) || convDouble(D5) <= 0) {
            Wk2_pmt3 = 1500;
        } else if (isEqual(D7, "SI") && convDouble(E1) > convDouble(D5)) {
            double pers1 = KSI * convDouble(D6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D5);
            pers2 = (Math.pow(pers2, ASI)) - 1;
            Wk2_pmt3 = pers1 / pers2;
        } else if (isEqual(D7, "VI") && convDouble(E1) > convDouble(D5)) {
            double pers1 = KVI * convDouble(D6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D5);
            pers2 = (Math.pow(pers2, AVI)) - 1;
            Wk2_pmt3 = pers1 / pers2;
        } else if (isEqual(D7, "XI") && convDouble(E1) > convDouble(D5)) {
            double pers1 = KXI * convDouble(D6);
            double pers2 = (convDouble(E1) * 1.01) / convDouble(D5);
            pers2 = (Math.pow(pers2, AXI)) - 1;
            Wk2_pmt3 = pers1 / pers2;
        } else if (isEqual(D7, "DEF") && convDouble(E1) > convDouble(D5)) {
            Wk2_pmt3 = convDouble(D6);
        }

        double Wk3_pmt3 = 0;
        if (convDouble(E1) < convDouble(D2) || convDouble(D2) <= 0) {
            Wk3_pmt3 = 1500;
        } else {
            Wk3_pmt3 = convDouble(D3);
        }

        double Av1_GIc = 0;
        if (Wk3_GI == 1500) {
            Av1_GIc = 0;
        } else {
            Av1_GIc = 1;
        }

        double Av1_GIb = 0;
        if ((Wk2_GI == 1500) || (Av1_GIc == 1)) {
            Av1_GIb = 0;
        } else {
            Av1_GIb = 1;
        }

        double Av1_GIa = 0;
        if ((Wk1_GI == 1500) || (Av1_GIc == 1) || (Av1_GIb == 1)) {
            Av1_GIa = 0;
        } else {
            Av1_GIa = 1;
        }

        double Av1_pmt1c;
        if (Wk3_pmt1 == 1500) {
            Av1_pmt1c = 0;
        } else {
            Av1_pmt1c = 1;
        }

        double Av1_pmt1b;
        if ((Wk2_pmt1 == 1500) || (Av1_pmt1c == 1)) {
            Av1_pmt1b = 0;
        } else {
            Av1_pmt1b = 1;
        }

        double Av1_pmt1a;
        if ((Wk1_pmt1 == 1500) || (Av1_pmt1c == 1) || (Av1_pmt1b == 1)) {
            Av1_pmt1a = 0;
        } else {
            Av1_pmt1a = 1;
        }

        double Av1_pmt2c = 0;
        if ((Wk3_pmt2 == 1500)) {
            Av1_pmt2c = 0;
        } else {
            Av1_pmt2c = 1;
        }

        double Av1_pmt2b;
        if ((Wk2_pmt2 == 1500) || (Av1_pmt2c == 1)) {
            Av1_pmt2b = 0;
        } else {
            Av1_pmt2b = 1;
        }

        double Av1_pmt2a;
        if ((Wk1_pmt2 == 1500) || (Av1_pmt2c == 1) || (Av1_pmt2b == 1)) {
            Av1_pmt2a = 0;
        } else {
            Av1_pmt2a = 1;
        }

        double Av1_pmt3c;
        if ((Wk3_pmt3 == 1500)) {
            Av1_pmt3c = 0;
        } else {
            Av1_pmt3c = 1;
        }

        double Av1_pmt3b;
        if ((Wk2_pmt3 == 1500) || (Av1_pmt3c == 1)) {
            Av1_pmt3b = 0;
        } else {
            Av1_pmt3b = 1;
        }

        double Av1_pmt3a;
        if ((Wk1_pmt3 == 0) || (Av1_pmt3c == 1) || (Av1_pmt3b == 1)) {
            Av1_pmt3a = 0;
        } else {
            Av1_pmt3a = 1;
        }

        double Wpu_GI;
        if ((Av1_GIc == 0) && (Av1_GIb == 0) && (Av1_GIa == 0)) {
            Wpu_GI = 1500;
        } else if ((Av1_GIc == 1)) {
            Wpu_GI = Wk3_GI;
        } else if ((Av1_GIb == 1)) {
            Wpu_GI = Wk2_GI;
        } else if ((Av1_GIa == 1)) {
            Wpu_GI = Wk1_GI;
        } else {
            Wpu_GI = 0;
        }

        double Wtp_GI;
        if ((Wpu_GI == 1500)) {
            Wtp_GI = 1500;
        } else {
            double pers1 = Wpu_GI;
            double pers2 = (CalculateDataUjiParameter.tcb_gi + CalculateDataUjiParameter.trele_gi) / 1000;
            Wtp_GI = pers1 + pers2;
        }

        double Wpu_pmt1 = 0.0;
        if ((Av1_pmt1c == 0) && (Av1_pmt1b == 0) && (Av1_pmt1a == 0)) {
            Wpu_pmt1 = 1500;
        } else if ((Av1_pmt1c == 1)) {
            Wpu_pmt1 = Wk3_pmt1;
        } else if ((Av1_pmt1b == 1)) {
            Wpu_pmt1 = Wk2_pmt1;
        } else if ((Av1_pmt1a == 1)) {
            Wpu_pmt1 = Wk1_pmt1;
        } else {
            Wpu_pmt1 = 0;
        }

        double Wtp_pmt1 = 0.0;
        if ((Wpu_pmt1 == 1500)) {
            Wtp_pmt1 = 1500;
        } else {
            double pers1 = Wpu_pmt1;
            double pers2 = (CalculateDataUjiParameter.tcb_pmt1 + CalculateDataUjiParameter.trele_pmt1) / 1000;
            Wtp_pmt1 = pers1 + pers2;
        }

        double Wpu_pmt2 = 0.0;
        if ((Av1_pmt2c == 0) && (Av1_pmt2b == 0) && (Av1_pmt2a == 0)) {
            Wpu_pmt2 = 1500;
        } else if ((Av1_pmt2c == 1)) {
            Wpu_pmt2 = Wk3_pmt2;
        } else if ((Av1_pmt2b == 1)) {
            Wpu_pmt2 = Wk2_pmt2;
        } else if ((Av1_pmt2a == 1)) {
            Wpu_pmt2 = Wk1_pmt2;
        } else {
            Wpu_pmt2 = 0;
        }

        double Wtp_pmt2 = 0.0;
        if ((Wpu_pmt2 == 1500)) {
            Wtp_pmt2 = 1500;
        } else {
            double pers1 = Wpu_pmt2;
            double pers2 = (CalculateDataUjiParameter.tcb_pmt2 + CalculateDataUjiParameter.trele_pmt2) / 1000;
            Wtp_pmt2 = pers1 + pers2;
        }

        double Wpu_pmt3 = 0.0;
        if ((Av1_pmt3c == 0) && (Av1_pmt3b == 0) && (Av1_pmt3a == 0)) {
            Wpu_pmt3 = 1500;
        } else if ((Av1_pmt3c == 1)) {
            Wpu_pmt3 = Wk3_pmt3;
        } else if ((Av1_pmt3b == 1)) {
            Wpu_pmt3 = Wk2_pmt3;
        } else if ((Av1_pmt3a == 1)) {
            Wpu_pmt3 = Wk1_pmt3;
        } else {
            Wpu_pmt3 = 0;
        }

        double Wtp_pmt3 = 0.0;
        if ((Wpu_pmt3 == 1500)) {
            Wtp_pmt3 = 1500;
        } else {
            double pers1 = Wpu_pmt3;
            double pers2 = (CalculateDataUjiParameter.tcb_pmt3 + CalculateDataUjiParameter.trele_pmt3) / 1000;
            Wtp_pmt3 = pers1 + pers2;
        }

        double Av2_pu_GI = 0.0;
        if ((Wpu_GI == 1500)) {
            Av2_pu_GI = 0;
        } else {
            Av2_pu_GI = 1;
        }

        double Av2_tp_GI = 0.0;
        if ((Wtp_GI == 1500)) {
            Av2_tp_GI = 0;
        } else {
            Av2_tp_GI = 1;
        }

        double Av2_pu_pmt1 = 0.0;
        if ((Wpu_pmt1 == 1500)) {
            Av2_pu_pmt1 = 0;
        } else {
            Av2_pu_pmt1 = 1;
        }

        double Av2_tp_pmt1 = 0.0;
        if ((Wtp_pmt1 == 1500)) {
            Av2_tp_pmt1 = 0;
        } else {
            Av2_tp_pmt1 = 1;
        }

        double Av2_pu_pmt2 = 0.0;
        if ((Wpu_pmt2 == 1500)) {
            Av2_pu_pmt2 = 0;
        } else {
            Av2_pu_pmt2 = 1;
        }

        double Av2_tp_pmt2 = 0.0;
        if ((Wtp_pmt2 == 1500)) {
            Av2_tp_pmt2 = 0;
        } else {
            Av2_tp_pmt2 = 1;
        }

        double Av2_pu_pmt3 = 0.0;
        if ((Wpu_pmt3 == 1500)) {
            Av2_pu_pmt3 = 0;
        } else {
            Av2_pu_pmt3 = 1;
        }

        double Av2_tp_pmt3 = 0.0;
        if ((Wtp_pmt3 == 1500)) {
            Av2_tp_pmt3 = 0;
        } else {
            Av2_tp_pmt3 = 1;
        }

        /*VARIABEL OUTPUT AKHIR*/
        String S1a, S1b, S1c, S2a, S2b, S2c, S3a, S3b, S3c, S4a, S4b, S4c;

        S1a = X;
        akhir.setS1a(S1a.toUpperCase());

        if ((Wpu_pmt1 == 1500) && (Av2_pu_GI == 1)) {
            S1c = "OPEN";
        } else if ((Av2_pu_GI == 1) && (Wpu_GI <= Wpu_pmt1) && (Wpu_GI <= Wpu_pmt2) && (Wpu_GI <= Wpu_pmt3)) {
            S1c = "OPEN";
        } else if ((Av2_tp_GI == 1) && (Wpu_GI <= Wtp_pmt1) && (Wpu_GI <= Wtp_pmt2) && (Wpu_GI <= Wtp_pmt3)) {
            S1c = "OPEN";
        } else {
            S1c = "CLOSE";
        }
        akhir.setS1c(S1c);

        if (isEqual(S1c, "OPEN")) {
            S1b = "KUNING";
        } else {
            S1b = "HITAM";
        }
        akhir.setS1b(S1b);

        S2a = X1;
        akhir.setS2a(S2a);

        if ((Wpu_pmt2 == 1500) && (Av2_pu_pmt1 == 1) && (Wpu_pmt1 <= Wpu_GI)) {
            S2c = "OPEN";
        } else if ((Av2_pu_pmt1 == 1) && (Wpu_pmt1 <= Wpu_GI) && (Wpu_pmt1 <= Wpu_pmt2) && (Wpu_pmt1 <= Wpu_pmt3)) {
            S2c = "OPEN";
        } else if ((Av2_tp_pmt1 == 1) && (Wpu_pmt1 <= Wtp_GI) && (Wpu_pmt1 <= Wtp_pmt2) && (Wpu_pmt1 <= Wtp_pmt3)) {
            S2c = "OPEN";
        } else {
            S2c = "CLOSE";
        }
        akhir.setS2c(S2c);

        if (isEqual(S2c, "OPEN")) {
            S2b = "KUNING";
        } else {
            S2b = "HITAM";
        }
        akhir.setS2b(S2b);

        S3a = X2;
        akhir.setS3a(S3a);

        if ((Wpu_pmt3 == 1500) && (Av2_pu_pmt2 == 1) && (Wpu_pmt2 <= Wpu_pmt1) && (Wpu_pmt2 <= Wpu_GI)) {
            S3c = "OPEN";
        } else if ((Wpu_pmt3 == 1500) && (Av2_tp_pmt2 == 1) && (Wpu_pmt2 <= Wtp_pmt1) && (Wpu_pmt2 <= Wtp_GI)) {
            S3c = "OPEN";
        } else if ((Av2_pu_pmt2 == 1) && (Wpu_pmt2 <= Wpu_GI) && (Wpu_pmt2 <= Wpu_pmt1) && (Wpu_pmt2 <= Wpu_pmt3)) {
            S3c = "OPEN";
        } else if ((Av2_tp_pmt2 == 1) && (Wpu_pmt2 <= Wtp_GI) && (Wpu_pmt2 <= Wtp_pmt1) && (Wpu_pmt2 <= Wtp_pmt3)) {
            S3c = "OPEN";
        } else {
            S3c = "CLOSE";
        }
        akhir.setS3c(S3c);

        if (isEqual(S3c, "OPEN")) {
            S3b = "KUNING";
        } else {
            S3b = "HITAM";
        }
        akhir.setS3b(S3b);

        S4a = X3;
        akhir.setS4a(X3);

        if ((Av2_pu_pmt3 == 1) && (Wpu_pmt3 <= Wpu_GI) && (Wpu_pmt3 <= Wpu_pmt1) && (Wpu_pmt3 <= Wpu_pmt2)) {
            S4c = "OPEN";
        } else if ((Av2_tp_pmt3 == 1) && (Wpu_pmt3 <= Wtp_GI) && (Wpu_pmt3 <= Wtp_pmt1) && (Wpu_pmt3 <= Wtp_pmt2)) {
            S4c = "OPEN";
        } else {
            S4c = "CLOSE";
        }
        akhir.setS4c(S4c);

        if (isEqual(S4c, "OPEN")) {
            S4b = "KUNING";
        } else {
            S4b = "HITAM";
        }
        akhir.setS4b(S4b);

        Double L1a = 0.000, L2a = 0.000, L3a = 0.000, L4a = 0.000,
                L5a = Wpu_pmt3 == 1500 ? L4a : Wpu_pmt3,
                L6a = Wpu_pmt2 == 1500 ? L5a : Wpu_pmt2,
                L7a = Wpu_pmt1 == 1500 ? L6a : Wpu_pmt1,
                L8a = Wpu_GI == 1500 ? L7a : Wpu_GI,
                L9a = Wtp_pmt3 == 1500 ? L8a : Wtp_pmt3,
                L10a = Wtp_pmt2 == 1500 ? L9a : Wtp_pmt2,
                L11a = Wtp_pmt1 == 1500 ? L10a : Wtp_pmt1,
                L12a = Wtp_GI == 1500 ? L11a : Wtp_GI;


        akhir.setL1a(convStringDigit(L1a));
        akhir.setL2a(convStringDigit(L2a));
        akhir.setL3a(convStringDigit(L3a));
        akhir.setL4a(convStringDigit(L4a));
        akhir.setL5a(convStringDigit(L5a));
        akhir.setL6a(convStringDigit(L6a));
        akhir.setL7a(convStringDigit(L7a));
        akhir.setL8a(convStringDigit(L8a));
        akhir.setL9a(convStringDigit(L9a));
        akhir.setL10a(convStringDigit(L10a));
        akhir.setL11a(convStringDigit(L11a));
        akhir.setL12a(convStringDigit(L12a));


        String Np_GI;
        if (!X.equals("")) {
            Np_GI = X;
        } else {
            Np_GI = "Pangkal GI";
        }

        String Np_pmt1;
        if (!X1.equals("")) {
            Np_pmt1 = X1;
        } else {
            Np_pmt1 = "Pemutus 1";
        }

        String Np_pmt2;
        if (!X2.equals("")) {
            Np_pmt2 = X2;
        } else {
            Np_pmt2 = "Pemutus 2";
        }

        String Np_pmt3;
        if (!X3.equals("")) {
            Np_pmt3 = X3;
        } else {
            Np_pmt3 = "Pemutus 3";
        }

        String Ind_GI = "";
        if (Av1_GIa == 1) {
            Ind_GI = "51/51N ";
        } else if (Av1_GIb == 1) {
            Ind_GI = "50/50N";
        } else {
            Ind_GI = "Instant";
        }

        String Ind_pmt1 = "";
        if (Av1_pmt1a == 1) {
            Ind_pmt1 = "51/51N ";
        } else if (Av1_pmt1b == 1) {
            Ind_pmt1 = "50/50N";
        } else {
            Ind_pmt1 = "Instant";
        }

        String Ind_pmt2 = "";
        if (Av1_pmt2a == 1) {
            Ind_pmt2 = "51/51N ";
        } else if (Av1_pmt2b == 1) {
            Ind_pmt2 = "50/50N";
        } else {
            Ind_pmt2 = "Instant";
        }

        String Ind_pmt3 = "";
        if (Av1_pmt3a == 1) {
            Ind_pmt3 = "51/51N ";
        } else if (Av1_pmt3b == 1) {
            Ind_pmt3 = "50/50N";
        } else {
            Ind_pmt3 = "Instant";
        }

        String L1b;
        if ((Av1_pmt3c == 1) || (Av1_pmt3b == 1) || (Av1_pmt3a == 1)) {
            L1b = Np_pmt3 + ",  Gangguan  " + Ind_pmt3 + "   App   " + E1;
        } else {
            L1b = "I-Pro Komunikasi Normal";
        }
        akhir.setL1b(L1b);

        String L2b;
        if ((Av1_pmt2c == 1) || (Av1_pmt2b == 1) || (Av1_pmt2a == 1)) {
            L2b = Np_pmt2 + ",  Gangguan  " + Ind_pmt2 + "   App   " + E1;
        } else {
            L2b = "I-Pro Komunikasi Normal";
        }
        akhir.setL2b(L2b);

        String L3b;
        if ((Av1_pmt1c == 1) || (Av1_pmt1b == 1) || (Av1_pmt1a == 1)) {
            L3b = Np_pmt1 + ",  Gangguan  " + Ind_pmt1 + "   App   " + E1;
        } else {
            L3b = "I-Pro Komunikasi Normal";
        }
        akhir.setL3b(L3b);

        String L4b;
        if ((Av1_GIc == 1) || (Av1_GIb == 1) || (Av1_GIa == 1)) {
            L4b = Np_GI + ",  Gangguan  " + Ind_GI + "   App   " + E1;
        } else {
            L4b = "I-Pro Komunikasi Normal";
        }
        akhir.setL4b(L4b);

        String L5b;
        if (isEqual(S4c, "OPEN")) {
            L5b = Np_pmt3 + ",  Gangguan  " + Ind_pmt3 + "   Pick Up   " + E1;
        } else {
            L5b = "I-Pro Komunikasi Normal";
        }
        akhir.setL5b(L5b);

        String L6b;
        if (isEqual(S3c, "OPEN")) {
            L6b = Np_pmt2 + ",  Gangguan  " + Ind_pmt2 + "   Pick Up   " + E1;
        } else {
            L6b = "I-Pro Komunikasi Normal";
        }
        akhir.setL6b(L6b);

        String L7b;
        if (isEqual(S2c, "OPEN")) {
            L7b = Np_pmt1 + ",  Gangguan  " + Ind_pmt1 + "   Pick Up   " + E1;
        } else {
            L7b = "I-Pro Komunikasi Normal";
        }
        akhir.setL7b(L7b);

        String L8b;
        if (isEqual(S1c, "OPEN")) {
            L8b = Np_GI + ",  Gangguan  " + Ind_GI + "   Pick Up   " + E1;
        } else {
            L8b = "I-Pro Komunikasi Normal";
        }
        akhir.setL8b(L8b);

        String L9b;
        if (isEqual(S4c, "OPEN")) {
            L9b = Np_pmt3 + ",  Gangguan  CB   Open";
        } else {
            L9b = "I-Pro Komunikasi Normal";
        }
        akhir.setL9b(L9b);

        String L10b;
        if (isEqual(S3c, "OPEN")) {
            L10b = Np_pmt2 + ",  Gangguan  CB   Open";
        } else {
            L10b = "I-Pro Komunikasi Normal";
        }
        akhir.setL10b(L10b);

        String L11b;
        if (isEqual(S2c, "OPEN")) {
            L11b = Np_pmt1 + ",  Gangguan  CB   Open";
        } else {
            L11b = "I-Pro Komunikasi Normal";
        }
        akhir.setL11b(L11b);

        String L12b;
        if (isEqual(S1c, "OPEN")) {
            L12b = Np_GI + ",  Gangguan  CB   Open";
        } else {
            L12b = "I-Pro Komunikasi Normal";
        }
        akhir.setL12b(L12b);

        return akhir;
    }

    private String convStringDigit(Double iparam) {
        String astring = "";

        astring = new DecimalFormat("##.###").format(iparam);
        return astring;
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
}
