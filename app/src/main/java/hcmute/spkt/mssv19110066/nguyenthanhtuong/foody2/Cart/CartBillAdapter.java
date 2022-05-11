package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class CartBillAdapter extends BaseAdapter {
    private Context context;
    private List<CartItem> cartItemList;
    private int layout;

    public CartBillAdapter(Context context, List<CartItem> cartItemList, int layout) {
        this.context = context;
        this.cartItemList = cartItemList;
        this.layout = layout;
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

    private static class ViewHolder{
        ImageView image;
        TextView foodName, price, quantity;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.image = view.findViewById(R.id.cart_bill_image);
            holder.foodName = view.findViewById(R.id.cart_bill_foodName);
            holder.price = view.findViewById(R.id.cart_bill_price);
            holder.quantity = view.findViewById(R.id.cart_bill_quantity);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //Set data
        CartItem cartItem = cartItemList.get(i);
        Glide.with(context).load(cartItem.getPhotoURL()).into(holder.image);
        holder.foodName.setText(cartItem.getFoodName());
        String price = Support.CurrencyFormat(cartItem.getPrice());
        holder.price.setText(price);
        holder.quantity.setText(String.valueOf(cartItem.getQuantity()));

        return view;
    }
}
