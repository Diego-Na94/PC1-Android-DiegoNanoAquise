package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.GridView;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;

/**
 * Created by Diego Nano A on 17/05/2016.
 */
public interface ListadoEquiposView {
    public void setPresenter(ListadoEquiposPresenter presenter);
    public void mostrarListadoAlumnos(List<EquipoLista> alumnos);
}
