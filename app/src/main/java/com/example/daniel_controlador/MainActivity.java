package com.example.daniel_controlador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b1, b2, b3;
    private Button start;

    private int counter = 0;

    private boolean iniciar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();


    }
    private void init(){
        b1 = findViewById(R.id.BombillaVerde);
        b2 = findViewById(R.id.BombillaAmarilla);
        b3 = findViewById(R.id.BombillaRoja);
        start = findViewById(R.id.btnIniciar);

        b1.setBackgroundColor(getResources().getColor(R.color.gris));
        b2.setBackgroundColor(getResources().getColor(R.color.gris));
        b3.setBackgroundColor(getResources().getColor(R.color.gris));
    }

    private void setColorCounter(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (iniciar){
                    counter++;
                    switch(counter){
                        case 1:
                            b1.setBackgroundColor(getResources().getColor(R.color.verde));
                            b2.setBackgroundColor(getResources().getColor(R.color.gris));
                            b3.setBackgroundColor(getResources().getColor(R.color.gris));
                            break;
                        case 2:
                            b1.setBackgroundColor(getResources().getColor(R.color.gris));
                            b2.setBackgroundColor(getResources().getColor(R.color.amarillo));
                            b3.setBackgroundColor(getResources().getColor(R.color.gris));
                            break;
                        case 3:
                            b1.setBackgroundColor(getResources().getColor(R.color.gris));
                            b2.setBackgroundColor(getResources().getColor(R.color.gris));
                            b3.setBackgroundColor(getResources().getColor(R.color.rojo));
                            counter = 0;
                            break;

                    } try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void start(View view){
        if(iniciar){
            iniciar = false;
            counter = 0;
            start.setText("Iniciar");
            b1.setBackgroundColor(getResources().getColor(R.color.gris));
            b2.setBackgroundColor(getResources().getColor(R.color.gris));
            b3.setBackgroundColor(getResources().getColor(R.color.gris));
        }else {
            iniciar = true;
            start.setText("Iniciar");
        }

        setColorCounter();
    }
}