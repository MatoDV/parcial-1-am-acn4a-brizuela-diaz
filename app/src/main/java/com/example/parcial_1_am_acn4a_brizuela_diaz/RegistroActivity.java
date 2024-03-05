package com.example.parcial_1_am_acn4a_brizuela_diaz;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText mEditarUser;

    EditText mEmailReg;
    EditText mEditarPass;
    Button mButtonRegistrar;
    TextView mTextViewRespuesta;

    FirebaseAuth mAuth;

    private String user, email, passReg;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mEditarUser = findViewById(R.id.userTextViewReg);
        mEmailReg = findViewById(R.id.EditTextMail);
        mEditarPass = findViewById(R.id.passEditText);
        mButtonRegistrar = findViewById(R.id.btnRegistro);
        mTextViewRespuesta = findViewById(R.id.TextViewRespuesta);

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            user = mEditarUser.getText().toString().trim();
            email = mEmailReg.getText().toString().trim();
            passReg = mEditarPass.getText().toString().trim();

                if (user.isEmpty() || email.isEmpty() || passReg.isEmpty()) {
                    mTextViewRespuesta.setText("Ingrese valores");
                    mTextViewRespuesta.setTextColor(Color.RED);

                }else if(!user.isEmpty() && !email.isEmpty() && !passReg.isEmpty()){
                    //verificamos mail
                    if(emailValido(email)){
                        if(passReg.length()>6){
                            mAuth.createUserWithEmailAndPassword(email, passReg).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        mTextViewRespuesta.setText("Se creo la cuenta correctamente");
                                        mTextViewRespuesta.setTextColor(Color.BLUE);
                                    }else{
                                        mTextViewRespuesta.setText("La cuenta ya existe");
                                        mTextViewRespuesta.setTextColor(Color.RED);
                                    }
                                }
                            });

                        }else{
                            mTextViewRespuesta.setText("Ingrese contraseña mayor a 6 caracteres");
                            mTextViewRespuesta.setTextColor(Color.RED);
                        }

                    }else{
                        mTextViewRespuesta.setText("Ingrese Email válido");
                        mTextViewRespuesta.setTextColor(Color.RED);
                    }

                }

            }
        });

    }

    private boolean emailValido(String email){
        String expression ="[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
