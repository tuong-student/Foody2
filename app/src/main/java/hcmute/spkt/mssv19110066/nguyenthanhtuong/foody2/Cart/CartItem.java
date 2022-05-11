package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int Id;
    private String photoURL;
    private String foodName;
    private int Price;
    private int quantity;

    public CartItem(int id, String photoURL, String foodName, int price, int quantity) {
        this.Id = id;
        this.photoURL = photoURL;
        this.foodName = foodName;
        this.Price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
