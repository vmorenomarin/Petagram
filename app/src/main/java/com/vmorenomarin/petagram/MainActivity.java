package com.vmorenomarin.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout IndicadorActualizar;
    ListView Lista;
    Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarIcon();

        IndicadorActualizar = (SwipeRefreshLayout) findViewById(R.id.IndicadorActualizar);
        Lista = (ListView) findViewById(R.id.Lista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        Lista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        IndicadorActualizar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrascandoContenido();

            }
        });
    }

    public void refrascandoContenido(){
         String[] planetas = getResources().getStringArray(R.array.planetas);
        Lista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        IndicadorActualizar.setRefreshing(false);
    }

    public void agregarIcon(){
        FloatingActionButton miBoton = (FloatingActionButton) findViewById(R.id.Boton2);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.texto_toast), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.texto_toast), Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
