package com.choicely.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;


public class MainActivity extends FragmentActivity {
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        button1 = findViewById(R.id.main_activity_fragment_button_1);
        button2 = findViewById(R.id.main_activity_fragment_button_2);
        button3 = findViewById(R.id.main_activity_fragment_button_3);


        FirstFragment fragment = new FirstFragment();

        fragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();

        button1.setOnClickListener(v -> {
            FirstFragment fragment1 = new FirstFragment();

            fragment1.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment1)
                    .commit();

        });
        button2.setOnClickListener(v -> {
            SecondFragment fragment12 = new SecondFragment();

            fragment12.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment12)
                    .commit();

        });
        button3.setOnClickListener(v -> {
            ThirdFragment fragment13 = new ThirdFragment();

            fragment13.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment13)
                    .commit();

        });

    }
}
