package id.co.pln.ipro.clsumum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormHeader;

public class CreateFormSimulasi {

    List<BaseFormElement> mListItemHeader, mListItemDetail;
    public List<BaseFormElement> getmListItemHeader() {
        return mListItemHeader;
    }

    public List<BaseFormElement> getmListItemDetail() {
        return mListItemDetail;
    }

    public void formHeader() {
        FormHeader el0_header = FormHeader.createInstance("Input Arus Gangguan");
        FormElementTextEmail el1_penyulang = FormElementTextEmail
                .createInstance()
                .setTitle("Arus Gangguan")
                .setHint("Enter Arus Gangguan");

        mListItemHeader = new ArrayList<>();
        mListItemHeader.add(el0_header);
        mListItemHeader.add(el1_penyulang);
    }

    public void formDetail() {
        /*pertama*/
        FormHeader el0_header = FormHeader.createInstance("Waktu Dan Aktivitas");

        FormElementTextEmail el1_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el2_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el3_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el4_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el5_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el6_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el7_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el8_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el9_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el10_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el11_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        FormElementTextEmail el12_waktu = FormElementTextEmail.createInstance().setTitle("Waktu").setHint("Aktivitas");
        mListItemDetail = new ArrayList<BaseFormElement>();
        mListItemDetail.addAll(Arrays.asList(
                el0_header, el1_waktu, el2_waktu, el3_waktu, el4_waktu,el5_waktu,el6_waktu, el7_waktu, el8_waktu, el9_waktu,
                el10_waktu, el11_waktu, el12_waktu
        ));
    }
}
