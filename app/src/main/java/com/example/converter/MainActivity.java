package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.converter.ViewModel.ConverterViewModel;

public class MainActivity extends AppCompatActivity {
    ConverterViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ConverterViewModel.class);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] list_options = getResources().getStringArray(R.array.options);
                String unit = list_options[i];

                Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
                intent.putExtra("unit", unit);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }


}