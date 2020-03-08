package com.example.catchthecartman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartActivity extends AppCompatActivity {
    Button startButton,aboutButton;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startButton=findViewById(R.id.startButton);
        aboutButton = findViewById(R.id.aboutButton);
    }
    public void startClick(View view){
        intent =new Intent(this,GameActivity.class);
        startActivity(intent);
    }
    public void aboutClick(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("About ");
        alert.setMessage("\n\nYou have 10 seconds after pressing the Start Button. Press as much as you can on Cartman in ten seconds. Have fun !\n\n");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                intent = getIntent();
                startActivity(intent);
            }
        });
        alert.show();
    }

}
