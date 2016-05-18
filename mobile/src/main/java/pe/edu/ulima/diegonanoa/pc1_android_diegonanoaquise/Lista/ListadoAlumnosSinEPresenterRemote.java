package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Lista;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.Alumno;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Nano A on 18/05/2016.
 */
public class ListadoAlumnosSinEPresenterRemote implements ListadoAlumnosSinEPresenter{

    ListadoAlumnosSinEView mView;

    public ListadoAlumnosSinEPresenterRemote(ListadoAlumnosSinEView view){
        mView = view;
    }


    @Override
    public void obtenerAlumnos() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);

        service.alumnosSinEquipo().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                //Codigo luego de la llamada de servicio (exitosa)

                Log.d("myTag:","-----------------E.1 response raw:"+response.raw());
                Log.d("myTag:","-----------------E.2 response body:"+response.body().toString());
                List<Alumno> alumnos = response.body();
                mView.mostrarListadoAlumnos(alumnos);
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                //Codigo luego de un error en la llamada
            }
        });




    }
}
