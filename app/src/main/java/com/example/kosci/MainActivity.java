package com.example.kosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewPunkty;
    Button buttonRzuc;
    Button buttonreset;
    TextView textViewGra;

    ImageView[] tablicaObrazow = new ImageView[5];
    Kosc[] kosci = new Kosc[5];

    int wyniki = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPunkty = findViewById(R.id.textViewPunkty);
        textViewGra = findViewById(R.id.textView);
        buttonRzuc = findViewById(R.id.button);
        buttonreset = findViewById(R.id.button2);
        tablicaObrazow[0] = findViewById(R.id.imageView);
        tablicaObrazow[1] = findViewById(R.id.imageView2);
        tablicaObrazow[2] = findViewById(R.id.imageView3);
        tablicaObrazow[3] = findViewById(R.id.imageView4);
        tablicaObrazow[4] = findViewById(R.id.imageView5);

        for (int i = 0; i < kosci.length; i++) {
            kosci[i] = new Kosc();
        }

        buttonRzuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int suma = 0;

                for (int i = 0; i < kosci.length; i++) {
                    kosci[i].wylosujKosc();
                    tablicaObrazow[i].setImageResource(kosci[i].getIdObrazka());
                    suma += kosci[i].getWartosc();
                }

                wyniki += suma;

                textViewPunkty.setText("Wynik tego losowania: " + suma);
                textViewGra.setText("Suma wyniku: " + wyniki);
            }
        });

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < kosci.length; i++) {
                    tablicaObrazow[i].setImageResource(R.drawable.question);
                }
                textViewPunkty.setText("Wynik tego losowania: 0");
                textViewGra.setText("Suma wyniku: 0");
                wyniki = 0;
            }
        });
    }
}
