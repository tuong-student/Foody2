package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Menu;

public class MenuItem {
    int Id;
    private String storeName;
    private String name;
    private int price;
    private String description;
    private String photoURL;

    public MenuItem(int id, String storeName, String name, int price, String description, String photoURL) {
        Id = id;
        this.storeName = storeName;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photoURL = photoURL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
