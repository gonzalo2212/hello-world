package com.example.android.anotadortruco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int scoreNosotros = 0, scoreEllos = 0;
    public boolean suma = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void updateScreen(char team, int score){

        if(suma) {
            if (team == 'A') scoreNosotros += score;
            else scoreEllos += score;
        } else {
            if (team == 'A' && scoreNosotros > 0 && score <= scoreNosotros) scoreNosotros -= score;
            else if(scoreEllos > 0 && score <= scoreEllos) scoreEllos -= score;
        }

        TextView nosotrosView = findViewById(R.id.nosotros_score);
        nosotrosView.setText(String.valueOf(scoreNosotros));
        TextView ellosView = findViewById(R.id.ellos_score);
        ellosView.setText(String.valueOf(scoreEllos));

        if(scoreNosotros > 29 || scoreEllos > 29){
            String ganador;
            if(scoreNosotros > 29) ganador = "Ganamos\nNosotros";
            else ganador = "Ganaron\nEllos";
            TextView messageView = findViewById(R.id.message_ganador);
            messageView.setText(ganador);
            messageView.setBackgroundColor(0xc8008477);
        }
    }

    public void cambio(View v){
        Button signo = findViewById(R.id.signo);

        if (suma) {
            suma = false;
            signo.setText("-");
        }
        else {
            suma = true;
            signo.setText("+");
        }
    }

    public void reiniciar(View v){
        scoreEllos = 0;
        scoreNosotros = 0;
        updateScreen('A',0);
        TextView messageView = (TextView) findViewById(R.id.message_ganador);
        messageView.setText("");
        messageView.setBackgroundColor(0x00FFFFFF);
    }

    public void informar(View V){
        Toast.makeText(this,"Creado por:\nGonzalo Vargas",Toast.LENGTH_LONG).show();
    }

    public void cincoPuntos(View v){
        updateScreen('A',5);
    }
    public void cincoPuntosB(View v){
        updateScreen('B',5);
    }
    public void tresPuntos(View v){
        updateScreen('A',3);
    }
    public void tresPuntosB(View v){
        updateScreen('B',3);
    }
    public void unPunto(View v){
        updateScreen('A',1);
    }
    public void unPuntoB(View v){
        updateScreen('B',1);
    }
}
