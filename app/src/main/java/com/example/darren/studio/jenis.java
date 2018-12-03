package com.example.darren.studio;

public class jenis {
    String id,Nama, Nope, Alamat, type;
    int harga,pembayaran,kembalian ;

    public jenis(String nama, int harga) {
        Nama = nama;
        this.harga = harga;
    }

    public jenis(String id, String Nama, String Nope, String Alamat, String type, int harga, int pembayaran, int kembalian) {
        this.id = id;
        this.Nama = Nama;
        this.Nope =Nope;
        this.Alamat = Alamat;
        this.type= type;
        this.harga=harga;
        this.pembayaran=pembayaran;
        this.kembalian=kembalian;

    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
