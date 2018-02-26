package com.example.visitante.playerselector;

import android.app.Activity;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.validation.Validator;

/**
 * Created by Visitante on 26/02/2018.
 */

public class CustomAdapter extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Jugador> values;

    public CustomAdapter(Activity activity, ArrayList<Jugador> values){
        this.activity = activity;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.row, null);
        }

        Jugador player = values.get(i);

        TextView nombre = (TextView) v.findViewById(R.id.nombretv);
        nombre.setText(player.Nombre);

        TextView apellido = (TextView) v.findViewById(R.id.apellidotv);
        apellido.setText(player.Apellido);

        TextView position = (TextView) v.findViewById(R.id.posiciontv);
        position.setText(player.Posicion);

        TextView selected = (TextView) v.findViewById(R.id.selectv);
        selected.setText(player.seleccionado? "Sí":"No");

        Button edit = v.findViewById(R.id.button);
        edit.setText("Editar");
        edit.setTag(i);
        edit.setFocusable(false);
        edit.setFocusableInTouchMode(false);
        return v;
    }
}
