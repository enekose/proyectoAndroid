package com.enekose.seriola_eneko_trabajo_4_android.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.enekose.seriola_eneko_trabajo_4_android.Averia;
import com.enekose.seriola_eneko_trabajo_4_android.R;

import java.util.List;

class MiAdaptadorAverias extends ArrayAdapter<Averia> {
    Context ctx;
    int layoutTemplate;
    List<Averia> averiaList;

    public MiAdaptadorAverias(@NonNull Context context, int resource, @NonNull List<Averia> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.averiaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        Averia elementoActual = averiaList.get(position);
        TextView textViewTitulo = (TextView) v.findViewById(R.id.textViewTitulo);
        TextView textViewModelo = (TextView) v.findViewById(R.id.textViewModeloCoche);
        TextView textViewPresupuesto = (TextView) v.findViewById(R.id.textViewPresupuesto);
        ImageView imageViewFoto = (ImageView) v.findViewById(R.id.imageViewFoto);

        textViewTitulo.setText(elementoActual.getTitulo());
        textViewModelo.setText(elementoActual.getModeloCoche());
        textViewPresupuesto.setText(elementoActual.getNumeroImpuestos() + " presupuestos");

        if(elementoActual.getBitmap() != null) {
            imageViewFoto.setImageBitmap(elementoActual.getBitmap());
        }else if(!elementoActual.getUrlFoto().isEmpty()){
            Glide.with(ctx)
                    .load(elementoActual.getUrlFoto())
                    .into(imageViewFoto);
        }
        return v;
    }
}
