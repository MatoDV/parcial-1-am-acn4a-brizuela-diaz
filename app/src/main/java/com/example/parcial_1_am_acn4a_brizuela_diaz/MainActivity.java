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

    //Componentes

    EditText mEditTextUser;
    EditText mEditTextPass;
    Button mBtnAcceso;
    TextView mTextViewRespuesta;
    TextView mTextViewIrReg;

    //FireBase

    FirebaseAuth mAuth;

    private String user;
    private String pass;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextUser = findViewById(R.id.userTextView);
        mEditTextPass = findViewById(R.id.passEditText);
        mBtnAcceso = findViewById(R.id.BtnAcceso);
        mTextViewRespuesta = findViewById(R.id.TextViewRespuesta);
        mTextViewIrReg = findViewById(R.id.TextViewRespuesta);

        mAuth = FirebaseAuth.getInstance();

        mTextViewIrReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irRegistro();
            }

            private void irRegistro(){
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        mBtnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = mEditTextUser.getText().toString().trim();
                pass = mEditTextPass.getText().toString().trim();

                if(user.isEmpty() || pass.isEmpty()){
                    mTextViewRespuesta.setText("Ingrese el usuario y la contraseña");
                    mTextViewRespuesta.setTextColor(Color.RED);

                }else{
                    if(user != null){
                    mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                mTextViewRespuesta.setText("Iniciamos Sesión");
                                mTextViewRespuesta.setTextColor(Color.BLUE);
                            }else{
                                mTextViewRespuesta.setText("Credenciales invalidas");
                                mTextViewRespuesta.setTextColor(Color.RED);
                            }
                        }
                    });

                    }else{
                        mTextViewRespuesta.setText("usuario no valido");
                        mTextViewRespuesta.setTextColor(Color.RED);
                    }

                }
            }
        });

        protected void onStart() {
            super.onStart();
            FirebaseUser usuario = mAuth.getCurrentUser();
            if(usuario != null){
                irHome();
            }
        }

        private void irHome() {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

            finish();

        }

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