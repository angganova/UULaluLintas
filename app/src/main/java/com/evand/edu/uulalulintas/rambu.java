package com.evand.edu.uulalulintas;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ListView;
import com.evand.edu.uulalulintas.Database.Rambuadt;
import com.evand.edu.uulalulintas.R;

public class rambu extends Activity {

    ListView lv;
    Context context;
    public static int [] img={R.drawable.dka,R.drawable.dlki,R.drawable.dpb,R.drawable.klakson,R.drawable.
            masuk,R.drawable.max, R.drawable.berhenti,
            R.drawable.allstop, R.drawable.nomotor, R.drawable.nowmotor, R.drawable.nop, R.drawable.nowalker,

            R.drawable.ap, R.drawable.jalan, R.drawable.lurus, R.drawable.min, R.drawable.pb,
            R.drawable.putar, R.drawable.wka,R.drawable.wki, R.drawable.wlka, R.drawable.wlki,
            R.drawable.masjid, R.drawable.gereja, R.drawable.candi, R.drawable.pura, R.drawable.museum,
            R.drawable.hotel, R.drawable.pohon, R.drawable.pom, R.drawable.rm, R.drawable.rs,

            R.drawable.anak, R.drawable.jembatan, R.drawable.licin, R.drawable.pekerja, R.drawable.sebrang,
            R.drawable.spd, R.drawable.tanjakan, R.drawable.turunan, R.drawable.tka, R.drawable.tki,
            R.drawable.api, R.drawable.batu, R.drawable.bpki, R.drawable.bpka, R.drawable.ganda, R.drawable.hati,
            R.drawable.longsor, R.drawable.sempit
    };
    public static String [] ket={"Dilarang Belok Kanan","Dilarang Belok Kiri", "Dilarang Putar Balik",
            "Dilarang Membunyikan Klakson", "Dilarang Masuk", "Kecepatan Maksimum yang Diperbolehkan",
            "Dilarang Berhenti",
            "Dilarang Masuk Bagi Semua Kendaraan Bermotor Maupun Tidak Bermotor",
            "Dilarang Masuk Bagi Semua Kendaraan Bermotor", "Dilarang Masuk Bagi Semua Kendaraan Tidak Bermotor",
            "Dilarang Parkir", "Dilarang Masuk Bagi Pejalan Kaki",

            "Area Parkir", "Penyebrangan Pejalan Kaki", "Jalan Satu Arah", "Batas Kecepatan Minimum",
            "Area Putar Balik", "Wajib Mengitari Bundaran", "Wajib Belok Kanan", "Wajib Belok Kiri",
            "Wajib Memasuki Lajur Kanan", "Wajib Memasuki Lajur Kiri",
            "Rumah Ibadah Umat Islam", "Rumah Ibadah Umat Kristen", "Rumah Ibadah Umat Budha", "Rumah Ibadah Umat Hindu",
            "Museum", "Hotel / Motel", "Tempat Wisata", "Pompa Bahan Bakar", "Rumah Makan", "Rumah Sakit",

            "Banyak Anak - anak", "Jembatan Atau Penyempitan di Jembatan", "Jalan Licin", "Ada Pekerjaan di Jalan",
            "Penyebrangan Orang", "Banyak Orang Bersepeda dan Sering Menyebrang Jalan", "Tanjakan", "Turunan",
            "Tikungan ke Kanan", "Tikungan ke Kiri",
            "Lintasan Kereta Api Berpintu", "Kerikil Lepas", "Tikungan Ganda, Tikungan Pertama ke Kiri",
            "Tikungan Ganda, Tikungan Pertama ke Kanan", "Jalan Tidak Datar, Bergelombang, atau Berbukit - bukit",
            "Hati - hati", "Rawan Longsor", "Penyempitan di Kiri dan Kanan Jalan"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rambu);

        context=this;

        lv=(ListView) findViewById(R.id.listview);
        lv.setAdapter(new Rambuadt(this, ket,img));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rambu, menu);
        return true;
    }

}