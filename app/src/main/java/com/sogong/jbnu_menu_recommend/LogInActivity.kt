package com.sogong.jbnu_menu_recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sogong.jbnu_menu_recommend.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //회원가입 버튼 이벤트
        binding.register.setOnClickListener {
            val intent: Intent = Intent(this@LogInActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}