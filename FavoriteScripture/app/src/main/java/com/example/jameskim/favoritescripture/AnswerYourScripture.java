package com.example.jameskim.favoritescripture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerYourScripture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_your_scripture);

        Intent JamesIntent = getIntent();
        String book = JamesIntent.getStringExtra("book");
        String chapter = JamesIntent.getStringExtra("chapter");
        String verse = JamesIntent.getStringExtra("verse");

        TextView answer = (TextView) findViewById(R.id.answer_box);
        answer.setText(book + " " + chapter + " : " + verse);
    }
}
