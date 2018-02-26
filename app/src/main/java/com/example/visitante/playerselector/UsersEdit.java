package com.example.visitante.playerselector;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class UsersEdit extends AppCompatActivity {

    EditText nameE, lastnameE, positionE, ageE;
    CheckBox selectedE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_edit);

        Intent intent = getIntent();
        Jugador h = (Jugador) intent.getSerializableExtra("Player");

        nameE = (EditText)findViewById(R.id.name);
        lastnameE = (EditText)findViewById(R.id.lastname);
        positionE = (EditText)findViewById(R.id.position);
        ageE = (EditText)findViewById(R.id.age);
        selectedE = (CheckBox)findViewById(R.id.selected);

        nameE.setText(h.Nombre);
        lastnameE.setText(h.Apellido);
        positionE.setText(h.Posicion);
        ageE.setText(h.edad+"");
        selectedE.setChecked(h.seleccionado);
    }

    public Jugador getNewPlayer(){
        String name = nameE.getText().toString();
        String lastname = lastnameE.getText().toString();
        String position = positionE.getText().toString();
        int age = Integer.parseInt(ageE.getText().toString());
        boolean selected = selectedE.isChecked();

        return new Jugador(name, lastname, position, selected, age);
    }

    public void onClickSave(View view) {
        Intent intent = new Intent();
        Jugador newPlayer = getNewPlayer();
        intent.putExtra("Jugador",newPlayer);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
