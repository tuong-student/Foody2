package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import android.database.Cursor;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Database;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.MainActivity;

public class CartDB {
    Database CartDatabase;

    public CartDB() {
        //tạo database cho Cart
        CartDatabase = new Database(MainActivity.Ins.getApplicationContext(), "Cart.sqlite", null, 1);

        //tạo bảng cho noti
        CartDatabase.QueryData("CREATE TABLE IF NOT EXISTS Cart(Id INTEGER PRIMARY KEY AUTOINCREMENT, imgUrl VARCHAR(400), foodName VARCHAR(200), foodPrice INTEGER, foodQuantity INTEGER)");

    }

    public void AddToCart(CartItem item){
        //TODO: Viết hàm add item vào DB
        //Item add vào DB không được trùng nhau
        boolean hasItem = CartDatabase.GetData("SELECT foodName FROM Cart WHERE foodName = ?", new String[] {item.getFoodName()}).moveToNext();
        if(hasItem) {
            return;
        }
        CartDatabase.QueryData("INSERT INTO Cart VALUES(?,?,?,?,?)",new Object[] {item.getId(), item.getPhotoURL(),item.getFoodName(),item.getPrice(),item.getQuantity()});
    }

    public void DeleteToCart(String id){
        //TODO: Viết hàm xóa item khỏi DB
        CartDatabase.QueryData("DELETE FROM Cart WHERE Id = ?",new String[] {id});
    }

    public void DeleteAll(){
        //TODO: Viết hàm xóa item khỏi DB
        CartDatabase.QueryData("DELETE FROM Cart");
    }

    public CartItem GetItem(int Id){
        //TODO: Lấy dữ liệu trong sql dựa vào Id sau đó gán dữ liệu vào item

        Cursor cursor = CartDatabase.GetData("SELECT * FROM Cart WHERE Id = ?", new String[] {String.valueOf(Id)});
        cursor.moveToNext();
        int id = cursor.getInt(0);
        String photoURL = cursor.getString(1);
        String foodName = cursor.getString(2);
        int price = cursor.getInt(3);
        int Quantity = cursor.getInt(4);
        return new CartItem(id, photoURL,foodName,price,Quantity);
    }
}
