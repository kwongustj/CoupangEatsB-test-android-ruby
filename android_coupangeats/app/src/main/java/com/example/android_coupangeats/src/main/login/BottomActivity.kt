package com.example.android_coupangeats.src.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityBottomBinding
import com.example.android_coupangeats.databinding.ActivityLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomActivity : BaseActivity<ActivityBottomBinding>(ActivityBottomBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()

        bottomSheetDialog.setOnDismissListener {
            onBackPressed()
            }

        bottomSheetView.findViewById<AppCompatButton>(R.id.btn_login_email).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        }

    override fun onRestart() {
        super.onRestart()
        if(ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN," ") !=" "){
            finish()
            }
        else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}