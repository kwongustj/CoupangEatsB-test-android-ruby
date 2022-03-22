package com.example.android_coupangeats.src.main.signup

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {

    var eye = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 버튼 누르면 PW 보이게 안보이게 처리 해줌
        binding.btnPwEye.setOnClickListener {
            Log.e("buttonclicked", "buttonclicked")
            if (eye == 0) {
                binding.btnPwEye.setImageResource(R.drawable.eye_on)
                binding.etxtPw.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.etxtPw.setSelection(binding.etxtPw.length())
                eye = 1
            } else if (eye == 1) {
                binding.btnPwEye.setImageResource(R.drawable.eye_close)
                binding.etxtPw.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.etxtPw.setSelection(binding.etxtPw.length())
                eye = 0
            }
        }

        // 맨처음 focused 되면 edittext색깔 파란색
        binding.etxtId.setOnFocusChangeListener { v, hasFocused ->
            if(hasFocused == true ) {
                Log.e("true", "true")
                binding.lineEmail.visibility = View.VISIBLE
            }
            else{

            }
        }
        // 맨처음 focused 되면 edittext색깔 파란색
        binding.etxtName.setOnFocusChangeListener { v, hasFocused ->
            if(hasFocused == true ) {
                Log.e("true", "true")
                binding.lineName.visibility = View.VISIBLE
            }
            else{

            }
        }
        // 맨처음 focused 되면 edittext색깔 파란색
        binding.etxtPw.setOnFocusChangeListener { v, hasFocused ->
            if(hasFocused == true ) {
                Log.e("true", "true")
                binding.linePw.visibility = View.VISIBLE
            }
            else{

            }
        }
        // 맨처음 focused 되면 edittext색깔 파란색
        binding.etxtPhone.setOnFocusChangeListener { v, hasFocused ->
            Log.e("setOnFocusChangeListener", "setOnFocusChangeListener")
            if(hasFocused == true ) {
                Log.e("true", "true")
                binding.linePhone.visibility = View.VISIBLE
            }
            else{

            }
        }

        // 이메일 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_patterns(binding.etxtId,Patterns.EMAIL_ADDRESS, binding.lineEmail, binding.txtWrongId)

        // 이름 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_pattern(binding.etxtName,"^[a-zA-Z가-힣]*$",binding.lineName, binding.txtWrongName)

        // 휴대폰 번호 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_pattern(binding.etxtPhone,"^01(?:0|1|[6-9])(?:\\d{4})\\d{4}\$", binding.linePhone, binding.txtWrongPhone)


//        // 비밀번호 형이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
//        binding.etxtId.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//
//                if (Patterns.) {
//                    //이메일 맞음!
//                    binding.lineEmail.setBackgroundColor(Color.parseColor("#169DFF"))
//                    binding.txtWrongId.visibility = View.GONE
//                } else {
//                    //이메일 아님!
//                    binding.lineEmail.setBackgroundColor(Color.parseColor("#ff0000"))
//                    binding.txtWrongId.visibility = View.VISIBLE
//                }
//            }
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//        })

    }

    fun line_patterns (edit :EditText, pattern: Pattern, line:View,text: TextView) {
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (pattern.matcher(edit.text).matches()) {
                    //이메일 맞음!
                    line.setBackgroundColor(Color.parseColor("#169DFF"))
                    text.visibility = View.GONE
                } else {
                    //이메일 아님!
                    line.setBackgroundColor(Color.parseColor("#ff0000"))
                    text.visibility = View.VISIBLE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    fun line_pattern (edit :EditText, pattern: String, line:View,text: TextView) {
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (Pattern.matches("$pattern",edit.text)) {
                    //이메일 맞음!
                    line.setBackgroundColor(Color.parseColor("#169DFF"))
                    text.visibility = View.GONE
                } else {
                    //이메일 아님!
                    line.setBackgroundColor(Color.parseColor("#ff0000"))
                    text.visibility = View.VISIBLE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

}
