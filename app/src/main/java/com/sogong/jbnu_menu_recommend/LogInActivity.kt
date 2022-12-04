package com.sogong.jbnu_menu_recommend

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sogong.jbnu_menu_recommend.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth

        binding.logInButton.setOnClickListener{
            val email = binding.logInId.text.toString()
            val password = binding.logInPassword.text.toString()

            login(email, password)
        }

        //회원가입 버튼 이벤트
        binding.register.setOnClickListener {
            val intent: Intent = Intent(this@LogInActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent: Intent = Intent(this@LogInActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "환영합니다!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "로그인 정보가 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error: ${task.exception}")
                }
            }
    }
}