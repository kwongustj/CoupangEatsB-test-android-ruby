package com.example.android_coupangeats.src.main.login

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

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
    }


}
