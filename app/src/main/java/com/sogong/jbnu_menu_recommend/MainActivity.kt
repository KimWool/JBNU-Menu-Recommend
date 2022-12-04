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
    fun goN() { //Wallet Fragment의 Nbutton을 클릭 시 호출되는 메서드
        val nFragment = NFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_frame, nFragment)
        transaction.addToBackStack("n")
        transaction.commit()
    }

    fun goL() { //Wallet Fragment의 Lbutton을 클릭 시 호출되는 메서드
        val lFragment = LFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_frame, lFragment)
        transaction.addToBackStack("l")
        transaction.commit()
    }

    fun goS() { //Wallet Fragment의 Sbutton을 클릭 시 호출되는 메서드
        val sFragment = SFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_frame, sFragment)
        transaction.addToBackStack("s")
        transaction.commit()
    }

    fun goD() { //Wallet Fragment의 Dbutton을 클릭 시 호출되는 메서드
        val dFragment = DFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_frame, dFragment)
        transaction.addToBackStack("d")
        transaction.commit()
    }

    fun goBack(){ //Back 버튼 클릭 시 호출되는 메서드
        onBackPressed()
    }
}