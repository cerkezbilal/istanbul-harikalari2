package com.bilalkarademir.istanbulharikalar2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetayActivity extends MenuActivity {

    ImageView resim;
    TextView txtbaslik,txticerik,txtulasim;
    Button btnkonum,btnulasim,btnpuanver,btnpuanla;
    String konum;
    RatingBar rtpuan;
    Context context = this;
    int tiklamaSayisi=0;
    Button btnbilgiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        tanimla();
        Intent intent = getIntent();
        String isim = intent.getStringExtra("isim");
        String icerik = intent.getStringExtra("icerik");
        String ulasim = intent.getStringExtra("ulasim");
        konum = intent.getStringExtra("konum");

        txtbaslik.setText(isim);
        txticerik.setText(icerik);
        txtulasim.setText(ulasim);

        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();
        resim.setImageBitmap(bitmap);
        BilgiVer();
        ulasimGör();
        KonumGor();
        puanver();
        puanla();
    }

    public void BilgiVer(){

        btnbilgiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiklamaSayisi++;
                if(tiklamaSayisi%2==1){

                    txticerik.setVisibility(View.VISIBLE);
                    txtulasim.setVisibility(View.GONE);
                    rtpuan.setVisibility(View.GONE);
                    btnpuanla.setVisibility(View.GONE);
                }else {

                    txticerik.setVisibility(View.GONE);
                }
            }
        });

    }

    public void tanimla(){

        resim = findViewById(R.id.resim);
        txtbaslik = findViewById(R.id.txtbaslik);
        txticerik = findViewById(R.id.txticerik);
        txtulasim = findViewById(R.id.txtulasim);
        btnkonum = findViewById(R.id.btnkonum);
        btnulasim = findViewById(R.id.btnulasim);
        btnpuanver = findViewById(R.id.btnpuanver);
        btnpuanla = findViewById(R.id.btnpuanla);
        btnbilgiver = findViewById(R.id.btnbilgi);
        rtpuan = findViewById(R.id.puanver);
    }

    public void ulasimGör(){


        btnulasim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiklamaSayisi++;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(txtulasim.getText().toString()));
                startActivity(intent);
                /*
                if(tiklamaSayisi%2==1){
                    txtulasim.setVisibility(View.VISIBLE);
                    txticerik.setVisibility(View.GONE);
                    btnpuanla.setVisibility(View.GONE);
                    rtpuan.setVisibility(View.GONE);

                }else {
                    txtulasim.setVisibility(View.GONE);
                }
                */

            }
        });
    }


    public void KonumGor(){

        btnkonum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+konum));
                startActivity(intent);
            }
        });

    }

    public void puanver(){

        btnpuanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiklamaSayisi++;
                if(tiklamaSayisi%2==1) {
                    rtpuan.setVisibility(View.VISIBLE);
                    btnpuanla.setVisibility(View.VISIBLE);
                    txticerik.setVisibility(View.GONE);
                    txtulasim.setVisibility(View.GONE);
                }else {
                    rtpuan.setVisibility(View.GONE);
                    btnpuanla.setVisibility(View.GONE);
                }
            }
        });
    }

    public void puanla(){

        btnpuanla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtpuan.setIsIndicator(true);
                Toast.makeText(context," Puanlama Başarıyla Yapıldı",Toast.LENGTH_LONG).show();
            }
        });
    }
}
