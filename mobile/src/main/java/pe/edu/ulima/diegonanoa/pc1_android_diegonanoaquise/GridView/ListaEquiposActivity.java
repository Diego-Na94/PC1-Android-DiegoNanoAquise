package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.GridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Adapter.ListaEquiposAdapter;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.R;

public class ListaEquiposActivity extends AppCompatActivity implements ListadoEquiposView{

    ListadoEquiposPresenter mPresenter;
    GridView myGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipos);

        myGrid=(GridView)findViewById(R.id.gridView);

        setPresenter(new ListadoEquiposPresenterRemote(this));

        mPresenter.obtenerEquipos();

    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {this.mPresenter= presenter;}

    @Override
    public void mostrarListadoAlumnos(List<EquipoLista> lista) {
        ListaEquiposAdapter adapter = new ListaEquiposAdapter(this, lista);

        myGrid.setAdapter(adapter);
    }
}
