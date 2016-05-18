package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InformacionEquipos extends AppCompatActivity {

    TextView etNombreEquipo, etGanadas, etPerdidas;
    ImageView etFoto;
    Context context;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_equipos);

        etNombreEquipo=(TextView)findViewById(R.id.etNombre_Equipo);
        etGanadas=(TextView)findViewById(R.id.etGanadas);
        etPerdidas=(TextView)findViewById(R.id.etPerdidas);
        etFoto=(ImageView)findViewById(R.id.Foto_Equipo);

        id = getIntent().getExtras().getInt("id");

        obtenerInfo();
    }

    public void obtenerInfo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        service.obtenerInformacion(id).enqueue(new Callback<EquipoLista>() {
            @Override
            public void onResponse(Call<EquipoLista> call, Response<EquipoLista> response) {
                Log.d("myTag:","-----------------3.1 response body:"+response.body().toString());

                EquipoLista equipo = response.body();
                Log.d("myTag:","-----------------3.2 equipo:"+equipo.getNombreEquipos());
                etNombreEquipo.setText(equipo.getNombreEquipos());
                etGanadas.setText("Partidas Ganadas: "+equipo.getPartGa());
                etPerdidas.setText("Partidas Perdidas: "+equipo.getPartPer());

                Log.i("ULimers", equipo.getUrlFoto());

                Picasso.with(context).load(equipo.getUrlFoto()).into(etFoto);
                //Picasso.with(mContext).load(alumno.getUrlFoto()).into(viewHolder.iviAlumnoFoto);
            }

            @Override
            public void onFailure(Call<EquipoLista> call, Throwable t) {

            }
        });
    }




}
