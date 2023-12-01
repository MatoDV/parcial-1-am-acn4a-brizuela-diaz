package com.example.parcial_1_am_acn4a_brizuela_diaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SegundaPagina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pagina);
        ImageButton btnInstagram = findViewById(R.id.img_instagram2);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ImageButtonClick", "Instagram button clicked");
                String url = "https://www.instagram.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.android.chrome"); // Paquete de Chrome
                startActivity(intent);

            }
        });
        ImageButton btnFacebook = findViewById(R.id.img_facebook2);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ImageButtonClick", "Facebook button clicked");
                String url = "https://www.facebook.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.android.chrome"); // Paquete de Chrome
                startActivity(intent);

            }
        });
        ImageButton btnGmail = findViewById(R.id.img_gmail2);
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ImageButtonClick", "Gmail button clicked");
                String url = "https://mail.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage("com.android.chrome"); // Paquete de Chrome
                startActivity(intent);

            }
        });

        Button MostrarMasButton = findViewById(R.id.btn_masinfo2);
        TextView TextoEscondido = findViewById(R.id.txt_escondido2);

        MostrarMasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambia la visibilidad del TextView para mostrar más información
                if (TextoEscondido.getVisibility() == View.VISIBLE) {
                    TextoEscondido.setVisibility(View.GONE); // Si es visible, lo oculta
                    MostrarMasButton.setText("Mas info");
                } else {
                    TextoEscondido.setVisibility(View.VISIBLE); // Si está oculto, lo muestra
                    MostrarMasButton.setText("Menos info");
                }
            }
        });

        Button botonVolver = findViewById(R.id.btn_prepag);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaPagina.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}