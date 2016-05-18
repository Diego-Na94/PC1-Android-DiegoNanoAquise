package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Adapter.ListadoAlumnosSinEAdapter;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.Alumno;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.R;

public class ListaAlumnosSinEquipo extends AppCompatActivity implements ListadoAlumnosSinEView{

    ListadoAlumnosSinEPresenter mPresenter;
    ListView lviAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_alumnos_sin_equipo);
        setTitle("Lista de Equipos");
        lviAlumnos = (ListView) findViewById(R.id.lviAlumnos);

        setPresenter(new ListadoAlumnosSinEPresenterRemote(this));

        mPresenter.obtenerAlumnos();

    }

    @Override
    public void setPresenter(ListadoAlumnosSinEPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarListadoAlumnos(List<Alumno> alumnos) {

        ListadoAlumnosSinEAdapter adapter = new ListadoAlumnosSinEAdapter(this, alumnos);
        adapter.setMidEquipo(getIntent().getExtras().getInt("idEquipoAgregar"));
        lviAlumnos.setAdapter(adapter);
    }
}
