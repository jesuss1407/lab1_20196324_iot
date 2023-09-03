package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView colorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorTextView = findViewById(R.id.textView);
        registerForContextMenu(colorTextView);

        Button play = findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.color_menu,menu);

    }

    public void rojo(MenuItem menuItem){
        colorTextView.setTextColor(Color.RED);
        Toast.makeText(this, "Rojo", Toast.LENGTH_SHORT).show();
    }
    public void azul(MenuItem menuItem){
        colorTextView.setTextColor(Color.BLUE);
        Toast.makeText(this, "Azul", Toast.LENGTH_SHORT).show();
    }
    public void amarillo(MenuItem menuItem){
        colorTextView.setTextColor(Color.YELLOW);
        Toast.makeText(this, "Amarillo", Toast.LENGTH_SHORT).show();
    }
}