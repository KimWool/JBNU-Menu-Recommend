package com.sogong.jbnu_menu_recommend

//noinspection SuspiciousImport
import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sogong.jbnu_menu_recommend.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth

        binding.registerButton.setOnClickListener {
            val email = binding.registerId.text.toString().trim()
            val password = binding.registerPassword.text.toString().trim()

            signUp(email, password)
        }

        val data = listOf("- 선택하세요 -", "간호대학", "공과대학", "글로벌융합대학", "농업생명과학대학", "사범대학", "사회과학대학", "상과대학", "생활과학대학", "수의과대학", "스마트팜학과", "약학대학", "예술대학", "의과대학", "인문대학", "자연과학대학", "치과대학", "환경생명자원대학")

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, data)

        binding.departmentSpinner.adapter = adapter

        binding.departmentSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?){}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
        }
    }

    //회원가입 기능 구현
    private fun signUp(email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입에 성공하였습니다.\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@RegisterActivity, LogInActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "회원가입에 실패하였습니다.\n다시 한번 확인해 주세요.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /**
    private fun RegisterTextWatcher(){
        register_password_check.addTextChangedListener(object : TextWatcher){
            override fun afterTextChanged(p0: Editable?){
                if(register_password.getText().toString().equals(register_password_check.getText().toString())){
                    pw_confirm.setText("비밀번호가 일치합니다.")
                    register_button.isEnabled=true
                }
                else{
                    pw_confirm.setText("비밀번호가 일치하지 않습니다.")
                    register_button.isEnabled=false
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p:1 Int, p2: Int, p3: Int){}

            override fun onTextChanged(p0: CharSequence?, p:1 Int, p2: Int, p3: Int){
                if(register_password.getText().toString().equals(register_password_check.getText().toString())){
                    pw_confirm.setText("비밀번호가 일치합니다.")
                    register_button.isEnabled=true
                }
                else{
                    pw_confirm.setText("비밀번호가 일치하지 않습니다.")
                    register_button.isEnabled=false
                }
            }
        }
    }
    **/
}