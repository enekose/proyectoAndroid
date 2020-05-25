package com.enekose.seriola_eneko_trabajo_4_android.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.enekose.seriola_eneko_trabajo_4_android.R;
import com.enekose.seriola_eneko_trabajo_4_android.activities.MapsActivity;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView lista;
    private List<String> talleresList;
    public SlideshowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_talleres, container,
                false);
        lista = (ListView) view.findViewById(R.id.listViewTalleres);
        talleresList = new ArrayList<>();
        talleresList.add("Taller Juan e Hijos");
        talleresList.add("Chapa y Pintura González");
        talleresList.add("Norauto");
        talleresList.add("Midas");
        //...
        ArrayAdapter<String> adaptadorTalleres = new
                ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1,
                talleresList);
        lista.setAdapter(adaptadorTalleres);
        // Evento click sobre cada elemento de la lista
        lista.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), MapsActivity.class);
        i.putExtra("pos", position);
        startActivity(i);
    }

}
