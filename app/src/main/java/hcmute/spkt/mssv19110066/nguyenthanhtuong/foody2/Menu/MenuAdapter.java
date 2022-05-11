package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartItem;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartView;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder>{

    private final Menu_fragment context;
    private final List<MenuItem> menuItemList;

    public MenuAdapter(Menu_fragment context, List<MenuItem> menuItemList) {
        this.context = context;
        this.menuItemList = menuItemList;
    }

    @Override
    @NonNull
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.menu_row, parent, false );

        return new MenuAdapter.MyViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MyViewHolder holder, final int position) {
        final MenuItem menuItem = menuItemList.get( position );
        holder.name.setText( menuItem.getName() );
        holder.price.setText(Support.CurrencyFormat(menuItem.getPrice()));

        Glide.with( context ).load( menuItem.getPhotoURL() ).into( holder.image );

        holder.btn_addToCart.setOnClickListener(view -> {
            CartItem item = new CartItem(menuItem.getId(), menuItem.getPhotoURL(), menuItem.getName(), menuItem.getPrice(), 1);
            Support.cartDB.AddToCart(item);
            Toast.makeText(context.getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView image;
        public ImageButton btn_addToCart;

        public MyViewHolder(View view) {
            super( view );
            name = view.findViewById( R.id.menu_row_foodName );
            price = view.findViewById(R.id.menu_row_price);
            image = view.findViewById( R.id.menu_row_image );
            btn_addToCart = view.findViewById(R.id.menu_row_btn_addToCart);
        }
    }
}
