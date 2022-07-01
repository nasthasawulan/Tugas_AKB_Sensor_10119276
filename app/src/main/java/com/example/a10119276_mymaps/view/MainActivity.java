package com.example.a10119276_mymaps.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a10119276_mymaps.view.fragment.Fragment0;
import com.example.a10119276_mymaps.view.fragment.MapsActivity;
import com.example.a10119276_mymaps.view.fragment.Profil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.a10119276_mymaps.R;
import com.example.a10119276_mymaps.view.fragment.DiaryFragment;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class MainActivity extends AppCompatActivity {
    private Button inimap;
    private BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //menampilkan halaman yang pertama muncul
        getFragmentPage(new Fragment0());

        inimap = (Button)findViewById(R.id.inimap);
        inimap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
            public void openmap(){
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
                String toastMessage = "Tekan Back Untuk Kembali";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        //insialisasi bottom nav
        botNav = findViewById(R.id.botNav);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.info:
                        fragment = new Fragment0();
                        break;
                    case
                            R.id.diary:
                        fragment = new DiaryFragment();
                        break;
                    case
                            R.id.profil:
                        fragment = new Profil();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rv_diary, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

