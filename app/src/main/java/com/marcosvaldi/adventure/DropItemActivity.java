package com.marcosvaldi.adventure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropItemActivity extends AppCompatActivity {

    @BindView(R.id.activity_drop_item_list) ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_item);
        ButterKnife.bind(this);

    }
}
