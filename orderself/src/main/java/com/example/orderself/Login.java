package com.example.orderself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderself.entity.Position;

public class Login extends AppCompatActivity {
    private String userName;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = ((EditText) findViewById(R.id.userName)).getText().toString();
                password = ((EditText) findViewById(R.id.password)).getText().toString();
                    if ("12345".equals(password)&&"12345".equals(userName)) {
                        startActivity(new Intent(Login.this, PositonActivity.class));
                        Login.this.finish();
                    } else {
                        Toast.makeText(Login.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }
}
