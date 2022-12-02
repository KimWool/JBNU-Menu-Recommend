package com.sogong.jbnu_menu_recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sogong.jbnu_menu_recommend.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth

        binding.registerButton.setOnClickListener {
            val email = binding.registerId.text.toString().trim()
            val password = binding.registerPassword.text.toString().trim()
            //비밀번호 재확인, 이름 입력 부분 추가

            signUp(email, password)
        }
    }

    //회원가입 기능 구현
    private fun signUp(email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "환영합니다!", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@RegisterActivity, LogInActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "회원가입에 실패하였습니다.\n다시 한번 확인해 주세요.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}