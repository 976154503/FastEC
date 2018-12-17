package com.example.zhaojiaxiaoluoli.fastec.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte.app.Latte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(Latte.getApplication().getApplicationContext(),"上下文已经传入",Toast.LENGTH_LONG).show();
    }
}
