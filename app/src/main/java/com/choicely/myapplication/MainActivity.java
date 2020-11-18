package com.choicely.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FragmentTwo fragmentTwo = new FragmentTwo();

//        transaction.add(R.id.fragment_container, fragmentTwo);
        transaction.replace(R.id.fragment_container, fragmentTwo);
        transaction.commit();


    }
}
