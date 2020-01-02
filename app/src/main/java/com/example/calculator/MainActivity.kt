package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showResult(result : String){
        val resultFragment = getSupportFragmentManager().findFragmentById(R.id.result_fragment) as ResultFragment
        resultFragment.showResult(result)
    }
}