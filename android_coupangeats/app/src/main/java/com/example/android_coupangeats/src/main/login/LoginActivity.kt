package com.example.android_coupangeats.src.main.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.android_coupangeats.config.ApplicationClass.Companion.sSharedPreferences
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityLoginBinding
import com.example.android_coupangeats.src.main.login.models.LoginResponse
import com.example.android_coupangeats.src.main.login.models.PostLoginRequest
import com.example.android_coupangeats.src.main.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),

    LoginActivityView {

    var eye = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnPwEye.setOnClickListener {
            if (eye == 0) {
                binding.btnPwEye.setImageResource(R.drawable.oneye)
                binding.etxtPw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.etxtPw.setSelection(binding.etxtPw.length())
                eye = 1
            } else if (eye == 1) {
                binding.btnPwEye.setImageResource(R.drawable.noeye)
                binding.etxtPw.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.etxtPw.setSelection(binding.etxtPw.length())
                eye = 0
            }


        }

        binding.etxtId.setOnFocusChangeListener { v, hasFocusId ->
            if (hasFocusId == true) {
                binding.layoutId.setBackgroundResource(R.drawable.edtxt_login)
       //         Log.e("IdTrue","IdTrue")
            }
            else if (hasFocusId == false){
                binding.layoutId.setBackgroundResource(R.drawable.etxt_login_nofocused)
        //        Log.e("IdFalse","Idfalse")
            }
        }

        binding.etxtPw.setOnFocusChangeListener { v, hasFocusPw ->
            if (hasFocusPw == true){
                binding.layoutPw.setBackgroundResource(R.drawable.edtxt_login)
         //       Log.e("PWTrue","PwTrue")
            }
            else if (hasFocusPw == false) {
                binding.layoutPw.setBackgroundResource(R.drawable.etxt_login_nofocused)
          //      Log.e("PWfalse","Pwfalse")
            }
        }

        binding.txtSignIn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnX.setOnClickListener {
            onBackPressed()
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etxtId.text.toString()
            val password = binding.etxtPw.text.toString()
            val postRequest = PostLoginRequest(email = email, password = password)
            LoginService(this).tryLogin(postRequest)
        }

    }

    override fun onGetUserSuccess(response: LoginResponse) {

        val editor = sSharedPreferences.edit()
        editor.putString("user_idx","${response.result.userIdx}")
        Log.e("userIdx",response.result.userIdx.toString())
        editor.putString(X_ACCESS_TOKEN, response.result.jwt)
        editor.commit()

        finish()

    }

    override fun onGetUserFailure(message: String) {
        Log.e("로그인 실패", "로그인 실패")
    }

}
