package hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.MainActivity;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.Menu.Menu_fragment;
import hcmute.spkt.mssv19110066.nguyenthanhtuong.foody2.R;

public class Home_fragment extends Fragment {
    private static final String TAG = Home_fragment.class.getSimpleName();
    private static final String URL = "https://www.foody.vn/__get/Place/HomeListPlace?t=1652116366421&page=1&lat=10.823099&lon=106.629664&count=12&districtId=11&cateId=&cuisineId=&isReputation=&type=1";

    RecyclerView Posts;
    StoreAdapter adapter;
    ArrayList<Store> storeArrayList;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        Posts = view.findViewById(R.id.gvPosts);
        storeArrayList = new ArrayList<>();
        adapter = new StoreAdapter(this, storeArrayList);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        Posts.setLayoutManager(mLayoutManager);
        Posts.setAdapter(adapter);
        Posts.setNestedScrollingEnabled(false);

        FetchStoreItem();
        //region Click event

        //endregion

        // Inflate the layout for this fragment
        return view;
    }

    public void SendData(Integer Id, String StoreName){
        Bundle bundle = new Bundle();
        bundle.putInt("Id", Id);
        bundle.putString("storeName", StoreName);

        Menu_fragment menu_fragment = new Menu_fragment();
        menu_fragment.setArguments(bundle);

        MainActivity.Ins.replaceFragment(menu_fragment);
    }

    public void FetchStoreItem() {
        JsonObjectRequest request = new JsonObjectRequest(URL,
                response -> {
                    if (response == null) {
                        Toast.makeText(getActivity(), "Couldn't fetch the " +
                                "store items! Please try again.", Toast.LENGTH_LONG).show();
                        return;
                    }

                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());

                        JSONArray jSONArray = jsonObject.getJSONArray("Items");

                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject store = jSONArray.getJSONObject(i);
                            int id = store.getInt("Id");
                            String name = store.getString("Name");
                            String photoUrl = store.getString("PhotoUrl");
                            String url = store.getString("Url");

                            storeArrayList.add(new Store(id, name, url, photoUrl, "Thu Duc"));
                        }

                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                },
                error -> {
                    // error in getting json
                    Log.e(TAG, error.getMessage());
                }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("X-Requested-With", "XMLHttpRequest");
                params.put("Cookie", "gcat=food; fd.res.view.217=990502; " +
                        "__ondemand_sessionid=0plb3jqny0w21mwzcuj0ggxe; floc=217; flg=vn");

                return params;
            }
        };
            MyApplication.getInstance().addToRequestQueue(request);
    }
}