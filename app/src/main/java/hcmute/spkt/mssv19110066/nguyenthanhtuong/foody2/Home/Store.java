package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Database;

public class Store {
    private int Id;
    String name;
    String url;
    String locationName;
    String photoUrl;

    public Store(int Id, String title, String url, String photoUrl, String locationName) {
        this.Id = Id;
        this.locationName = locationName;
        this.name = title;
        this.photoUrl = photoUrl;
        this.url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
