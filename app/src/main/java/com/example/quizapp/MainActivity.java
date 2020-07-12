package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button b1,b2;
TextView t1,t2;
ProgressBar p1;
    int k1 = 0;

    int m234=0;
boolean anwser;

    quizapp[] tx=new quizapp[]{
            new quizapp(R.string.q1,true),
            new quizapp(R.string.q2,true),
            new quizapp(R.string.q3,true),
            new quizapp(R.string.q4,false),
            new quizapp(R.string.q5,true),
            new quizapp(R.string.q6,false),
            new quizapp(R.string.q7,true),
            new quizapp(R.string.q8,false),
            new quizapp(R.string.q9,true),
            new quizapp(R.string.q10,false)
    };
    int m23=(int)Math.ceil(100.0/tx.length);
    private final String score_key="your score";
    private final String Index_key="index number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2=(TextView) findViewById(R.id.textView3);
        if(savedInstanceState!=null)
        {
            k1=savedInstanceState.getInt(Index_key);
            m234=savedInstanceState.getInt(score_key);
            t2.setText("your score is "+m234);

        }
        Toast.makeText(this,"oncreate  lifecycle start",Toast.LENGTH_LONG).show();
        p1=(ProgressBar)findViewById(R.id.progressBar3);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        t1=(TextView) findViewById(R.id.textView2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        quizapp a2=tx[k1];
        t1.setText(a2.getQuestionno());
        anwser=a2.getmatch();

        //t2.setText(anwser+"");


    }

    @Override
    public void onClick(View v) {


        if(anwser==true)
        {
            if(v.getId()==R.id.button)
            {
                Toast.makeText(MainActivity.this,"yes you are right",Toast.LENGTH_SHORT).show();
                p1.incrementProgressBy(m23);
                m234=m234+10;
                t2.setText("your score is "+ m234);
            }
            else if(v.getId()==R.id.button2)
            {
                Toast.makeText(MainActivity.this,"you are wrong",Toast.LENGTH_SHORT).show();
            }

        }
        else
        { if(v.getId()==R.id.button)
            {
                Toast.makeText(MainActivity.this,"you are wrong",Toast.LENGTH_SHORT).show();
            }
            else if(v.getId()==R.id.button2)
            {
                Toast.makeText(MainActivity.this,"yes you are right",Toast.LENGTH_SHORT).show();
                p1.incrementProgressBy(m23);
                m234=m234+10;
                t2.setText("your score is "+ m234);
            }
        }
        k1=k1+1;
        k1=k1%10;
        if(k1==0){
            AlertDialog.Builder ktm=new AlertDialog.Builder(this);
            ktm.setCancelable(false);
            ktm.setTitle("you attempted all the question ");
            ktm.setMessage("your total score is "+m234);
            ktm.setPositiveButton("finish the quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            ktm.show();
        }
        quizapp a1=tx[k1];
                t1.setText(a1.getQuestionno());
                anwser=a1.getmatch();
        //t2.setText(anwser+"");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"start lifecycle start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onresume lifecycle start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause lifecycle start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onstop  lifecycle start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"ondestroy  lifecycle start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(score_key,m234);
        outState.putInt(Index_key,k1);

    }
}
