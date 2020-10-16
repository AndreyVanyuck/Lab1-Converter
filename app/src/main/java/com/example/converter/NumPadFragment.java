package com.example.converter;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class NumPadFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_num_pad, container, false);

        SetDigitClickListener(view.findViewById(R.id.button0));
        SetDigitClickListener(view.findViewById(R.id.button1));
        SetDigitClickListener(view.findViewById(R.id.button2));
        SetDigitClickListener(view.findViewById(R.id.button3));
        SetDigitClickListener(view.findViewById(R.id.button4));
        SetDigitClickListener(view.findViewById(R.id.button5));
        SetDigitClickListener(view.findViewById(R.id.button6));
        SetDigitClickListener(view.findViewById(R.id.button7));
        SetDigitClickListener(view.findViewById(R.id.button8));
        SetDigitClickListener(view.findViewById(R.id.button9));
        SetDigitClickListener(view.findViewById(R.id.buttonDot));
        SetDigitClickListener(view.findViewById(R.id.buttonC));

        return view;
    }
    private void SetDigitClickListener(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textButton = button.getText().toString();
                mListener.onFragmentInteraction(textButton);
            }
        });
    }

    public void clickDigitButton(View view){
        Button button = (Button) view;
        String textButton = button.getText().toString();
    }
}