package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.MainActivity;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class CartBill extends AppCompatActivity {

    CartBillAdapter adapter;
    ListView lvCart;
    TextView totalTextview;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_bill);

        ArrayList<CartItem> cartItemArrayList = (ArrayList<CartItem>) getIntent().getSerializableExtra("CartList");

        for (CartItem cartItem: cartItemArrayList) {
            total += cartItem.getPrice();
        }

        adapter = new CartBillAdapter(this.getApplicationContext(), cartItemArrayList, R.layout.cart_bill_row);
        lvCart = findViewById(R.id.cart_bill_listView);
        totalTextview = findViewById(R.id.cart_bill_total);

        String strTotal = Support.CurrencyFormat(total);
        totalTextview.setText(strTotal);
        lvCart.setAdapter(adapter);

        findViewById(R.id.cart_btn_return_home).setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}