package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.User;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class UserAccountInfo extends AppCompatActivity {
    TextView user_name, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account_info);

        user_name = findViewById(R.id.txt_user_name);
        password = findViewById(R.id.txt_email);

        user_name.setText(Support.user.name);
        password.setText(Support.user.password);

        findViewById(R.id.returnBtn).setOnClickListener(view -> {
            finish();
        });
    }
}
