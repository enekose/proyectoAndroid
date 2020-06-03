package com.enekose.seriola_eneko_trabajo_4_android.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.provider.MediaStore;
import android.widget.Toast;
import java.io.File;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import android.os.Environment.*;

import com.enekose.seriola_eneko_trabajo_4_android.Averia;
import com.enekose.seriola_eneko_trabajo_4_android.ManagementAveria;
import com.enekose.seriola_eneko_trabajo_4_android.R;
import com.enekose.seriola_eneko_trabajo_4_android.activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView lista;
    private List<Averia> averiaList;
    private MiAdaptadorAverias adaptadorAverias;
    private String pathToFile;
    private Averia averiaSelect;

    public HomeFragment() {
        // Vacio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averias, container,
                false);
        lista = (ListView) view.findViewById(R.id.listViewAverias);

        ManagementAveria.addAveria(new Averia("Espejo roto", "Audi - A4", "https://previews.123rf.com/images/martincp/martincp1505/martincp150500365/40521209-siete-a%C3%B1os-de-mala-suerte-coche-roto-ala-espejo.jpg", 2));
        ManagementAveria.addAveria(new Averia("Paragolpes delantero", "Citroen - C4", "https://img.milanuncios.com/fg/2816/07/281607271_1.jpg?VersionId=A47prdN7u1YtjPcoAzAXVhZTcKZdfTXr", 0));
        ManagementAveria.addAveria(new Averia("Alerón M3", "BMW - M3", "", 3));
        ManagementAveria.addAveria((new Averia("Junta de la trocola", "Fiat - Multipla", "", 1)));

        adaptadorAverias = new MiAdaptadorAverias(this.getContext(), R.layout.averia_item, ManagementAveria.getListAverias());
        lista.setAdapter(adaptadorAverias);
        lista.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            averiaSelect.setBitmap(bitmap);
            adaptadorAverias.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        averiaSelect = ManagementAveria.getAveriaPos(position);

        startActivityForResult(takePic, 1);
    }
}
