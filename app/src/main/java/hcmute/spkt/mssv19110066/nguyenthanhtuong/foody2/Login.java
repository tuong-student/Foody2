package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText inputEmail, inputPassword;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);

        btnLogin.setOnClickListener(view -> {
            if(!inputEmail.equals(email)) {
                //TODO: Show alert

                return;
            }
            if(!inputPassword.equals(password)){
                //TODO: Show alert

                return;
            }
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}