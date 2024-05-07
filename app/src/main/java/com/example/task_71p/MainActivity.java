package com.example.task_71p;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        button components
        Button newAdvertButton = findViewById(R.id.newAdvertButton);
        Button showALlbutton = findViewById(R.id.showAllButton);

//        set up navigation
        newAdvertButton.setOnClickListener(v -> {
            Intent newAdvertIntent = new Intent(MainActivity.this, NewAdvertActivity.class);
            startActivity(newAdvertIntent);
        });

        showALlbutton.setOnClickListener(v -> {
            Intent showAllIntent = new Intent(MainActivity.this, ShowAllActivity.class);
            startActivity(showAllIntent);
        });
    }
}