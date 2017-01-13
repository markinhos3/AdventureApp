package com.marcosvaldi.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        entry = (Button) findViewById(R.id.activity_home_entry);

        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomeActivity.this, MainActivity.class); // es una INTENCIÓN que va desde MainActivity hasta HelpActivity
                startActivity(i);
            }
        });
    }
}
