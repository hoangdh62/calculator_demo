package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity(), FragmentInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragment1 = ResultFragment()
        var fragment2 = ButtonFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.screenFragmentContainer, fragment1)
        transaction.add(R.id.buttonFragmentContainer, fragment2)
        transaction.commit()
    }

    override fun showResult(result : String){
        val resultFragment = getSupportFragmentManager().findFragmentById(R.id.screenFragmentContainer) as ResultFragment
        resultFragment.showResult(result)
    }
}