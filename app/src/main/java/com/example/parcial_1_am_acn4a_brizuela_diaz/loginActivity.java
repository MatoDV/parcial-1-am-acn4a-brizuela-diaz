package com.example.parcial_1_am_acn4a_brizuela_diaz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    EditText mEditTextUser;
    EditText mEditTextPass;
    Button mBtnAcceso;
    Button mCerrarSesion;
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
        setContentView(R.layout.activity_login);


        mEditTextUser = findViewById(R.id.userTextView);
        mEditTextPass = findViewById(R.id.passEditText);
        mBtnAcceso = findViewById(R.id.BtnAcceso);
        mCerrarSesion = findViewById(R.id.btnCerrarSesion);
        mTextViewRespuesta = findViewById(R.id.TextViewRespuesta);
        mTextViewIrReg = findViewById(R.id.TextViewRespuesta);

        mAuth = FirebaseAuth.getInstance();

        mTextViewIrReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irRegistro();
            }

            private void irRegistro(){
                Intent intent = new Intent(loginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        mCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut(); //Cerramos sesión
                irLogin();
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





}

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuario = mAuth.getCurrentUser();
        if(usuario != null){
            irLogin();
        }
    }

    private void irLogin() {
        Intent intent = new Intent(loginActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }
    }
