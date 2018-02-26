package com.example.visitante.playerselector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    public ArrayList<Jugador> jugadores;
    int jugador_edit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugadores = new ArrayList<Jugador>();
        jugadores.add(new Jugador("Teofilo","Gutierrez","Delantero",true,25));
        jugadores.add(new Jugador("Cristiano","Ronaldo","Delantero",true,24));
        jugadores.add(new Jugador("Lionel","Messi","Volante",false,24));

        lv = findViewById(R.id.playerList);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        CustomAdapter customAdapter = new CustomAdapter(this,jugadores);
        lv.setAdapter(customAdapter);
        final Context con = lv.getContext();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(con,UserID.class);
                x.putExtra("Jugador",jugadores.get(i));
                startActivityForResult(x,2);
            }
        });
    }

    public void onClickEdit(View view) {
        Intent i = new Intent(this, UsersEdit.class);
        jugador_edit = (Integer)view.getTag();
        i.putExtra("Player", jugadores.get(jugador_edit));
        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Jugador newPlayer = (Jugador) data.getSerializableExtra("Jugador");
            jugadores.set(jugador_edit, newPlayer);
            CustomAdapter adapter = new CustomAdapter(this, jugadores);
            lv.setAdapter(adapter);
        }
    }
}
