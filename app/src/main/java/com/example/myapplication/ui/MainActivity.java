package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.data.NotificationHelper;
import com.example.myapplication.data.ServiceBuilder;

public class MainActivity extends AppCompatActivity {

    private Button btnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupListeners();
    }

    private void setupListeners() {
        btnPush.setOnClickListener(v ->
                startService(new Intent(this, ServiceBuilder.class)));
    }

    private void setupView() {
        btnPush = findViewById(R.id.btnPush);
    }

}
