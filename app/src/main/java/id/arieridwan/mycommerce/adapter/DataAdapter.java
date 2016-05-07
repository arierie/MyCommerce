package id.arieridwan.mycommerce.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import id.arieridwan.mycommerce.DetailActivity;
import id.arieridwan.mycommerce.R;
import id.arieridwan.mycommerce.model.Product;

public  class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Product> mDataList;
    private LayoutInflater mInflater;
    private Context mContext;

    public DataAdapter(Context context , List<Product> dataList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mDataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, mDataList.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Locale ina = new Locale("id", "ID");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(ina);
        Product prod = mDataList.get(position);
        Picasso.with(mContext)
                .load(prod.getUrl_foto())
                .centerCrop()
                .resize(300, 380)
                .into(holder.foto);
        holder.nama.setText(prod.getNama());
        Double hrg = Double.parseDouble(prod.getHarga());
        holder.harga.setText(defaultFormat.format(hrg));
        holder.dis.setText("Disc " + prod.getDiskon() + "%");
    }

    @Override
    public int getItemCount() {
        return (mDataList == null) ? 0 : mDataList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView foto;
        public TextView nama,harga,dis;
        public ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nama = (TextView)itemView.findViewById(R.id.nama);
            harga = (TextView)itemView.findViewById(R.id.harga);
            dis = (TextView)itemView.findViewById(R.id.dis);
        }
    }

}