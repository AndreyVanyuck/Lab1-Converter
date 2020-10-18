package com.example.converter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class DataFragment extends Fragment {
    Button button_convert;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    ConverterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_data, container, false);

        button_convert = (Button) view.findViewById(R.id.buttonConvert);
        spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) view.findViewById(R.id.spinnerTo);
        viewModel = new ViewModelProvider(requireActivity()).get(ConverterViewModel.class);

        String unitCategory = (String) getActivity().getIntent().getSerializableExtra("unit");
        setTextSpinner(unitCategory);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setFromUnit(spinnerFrom.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setToUnit(spinnerTo.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        button_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = spinnerFrom.getSelectedItemPosition();
            }
        });
        return view;
    }

    private void setTextSpinner(String unitCategory){
        ArrayAdapter<CharSequence> adapter = null;
        switch (unitCategory) {
            case "Temperature":
                adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.temperature, android.R.layout.simple_spinner_item);
                viewModel.setUnitCategory(UnitCategory.TEMPERATURE);
                viewModel.setFromUnit("Celsius");
                viewModel.setToUnit("Celsius");
                break;
            case "Distance":
                adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.distance, android.R.layout.simple_spinner_item);
                viewModel.setUnitCategory(UnitCategory.DISTANCE);
                viewModel.setFromUnit("Meter");
                viewModel.setToUnit("Meter");
                break;
            case "Weight":
                adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.weight, android.R.layout.simple_spinner_item);
                viewModel.setUnitCategory(UnitCategory.WEIGHT);
                viewModel.setFromUnit("Kilogram");
                viewModel.setToUnit("Kilogram");
                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(adapter);
        spinnerFrom.setAdapter(adapter);
    }
    public void setText(String text){
        TextView textView = (TextView)getView().findViewById(R.id.textView);
        String textOfTextView = textView.getText().toString();

        if (text == "C"){
            textView.setText("");
            viewModel.setFromValue("");
            return;
        }

        if(text == "."){
            if (textOfTextView.indexOf(".") != -1){
                return;
            }
            if (textOfTextView == ""){
               textView.setText("0" + text);
               viewModel.setFromValue("0" + text);
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
        viewModel.setFromValue(textOfTextView + text);
    }
}