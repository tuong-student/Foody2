package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class CartAdapter extends BaseAdapter {
    private CartView context;
    private int layout;
    private List<CartItem> cartItemList;

    public CartAdapter(CartView context, int layout, List<CartItem> cartItemList) {
        this.context = context;
        this.layout = layout;
        this.cartItemList = cartItemList;
    }

    @Override
    public int getCount() {
        return cartItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private static class ViewHolder {
        ImageView image;
        TextView foodName, price, quantity;
        ImageButton btn_up, btn_down;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.image = view.findViewById(R.id.cart_row_image);
            holder.foodName = view.findViewById(R.id.cart_row_foodName);
            holder.price = view.findViewById(R.id.cart_row_price);
            holder.quantity = view.findViewById(R.id.cart_row_numQuantity);
            holder.btn_up = view.findViewById(R.id.cart_row_btn_arrow_up);
            holder.btn_down = view.findViewById(R.id.cart_row_btn_arrow_down);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Gán dữ liệu
        CartItem item = cartItemList.get(i);
        Glide.with(context).load(item.getPhotoURL()).into(holder.image);
        holder.foodName.setText(item.getFoodName());
        String price = Support.CurrencyFormat(item.getPrice());
        holder.price.setText(price);
        holder.quantity.setText(String.valueOf(item.getQuantity()));

        holder.btn_up.setOnClickListener(view1 -> {
            CartItem chooseItem = Support.cartDB.GetItem(item.getId());
            chooseItem.setQuantity(chooseItem.getQuantity() + 1);
            Support.cartDB.UpdateToCart(chooseItem);
            context.LoadData();

        });

        holder.btn_down.setOnClickListener(view1 -> {
            CartItem chooseItem = Support.cartDB.GetItem(item.getId());
            if (chooseItem.getQuantity() > 1) {
                chooseItem.setQuantity(chooseItem.getQuantity() - 1);
                Support.cartDB.UpdateToCart(chooseItem);
                context.LoadData();
            }
        });
        return view;
    }
}
