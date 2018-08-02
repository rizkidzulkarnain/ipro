package id.co.pln.ipro.clsumum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.co.pln.ipro.model.UjiOutputClass;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormHeader;

public class CreateFormOutputUji {

    List<BaseFormElement> mListItemUjiOutput;

    public List<BaseFormElement> getmListItemUjiOutput() {
        return mListItemUjiOutput;
    }

    public void formDetail() {
        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Output Setting Pangkal (GI)");
        FormElementTextEmail el1_tahap1 = FormElementTextEmail.createInstance().setTitle("Tahap 1");
        FormElementTextEmail el2_tahap2 = FormElementTextEmail.createInstance().setTitle("Tahap 2");
        FormElementTextEmail el3_tahap3 = FormElementTextEmail.createInstance().setTitle("Tahap 3");
        FormElementTextEmail el4_rekom = FormElementTextEmail.createInstance().setTitle("Rekomendasi");
        FormElementTextEmail el5_ket = FormElementTextEmail.createInstance().setTitle("Keterangan");

        /*kedua*/
        FormHeader el6_header = FormHeader.createInstance("Output Setting Pemutus 1");
        FormElementTextEmail el7_tahap1 = FormElementTextEmail.createInstance().setTitle("Tahap 1");
        FormElementTextEmail el8_tahap2 = FormElementTextEmail.createInstance().setTitle("Tahap 2");
        FormElementTextEmail el9_tahap3 = FormElementTextEmail.createInstance().setTitle("Tahap 3");
        FormElementTextEmail el10_rekom = FormElementTextEmail.createInstance().setTitle("Rekomendasi");
        FormElementTextEmail el11_ket = FormElementTextEmail.createInstance().setTitle("Keterangan");

        /*ketiga*/
        FormHeader el12_header = FormHeader.createInstance("Output Setting Pemutus 2");
        FormElementTextEmail el13_tahap1 = FormElementTextEmail.createInstance().setTitle("Tahap 1");
        FormElementTextEmail el14_tahap2 = FormElementTextEmail.createInstance().setTitle("Tahap 2");
        FormElementTextEmail el15_tahap3 = FormElementTextEmail.createInstance().setTitle("Tahap 3");
        FormElementTextEmail el16_rekom = FormElementTextEmail.createInstance().setTitle("Rekomendasi");
        FormElementTextEmail el17_ket = FormElementTextEmail.createInstance().setTitle("Keterangan");

        /*keempat*/
        FormHeader el18_header = FormHeader.createInstance("Output Setting Pemutus 3");
        FormElementTextEmail el19_tahap1 = FormElementTextEmail.createInstance().setTitle("Tahap 1");
        FormElementTextEmail el20_tahap2 = FormElementTextEmail.createInstance().setTitle("Tahap 2");
        FormElementTextEmail el21_tahap3 = FormElementTextEmail.createInstance().setTitle("Tahap 3");
        FormElementTextEmail el22_rekom = FormElementTextEmail.createInstance().setTitle("Rekomendasi");
        FormElementTextEmail el23_ket = FormElementTextEmail.createInstance().setTitle("Keterangan");

        mListItemUjiOutput = new ArrayList<BaseFormElement>();
        mListItemUjiOutput.addAll(Arrays.asList(
                el0_header, el1_tahap1, el2_tahap2, el3_tahap3, el4_rekom, el5_ket,
                el6_header, el7_tahap1, el8_tahap2, el9_tahap3, el10_rekom,
                el11_ket, el12_header, el13_tahap1, el14_tahap2, el15_tahap3,
                el16_rekom, el17_ket, el18_header, el19_tahap1, el20_tahap2,
                el21_tahap3, el22_rekom, el23_ket
        ));
    }
}
