package com.example.converter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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

import java.util.Objects;


public class DataFragment extends Fragment {
    Button buttonConvert;
    Button buttonCopy;
    Button buttonSwap;
    TextView textViewFrom;
    TextView textViewTo;
    Spinner spinnerFrom ;
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

                viewModel.setSelectedIdSpinnerFrom(Integer.toString(spinnerFrom.getSelectedItemPosition())); ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setToUnit(spinnerTo.getSelectedItem().toString());

                viewModel.setSelectedIdSpinnerTo(Integer.toString(spinnerTo.getSelectedItemPosition())); ///
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Observer<String> valueFromObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewFrom.setText(s);
            }
        };
        final Observer<String> valueToObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewTo.setText(s);
            }
        };
        viewModel.getFromValue().observe(getViewLifecycleOwner(), valueFromObserver);
        viewModel.getToValue().observe(getViewLifecycleOwner(), valueToObserver);


        final Observer<String> spinnerFromValueObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                spinnerFrom.setSelection(Integer.parseInt(s));
            }
        };

        final Observer<String> spinnerToValueObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                spinnerTo.setSelection(Integer.parseInt(s));
            }
        };
        viewModel.getSelectedIdSpinnerFrom().observe(getViewLifecycleOwner(), spinnerFromValueObserver);
        viewModel.getSelectedIdSpinnerTo().observe(getViewLifecycleOwner(), spinnerToValueObserver);

        buttonConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!Objects.equals(viewModel.getFromValue().getValue(), "")){
                    viewModel.convert();
                }
            }
        });

        buttonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFromValue = viewModel.getFromValue().getValue();
                viewModel.setFromValue(viewModel.getToValue().getValue());
                viewModel.setToValue(textFromValue);

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
}