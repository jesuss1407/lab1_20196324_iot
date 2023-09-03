package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private PopupWindow popupWindow;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        myDialog = new Dialog(this);
        getSupportActionBar().setTitle("TeleAhorcado");

        Button play = findViewById(R.id.button2);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        // Obtener el TextView donde mostrar la palabra oculta
        TextView textPalabraOculta = findViewById(R.id.textView2);

        // Tu lista de palabras (puedes declararla aquí o en otro lugar)
        String[] listaDePalabras = {"REDES", "PROPA", "PUCP", "TELITO", "TELECO","BATI"};

        // Elegir una palabra al azar

        Random random = new Random();
        int indice = random.nextInt(listaDePalabras.length);
        String palabraElegida = listaDePalabras[indice];

        // Crear una cadena con guiones bajos en lugar de letras
        StringBuilder palabraConGuiones = new StringBuilder();
        for (int i = 0; i < palabraElegida.length(); i++) {
            palabraConGuiones.append("_ ");
        }

        // Mostrar la palabra oculta con guiones bajos en el TextView
        textPalabraOculta.setText(palabraConGuiones.toString());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.statistics_menu,menu);
        return true;
    }

    public void statsBtn(MenuItem menuItem){
        Toast.makeText(this, "btn ADD presiondddddddddddddddddddddddado", Toast.LENGTH_SHORT).show();
        TextView txtclose;
        myDialog.setContentView(R.layout.popup_layout);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        myDialog.show();
    }



}



