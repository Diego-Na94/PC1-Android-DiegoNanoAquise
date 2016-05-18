package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Nano A on 16/05/2016.
 */
public class LoginResponse {
    @SerializedName("msg")
    private String msg;

    public LoginResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
