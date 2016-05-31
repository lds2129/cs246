package com.example.jayoh.multithreaded;

import android.media.tv.TvContract;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

/**
 * Created by jayoh on 5/28/16.
 */
public class MyCreate implements Runnable {
    private File file;
    private ProgressBar bar;
    //constructor
    public MyCreate(File file, ProgressBar bar){
        this.file = file;
        this.bar = bar;
    }

    //write to the file
    public void run(){
        try{
            FileWriter writer = new FileWriter(file);

            for(int i = 1; i<=10; i++){
                writer.write(Integer.toString(i) + '\n');
                bar.setProgress((i + 1) * 10);
                Thread.sleep(250);
            }

            writer.close();
            bar.setProgress(0);

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
