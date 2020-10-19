package com.example.converter;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.converter.ViewModel.ConverterViewModel;

import java.util.Objects;


public class NumPadFragment extends Fragment {
    ConverterViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_num_pad, container, false);
        viewModel =  new ViewModelProvider(requireActivity()).get(ConverterViewModel.class);

        SetDigitClickListener(view.findViewById(R.id.button0), "0");
        SetDigitClickListener(view.findViewById(R.id.button1), "1");
        SetDigitClickListener(view.findViewById(R.id.button2), "2");
        SetDigitClickListener(view.findViewById(R.id.button3), "3");
        SetDigitClickListener(view.findViewById(R.id.button4),"4");
        SetDigitClickListener(view.findViewById(R.id.button5),"5");
        SetDigitClickListener(view.findViewById(R.id.button6),"6");
        SetDigitClickListener(view.findViewById(R.id.button7),"7");
        SetDigitClickListener(view.findViewById(R.id.button8),"8");
        SetDigitClickListener(view.findViewById(R.id.button9),"9");
        SetDigitClickListener(view.findViewById(R.id.buttonDot),".");

        Button buttonC = view.findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setFromValue("");
                viewModel.setToValue("");
            }
        });

        return view;
    }
    private void SetDigitClickListener(Button button, String textButton){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModel.getFromValue().getValue().length() < 7){
                    viewModel.setFromValue(viewModel.getFromValue().getValue() + textButton);
                }
            }
        });
    }
}