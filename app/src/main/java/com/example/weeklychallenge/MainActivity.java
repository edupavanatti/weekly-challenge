package com.example.weeklychallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton(R.id.buttonA);
        createButton(R.id.buttonB);
    }

    /**
     * Creates a pre-defined button model with layout based on the ID received by parameter.
     *
     * @param buttonID the ID of the button layout to be created.
     */
    public void createButton(int buttonID) {
        Button button = findViewById(buttonID);
        button.setText(R.string.button_text);
        button.setTextColor(Color.rgb(80, 214, 145));
        button.setBackgroundColor(Color.rgb(71, 29, 124));
    }
}
