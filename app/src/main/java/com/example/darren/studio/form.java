package com.example.darren.studio;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class form extends AppCompatActivity {

    EditText etHarga, etKembalian, etPembayaran,etOngkir;
    Button btnkembalian, btnSimpan;
    List<jenis> jenisList = new ArrayList<>();
    List<String> namaList = new ArrayList<>();


    FirebaseFirestore firestoreDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        jenisList.add(new jenis("type",1000));
        jenisList.add(new jenis("6 Slot Basic",40000));
        jenisList.add(new jenis("12 Slot Basic",50000));
        jenisList.add(new jenis("20 Slot Basic",80000));
        jenisList.add(new jenis("Bookcard Basic",70000));
        jenisList.add(new jenis("Mini Button Basic",60000));
        jenisList.add(new jenis("Passport Flip Basic",70000));
        jenisList.add(new jenis("6 Slot Metalic",50000));
        jenisList.add(new jenis("12 Slot Metalic",60000));
        jenisList.add(new jenis("20 Slot Metalic",90000));
        jenisList.add(new jenis("Bookcard Metalic",80000));
        jenisList.add(new jenis("Mini Button Metalic",70000));
        jenisList.add(new jenis("Passport Flip Metalic",80000));

        namaList.add("type");
        namaList.add("6 Slot Basic");
        namaList.add("12 Slot Basic");
        namaList.add("20 Slot Basic");
        namaList.add("Bookcard Basic");
        namaList.add("Mini Button Basic");
        namaList.add("Passport Flip Basic");
        namaList.add("6 Slot Metalic");
        namaList.add("12 Slot Metalic");
        namaList.add("20 Slot Metalic");
        namaList.add("Bookcard Metalic");
        namaList.add("Mini Button Metalic");
        namaList.add("Passport Flip Metalic");

        Spinner spinner = findViewById(R.id.spinnerModel);
        etHarga = findViewById(R.id.etHarga);
        etKembalian = findViewById(R.id.etKembalian);
        etPembayaran = findViewById(R.id.etPembayaran);
        btnkembalian = findViewById(R.id.btnkembali);
        btnSimpan = findViewById(R.id.btnSimpan);
        etOngkir = findViewById(R.id.etOngkir);

        ArrayAdapter<String> SpinnerAdapter = new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.simple_list_item_1, namaList);
        spinner.setAdapter(SpinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("type")){

                }
                else{
                    Log.d("position---", String.valueOf(position));
                   etHarga.setText(String.valueOf(jenisList.get(position).getHarga()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnkembalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=hitungKembalian(Integer.parseInt(etHarga.getText().toString()),Integer.parseInt(etPembayaran.getText().toString()) ,Integer.parseInt(etOngkir.getText().toString()));
                etKembalian.setText(String.valueOf(i));
            }
        });
//        btnSimpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buy(produk.getId(),produk.nama,(produk.price-(produk.price*produk.discount/100)),produk.discount,1,produk.price*1,produk.price);
//                Toast.makeText(context, String.valueOf(produk.getDiscount()), Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, produk.getNama(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.ll_CvProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(v.getContext(), DetailProductActivity.class);
//                i.putExtra("produkID", produk.getId());
//                i.putExtra("namaProduk", produk.getNama());
//                i.putExtra("imageProduk", produk.getUrl());
//                i.putExtra("hargaProduk", produk.getPrice());
//                i.putExtra("hargaDiskon", (produk.getPrice()-(produk.getPrice()*produk.getDiscount()/100)));
//                i.putExtra("diskon", produk.getDiscount());
//                i.putExtra("fungsiProduk", produk.getFungsi());
//                i.putExtra("ingredient", produk.getIngredients());
//
//                v.getContext().startActivity(i);
//            }
//        });
    }

    public int hitungKembalian(int harga, int pembayaran, int ongkir){
        Log.d("hitungharga", String.valueOf(harga));
        Log.d("hitungpembayaran", String.valueOf(pembayaran));
        return pembayaran - (harga+ongkir);
    }

    private void buy(String productID,String productName,int price,int priceDisc,int qty,int amount,int salePrice) {
        Map<String, Object> produk = new HashMap<>();
        produk.put("ProductID", productID);
        produk.put("ProductName", productName);
        produk.put("NettPrice", price);
        produk.put("DiscCen", priceDisc);
        produk.put("Qty", qty);
        produk.put("Amount", amount);
        produk.put("SalePrice", salePrice);


//        firestoreDB.collection("001").document("transaction")
//                .collection("sales_vm").document(tes)
//                .collection("salesdetail").document(productID)
//                .set(produk)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d("addstatus", "DocumentSnapshot successfully written!");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("addstatus", "Error writing document", e);
//                    }
//                });
    }

}
