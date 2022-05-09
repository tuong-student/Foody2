package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.User;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class UserCartView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_cart);

        findViewById(R.id.returnBtn).setOnClickListener(view -> {
            finish();
        });
    }
}
