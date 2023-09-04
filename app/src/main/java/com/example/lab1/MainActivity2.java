package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private PopupWindow popupWindow;
    Dialog myDialog;

    private String palabraEscogida = "";
    private TextView[] lineas;
    private ImageView[] partes;
    private int errores = 0;
    private List<String> palabras = Arrays.asList("REDES", "PROPA", "PUCP", "TELITO", "TELECO", "BATI");
    private List<String> palabras2 = Arrays.asList("TELITO", "TELECO");
    private Button[] botonesTeclado;
    private int tiempoTranscurrido = 0;
    private Handler handler = new Handler();
    private boolean juegoAcabado = false;
    private boolean juegoEnCurso = true;
    private ArrayList<String> estadisticas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        myDialog = new Dialog(this);
        getSupportActionBar().setTitle("TeleAhorcado");

        //Button play = findViewById(R.id.button2);
        //play.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View view) {
               // Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                //startActivity(intent);
          //  }
        //});
        botonesTeclado = new Button[]{
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9),
                findViewById(R.id.button10),
                findViewById(R.id.button11),
                findViewById(R.id.button12),
                findViewById(R.id.button13),
                findViewById(R.id.button14),
                findViewById(R.id.button15),
                findViewById(R.id.button16),
                findViewById(R.id.button17),
                findViewById(R.id.button18),
                findViewById(R.id.button19),
                findViewById(R.id.button20),
                findViewById(R.id.button21),
                findViewById(R.id.button22),
                findViewById(R.id.button23),
                findViewById(R.id.button24),
                findViewById(R.id.button25),
                findViewById(R.id.button26),
                findViewById(R.id.button27),
                findViewById(R.id.button28),

        };
        final Random random = new Random();
        errores = 0;
        int randomIndex = random.nextInt(palabras2.size());
        palabraEscogida = palabras2.get(randomIndex);
        //contador de tiempo
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                tiempoTranscurrido++;
                TextView textViewTiempo = findViewById(R.id.resultados);
                textViewTiempo.setText("Tiempo: " + tiempoTranscurrido + " segundos");

                handler.postDelayed(this, 1000);
            }
        }, 1000);


        final ImageView cabeza = findViewById(R.id.cabeza);
        final ImageView cuerpo = findViewById(R.id.cuerpo);
        final ImageView piernaizquierda = findViewById(R.id.piernaizquierda);
        final ImageView brazoizquierdo = findViewById(R.id.brazoizquierdo);
        final ImageView brazoderecho = findViewById(R.id.brazoderecho);
        final ImageView piernaderecha = findViewById(R.id.piernaderecha);

        partes = new ImageView[]{cabeza, cuerpo, piernaizquierda, brazoizquierdo, brazoderecho, piernaderecha};

        final TextView resultados = findViewById(R.id.resultados);
        final TextView linea1 = findViewById(R.id.linea1);
        final TextView linea2 = findViewById(R.id.linea2);
        final TextView linea3 = findViewById(R.id.linea3);
        final TextView linea4 = findViewById(R.id.linea4);
        final TextView linea5 = findViewById(R.id.linea5);
        final TextView linea6 = findViewById(R.id.linea6);

        lineas = new TextView[]{linea1, linea2, linea3, linea4, linea5, linea6};

        final Button nuevoJuego = findViewById(R.id.button2);
        nuevoJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random2 = new Random();
                if (juegoEnCurso && !juegoAcabado) {
                    estadisticas.add("Canceló");

                }
                // se reinician los valores
                juegoAcabado = false;
                juegoEnCurso = true;
                tiempoTranscurrido=0;
                errores = 0;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tiempoTranscurrido++;
                        TextView textViewTiempo = findViewById(R.id.resultados);
                        textViewTiempo.setText("Tiempo: " + tiempoTranscurrido + " segundos");
                        handler.postDelayed(this, 1000);
                    }
                }, 1000);

                habilitarBotonesTeclado();
                for (ImageView parte : partes) {
                    parte.setVisibility(View.INVISIBLE);
                }

                int randomIndex = random2.nextInt(palabras.size());
                palabraEscogida = palabras.get(randomIndex);

                for (int i = 0; i < lineas.length; i++) {
                    if (i < palabraEscogida.length()) {
                        lineas[i].setVisibility(View.VISIBLE);
                        lineas[i].setText("_");
                    } else {
                        lineas[i].setVisibility(View.INVISIBLE);
                    }
                }
                resultados.setText("");
            }

            private void habilitarBotonesTeclado() {
                for (Button boton : botonesTeclado) {
                    boton.setEnabled(true);
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.statistics_menu,menu);
        return true;
    }

    public void statsBtn(MenuItem menuItem){
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

        LinearLayout listaStats = myDialog.findViewById(R.id.statistics); // Obtener referencia al LinearLayout
        listaStats.removeAllViews(); // Eliminar las vistas previas

        // Añadir estadísticas
        int i = 1;
        for (String stat : estadisticas) {

            TextView newStat = new TextView(this);
            newStat.setText(i + ". " + stat);
            i++;
            newStat.setTextColor(Color.BLACK);
            newStat.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) newStat.getLayoutParams();
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            newStat.setLayoutParams(layoutParams);
            listaStats.addView(newStat);
        }
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        myDialog.show();
    }



    // letras botones
    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        button.setEnabled(false);
        final TextView resultados = findViewById(R.id.resultados);

        if (!palabraEscogida.isEmpty()) {
            boolean gana = false;
            for (int i = 0; i < palabraEscogida.length(); i++) {
                if (palabraEscogida.charAt(i) == buttonText.charAt(0)) {
                    lineas[i].setText(buttonText);
                    gana = true;
                    button.setEnabled(false);
                }
            }

            if (!gana) {
                partes[errores].setVisibility(View.VISIBLE);
                errores++;
                if (errores >= partes.length) {
                    resultados.setText("Perdiste :(");
                    for (Button boton : botonesTeclado) {
                        boton.setEnabled(false);
                    }
                    juegoAcabado = true;
                    estadisticas.add("Terminó en " + tiempoTranscurrido + " segundos");
                    handler.removeCallbacksAndMessages(null);
                }
            }

            boolean siGana = true;
            for (int i = 0; i < palabraEscogida.length(); i++) {
                if ("_".equals(lineas[i].getText().toString())) {
                    siGana = false;
                    break;
                }
            }

            if (siGana) {
                resultados.setText("¡Ganaste!");
                for (Button boton : botonesTeclado) {
                    boton.setEnabled(false);
                }
                juegoAcabado = true;
                estadisticas.add("Terminó en " + tiempoTranscurrido + " segundos");
                handler.removeCallbacksAndMessages(null);
            }

        }

    }




}



