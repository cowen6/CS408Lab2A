package com.example.cs408lab2a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import com.example.cs408lab2a.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
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

                EditText billInput = binding.billInput;
                EditText tipInput = binding.tipInput;
                EditText peopleInput = binding.peopleInput;
                TextView t = binding.resultOutput;

                //Logs the inputted values
                Log.d(TAG, "bill input: " + billInput.getText().toString());
                Log.d(TAG, "tip input: " + tipInput.getText().toString());
                Log.d(TAG, "people input: " + peopleInput.getText().toString());

                boolean billempty = billInput.getText().toString().isEmpty();
                boolean tipempty = tipInput.getText().toString().isEmpty();
                boolean peopleempty = peopleInput.getText().toString().isEmpty();

                //Logs if input values were empty
                Log.d(TAG, "bill empty: " + billempty);
                Log.d(TAG, "tip empty: " + tipempty);
                Log.d(TAG, "people empty: " + peopleempty);

                if(!billempty && !tipempty && !peopleempty){
                    float bill = Float.parseFloat(billInput.getText().toString());
                    float tip = 1 + ((float) Integer.parseInt(tipInput.getText().toString()) / 100);
                    int people = Integer.parseInt(peopleInput.getText().toString());

                    float total = bill * tip;
                    float result = total / people;

                    String output = label + " " + format.format(result);
                    t.setText(output);
                }

            }
        });
    }


}