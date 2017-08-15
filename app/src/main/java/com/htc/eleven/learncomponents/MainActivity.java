package com.htc.eleven.learncomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner pin = null;
    private String[] dataSource = new String[]{"Entertainment", "Sports", "News", "Music","Movies"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pin = (Spinner) findViewById(R.id.spinner);

//        pin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"a", "b", "c", "d"}));


        pin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource));

        pin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You have chose " + dataSource[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
