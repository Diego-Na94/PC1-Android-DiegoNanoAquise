package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Nano A on 15/05/2016.
 */
public class LoginRequest {

    private String usuario;
    private String password;

    public LoginRequest(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
