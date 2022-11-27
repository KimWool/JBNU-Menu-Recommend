package com.sogong.jbnu_menu_recommend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottomNavi)

        bottomNavi.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.aciton_home -> {
                        val homeFragment = Home()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, homeFragment).commit()
                    }
                    R.id.aciton_location -> {
                        val locationFragment = Location()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, locationFragment).commit()
                    }
                    R.id.aciton_wallet -> {
                        val walletFragment = Wallet()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, walletFragment).commit()
                    }
                    R.id.aciton_person -> {
                        val personFragment = Person()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frame, personFragment).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.aciton_home
        }
    }
}