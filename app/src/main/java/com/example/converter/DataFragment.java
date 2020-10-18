package com.example.converter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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

import com.example.converter.ViewModel.ConverterViewModel;
import com.example.converter.unit.UnitCategory;


public class DataFragment extends Fragment {
    Button buttonConvert;
    Button buttonCopy;
    Button buttonSwap;
    TextView textViewFrom;
    TextView textViewTo;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    ConverterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_data, container, false);

        buttonConvert = (Button) view.findViewById(R.id.buttonConvert);
        buttonCopy = (Button) view.findViewById(R.id.buttonCopy);
        buttonSwap = (Button) view.findViewById(R.id.buttonSwap);
        textViewFrom = (TextView) view.findViewById(R.id.textViewFrom);
        textViewTo = (TextView) view.findViewById(R.id.textViewTo);
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



        buttonConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewModel.convert();
                textViewTo.setText(viewModel.getToValue().toString());
            }
        });

        buttonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setFromValue(textViewTo.getText().toString());

                CharSequence textFrom = textViewFrom.getText();
                textViewFrom.setText(textViewTo.getText());
                textViewTo.setText(textFrom);

                int selectedItemPositionFrom =  spinnerFrom.getSelectedItemPosition();
                spinnerFrom.setSelection(spinnerTo.getSelectedItemPosition());
                spinnerTo.setSelection(selectedItemPositionFrom);
            }
        });
        buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", textViewTo.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getActivity(), "Saved: " + textViewTo.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setTextSpinner(String unitCategory){
        ArrayAdapter<CharSequence> adapter = null;
        switch (unitCategory) {
            case "Time":
                adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.time, android.R.layout.simple_spinner_item);
                viewModel.setUnitCategory(UnitCategory.TIME);
                viewModel.setFromUnit("Hour");
                viewModel.setToUnit("Hour");
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
        TextView textViewFrom = (TextView)getView().findViewById(R.id.textViewFrom);
        TextView textViewTo = (TextView)getView().findViewById(R.id.textViewTo);
        String textOfTextView = textViewFrom.getText().toString();

        if (text == "C"){
            textViewFrom.setText("");
            textViewTo.setText("");
            viewModel.setFromValue("");
            viewModel.setToValue("");
            return;
        }

        if(text == "."){
            if (textOfTextView.indexOf(".") != -1){
                return;
            }
            if (textOfTextView == ""){
                textViewFrom.setText("0" + text);
               viewModel.setFromValue("0" + text);
               return;
            }
            textViewFrom.setText(textOfTextView + text);
        }

        if (textOfTextView == ""){
            textViewFrom.setText(text);
        }
        else {
            textViewFrom.setText(textOfTextView + text);
        }
        viewModel.setFromValue(textOfTextView + text);
    }
}