package com.example.fragment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;
    FragmentManager manager;
    FragmentTransaction ft;

    Fragment_1 fragment_1;
    Fragment_2 fragment_2;
    Fragment_3 fragment_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();
        fragment_3 = new Fragment_3();

        ft = manager.beginTransaction();
        ft.add(R.id.main_frame, fragment_1);
        ft.addToBackStack(null);
        ft.commit();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ft = manager.beginTransaction();

        int id = v.getId();

        switch (id){
            case R.id.button1:
                ft.replace(R.id.main_frame, fragment1);
                ft.commit();
                break;

            case R.id.button2:
                ft.replace(R.id.main_frame, fragment2);
                ft.commit();
                break;
            case R.id.button3:
                ft.replace(R.id.main_frame, fragment3)     ;
                ft.commit();
                break;
        }
    }
}