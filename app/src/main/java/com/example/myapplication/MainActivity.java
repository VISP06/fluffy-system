package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean isDarkMode=true;
    //global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @SuppressLint("ResourceAsColor")
    public void Modes(View v) {
        //creating the objects
        ConstraintLayout layout = findViewById(R.id.main);
        Button button = findViewById(R.id.button1);
        TextView view = findViewById(R.id.textView);
        //the appearance toggle code
        if (isDarkMode) {
            view.setText("Click the button to change to Dark Mode");
            view.setTextColor(Color.BLACK);
            layout.setBackgroundColor(Color.WHITE);
            button.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
            button.setTextColor(Color.WHITE);
        }
        else{
            view.setText("Click the button to change to Light Mode");
            view.setTextColor(Color.WHITE);
            layout.setBackgroundColor(Color.BLACK);
            button.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            button.setTextColor(Color.BLACK);
        }
        isDarkMode=!isDarkMode;
    }
}