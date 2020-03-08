package com.example.catchthecartman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    TextView scoreText;
    SharedPreferences sharedPreferences;
    int highScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        scoreText = findViewById(R.id.scoreText);

        score =getIntent().getExtras().getInt("score");

        sharedPreferences = this.getSharedPreferences("com.example.catchthecartman",Context.MODE_PRIVATE);

        highScore=sharedPreferences.getInt("highScore",0);

        if (score>=highScore){
            sharedPreferences.edit().putInt("highScore",score).apply();
            highScore=sharedPreferences.getInt("highScore",0);
        }

        scoreText.setText("High Score : "+highScore+"\nYour Score : "+score);
    }
    public void restartClick(View view){
        Intent intent = new Intent(FinishActivity.this,GameActivity.class);
        startActivity(intent);
    }
}
