package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class ConverterActivity extends AppCompatActivity implements NumPadFragment.OnFragmentInteractionListener {
    NumPadFragment numPadFragment;
    DataFragment dataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        numPadFragment = new NumPadFragment();
        dataFragment = new DataFragment();
        fragmentTransaction.add(R.id.numPadFragment,numPadFragment);
        fragmentTransaction.add(R.id.dataFragment, dataFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String link) {
        DataFragment fragment = (DataFragment) getSupportFragmentManager().findFragmentById(R.id.dataFragment);
        fragment.setText(link);
    }
}