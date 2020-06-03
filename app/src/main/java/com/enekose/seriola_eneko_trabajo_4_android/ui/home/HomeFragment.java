package com.enekose.seriola_eneko_trabajo_4_android.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.enekose.seriola_eneko_trabajo_4_android.Averia;
import com.enekose.seriola_eneko_trabajo_4_android.ManagementAveria;
import com.enekose.seriola_eneko_trabajo_4_android.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView lista;
    private List<Averia> averiaList;
    private MiAdaptadorAverias adaptadorAverias;

    public HomeFragment() {
        // Vacio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averias, container,
                false);
        lista = (ListView) view.findViewById(R.id.listViewAverias);

        //averiaList = new ArrayList<>();
        //averiaList.add(new Averia("Espejo roto", "Audi - A4", "https://previews.123rf.com/images/martincp/martincp1505/martincp150500365/40521209-siete-a%C3%B1os-de-mala-suerte-coche-roto-ala-espejo.jpg", 2));
        //averiaList.add(new Averia("Paragolpes delantero", "Citroen - C4", "https://img.milanuncios.com/fg/2816/07/281607271_1.jpg?VersionId=A47prdN7u1YtjPcoAzAXVhZTcKZdfTXr", 0));
        //averiaList.add(new Averia("Alerón M3", "BMW - M3", "", 3));
        //averiaList.add(new Averia("Junta de la trocola", "Fiat - Multipla", "", 1));

        ManagementAveria.addAveria(new Averia("Espejo roto", "Audi - A4", "https://previews.123rf.com/images/martincp/martincp1505/martincp150500365/40521209-siete-a%C3%B1os-de-mala-suerte-coche-roto-ala-espejo.jpg", 2));
        ManagementAveria.addAveria(new Averia("Paragolpes delantero", "Citroen - C4", "https://img.milanuncios.com/fg/2816/07/281607271_1.jpg?VersionId=A47prdN7u1YtjPcoAzAXVhZTcKZdfTXr", 0));
        ManagementAveria.addAveria(new Averia("Alerón M3", "BMW - M3", "", 3));
        ManagementAveria.addAveria((new Averia("Junta de la trocola", "Fiat - Multipla", "", 1)));

        adaptadorAverias = new MiAdaptadorAverias(this.getContext(), R.layout.averia_item, ManagementAveria.getListAverias());
        lista.setAdapter(adaptadorAverias);
        lista.setOnItemClickListener(this);
        return view;
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Averia averia = ManagementAveria.getAveriaPos(position);
        averia.setUrlFoto("https://periodismodelmotor.com/wp-content/uploads/2020/01/Subasta-BMW-M3-E46-2002.jpg");

        adaptadorAverias.notifyDataSetChanged();

    }
}
