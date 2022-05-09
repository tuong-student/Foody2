package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class CartView extends AppCompatActivity {
    CartAdapter adapter;
    ArrayList<CartItem> cartItemArrayList;
    ListView lvCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);

        cartItemArrayList = new ArrayList<>();
        adapter = new CartAdapter(getApplicationContext(), R.layout.cart_row, cartItemArrayList);
        lvCart = findViewById(R.id.lvCart);

        //Set data
        //TODO: Mày dựa vào cái này mà thêm dữ liệu vào cartItemArrayList từ DB
        //TODO: ảnh thì tạm thời m lấy link trên mạng rồi thêm vào DB để test, về sau t lấy api để thêm ảnh vào DB
        String photoURL = "https://food.fnr.sndimg.com/content/dam/images/food/products/2022/3/11/rx_goldbelly-clinton-street-diner-zeus-burger.jpg.rend.hgtvcom.406.305.suffix/1647019464547.jpeg";
        cartItemArrayList.add(new CartItem(1, photoURL ,"Fast food", 2, 2));
        photoURL = "https://cdn.tgdd.vn/2021/05/CookRecipe/Avatar/banh-mi-thit-bo-nuong-thumbnail-1.jpg";
        cartItemArrayList.add(new CartItem(1, photoURL ,"Banh Mi", 2, 2));

        lvCart.setAdapter(adapter);

        findViewById(R.id.returnBtn).setOnClickListener(view -> {
            finish();
        });
    }

    //TODO: Tạo thêm 1 hàm LoadData() từ DataBase
    public void LoadData(){

    }
}
