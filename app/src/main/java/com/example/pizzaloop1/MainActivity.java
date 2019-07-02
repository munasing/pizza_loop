package com.example.pizzaloop1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private static final String PRODUCT_URL = "http://192.168.8.172:8080/demo/all";

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadProducts();

    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,PRODUCT_URL,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray products = new JSONArray(response);

                    for (int i = 0; i<products.length(); i++) {
                        JSONObject productobject = products.getJSONObject(i);

                        int rating = productobject.getInt("rating");
                        int id = productobject.getInt("id");
                        String title = productobject.getString("title");
                        String shortdesc = productobject.getString("shortdesc");
                        double price = productobject.getDouble("price");
                        String image = productobject.getString("image");

                        product product = new product(id, title, shortdesc,rating, price, image);
                        productList.add(product);
                    }
                    adapter = new ProductAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(adapter);
                    } catch (JSONException e1) {
                    e1.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
         protected Map<String,String>getParams() throws AuthFailureError{
             Map<String,String>params = new HashMap<>();
             return params;
         }
        }
                ;
        Volley.newRequestQueue(this).add(stringRequest);
    }

}
