package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.GridView;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Nano A on 17/05/2016.
 */
public class ListadoEquiposPresenterRemote implements ListadoEquiposPresenter {

    ListadoEquiposView mView;

    public ListadoEquiposPresenterRemote(ListadoEquiposView view){

        mView = view;
    }

    @Override
    public void obtenerEquipos() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);

        service.obtenerEquiposLista().enqueue(new Callback<List<EquipoLista>>() {
            @Override
            public void onResponse(Call<List<EquipoLista>> call, Response<List<EquipoLista>> response) {
                Log.d("myTag:","-----------------2.1 response raw:"+response.raw());
                Log.d("myTag:","-----------------2.2 response body:"+response.body().toString());

                List<EquipoLista> lista = response.body();
                Log.d("myTag:","-----------------2.3 Lista:1 "+lista.get(1).getNombreEquipos());
                Log.d("myTag:","-----------------2.4 Lista:URL "+lista.get(1).getUrlFoto());
                mView.mostrarListadoAlumnos(lista);
            }

            @Override
            public void onFailure(Call<List<EquipoLista>> call, Throwable t) {

            }
        } );
    }
}
