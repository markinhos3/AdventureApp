package com.marcosvaldi.adventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        exitButton = (ImageButton) findViewById(R.id.activity_help_exit_button);

        /*
        //PARA ENLAZAR EL BOTÓN A UNA WEB - con el método ACTION_VIEW
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                //startActivity(i);
                i.setData(Uri.parse("http://www.marcosvaldi.com"));
                startActivity(i);
            }
        });
        */

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

}
}


