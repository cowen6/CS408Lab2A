package com.example.cs408lab2a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cs408lab2a.databinding.ActivityMainBinding;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String label = getResources().getString(R.string.total_per_person);
        NumberFormat format = NumberFormat.getCurrencyInstance();

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if inputs have values

                EditText billInput = binding.billInput;
                EditText tipInput = binding.tipInput;
                EditText peopleInput = binding.peopleInput;
                TextView t = binding.resultOutput;

                float bill = Float.parseFloat(billInput.toString());
                float tip = 1 + ((float) Integer.parseInt(tipInput.toString()) / 100);
                int people = Integer.parseInt(peopleInput.toString());

                float total = bill * tip;
                float result = total / people;

                String output = label + format.format(result);
                t.setText(output);
            }
        });
    }


}