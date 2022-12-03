package com.example.tacolodinputbmi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText tWeight, tHeight;
    String sWeight, sHeight, outputMessage;
    int category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Generating....", Toast.LENGTH_SHORT).show();
        GenerateResult();
    }

    public void GenerateResult() {
        tWeight = (EditText) findViewById(R.id.tWeight);
        tHeight = (EditText) findViewById(R.id.tHeight);

        sWeight = tWeight.getText().toString();
        sHeight = tHeight.getText().toString();

        double rawWeight = Double.parseDouble(sWeight);
        double rawHeight = Double.parseDouble(sHeight);

        double val1 = rawHeight * rawHeight;
        double result = rawWeight / val1;

        if  (result < 18.25){
            category = 0;
        }

        else if (result > 18.25 && result < 24.9 ){
            category = 1;
        }

        else if (result > 25.0 && result < 29.9 ){
            category = 2;
        }

        else if (result > 30.0){
            category = 3;
        }

        switch (category){
            case 0:
                outputMessage = "Your Body Mass Index is " + (int)result + " and your Condition is UNDERWEIGHT...";

                Bundle args = new Bundle();
                args.putString("result", outputMessage);

                Intent underweight = new Intent(MainActivity.this, UnderWeightResult.class);
                underweight.putExtras(args);
                startActivity(underweight);

                clearEditText();

                break;

            case 1:
                outputMessage = "Your Body Mass Index is " + (int)result + " and your Condition is NORMAL WEIGHT...";

                Bundle args1 = new Bundle();
                args1.putString("result", outputMessage);

                Intent normalweight = new Intent(MainActivity.this, NormalWeightResult.class);
                normalweight.putExtras(args1);
                startActivity(normalweight);

                clearEditText();

                break;

            case 2:
                outputMessage = "Your Body Mass Index is " + (int)result + " and your Condition is OVERWEIGHT...";

                Bundle args2 = new Bundle();
                args2.putString("result", outputMessage);

                Intent overweight = new Intent(MainActivity.this, OverWeightResult.class);
                overweight.putExtras(args2);
                startActivity(overweight);

                clearEditText();

                break;

            case 3:
                outputMessage = "Your Body Mass Index is " + (int)result + " and your Condition is OBESE...";

                Bundle args3 = new Bundle();
                args3.putString("result", outputMessage);

                Intent obese = new Intent(MainActivity.this, ObeseResult.class);
                obese.putExtras(args3);
                startActivity(obese);

                clearEditText();

                break;
        }
    }

    public void clearEditText(){
        tWeight.getText().clear();
        tHeight.getText().clear();
        tHeight.requestFocus();
    }
}