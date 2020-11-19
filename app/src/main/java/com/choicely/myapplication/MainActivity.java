package com.choicely.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public class MainActivity extends FragmentActivity {
    private Button button1;
    private Button button2;
    private Button button3;

    private View.OnClickListener onClickListener = v -> {
        switch (v.getId()) {
            case R.id.main_activity_fragment_button_1:
                System.out.println("Fragment 1");
                createFragment(new FirstFragment());
                break;
            case R.id.main_activity_fragment_button_2:
                System.out.println("FRAGMENT 2");
                createFragment(new SecondFragment());
                break;
            case R.id.main_activity_fragment_button_3:
                System.out.println("Fragment 3");
                createFragment(new ThirdFragment());
                break;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        button1 = findViewById(R.id.main_activity_fragment_button_1);
        button2 = findViewById(R.id.main_activity_fragment_button_2);
        button3 = findViewById(R.id.main_activity_fragment_button_3);

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
    }


    public void createFragment(Fragment fragment) {

        fragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();

    }
}
