package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class NotificationListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<NotificationList> notiList;

    public NotificationListAdapter (Context context, int layout, List<NotificationList> notiList){
        this.context = context;
        this.layout = layout;
        this.notiList = notiList;

    }

    @Override
    public int getCount() {
        return notiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private static class ViewHolder{
        ImageView imgNoti;
        TextView txtNotiName;
        TextView txtNotiContent;
        TextView txtDate;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgNoti = view.findViewById(R.id.imgNoti);
            holder.txtNotiName = view.findViewById(R.id.notiName);
            holder.txtNotiContent = view.findViewById(R.id.notiContent);
            holder.txtDate = view.findViewById(R.id.notiDate);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        NotificationList notificationList = notiList.get(i);

        holder.txtNotiName.setText(notificationList.getNotiName());
        holder.txtNotiContent.setText(notificationList.getNotiContent());
        holder.txtDate.setText(notificationList.getNotiDate());
        return view;
    }

}
