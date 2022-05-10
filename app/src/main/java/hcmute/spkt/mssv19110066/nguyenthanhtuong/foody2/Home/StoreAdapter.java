package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private final Home_fragment context;
    private final List<Store> storeList;

    public StoreAdapter(Home_fragment context, List<Store> storeList) {
        this.context = context;
        this.storeList = storeList;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.store_block, parent, false );

        return new MyViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Store store = storeList.get( position );
        holder.name.setText( store.getName() );
        holder.address.setText(store.getLocationName());

        Glide.with( context ).load( store.getPhotoUrl() ).into( holder.image );

        //Set Click even
        holder.store_block_layout.setOnClickListener(view -> {
            context.SendData(store.getId(), store.getName());
        });
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, address;
        public ImageView image;
        public LinearLayout store_block_layout;

        public MyViewHolder(View view) {
            super( view );
            name = view.findViewById( R.id.tv_store_name );
            address = view.findViewById(R.id.tv_store_address);
            image = view.findViewById( R.id.iv_store_image );
            store_block_layout = view.findViewById(R.id.store_block_layout);
        }
    }
}
