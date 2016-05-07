
package id.arieridwan.mycommerce.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String id;
    private String rating;
    private String nama;
    private String jenis;
    private String harga;
    private String diskon;
    private String stok;
    private String url_foto;

    protected Product(Parcel in) {
        id = in.readString();
        rating = in.readString();
        nama = in.readString();
        jenis = in.readString();
        harga = in.readString();
        diskon = in.readString();
        stok = in.readString();
        url_foto = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * 
     * @param jenis
     *     The jenis
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * 
     * @return
     *     The harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     * 
     * @param harga
     *     The harga
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     * 
     * @return
     *     The diskon
     */
    public String getDiskon() {
        return diskon;
    }

    /**
     * 
     * @param diskon
     *     The diskon
     */
    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    /**
     * 
     * @return
     *     The stok
     */
    public String getStok() {
        return stok;
    }

    /**
     * 
     * @param stok
     *     The stok
     */
    public void setStok(String stok) {
        this.stok = stok;
    }

    /**
     * 
     * @return
     *     The urlFoto
     */
    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(rating);
        dest.writeString(nama);
        dest.writeString(jenis);
        dest.writeString(harga);
        dest.writeString(diskon);
        dest.writeString(stok);
        dest.writeString(url_foto);
    }
}
