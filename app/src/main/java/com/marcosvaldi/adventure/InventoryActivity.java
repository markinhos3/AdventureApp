package com.marcosvaldi.adventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InventoryActivity extends AppCompatActivity {


    Button showInventory;
    TextView things;
    ImageView imgInventory;
    ImageView imgPpal;
    TextView textPpal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        textPpal = (TextView) findViewById(R.id.activity_main_scene_text);
        imgPpal = (ImageView) findViewById(R.id.activity_main_scene_image);



        showInventory = (Button) findViewById(R.id.activity_main_inventory);

        showInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imgPpal.setImageResource(R.drawable.inventory_new);
                    textPpal.setText("Espada\n Lanza\n Señuelo");
            }
        });

    }
}
