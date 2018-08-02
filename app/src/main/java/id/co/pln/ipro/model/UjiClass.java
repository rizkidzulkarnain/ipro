package id.co.pln.ipro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UjiClass {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data_gi")
    @Expose
    private DataUjiClass data_gi;
    @SerializedName("data_pemutus1")
    @Expose
    private DataUjiClass data_pemutus1;
    @SerializedName("data_pemutus2")
    @Expose
    private DataUjiClass data_pemutus2;
    @SerializedName("data_pemutus3")
    @Expose
    private DataUjiClass data_pemutus3;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DataUjiClass getData_gi() {
        return data_gi;
    }

    public void setData_gi(DataUjiClass data_gi) {
        this.data_gi = data_gi;
    }

    public DataUjiClass getData_pemutus1() {
        return data_pemutus1;
    }

    public void setData_pemutus1(DataUjiClass data_pemutus1) {
        this.data_pemutus1 = data_pemutus1;
    }

    public DataUjiClass getData_pemutus2() {
        return data_pemutus2;
    }

    public void setData_pemutus2(DataUjiClass data_pemutus2) {
        this.data_pemutus2 = data_pemutus2;
    }

    public DataUjiClass getData_pemutus3() {
        return data_pemutus3;
    }

    public void setData_pemutus3(DataUjiClass data_pemutus3) {
        this.data_pemutus3 = data_pemutus3;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
