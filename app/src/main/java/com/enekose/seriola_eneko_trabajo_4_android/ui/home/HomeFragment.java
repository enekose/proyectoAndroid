package com.enekose.seriola_eneko_trabajo_4_android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.enekose.seriola_eneko_trabajo_4_android.Averia;
import com.enekose.seriola_eneko_trabajo_4_android.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ListView lista;
    private List<Averia> averiaList;

    public HomeFragment() {
        // Vacio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averias, container,
                false);
        lista = (ListView) view.findViewById(R.id.listViewAverias);

        averiaList = new ArrayList<>();
        averiaList.add(new Averia("Espejo roto", "Audi - A4", "https://previews.123rf.com/images/martincp/martincp1505/martincp150500365/40521209-siete-a%C3%B1os-de-mala-suerte-coche-roto-ala-espejo.jpg", 2));
        averiaList.add(new Averia("Paragolpes delantero", "Citroen - C4", "https://img.milanuncios.com/fg/2816/07/281607271_1.jpg?VersionId=A47prdN7u1YtjPcoAzAXVhZTcKZdfTXr", 0));
        averiaList.add(new Averia("Alerón M3", "BMW - M3", "", 3));
        averiaList.add(new Averia("Junta de la trocola", "Fiat - Multipla", "", 1));

        MiAdaptadorAverias adaptadorAverias = new MiAdaptadorAverias(this.getContext(), R.layout.averia_item, averiaList);
        lista.setAdapter(adaptadorAverias);

        return view;
    }
}
