package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Database;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.MainActivity;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class CartView extends AppCompatActivity {
    Database CartDatabase;
    CartAdapter adapter;
    ArrayList<CartItem> cartItemArrayList;
    ListView lvCart;
    public static CartItem item;
    public static CartView ins;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);
        if(ins == null){ins = this;}

        cartItemArrayList = new ArrayList<>();
        adapter = new CartAdapter(this, R.layout.cart_row, cartItemArrayList);
        lvCart = (ListView) findViewById(R.id.cart_lvCart);

        //tạo database cho Cart
        CartDatabase = new Database(getApplicationContext(), "Cart.sqlite", null, 1);

        // insert data
//        CartDatabase.QueryData("INSERT INTO Cart VALUES(null,'https://cdn.tgdd.vn/2020/06/CookProductThumb/Untitled-1-620x620.jpg','Cháo Lòng','30000đ',1)");

        //Set data
        //TODO: Mày dựa vào cái này mà thêm dữ liệu vào cartItemArrayList từ DB
        //TODO: ảnh thì tạm thời m lấy link trên mạng rồi thêm vào DB để test, về sau t lấy api để thêm ảnh vào DB
        LoadData();

        lvCart.setAdapter(adapter);

        findViewById(R.id.returnBtn).setOnClickListener(view -> {
            finish();
        });

        findViewById(R.id.cart_btn_purchase).setOnClickListener(view -> {
            Intent intent = new Intent(this, CartBill.class);
            intent.putExtra("CartList", (Serializable) cartItemArrayList);

            startActivity(intent);
        });
    }

    //TODO: Tạo thêm 1 hàm LoadData() từ DataBase
    public void LoadData () {
        Cursor dataCart = CartDatabase.GetData("SELECT * FROM Cart");
        cartItemArrayList.clear();
        while (dataCart.moveToNext()) {
            int id = dataCart.getInt(0);
            String photoURL = dataCart.getString(1);
            String foodName = dataCart.getString(2);
            int price = dataCart.getInt(3);
            int Quantity = dataCart.getInt(4);
            cartItemArrayList.add(new CartItem(id, photoURL, foodName, price, Quantity));

        }
        adapter.notifyDataSetChanged();
    }
}
