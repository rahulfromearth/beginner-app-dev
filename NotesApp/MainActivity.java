package com.example.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name,password,confirmPassword;
    private Button button;
    private String nameText,passwordText,confirmPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm);
        button = findViewById(R.id.submit);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView t = findViewById(R.id.passcheck);

                        //block outside
                    nameText = name.getEditableText().toString();
                    passwordText = password.getEditableText().toString();
                    confirmPasswordText = confirmPassword.getEditableText().toString();

                    //if(nameText.isEmpty())
                    /*
                    Log.d("Button","clicked");
                    Log.d("user",nameText);                     // "empty"); debug log
                    Log.d("pass",passwordText);
                    Log.d("confirmPass",confirmPasswordText);*/

                    if(passwordText.length()<8)
                        t.setText("Password cannot be less than 8 characters");


                    else {

                        t.setText("");

                        if (!passwordText.equals(confirmPasswordText)) {
                            Toast.makeText(MainActivity.this, "Not same password", Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, NotesActivity.class);

                            Bundle bundle = new Bundle();
                            bundle.putString("nameText",nameText);

                            intent.putExtras(bundle);
                            intent.putExtra("passwordText",passwordText);

                            startActivity(intent);
                        }
                    }

                    }
                });

    }
}