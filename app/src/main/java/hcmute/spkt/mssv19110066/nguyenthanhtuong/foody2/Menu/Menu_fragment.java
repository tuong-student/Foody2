package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartItem;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Cart.CartView;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home.Home_fragment;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home.MyApplication;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home.Store;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.MainActivity;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class Menu_fragment extends Fragment {
    private static final String TAG = Menu_fragment.class.getSimpleName();
    private static final String URL = "https://gappapi.deliverynow.vn/api/dish/get_delivery_dishes?id_type=1&request_id=";

    View view;
    CartView cartView;
    MenuAdapter adapter;
    ArrayList<MenuItem> menuItemArrayList;
    String storeId;
    String storeName;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu_fragment, container, false);

        menuItemArrayList = new ArrayList<>();
        adapter = new MenuAdapter(this, menuItemArrayList);
        recyclerView = view.findViewById(R.id.menu_fragment_recyclerView);
        if (cartView == null) {
            cartView = new CartView();
        }


        RecyclerView.LayoutManager mLayoutManagement = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManagement);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        Store store = (Store) getArguments().getSerializable("store");
        storeId = String.valueOf(store.getId());
        storeName = store.getName();

        fetchStoreItems();
        return view;
    }

    public void AddToCart(CartItem item){
        cartView.AddToCart(item);
    }

    private void fetchStoreItems() {
        JsonObjectRequest request = new JsonObjectRequest( URL + storeId,
                response -> {
                    if (response == null) {
                        Toast.makeText(this.getContext(), "Couldn't fetch the " +
                                "menu items! Please try again.", Toast.LENGTH_LONG).show();
                        return;
                    }

                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());

                        JSONArray jSONArray = jsonObject
                                .getJSONObject( "reply" )
                                .getJSONArray( "menu_infos" );

                        menuItemArrayList.clear();

                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONArray dishes = jSONArray
                                    .getJSONObject( i )
                                    .getJSONArray( "dishes" );

                            for (int j = 0; j < dishes.length(); j++) {
                                JSONObject dish = dishes.getJSONObject( j );
                                int id = dish.getInt("id");
                                String name = dish.getString( "name" );
                                String description = dish
                                        .getString(
                                                "description" );
                                String photoUrl = dish
                                        .getJSONArray( "photos" )
                                        .getJSONObject( 1 )
                                        .getString( "value" );
                                int price = dish.getJSONObject( "price" )
                                        .getInt( "value" );

                                menuItemArrayList.add( new MenuItem(id, storeName, name, price,
                                        description, photoUrl ) );
                            }
                        }

                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                },
                error -> {
                    // error in getting json
                    Log.e( TAG, error.getMessage() );
                } ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put( "x-foody-client-type", "1" );
                params.put( "x-foody-client-id", "" );
                params.put( "x-foody-client-language", "vi" );
                params.put( "x-foody-client-version", "3.0.0" );
                params.put( "x-foody-access-token", "" );
                params.put( "x-foody-api-version", "1" );
                params.put( "x-foody-app-type", "1004" );

                return params;
            }
        };

        MyApplication.getInstance().addToRequestQueue( request );
    }
}
