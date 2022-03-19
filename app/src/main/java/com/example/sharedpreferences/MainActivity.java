package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numberCountText;
    Button blackBut, redBut, blueBut, greenBut, countBut, resetBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberCountText=findViewById(R.id.numberId);
        blackBut=findViewById(R.id.blackId);
        redBut=findViewById(R.id.redId);
        blueBut=findViewById(R.id.blueId);
        greenBut=findViewById(R.id.greenId);
        countBut=findViewById(R.id.countId);
        resetBut=findViewById(R.id.resetId);
        SharedPreferences sharedPreferences = getSharedPreferences("number", Context.MODE_PRIVATE);
        blueBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberCountText.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });
        blackBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberCountText.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        redBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberCountText.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });
        greenBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberCountText.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        countBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countTotal=Integer.parseInt(numberCountText.getText().toString())+1;
                numberCountText.setText(""+countTotal);
            }
        });
        resetBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                numberCountText.setText(""+0);
                numberCountText.setBackgroundColor(getResources().getColor(R.color.white));
                editor.apply();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("number", Context.MODE_PRIVATE);
        int count=Integer.parseInt(numberCountText.getText().toString());
        int color=((ColorDrawable)numberCountText.getBackground()).getColor();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("count",count);
        editor.putInt("color",color);
        editor.apply();
    }
}