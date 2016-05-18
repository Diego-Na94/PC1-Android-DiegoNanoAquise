package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.Alumno;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.LoginResponse;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.GridView.ListaEquiposActivity;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Lista.ListaAlumnosSinEquipo;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.R;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Nano A on 18/05/2016.
 */
public class ListadoAlumnosSinEAdapter extends BaseAdapter{

    private List<Alumno> mAlumnos;
    private Context mContext;
    private LayoutInflater mInflater;
    private int midEquipo;

    public ListadoAlumnosSinEAdapter(Context context, List<Alumno> alumnos) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mAlumnos = alumnos;
    }

    public void setMidEquipo(int midEquipo) {
        this.midEquipo = midEquipo;
    }

    @Override
    public int getCount() {
        return mAlumnos.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlumnos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mAlumnos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null){

            view = mInflater.inflate(R.layout.item_alumno_sin_e, null);
            viewHolder = new ViewHolder();
            viewHolder.fut_icon = (ImageView) view.findViewById(R.id.fut_icon);

            viewHolder.nombre = (TextView) view.findViewById(R.id.nombre);
            viewHolder.codigo = (TextView) view.findViewById(R.id.codigo);
            viewHolder.agregar = (ImageView) view.findViewById(R.id.tviAgregar2);


            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final Alumno alumno = mAlumnos.get(i);

        viewHolder.nombre.setText(alumno.getNombre());
        viewHolder.codigo.setText(alumno.getCodigo());

        viewHolder.agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                AlumnosService service = retrofit.create(AlumnosService.class);

                service.agregarEquipo(midEquipo,alumno.getCodigo()).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        Log.d("myTag","----------agregar1----------"+response.body().toString());
                        LoginResponse loginMsg = response.body();
                        Log.d("myTag","----------agregar2----------"+loginMsg.getMsg());
                        if(loginMsg.getMsg().equals("OK")){
                            Intent intent = new Intent(mContext, ListaEquiposActivity.class);
                            Toast.makeText(
                                    mContext,
                                    "Se agrego alumno: " + alumno.getCodigo()+", al equipo: " + midEquipo,
                                    Toast.LENGTH_SHORT
                            ).show();

                            mContext.startActivity(intent);
                        } else {
                            Toast.makeText(
                                    mContext,
                                    "Operación agregar alumno incorrecto",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

            }
        });

        return view;
    }

    class ViewHolder{
        ImageView fut_icon;
        TextView nombre;
        TextView codigo;
        ImageView agregar;
    }


}
