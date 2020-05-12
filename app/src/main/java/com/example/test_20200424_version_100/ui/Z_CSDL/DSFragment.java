package com.example.test_20200424_version_100.ui.Z_CSDL;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test_20200424_version_100.Class.ListView_Adapter;
import com.example.test_20200424_version_100.Class.Model_BB;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.B.BFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DSFragment extends Fragment{


    public DSFragment() {
        // Required empty public constructor
    }

    String urlGetData = "http://192.168.49.2/Student/Bien_Bao_20200424/get_Data.php";
    ArrayList<Model_BB> arrayList;
    ListView_Adapter adapter;
    ListView listView;
    SearchView searchView;
    RelativeLayout rl;

    OnClickItemTab1 onClickItemTab1;
    public void setOnClickItemTab1(OnClickItemTab1 onClickItemTab1) {
        this.onClickItemTab1 = onClickItemTab1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_we_ds,null);
        //--Anh Xa
        AnhXa(view);
        //--ListView
        arrayList = new ArrayList<>();
        adapter = new ListView_Adapter(getContext(), R.layout.i_dong_item, arrayList,onClickItemTab1);
        listView.setAdapter(adapter);
        ReadJson(urlGetData);
        //--Search View
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText.toString());
                return false;
            }
        });
        return view;
    }
    private void AnhXa(View view) {
        listView    = (ListView) view.findViewById(R.id.listviewDS);
        searchView  = (SearchView) view.findViewById(R.id.searchviewDS);
        rl          = (RelativeLayout) view.findViewById(R.id.dong_item);
    }

    private void ReadJson(String url){
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        //--5ts:Lay Du lieu=Get : Day len App=Post; duong dan=url; null; lang nghe tra loi ; Lang nghe loi
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                        for(int i = 0; i < response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayList.add(new Model_BB(
                                        object.getString("ID_BB"),
                                        object.getString("Name"),
                                        object.getString("Year"),
                                        object.getString("Code"),
                                        object.getString("Image"),
                                        object.getString("Detail"),
                                        object.getString("Id_kind"),
                                        object.getString("Kind")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    private void filter(String text){
        ArrayList<Model_BB> filteredList = new ArrayList<>();
        for (Model_BB item : arrayList){
            if(item.getCode().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

}
