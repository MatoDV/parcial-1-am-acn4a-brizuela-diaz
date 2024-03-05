package com.example.parcial_1_am_acn4a_brizuela_diaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

        ImageButton btnInstagram = findViewById(R.id.img_instagram3);
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
        ImageButton btnFacebook = findViewById(R.id.img_facebook3);
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
        ImageButton btnGmail = findViewById(R.id.img_gmail3);
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

        Button MostrarMasButton = findViewById(R.id.btn_masinfo3);
        TextView TextoEscondido = findViewById(R.id.txt_escondido3);

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
        Button botonIrSegundaPagina = findViewById(R.id.btn_nextpag2);
        botonIrSegundaPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaPagina.class);
                startActivity(intent);
            }
        });
    }




}