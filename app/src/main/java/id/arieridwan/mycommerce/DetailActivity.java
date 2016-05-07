package id.arieridwan.mycommerce;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.arieridwan.mycommerce.api.DataAPI;
import id.arieridwan.mycommerce.model.DetailModel;
import id.arieridwan.mycommerce.model.Product;
import id.arieridwan.mycommerce.model.Ukuran;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "data";
    private List<Ukuran> mUkuranlList;
    private Product prod;
    TextView nama,harga,diskon,des,spec;
    ImageView foto;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent().hasExtra(EXTRA_DATA)) {
            prod = getIntent().getParcelableExtra(EXTRA_DATA);
        } else {
            throw new IllegalArgumentException("Detail not found");
        }
        nama = (TextView)findViewById(R.id.nama);
        harga = (TextView)findViewById(R.id.harga);
        diskon = (TextView)findViewById(R.id.dis);
        des = (TextView)findViewById(R.id.des);
        spec = (TextView)findViewById(R.id.spec);
        foto = (ImageView)findViewById(R.id.foto);
        id = prod.getId();
        fetch();
    }

    public void fetch(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://dev.gits.co.id")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        DataAPI service = restAdapter.create(DataAPI.class);
        service.getDetail(id, new Callback<DetailModel>() {
            @Override
            public void success(DetailModel detailModel, Response response) {
                des.setText(detailModel.getDATA().getDeskripsi());
                nama.setText(detailModel.getDATA().getNama());
                harga.setText(detailModel.getDATA().getHarga());
                //diskon.setText(detailModel.getDATA().getDiskon());
                //spec.setText((CharSequence) detailModel.getDATA().getSpesifikasi());
                Picasso.with(getApplicationContext()).load(prod.getUrl_foto()).resize(300,200).centerCrop().into(foto);
                mUkuranlList  = new ArrayList<>();
                //mUkuranlList.addAll(detailModel.getDATA().getUkuran());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }
}
