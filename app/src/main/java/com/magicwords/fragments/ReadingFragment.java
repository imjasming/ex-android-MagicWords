package com.magicwords.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.magicwords.R;

public class ReadingFragment extends AppCompatActivity {

    TextView title;
    TextView content;
    Button next_translate;
    boolean is_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        title = findViewById(R.id.passage_title);
        content = findViewById(R.id.passage_content);
        next_translate = findViewById(R.id.btn_translation_next);
        is_next = false;
        next_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_next==false){
                    is_next=true;
                    next_translate.setText("next passage");
                }
                else {
                    is_next=false;
                    next_translate.setText("translate it");
                }
            }
        });
    }
}
