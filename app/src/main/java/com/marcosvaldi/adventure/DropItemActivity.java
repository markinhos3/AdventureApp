package com.marcosvaldi.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marcosvaldi.adventure.Model.Inventory;
import com.marcosvaldi.adventure.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropItemActivity extends AppCompatActivity {

    @BindView(R.id.activity_drop_item_list) ListView itemList;

    Inventory inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_item);
        ButterKnife.bind(this);



        Intent i = getIntent();
        inventory = (Inventory)i.getSerializableExtra(Constants.KEY_INTENT_INVENTORY); // es peligroso el uso de estas claves

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inventory.getItemNames()); //le paso el contexto this pq es una actividad y un DISEÑO (de una fila que aparecía pintado)
        // que trae Adroid; y debo pasarle la lista de cadenas de texto con  los nombres de todos los items que están dentro
        itemList.setAdapter(adapter); //lo conecto al Adaptador


        //para los ITEMS su OnClick Listeners es (DETECTAR EL CLICK EN UN ELEMENTO DE LA LISTA):
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View row, int position, long id) {


                // tngo que pasar dsd inventario dónde he tocado; PASAR DATOS DE UNA PANTALLA A OTRA
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.KEY_INTENT_DROP_ITEM_POSITION,position); //le paso clave desde la clase Constants llamada KEY_INTENT_DROP_ITEM_POSITION
                //le damos a alt+intro y create Constant field para crear la cte ;posición en la que he tocado
                setResult(RESULT_OK, returnIntent);

                //tengo que hacer un finish para q cuando toque una fila se ha de cerrar la lista
                finish();



            }
        });
    }
}
