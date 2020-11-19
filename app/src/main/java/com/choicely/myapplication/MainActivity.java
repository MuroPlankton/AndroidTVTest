package com.choicely.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private Button button1;
    private Button button2;
    private Button button3;

    private View.OnClickListener onClickListener = v -> {
        Fragment fragment;
        switch (v.getId()) {
            default:
            case R.id.main_activity_fragment_button_1:
                Log.d(TAG, "Fragment 1");
                fragment = new FirstFragment();
                break;
            case R.id.main_activity_fragment_button_2:
                Log.d(TAG, "Fragment 2");
                fragment = new SecondFragment();
                button1.setEnabled(false);
                button3.setEnabled(false);
                break;
            case R.id.main_activity_fragment_button_3:
                Log.d(TAG, "Fragment 3");
                fragment = new ThirdFragment();
                button1.setEnabled(false);
                button2.setEnabled(false);
                break;
        }
        createFragment(fragment);
    };

    private View.OnFocusChangeListener onFocusChangeListener = (View v, boolean isFocused) -> {
        if (isFocused) {
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
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

        button1.setOnFocusChangeListener(onFocusChangeListener);
        button2.setOnFocusChangeListener(onFocusChangeListener);
        button3.setOnFocusChangeListener(onFocusChangeListener);
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
