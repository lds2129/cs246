package com.example.jayoh.multithreaded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    File file;

    public void createButton(View view){
        MyCreate create = new MyCreate(file, (ProgressBar)findViewById(R.id.progressBar));
        Thread thread = new Thread(create);
        thread.start();
    }

    public void loadButton(View view){
        MyLoad load = new MyLoad(file,this, (ListView)findViewById(R.id.listView),
                R.layout.support_simple_spinner_dropdown_item, (ProgressBar)findViewById(R.id.progressBar));
        Thread thread = new Thread(load);
        thread.start();
    }

    public void clearButton(View view){
        ((ListView)findViewById(R.id.listView)).setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        file = new File(getFilesDir(), "numbers.txt");
    }
}
