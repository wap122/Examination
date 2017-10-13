package com.example.examination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB;
    private TextView tvResult;
    private ListView mLv;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = (EditText) findViewById(R.id.edt_a);
        edtB = (EditText) findViewById(R.id.edt_b);
        tvResult = (TextView) findViewById(R.id.tv_result);
        mLv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<>();
        setupAdapter();
    }

    private void setupAdapter() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                list);
        mLv.setAdapter(adapter);
    }

    public void caculateAndAddToList(View view) {
        if (edtA.getText().toString().contentEquals("")) {
            Toast.makeText(this, "Empty A", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edtB.getText().toString().contentEquals("")) {
            Toast.makeText(this, "Empty B", Toast.LENGTH_SHORT).show();
            return;
        }
        int a;
        int b;
        try {
            a = Integer.parseInt(edtA.getText().toString());
            b = Integer.parseInt(edtB.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Text isn't allowed", Toast.LENGTH_SHORT).show();
            return;
        }

        if (b == 0) {
            Toast.makeText(this, "Divide 0 ", Toast.LENGTH_SHORT).show();
            return;
        }
        float result = ((float) a) / b;
        tvResult.setText(a + " / " + b + " = " + result);
        list.add(0,tvResult.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
