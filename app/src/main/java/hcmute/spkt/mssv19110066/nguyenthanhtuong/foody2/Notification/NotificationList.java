package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Notification;

public class NotificationList {
    private int IdNoti;
    private String NotiName;
    private String NotiContent;
    private String NotiDate;
    public NotificationList(int idNoti, String Notiname, String Noticontent, String Notidate){
        IdNoti = idNoti;
        NotiName = Notiname;
        NotiContent = Noticontent;
        NotiDate = Notidate;
    }

    public int getIdNoti() {
        return IdNoti;
    }

    public void setIdNoti(int idNoti) {
        IdNoti = idNoti;
    }

    public String getNotiName() {
        return NotiName;
    }

    public void setNotiName(String notiName) {
        NotiName = notiName;
    }

    public String getNotiContent() {
        return NotiContent;
    }

    public void setNotiContent(String notiContent) {
        NotiContent = notiContent;
    }

    public String getNotiDate() {
        return NotiDate;
    }

    public void setNotiDate(String notiDate) {
        NotiDate = notiDate;
    }
}
