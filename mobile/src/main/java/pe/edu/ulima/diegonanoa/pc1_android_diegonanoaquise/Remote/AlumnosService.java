package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.Alumno;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.LoginRequest;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlumnosService {
    @GET("rest/equipos")
    Call<List<EquipoLista>> obtenerEquiposLista();

    @Headers("Content-Type: application/json")
    @POST("rest/alumnos/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("rest/equipos/{id}")
    Call<EquipoLista> obtenerInformacion(@Path("id") int id);

    @GET("/rest/alumnos?sin_equipo=true")
    Call<List<Alumno>> alumnosSinEquipo();

    @POST("rest/equipos/{id}/{codigo}")
    Call<LoginResponse> agregarEquipo(@Path("id") int id,@Path("codigo") String codigo);

}
