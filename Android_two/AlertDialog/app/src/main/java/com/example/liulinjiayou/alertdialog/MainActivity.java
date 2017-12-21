package com.example.liulinjiayou.alertdialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ANDROID APP");
        builder.setPositiveButton("Sign in", null);
        builder.setNeutralButton("Cancle", null);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.layout, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
