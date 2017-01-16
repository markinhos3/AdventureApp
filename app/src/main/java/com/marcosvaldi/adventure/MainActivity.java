package com.marcosvaldi.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.marcosvaldi.adventure.Model.Inventory;
import com.marcosvaldi.adventure.Model.Item;
import com.marcosvaldi.adventure.Model.MapGenerator;
import com.marcosvaldi.adventure.Model.Room;
import com.marcosvaldi.adventure.util.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //VBLES DE LOS BOTONES y SU findViewById USANDO LA NUEVA LIBRERÍA ButterKnife
    @BindView(R.id.activity_main_scene_image)
    ImageView imgPpal;
    @BindView(R.id.activity_main_help)
    ImageButton helpButton;
    @BindView(R.id.activity_main_norte)
    ImageButton northButton;
    @BindView(R.id.activity_main_sur)
    ImageButton southButton;
    @BindView(R.id.activity_main_este)
    Button eastButton;
    @BindView(R.id.activity_main_oeste)
    Button westButton;
    @BindView(R.id.activity_main_inventory) // hace la función del findViewById
            Button inventoryButton;
    @BindView(R.id.activity_main_take)
    Button takeButton;
    @BindView(R.id.activity_main_drop)
    Button dropButton;
    @BindView(R.id.activity_main_scene_text)
    TextView textRoom; // PASO 1
    @BindView(R.id.activity_main_look)
    ImageButton lookButton; // en una Sóla Línea


    //VBLES DE INSTANCIA
    // AÑADO LOS OBJETOS AL INVENTARIO, creando para ello el objeto inventory ( y se hace dentro del GAME que es quien lo necesita, estaba en Main )
    Inventory inventory = new Inventory();
    //necesito saber en QUÉ ROOM ESTOY
    Room currentRoom;

    //MÉTODO PARA EL On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //HAY QUE ACTIVAR BUTTERKNIFE
        ButterKnife.bind(this);
        //PARA ACTIVAR PICASSO
        Picasso.with(this).setIndicatorsEnabled(true);
        Picasso.with(this).setLoggingEnabled(true);


        //CONCEPTO ONCLICKLISTENER: el botón necesita que le pase un Objeto tenga por narices un método onClick ( View.OnClickListener() con el método public void onClick(View view) )
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //CONCEPTO DE INTENCIÓN (INTENT): le digo al sistema android que me haga algo, en este caso que me muestre la pantalla
                Intent i = new Intent(MainActivity.this, HelpActivity.class); // es una INTENCIÓN que va desde MainActivity hasta HelpActivity
                startActivity(i);
            }

        });
        /*puede hacerse con la IMPLEMENTACIÓN (implements) PERO ES MÁS LIOSO:
        public class HelpActivity extends AppCompatActivity implements View.OnClickListener {

        ahora hay que añadirle el método
        @Override
            public void onClick(View view) {
                    }

         USANDO UNA CLASE:
         EN JAVA PUEDO METER UNA CLASE DENTRO DE UNA FUNCIÓN

        me creo una CLASE que implemente a onClickListener:

        class TrataBotonAyuda implements View.OnClickListener{
         @Override
             public void onClick(View view) {
             }
        }

        TrataBotonAyuda lalola = new TrataBotonAyuda();

        helpButton.setOnClickListener(lalola);
        */

        /* -------------------  EN DEFINITIVA SE PUEDE HACER -------------------------------

         helpButton.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View view) {
             }
        });
        --------------------------------------------------------------------------------------
         */


        //LLAMA A initGame
        initGame();
        //LAMO a PINTAR ESCENA
        repaintScene();


        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomNorth();
                repaintScene();
            }
        });
        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomSouth();
                repaintScene();
            }
        });
        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomEast();
                repaintScene();
            }
        });
        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentRoom = currentRoom.getRoomWest();
                repaintScene();
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPpal.setImageResource(R.drawable.new_inv);
                textRoom.setText(inventory.print());

            }
        });
        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, DropItemActivity.class);
                i.putExtra(Constants.KEY_INTENT_INVENTORY, inventory); // le paso la clave/etiqueta KEY_INVENTORY para cada casilla, a la hora de sacarlo sepa de dónde sacarlo
                // los intent no saben tratar cosas de la clase inventory: hay q darle la forma a inventory como quiere intent => la clase inventory está extendiendo de Object y eso no se lo traga el intent
                // ARRANCA UNA ACTIVIDAD ESPERANDO UN RESULTADO
                startActivityForResult(i, 1); // hay que pasarle un intent y un número
            }
        });

        lookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textRoom.setText(currentRoom.getDescription() + "\n" + currentRoom.getRoomItems());
            }
        });

    }


    //MÉTODO para inicializar el juego
    private void initGame() {

        // CREO OBJETOS DEL INVENTARIO
        Item sword = new Item("Sword", "A sharp blade");
        Item pieceOfPaper = new Item("Piece Of Paper", "A blank piece");
        Item rubberChicken = new Item("Pollo de Goma", "A blank piece");

        // AÑADO LOS OBJETOS AL INVENTARIO
        inventory.add(sword);
        inventory.add(pieceOfPaper);
        inventory.add(rubberChicken);

        //AQUÍ GEREO EL MAPA DEL JUEGO - llamo al método generate con la clase MapGenerator:
        MapGenerator.generate(this);
        currentRoom = MapGenerator.initialRoom;

    }

    //MÉTODO PARA PINTAR UNA ROOM/ESCENA
    private void repaintScene() {

        //write room description on screen
        textRoom.setText(currentRoom.getDescription());         //PASO 3

        //PINTAR CON LA LIBRERÍA PICASSO:
        Picasso.
                with(this).
                load(currentRoom.getImageUrl()).
                into(imgPpal);

        if (currentRoom.getRoomNorth() != null) {
            //eso es que tiene room al norte -> que aparezca botón
            northButton.setVisibility(View.VISIBLE);
        } else {
            //no hay room al norte -> voy a ocultar el botón
            northButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomSouth() != null) {
            //eso es que tiene room al norte -> que aparezca botón
            southButton.setVisibility(View.VISIBLE);
        } else {
            //no hay room al norte -> voy a ocultar el botón
            southButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomEast() != null) {
            //eso es que tiene room al norte -> que aparezca botón
            eastButton.setVisibility(View.VISIBLE);
        } else {
            //no hay room al norte -> voy a ocultar el botón
            eastButton.setVisibility(View.INVISIBLE);
        }
        if (currentRoom.getRoomWest() != null) {
            //eso es que tiene room al norte -> que aparezca botón
            westButton.setVisibility(View.VISIBLE);
        } else {
            //no hay room al norte -> voy a ocultar el botón
            westButton.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) { // 1 es el código que le habíamos pasado al startIntnentForResult

            if (resultCode == RESULT_OK) {

                // sacando un itemPosition
                int itemPosition = data.getIntExtra(Constants.KEY_INTENT_DROP_ITEM_POSITION, -1); // hay que pasarle un valor por defecto por si no se encuentra el itemPosition (-1)

                Item item = inventory.getItem(itemPosition); // del inventario sacar el item de la posición que he tocado; creo el método getItem con alt+ intro Create method -> y lo crea en la clase Inventory y hay q añadir: return inventory.get(itemPosition);
                //añade un item
                currentRoom.getItems().add(item);

                //tb debe tener borra un item
                inventory.deleteItem(itemPosition); // se crea el método con alt+intro Create method (se crea en la clase Inventory) y se le añade: inventory.remove(itemPosition);

                // Para que el
                // el Snakcbar necesita una vista para pintar -> yo la llamaba: textRoom
                Snackbar.make(textRoom, getString(R.string.dropped_item_text) + item.getName(), Snackbar.LENGTH_LONG) // hace referencia a una VISTA (view)
                        .setAction("Action", null).show(); // añade una única acción que no hace nada

            }

        }
    }
}