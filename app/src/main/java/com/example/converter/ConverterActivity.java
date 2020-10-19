package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.example.converter.ViewModel.ConverterViewModel;



public class ConverterActivity extends AppCompatActivity {
    NumPadFragment numPadFragment;
    DataFragment dataFragment;
    ConverterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        viewModel = new ViewModelProvider(this).get(ConverterViewModel.class);
        numPadFragment = new NumPadFragment();
        dataFragment = new DataFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.numPadFragment,numPadFragment);
        fragmentTransaction.add(R.id.dataFragment, dataFragment);
        fragmentTransaction.commit();
    }
}