package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import android.widget.Toast;

import com.example.converter.ViewModel.ConverterViewModel;



public class ConverterActivity extends AppCompatActivity implements NumPadFragment.OnFragmentInteractionListener {
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

//        Toast toast = Toast.makeText(getApplicationContext(),
//                "Ваш выбор: " + unit, Toast.LENGTH_SHORT);
//        toast.show();
    }

    @Override
    public void onFragmentInteraction(String text) {
        DataFragment fragment = (DataFragment) getSupportFragmentManager().findFragmentById(R.id.dataFragment);
        fragment.setText(text);
    }
}