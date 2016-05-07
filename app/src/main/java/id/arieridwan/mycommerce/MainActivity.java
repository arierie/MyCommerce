package id.arieridwan.mycommerce;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.arieridwan.mycommerce.adapter.DataAdapter;
import id.arieridwan.mycommerce.api.DataAPI;
import id.arieridwan.mycommerce.model.DataModel;
import id.arieridwan.mycommerce.model.Product;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager =  new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                fetch();
            }
        });
    }

    private void fetch() {
        mSwipeRefreshLayout.setRefreshing(true);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://dev.gits.co.id")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        DataAPI service = restAdapter.create(DataAPI.class);
        service.getData(new Callback<DataModel>() {
            @Override
            public void success(DataModel dataModel, Response response) {
                List<Product> mProductList = new ArrayList<Product>();
                mProductList.addAll(dataModel.getDATA().getProducts());

                final DataAdapter mAdapter = new DataAdapter(getApplicationContext(), mProductList);
                mRecyclerView.setAdapter(mAdapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }


    @Override
    public void onRefresh() {

        fetch();
    }
}
