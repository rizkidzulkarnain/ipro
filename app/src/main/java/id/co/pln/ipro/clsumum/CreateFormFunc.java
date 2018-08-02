package id.co.pln.ipro.clsumum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormHeader;

public class CreateFormFunc {

    List<BaseFormElement> mListItem1;
    List<BaseFormElement> mListItem2;
    List<BaseFormElement> mListItemPemutus1, mListItemPemutus2, mListItemPemutus3;

    public List<BaseFormElement> getmListItem1() {
        return mListItem1;
    }

    public List<BaseFormElement> getmListItem2() {
        return mListItem2;
    }

    public List<BaseFormElement> getmListItemPemutus1() {
        return mListItemPemutus1;
    }

    public List<BaseFormElement> getmListItemPemutus2() {
        return mListItemPemutus2;
    }

    public List<BaseFormElement> getmListItemPemutus3() {
        return mListItemPemutus3;
    }

    public void formHeader() {
        FormHeader el0_header = FormHeader.createInstance("Header");
        FormElementTextEmail el1_penyulang = FormElementTextEmail
                .createInstance()
                .setTitle("Penyulang")
                .setHint("Enter Penyulang");

        List<String> reles = new ArrayList<>();
        reles.add("GFR");
        reles.add("OCR");
        FormElementPickerSingle el2_rele = FormElementPickerSingle
                .createInstance()
                .setTitle("Rele")
                .setOptions(reles)
                .setPickerTitle("Pilih Rele Item");

        mListItem1 = new ArrayList<>();
        mListItem1.add(el0_header);
        mListItem1.add(el1_penyulang);
        mListItem1.add(el2_rele);
    }

    public void formDetail() {
        /*General*/
        List<String> functions = new ArrayList<>();
        functions.addAll(Arrays.asList("ON","OFF"));
        List<String> curves = new ArrayList<>();
        curves.addAll(Arrays.asList("SI","VI","XI","Def"));
        List<String> func_results = new ArrayList<>();
        func_results.addAll(Arrays.asList("ON","Default"));

        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Tahap 3 (GFR/OCR) Definit");
        FormElementPickerSingle el1_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el2_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el3_delay = FormElementTextEmail.createInstance().setTitle("Delay").setHint("Enter delay (Second)");

        /*kedua*/
        FormHeader el4_header = FormHeader.createInstance("Tahap 2 (GFR/OCR)");
        FormElementPickerSingle el5_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el6_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el7_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el8_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*ketiga*/
        FormHeader el9_header = FormHeader.createInstance("Tahap 1 (GFR/OCR)");
        FormElementPickerSingle el10_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el11_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el12_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el13_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*keempat*/
        FormHeader el14_header = FormHeader.createInstance("Waktu Hasil Pengujian");
        FormElementPickerSingle el15_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(func_results).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el16_ujicb = FormElementTextEmail.createInstance().setTitle("Uji CB").setHint("Enter Uji CB (Ampere)");
        FormElementTextEmail el17_ujirelay = FormElementTextEmail.createInstance().setTitle("Uji Relay").setHint("Enter Uji Relay (Second)");

        mListItem2 = new ArrayList<BaseFormElement>();
        mListItem2.addAll(Arrays.asList(
                el0_header, el1_fungsi, el2_iset, el3_delay, el4_header, el5_fungsi, el6_iset, el7_delay, el8_kurva,
                el9_header, el10_fungsi, el11_iset, el12_delay, el13_kurva, el14_header, el15_fungsi, el16_ujicb, el17_ujirelay
        ));
    }

    public void formDetailPemutus1() {
        /*General*/
        List<String> functions = new ArrayList<>();
        functions.addAll(Arrays.asList("ON","OFF"));
        List<String> curves = new ArrayList<>();
        curves.addAll(Arrays.asList("SI","VI","XI","Def"));
        List<String> func_results = new ArrayList<>();
        func_results.addAll(Arrays.asList("ON","Default"));

        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Tahap 3 (GFR/OCR) Definit");
        FormElementPickerSingle el1_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el2_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el3_delay = FormElementTextEmail.createInstance().setTitle("Delay").setHint("Enter delay (Second)");

        /*kedua*/
        FormHeader el4_header = FormHeader.createInstance("Tahap 2 (GFR/OCR)");
        FormElementPickerSingle el5_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el6_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el7_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el8_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*ketiga*/
        FormHeader el9_header = FormHeader.createInstance("Tahap 1 (GFR/OCR)");
        FormElementPickerSingle el10_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el11_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el12_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el13_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*keempat*/
        FormHeader el14_header = FormHeader.createInstance("Waktu Hasil Pengujian");
        FormElementPickerSingle el15_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(func_results).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el16_ujicb = FormElementTextEmail.createInstance().setTitle("Uji CB").setHint("Enter Uji CB (Ampere)");
        FormElementTextEmail el17_ujirelay = FormElementTextEmail.createInstance().setTitle("Uji Relay").setHint("Enter Uji Relay (Second)");

        mListItemPemutus1 = new ArrayList<BaseFormElement>();
        mListItemPemutus1.addAll(Arrays.asList(
                el0_header, el1_fungsi, el2_iset, el3_delay, el4_header, el5_fungsi, el6_iset, el7_delay, el8_kurva,
                el9_header, el10_fungsi, el11_iset, el12_delay, el13_kurva, el14_header, el15_fungsi, el16_ujicb, el17_ujirelay
        ));
    }

