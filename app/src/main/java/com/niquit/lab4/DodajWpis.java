package com.niquit.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {

    public void wyslij (View view)
    {
//        EditText kontrolka = (EditText)findViewById(R.id.editText); String pole = kontrolka.getText().toString();
//        Intent intencja = new Intent();
//        intencja.putExtra("wpis", pole); setResult(RESULT_OK, intencja); finish();

        EditText kolor = (EditText) findViewById(R.id.kolor);
        EditText wielkosc = (EditText) findViewById(R.id.wielkosc);
        EditText opis = (EditText) findViewById(R.id.opis);
        Spinner gatunek = (Spinner) findViewById(R.id.gatunek);

        Animal zwierze = new Animal(gatunek.getSelectedItem().toString(), kolor.getText().toString(), Float.valueOf(wielkosc.getText().toString()), opis.getText().toString());

        Intent intencja = new Intent();
        intencja.putExtra("nowy", zwierze);
        setResult(RESULT_OK, intencja);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);

        ArrayAdapter gatunki = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] {"Pies", "Kot", "Rybki"});
        Spinner gatunek = (Spinner) findViewById(R.id.gatunek);
        gatunek.setAdapter(gatunki);
    }
}
