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

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.EquipoLista;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.InformacionEquipos;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Lista.ListaAlumnosSinEquipo;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.R;

/**
 * Created by Diego Nano A on 17/05/2016.
 */
public class ListaEquiposAdapter extends BaseAdapter{

    private List<EquipoLista> mListaEquipos;
    private Context mContext;
    private LayoutInflater mInflater;

    public ListaEquiposAdapter(Context context, List<EquipoLista> listaEquipos) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mListaEquipos = listaEquipos;

    }

    @Override
    public int getCount() {
        return mListaEquipos.size();
    }

    @Override
    public Object getItem(int i) {
        return mListaEquipos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mListaEquipos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){
            view = mInflater.inflate(R.layout.item_listado_equipo, null);
            viewHolder = new ViewHolder();
            viewHolder.futbolTeamIcon =(ImageView) view.findViewById(R.id.futbolTeamIcon);
            viewHolder.tviAgregar = (ImageView) view.findViewById(R.id.tviAgregar);
            viewHolder.tviEquipo = (ImageView) view.findViewById(R.id.tviEquipo);
            viewHolder.tviNombre_Equipo = (TextView) view.findViewById(R.id.tviNombre_Equipo);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final EquipoLista equipo = mListaEquipos.get(i);

        viewHolder.tviNombre_Equipo.setText(equipo.getNombreEquipos());
        Log.i("ULimers", equipo.getUrlFoto());
        Picasso.with(mContext).load(equipo.getUrlFoto()).into(viewHolder.futbolTeamIcon);

        viewHolder.futbolTeamIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, InformacionEquipos.class);
                intent.putExtra("id",equipo.getId());
                intent.putExtra("nombre",equipo.getNombreEquipos());
                intent.putExtra("ganadas",equipo.getPartGa());
                intent.putExtra("perdidas",equipo.getPartPer());
                intent.putExtra("urlFoto",equipo.getUrlFoto());
                mContext.startActivity(intent);

            }
        });

        viewHolder.tviAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ListaAlumnosSinEquipo.class);
                intent.putExtra("idEquipoAgregar",equipo.getId());
                mContext.startActivity(intent);

            }
        });

        return view;
    }

    class ViewHolder{
        ImageView futbolTeamIcon;
        ImageView tviAgregar;
        ImageView tviEquipo;
        TextView tviNombre_Equipo;
    }
}