    public void formDetailPemutus2() {
        /*General*/
        List<String> functions = new ArrayList<>();
        functions.addAll(Arrays.asList("ON","OFF"));
        List<String> curves = new ArrayList<>();
        curves.addAll(Arrays.asList("SI","VI","XI","Def"));
        List<String> func_results = new ArrayList<>();
        func_results.addAll(Arrays.asList("ON","Default"));

        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Tahap 3 (GFR/OCR) Definit");
        FormElementPickerSingle el1_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el2_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el3_delay = FormElementTextEmail.createInstance().setTitle("Delay").setHint("Enter delay (Second)");

        /*kedua*/
        FormHeader el4_header = FormHeader.createInstance("Tahap 2 (GFR/OCR)");
        FormElementPickerSingle el5_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el6_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el7_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el8_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*ketiga*/
        FormHeader el9_header = FormHeader.createInstance("Tahap 1 (GFR/OCR)");
        FormElementPickerSingle el10_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el11_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el12_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el13_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*keempat*/
        FormHeader el14_header = FormHeader.createInstance("Waktu Hasil Pengujian");
        FormElementPickerSingle el15_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(func_results).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el16_ujicb = FormElementTextEmail.createInstance().setTitle("Uji CB").setHint("Enter Uji CB (Ampere)");
        FormElementTextEmail el17_ujirelay = FormElementTextEmail.createInstance().setTitle("Uji Relay").setHint("Enter Uji Relay (Second)");

        mListItemPemutus2 = new ArrayList<BaseFormElement>();
        mListItemPemutus2.addAll(Arrays.asList(
                el0_header, el1_fungsi, el2_iset, el3_delay, el4_header, el5_fungsi, el6_iset, el7_delay, el8_kurva,
                el9_header, el10_fungsi, el11_iset, el12_delay, el13_kurva, el14_header, el15_fungsi, el16_ujicb, el17_ujirelay
        ));
    }

    public void formDetailPemutus3() {
        /*General*/
        List<String> functions = new ArrayList<>();
        functions.addAll(Arrays.asList("ON","OFF"));
        List<String> curves = new ArrayList<>();
        curves.addAll(Arrays.asList("SI","VI","XI","Def"));
        List<String> func_results = new ArrayList<>();
        func_results.addAll(Arrays.asList("ON","Default"));

        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Tahap 3 (GFR/OCR) Definit");
        FormElementPickerSingle el1_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el2_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el3_delay = FormElementTextEmail.createInstance().setTitle("Delay").setHint("Enter delay (Second)");

        /*kedua*/
        FormHeader el4_header = FormHeader.createInstance("Tahap 2 (GFR/OCR)");
        FormElementPickerSingle el5_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el6_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el7_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el8_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*ketiga*/
        FormHeader el9_header = FormHeader.createInstance("Tahap 1 (GFR/OCR)");
        FormElementPickerSingle el10_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(functions).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el11_iset = FormElementTextEmail.createInstance().setTitle("I-set").setHint("Enter I-set (Ampere)");
        FormElementTextEmail el12_delay = FormElementTextEmail.createInstance().setTitle("Tms/Delay").setHint("Enter delay (Second)");
        FormElementPickerSingle el13_kurva = FormElementPickerSingle.createInstance().setTitle("Skala Kurva").setOptions(curves).setPickerTitle("Pilih Skala Kurva item");

        /*keempat*/
        FormHeader el14_header = FormHeader.createInstance("Waktu Hasil Pengujian");
        FormElementPickerSingle el15_fungsi = FormElementPickerSingle.createInstance().setTitle("Fungsi").setOptions(func_results).setPickerTitle("Pilih Fungsi Item");
        FormElementTextEmail el16_ujicb = FormElementTextEmail.createInstance().setTitle("Uji CB").setHint("Enter Uji CB (Ampere)");
        FormElementTextEmail el17_ujirelay = FormElementTextEmail.createInstance().setTitle("Uji Relay").setHint("Enter Uji Relay (Second)");

        mListItemPemutus3 = new ArrayList<BaseFormElement>();
        mListItemPemutus3.addAll(Arrays.asList(
                el0_header, el1_fungsi, el2_iset, el3_delay, el4_header, el5_fungsi, el6_iset, el7_delay, el8_kurva,
                el9_header, el10_fungsi, el11_iset, el12_delay, el13_kurva, el14_header, el15_fungsi, el16_ujicb, el17_ujirelay
        ));
    }

}
