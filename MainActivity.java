package com.adevfunda.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.winCount);
        t.setText("You have won "+String.valueOf(w)+" times");

        //TextView mytest = new TextView();
        /*TextView mytext = findViewById(R.id.diceText);
        Random r = new Random();
        int n = r.nextInt(6) + 1;
        mytext.setText(String.valueOf(n));*/
    }
    //static
    int w = 0;

    public void rollButton(View view){          //View view <- app crashes
        TextView mytext = findViewById(R.id.diceText);

        Random r = new Random();
        int n = r.nextInt(6) + 1;
        if(n==6){
            //mytext.setText(String.valueOf(n)+"\nyay\n");
            TextView t2 = findViewById(R.id.winCount);

            Toast.makeText(MainActivity.this,"Congratulations for winning",Toast.LENGTH_SHORT).show();
            w++;
            String tmp = w!=1?"s":"";
            t2.setText("You have won "+String.valueOf(w)+" time"+tmp);
        }
        //else
        mytext.setText(String.valueOf(n));

    }

}
