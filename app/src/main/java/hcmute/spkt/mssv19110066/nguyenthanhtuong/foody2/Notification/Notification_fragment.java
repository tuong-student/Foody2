package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Notification;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Database;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class Notification_fragment extends Fragment {

    Database notificationDatabase;
    ListView lvNotification;
    ArrayList<NotificationList> arrayNoti;
    NotificationListAdapter notiAdapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_notification_fragment, container, false);

        lvNotification = (ListView) view.findViewById(R.id.notificationList);
        arrayNoti = new ArrayList<>();
        notiAdapter = new NotificationListAdapter(this.getContext(), R.layout.notification_row, arrayNoti);
        lvNotification.setAdapter(notiAdapter);

//        //tạo database cho noti
        notificationDatabase = new Database(this.getContext(),"Notification.sqlite", null, 1);
//
//        //tạo bảng cho noti
        notificationDatabase.QueryData("CREATE TABLE IF NOT EXISTS Notification(Id INTEGER PRIMARY KEY AUTOINCREMENT, NotiName VARCHAR(200), NotiContent VARCHAR(200), NotiDate VARCHAR(200))");
//
//        // insert data
        notificationDatabase.QueryData("INSERT INTO Notification VALUES(null, 'GIẢM GIÁ', 'chúc mừng quý khách nhận được 50k off', '04/05/2022')");

        //select data
        Cursor dataNoti = notificationDatabase.GetData("SELECT * FROM Notification");
        while (dataNoti.moveToNext()){
            String name = dataNoti.getString(1);
            int id = dataNoti.getInt(0);
            String content = dataNoti.getString(2);
            String date = dataNoti.getString(3);
            arrayNoti.add(new NotificationList(id, name, content, date));
        }

        return view;
    }
}