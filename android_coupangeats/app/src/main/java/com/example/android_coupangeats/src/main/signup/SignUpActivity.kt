package com.example.android_coupangeats.src.main.signup

import android.content.SharedPreferences
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
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivitySignUpBinding
import com.example.android_coupangeats.src.main.login.LoginActivityView
import com.example.android_coupangeats.src.main.login.LoginService
import com.example.android_coupangeats.src.main.login.models.PostLoginRequest
import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate),
    SignUpFragmentView{

    var eye = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btnSignUpNow.setOnClickListener {
            val email = binding.etxtId.text.toString()
            val password = binding.etxtPw.text.toString()
            val name = binding.etxtName.text.toString()
            val phone = binding.etxtPhone.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,name = name, phoneNumber = phone)
            SignUpService(this).tryPostSignUp(postRequest)
        }

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

        //맨처음 focused 되면 edittext색깔 파란색
        first_focused(binding.etxtId, binding.lineEmail, binding.txtWrongId )

        first_focused(binding.etxtName, binding.lineName, binding.txtWrongName )

        first_focused(binding.etxtPhone, binding.linePhone, binding.txtWrongPhone )


        // 맨처음 focused 되면 edittext색깔 파란색
        binding.etxtPw.setOnFocusChangeListener { v, hasFocused ->
            if(hasFocused == true ) {
                Log.e("true", "true")
                binding.linePw.visibility = View.VISIBLE
                binding.etxtId.setHint("")
                binding.txtWrongPw.visibility = View.VISIBLE
                binding.btnPwEye.setImageResource(R.drawable.eye_close)
                binding.btnPwEye.isClickable = true
            }
        }

        // 이메일 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_patterns(binding.etxtId,Patterns.EMAIL_ADDRESS, binding.lineEmail, binding.txtWrongId,binding.imgCheck)

        // 이름 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_pattern(binding.etxtName,"^[a-zA-Z가-힣]*$",binding.lineName, binding.txtWrongName, binding.imgCheck2)

        // 휴대폰 번호 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        line_pattern(binding.etxtPhone,"^01(?:0|1|[6-9])(?:\\d{4})\\d{4}\$", binding.linePhone, binding.txtWrongPhone, binding.imgCheck3)


        // 비밀번호 형식이 아닐 때 빨간색 밑줄, 맞으면 파란색 밑줄
        binding.etxtPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

                if (Pattern.matches("^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#\$%^&*])(?=.*[0-9!@#\$%^&*]).{8,20}\$",binding.etxtPw.text)) {
                    //이메일 맞음!
                    Log.e("이메일맞음","이메일맞음")
                    binding.linePw.setBackgroundColor(Color.parseColor("#169DFF"))
                    binding.txtWrongPw.setTextColor(Color.parseColor("#009b33"))
                    binding.txtWrongPw.text = "✓ 영문/숫자/특수문자 2가지 이상 조합 (8~20자)"
                    binding.btnPwEye.setImageResource(R.drawable.check)
                    binding.btnPwEye.isClickable = false
                } else {
                    //이메일 아님!
                    Log.e("이메일아님","이메일아님")
                    binding.linePw.setBackgroundColor(Color.parseColor("#f63240"))
                    binding.txtWrongPw.setTextColor(Color.parseColor("#f63240"))
                    binding.txtWrongPw.visibility = View.VISIBLE
                    binding.btnPwEye.setImageResource(R.drawable.eye_close)
                    binding.btnPwEye.isClickable = true
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

    }

    fun line_patterns (edit :EditText, pattern: Pattern, line:View,text: TextView,appCompatImageView: AppCompatImageView) {
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (pattern.matcher(edit.text).matches()) {
                    //이메일 맞음!
                    line.setBackgroundColor(Color.parseColor("#169DFF"))
                    text.visibility = View.GONE
                    appCompatImageView.visibility = View.VISIBLE
                } else {
                    //이메일 아님!
                    line.setBackgroundColor(Color.parseColor("#ff0000"))
                    text.visibility = View.VISIBLE
                    appCompatImageView.visibility = View.GONE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    fun line_pattern (edit :EditText, pattern: String, line:View,text: TextView,appCompatImageView: AppCompatImageView) {
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (Pattern.matches("$pattern",edit.text)) {
                    //이메일 맞음!
                    line.setBackgroundColor(Color.parseColor("#169DFF"))
                    appCompatImageView.visibility = View.VISIBLE
                    text.visibility = View.GONE

                } else {
                    //이메일 아님!
                    line.setBackgroundColor(Color.parseColor("#ff0000"))
                    appCompatImageView.visibility = View.GONE
                    text.visibility = View.VISIBLE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    fun first_focused (edit: EditText, view: View, textView: TextView)
    {
        // 맨처음 focused 되면 edittext색깔 파란색
        edit.setOnFocusChangeListener { v, hasFocused ->
            if(hasFocused == true ) {
                Log.e("true", "true")
                view.visibility = View.VISIBLE
                edit.setHint("")
            }
            //focused가 false인데 ""이면 빨간색
            else if( hasFocused == false) {
                if(edit.text.toString() == "") {
                    view.setBackgroundColor(Color.parseColor("#ff0000"))
                    textView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        Log.e("회원가입 성공","${response.result.name}")

        val sharedPreference = getSharedPreferences("X_ACCESS_TOKEN", MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreference.edit()
//
//        editor.putString("COUPANG", response.result.jwt)
//        editor.commit()
//        finish()

        finish()
    }

    override fun onPostSignUpFailure(message: String) {
        Log.e("회원가입 실패","회원가입 실패")
    }

}
