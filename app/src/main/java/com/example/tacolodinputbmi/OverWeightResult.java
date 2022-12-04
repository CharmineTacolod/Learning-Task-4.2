package com.example.tacolodinputbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OverWeightResult extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String result = extras.getString("result");
        setContentView(R.layout.activity_over_weight_result);

        Button btnReturn = (Button) findViewById(R.id.btn_return);
        TextView tvResult = (TextView) findViewById(R.id.txt_result);
        tvResult.setText(result);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent overweight = new Intent(OverWeightResult.this, MainActivity.class);
        startActivity(overweight);
    }
}