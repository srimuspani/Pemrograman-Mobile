package com.example.laundryapp.view;

import android.app.Activity;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.laundryapp.R;
import com.example.laundryapp.utils.FunctionHelper;
import com.example.laundryapp.viewmodel.AddDataViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class IroningActivity extends AppCompatActivity{
    public static final String DATA_TITLE = "TITLE";
    int hargaKaos = 3000, hargaJeans = 4000, hargaJacket = 6000, hargaBedCover = 0, hargaCarpet = 0;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0;
    int countKaos, countJeans, countJacket, countBedCover, countCarpet, totalItems, totalPrice;
    String strTitle, strCurrentLocation;
    double strCurrentLatitude;
    double strCurrentLongitude;
    Button btnCheckOut;
    ImageView add1, add2, add3, add4, add5,
            minus1, minus2, minus3, minus4, minus5;
    TextView tvTitle, tvInfo, tvJumlahBarang, tvTotalPrice, pKaos, pJeans, pJacket, pBedCover, pCarpet,
            QtyKaos, QtyJeans, QtyJacket, QtyBedCover, QtyCarpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);

        setStatusbar();
        setInitLayout();
        setDataKaos();
        setDataJeans();
        setDataJacket();
        setDataBedCover();
        setDataCarpet();
        setInputData();
        getCurrentLocation();
    }

    private void setStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void setInitLayout() {
        tvTitle = findViewById(R.id.tvTitle);
        tvInfo = findViewById(R.id.tvInfo);

        tvJumlahBarang = findViewById(R.id.tvJumlahBarang);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        pKaos = findViewById(R.id.pKaos);
        pJeans = findViewById(R.id.pJeans);
        pJacket = findViewById(R.id.pJacket);
        pBedCover = findViewById(R.id.pBedCover);
        pCarpet = findViewById(R.id.pCarpet);
        QtyKaos = findViewById(R.id.qtyKaos);
        QtyJeans = findViewById(R.id.qtyJeans);
        QtyJacket = findViewById(R.id.qtyJacket);
        QtyBedCover = findViewById(R.id.qtyBedCover);
        QtyCarpet = findViewById(R.id.qtyCarpet);

        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        add3 = findViewById(R.id.add3);
        add4 = findViewById(R.id.add4);
        add5 = findViewById(R.id.add5);
        minus1 = findViewById(R.id.minus1);
        minus2 = findViewById(R.id.minus2);
        minus3 = findViewById(R.id.minus3);
        minus4 = findViewById(R.id.minus4);
        minus5 = findViewById(R.id.minus5);

        btnCheckOut = findViewById(R.id.btnCheckOut);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {
            tvTitle.setText(strTitle);
        }
    }

    private void setDataKaos() {
        pKaos.setText(FunctionHelper.rupiahFormat(hargaKaos));
        add1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            QtyKaos.setText(itemCount1);
            countKaos = hargaKaos * itemCount1;
            setTotalPrice();
        });

        minus1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                QtyKaos.setText(itemCount1);
            }
            countKaos = hargaKaos * itemCount1;
            setTotalPrice();
        });
    }

    private void setDataJeans() {
        pJeans.setText(FunctionHelper.rupiahFormat(hargaJeans));
        add2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            QtyJeans.setText(itemCount2);
            countJeans = hargaJeans * itemCount2;
            setTotalPrice();
        });

        minus2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                QtyJeans.setText(itemCount2);
            }
            countJeans = hargaJeans * itemCount2;
            setTotalPrice();
        });
    }

    private void setDataJacket() {
        pJacket.setText(FunctionHelper.rupiahFormat(hargaJacket));
        add3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            QtyJacket.setText(itemCount3);
            countJacket = hargaJacket * itemCount3;
            setTotalPrice();
        });

        minus3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                QtyJacket.setText(itemCount3);
            }
            countJacket = hargaJacket * itemCount3;
            setTotalPrice();
        });
    }

    private void setDataBedCover() {
        pBedCover.setText(FunctionHelper.rupiahFormat(hargaBedCover));
        add4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            QtyBedCover.setText(itemCount4);
            countBedCover = hargaBedCover * itemCount4;
            setTotalPrice();
        });

        minus4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                QtyBedCover.setText(itemCount4);
            }
            countBedCover = hargaBedCover * itemCount4;
            setTotalPrice();
        });
    }

    private void setDataCarpet() {
        pCarpet.setText(FunctionHelper.rupiahFormat(hargaCarpet));
        add5.setOnClickListener(v -> {
            itemCount5 = itemCount5 + 1;
            QtyCarpet.setText(itemCount5);
            countCarpet = hargaCarpet * itemCount5;
            setTotalPrice();
        });

        minus5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                QtyCarpet.setText(itemCount5);
            }
            countCarpet = hargaCarpet * itemCount5;
            setTotalPrice();
        });
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5;
        totalPrice = countKaos + countJeans + countJacket + countBedCover + countCarpet;

        tvJumlahBarang.setText(totalItems + " items");
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice));
    }

    private void getCurrentLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(strCurrentLatitude, strCurrentLongitude, 1);
            if (addressList != null && addressList.size() > 0) {
                strCurrentLocation = addressList.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setInputData() {
        btnCheckOut.setOnClickListener(v -> {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(IroningActivity.this, "Harap pilih jenis barang!", Toast.LENGTH_SHORT).show();
            } else {
                addDataViewModel.addDataLaundry(strTitle, totalItems, strCurrentLocation, totalPrice);
                Toast.makeText(IroningActivity.this, "Pesanan Anda sedang diproses, cek di menu riwayat", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }
}
