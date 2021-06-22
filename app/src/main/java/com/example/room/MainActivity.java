package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    TextView textView;
    RecyclerView recyclerView;
    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView);
        textView.setText("");

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomerAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((holder, view, position)->{
            Customer item = adapter.getItem(position);
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener((view)->{
            String name = editText.getText().toString();+
            String birth = editText2.getText().toString();
            String mobile = editText3.getText().toString();

            adapter.addItem(new Customer(name, birth, mobile, R.drawable.dog));
            adapter.notifyDataSetChanged();

            textView.setText(adapter.getItemCount() + " 명");
        });
    }
}