package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Lista;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.Alumno;

/**
 * Created by Diego Nano A on 18/05/2016.
 */
public interface ListadoAlumnosSinEView {
    public void setPresenter(ListadoAlumnosSinEPresenter presenter);
    public void mostrarListadoAlumnos(List<Alumno> alumnos);
}
