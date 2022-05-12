package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartView;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Support;

public class User_fragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_user_fragment, container,false);

        TextView userName = view.findViewById(R.id.user_name_text);
        userName.setText(Support.user.getName());

        //region Set click even
        view.findViewById(R.id.btn_account_info).setOnClickListener(view -> {
            Intent intent = new Intent(this.getContext(), UserAccountInfo.class);
            startActivity(intent);
        });

        view.findViewById(R.id.btn_cart).setOnClickListener(view ->{
            Intent intent2 = new Intent(this.getContext(), CartView.class);
            startActivity(intent2);
        });
        //endregion

        // Inflate the layout for this fragment
        return view;
    }
}