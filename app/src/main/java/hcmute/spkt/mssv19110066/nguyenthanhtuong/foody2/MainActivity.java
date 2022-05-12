package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartDB;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartView;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home.Home_fragment;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Notification.Notification_fragment;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.User.User_fragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    public static MainActivity Ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Ins == null) {
            Ins = this;
        }

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_container);

        //region Set navigation click even
        navigationView.setOnNavigationItemSelectedListener(mOnClickListener);

        findViewById(R.id.shopping_cart).setOnClickListener(view -> {
            Intent intent2 = new Intent(this, CartView.class);
            startActivity(intent2);
        });
        findViewById(R.id.btn_login).setOnClickListener(view -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });
        //endregion

        if (Support.cartDB == null) {
            Support.cartDB = new CartDB();
            Support.cartDB.DeleteAll();
        }
        //Default fragment
        replaceFragment(new Home_fragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnClickListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navi_notify:
                    replaceFragment(new Notification_fragment());
                    break;
                case R.id.navi_user:
                    if (Support.user == null) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        break;
                    }
                    replaceFragment(new User_fragment());
                    break;
                default:
                    replaceFragment(new Home_fragment());
                    break;
            }
            return false;
        }
    };

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame_layout, fragment);
        transaction.commit();
    }
}