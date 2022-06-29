package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn1,btn2,btn3,btn4,btn5,submit;
EditText word;
Random rand = new Random();
int x=rand.nextInt(9);
String[] words={"VIDEO","CRANE","QUEEN","SMART","BREST","FIGHT","MIGHT","TIGHT","BRAIN"};
char array[]=new char[5];
String randomWord;
int counter=0;
TextView tries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        submit=findViewById(R.id.submit);
        word=findViewById(R.id.word);
        tries=findViewById(R.id.tries);
        words[x].getChars(0,5,array,0);
        randomWord=words[x];
        btn1.setText(Character.toString(array[3]));
        btn2.setText(Character.toString(array[1]));
        btn3.setText(Character.toString(array[4]));
        btn4.setText(Character.toString(array[2]));
        btn5.setText(Character.toString(array[0]));
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(btn1.getId() == v.getId()){
            word.append(btn1.getText().toString());
            btn1.setEnabled(false);
        }
        if(btn2.getId() == v.getId()){
            word.append(btn2.getText().toString());
            btn2.setEnabled(false);
        }
        if(btn3.getId() == v.getId()){
            word.append(btn3.getText().toString());
            btn3.setEnabled(false);
        }
        if(btn4.getId() == v.getId()){
            word.append(btn4.getText().toString());
            btn4.setEnabled(false);
        }
        if(btn5.getId() == v.getId()){
            word.append(btn5.getText().toString());
            btn5.setEnabled(false);
        }
        if(submit.getId()==v.getId()){
            if(!word.getText().toString().isEmpty()){
                if(randomWord.trim().equals(word.getText().toString().trim()) ){
                    counter++;
                    tries.setText(Integer.toString(counter));
                    reset();

                }else{
                    Toast.makeText(this, "You Lost! The word was "+randomWord, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }else{
                Toast.makeText(this, "Start Clicking!", Toast.LENGTH_SHORT).show();

            }

        }
    }
    public void reset(){
        int x=rand.nextInt(9);
        char array[]=new char[5];
        words[x].getChars(0,5,array,0);
        randomWord=words[x];
        btn1.setText(Character.toString(array[3]));
        btn2.setText(Character.toString(array[1]));
        btn3.setText(Character.toString(array[4]));
        btn4.setText(Character.toString(array[2]));
        btn5.setText(Character.toString(array[0]));
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        word.setText("");

    }

}