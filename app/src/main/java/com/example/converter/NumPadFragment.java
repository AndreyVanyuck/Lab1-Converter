package com.example.converter;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NumPadFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String text);
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
        SetDigitClickListener(view.findViewById(R.id.buttonC),"C");

        return view;
    }
    private void SetDigitClickListener(Button button, String textButton){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(textButton);
            }
        });
    }
}