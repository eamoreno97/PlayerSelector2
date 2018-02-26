package com.example.visitante.playerselector;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserID extends AppCompatActivity {

    TextView Nombre, Apellido, Posicion, Edad, Seleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_id);

        Intent intent = getIntent();
        Jugador h = (Jugador) intent.getSerializableExtra("Player");

        Nombre = (TextView)findViewById(R.id.nombretv);
        Apellido = (TextView)findViewById(R.id.apellidotv);
        Posicion = (TextView)findViewById(R.id.posiciontv);
        Edad = (TextView)findViewById(R.id.edad);
        Seleccionado = (TextView)findViewById(R.id.selectv);

        Nombre.setText(h.Nombre);
        Apellido.setText(h.Apellido);
        Posicion.setText(h.Posicion);
        Edad.setText(h.edad+"");
        Seleccionado.setText(h.seleccionado? "Sí" : "No");

    }
}
