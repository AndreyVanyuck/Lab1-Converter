package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.ArrayAdapter.createFromResource;


public class ConverterActivity extends AppCompatActivity implements NumPadFragment.OnFragmentInteractionListener {
    NumPadFragment numPadFragment;
    DataFragment dataFragment;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    ConverterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        viewModel = new ViewModelProvider(this).get(ConverterViewModel.class);
//
//        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
//        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
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