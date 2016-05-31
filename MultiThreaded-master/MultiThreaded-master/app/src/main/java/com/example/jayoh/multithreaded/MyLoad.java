package com.example.jayoh.multithreaded;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jayoh on 5/28/16.
 */
public class MyLoad implements Runnable {

    private File file;
    private Activity activity;
    private List<Integer> list;
    private ListView listView;
    private int id;
    private ProgressBar bar;

    //constructor
    public MyLoad(File file, Activity activity, ListView listView, int id, ProgressBar bar){
        this.file = file;
        this.activity = activity;
        this.listView = listView;
        this.id = id;
        this.bar = bar;
        list = new ArrayList<Integer>();
    }

    public void run(){
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            for(int i = 0; i <10; i++){
                list.add(Integer.parseInt(reader.readLine()));
                bar.setProgress((i+1)*10);
                Thread.sleep(250);
            }
            reader.close();
            fileReader.close();
            bar.setProgress(0);

        }catch (Exception e){

        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ArrayAdapter adapter = new ArrayAdapter(activity,id,list);
                listView.setAdapter(adapter);
            }
        });
    }
}
