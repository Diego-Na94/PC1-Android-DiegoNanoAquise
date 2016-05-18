package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans;

/**
 * Created by Diego Nano A on 18/05/2016.
 */
public class Alumno {

    String codigo,equipo;
    int id;
    String nombre;

    public Alumno(String codigo, String equipo, int id, String nombre) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.id = id;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
