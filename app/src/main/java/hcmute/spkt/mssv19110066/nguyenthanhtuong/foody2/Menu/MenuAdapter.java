package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Menu;

import android.content.Context;
import android.icu.util.CurrencyAmount;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartItem;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

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

    private String currencyFormat(int price) {
        Locale locale = new Locale( "vi", "VN" );
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance( locale );

        return currencyFormatter.format( price );
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MyViewHolder holder, final int position) {
        final MenuItem menuItem = menuItemList.get( position );
        holder.name.setText( menuItem.getName() );
        holder.price.setText(currencyFormat(menuItem.getPrice()));

        Glide.with( context ).load( menuItem.getPhotoURL() ).into( holder.image );

        holder.btn_addToCart.setOnClickListener(view -> {
            context.AddToCart(new CartItem(menuItem.getPhotoURL(), menuItem.getName(), menuItem.getPrice(), 1));
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