package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

public class CartItem {
    private int Id;
    private String photoURL;
    private String foodName;
    private float Price;
    private int quantity;

    public CartItem(String photoURL, String foodName, float price, int quantity) {
        this.photoURL = photoURL;
        this.foodName = foodName;
        Price = price;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
