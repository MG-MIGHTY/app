package com.example.adrien.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Button button = findViewById(R.id.buttonSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get back what was written in the TextView
                EditText editText = (EditText) findViewById(R.id.editText);
                String str = editText.getText().toString();

                Intent intent = new Intent(Search.this, MainActivity.class);
                intent.putExtra("edittext", str);
                startActivity(intent);
            }
        });

        EditText textField = findViewById(R.id.editText);
    }
}
