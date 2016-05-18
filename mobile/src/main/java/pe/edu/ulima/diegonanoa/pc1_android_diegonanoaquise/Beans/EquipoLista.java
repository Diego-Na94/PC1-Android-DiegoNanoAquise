package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Nano A on 17/05/2016.
 */
public class EquipoLista {
    @SerializedName("id") @Expose private int id;
    @SerializedName("nombre") @Expose private String nombreEquipos;
    @SerializedName("partidosGanados") @Expose private int partGa;
    @SerializedName("partidosPerdidos") @Expose private int partPer;
    @SerializedName("urlFoto") @Expose private String urlFoto;

    public EquipoLista(){}

    public EquipoLista(int id, String nombreEquipos, int partGa, int partPer, String urlFoto) {
        this.id = id;
        this.nombreEquipos = nombreEquipos;
        this.partGa = partGa;
        this.partPer = partPer;
        this.urlFoto = urlFoto;
    }

    public int getId() {
        return id;
    }

    public String getNombreEquipos() {
        return nombreEquipos;
    }

    public int getPartGa() {
        return partGa;
    }

    public int getPartPer() {
        return partPer;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreEquipos(String nombreEquipos) {
        this.nombreEquipos = nombreEquipos;
    }

    public void setPartGa(int partGa) {
        this.partGa = partGa;
    }

    public void setPartPer(int partPer) {
        this.partPer = partPer;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
