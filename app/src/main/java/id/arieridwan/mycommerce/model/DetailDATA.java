package id.arieridwan.mycommerce.model;

import java.util.ArrayList;
import java.util.List;

public class DetailDATA {

    private String nama;
    private String harga;
    private String diskon;
    private String deskripsi;
    private Object spesifikasi;
    private List<Ukuran> ukuran = new ArrayList<Ukuran>();

    /**
     *
     * @return
     * The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     *
     * @param nama
     * The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     *
     * @return
     * The harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     *
     * @param harga
     * The harga
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     *
     * @return
     * The diskon
     */
    public String getDiskon() {
        return diskon;
    }

    /**
     *
     * @param diskon
     * The diskon
     */
    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    /**
     *
     * @return
     * The deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     *
     * @param deskripsi
     * The deskripsi
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     *
     * @return
     * The spesifikasi
     */
    public Object getSpesifikasi() {
        return spesifikasi;
    }

    /**
     *
     * @param spesifikasi
     * The spesifikasi
     */
    public void setSpesifikasi(Object spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    /**
     *
     * @return
     * The ukuran
     */
    public List<Ukuran> getUkuran() {
        return ukuran;
    }

    /**
     *
     * @param ukuran
     * The ukuran
     */
    public void setUkuran(List<Ukuran> ukuran) {
        this.ukuran = ukuran;
    }

}
