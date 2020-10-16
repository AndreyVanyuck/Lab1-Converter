package com.example.converter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }
    public void setText(String text){
        TextView textView = (TextView)getView().findViewById(R.id.textView);
        String textOfTextView = textView.getText().toString();

        if (text == "C"){
            textView.setText("123");
            return;
        }

        if(text == "."){
            if (text.indexOf(".") != -1){
                return;
            }
            if (textOfTextView == ""){
               textView.setText("0" + text);
               return;
            }
            textView.setText(textOfTextView + text);
        }

        if (textOfTextView == ""){
            textView.setText(text);
        }
        else {
            textView.setText(textOfTextView + text);
        }
    }
}