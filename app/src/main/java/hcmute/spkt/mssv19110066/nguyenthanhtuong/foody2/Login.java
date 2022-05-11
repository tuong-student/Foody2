package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Database LoginDatabase;
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

        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        //tạo database cho Cart
        LoginDatabase = new Database(getApplicationContext(), "Login.sqlite", null, 1);

        //tạo bảng cho noti
        LoginDatabase.QueryData("CREATE TABLE IF NOT EXISTS Login(Id INTEGER PRIMARY KEY AUTOINCREMENT,Username VARCHAR(50),Password VARCHAR(50))");

        // insert data
        //LoginDatabase.QueryData("INSERT INTO Login VALUES(null,'tinhau1204','tinhau12042001')");



        btnLogin.setOnClickListener(view -> {
            if(!checkUsername(inputEmail.getText().toString())) {
                //TODO: Show alert
                inputEmail.setError("invalid email!");

            }
            else if(!checkPassword(inputPassword.getText().toString())){
                //TODO: Show alert
                inputPassword.setError("Password incorrect!");

            }
            else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean checkUsername(String email){
        Cursor cursor = LoginDatabase.GetData("SELECT * FROM Login WHERE Username = ?", new String[] {email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean checkPassword(String password){
        Cursor cursor = LoginDatabase.GetData("SELECT * FROM Login WHERE PassWord = ?", new String[] {password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}