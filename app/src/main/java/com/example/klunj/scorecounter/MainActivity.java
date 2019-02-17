package com.example.klunj.scorecounter;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    TextView textView;
    int x = 1;
    int j;
    Handler handler = new Handler();
    String score;

    public void letsDoIt(View view) {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                updateScore();
            }
        };
        new Thread(myRunnable).start();
    }


    private void updateScore(){
        x = x + 10;
        for(int i = j; i < x; i++){
            score = Integer.toString(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView = (TextView) findViewById(R.id.textView);
                    textView.setText(score);
                    System.out.println(score);
                    j = x;
                }
            });
        }
    }

}
//test commi
