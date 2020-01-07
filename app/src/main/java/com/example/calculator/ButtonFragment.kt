package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_button.*
import java.lang.Exception
import java.lang.RuntimeException

class ButtonFragment : Fragment(), View.OnClickListener {

    var display: String = "0"
    var a = 0.0
    var b = 0.0
    var sum = false
    var subtract = false
    var multiply = false
    var divide = false
    var sqrt = false
    var square = false
    private var listener: FragmentInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_button, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        zero.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        comma.setOnClickListener(this)
        btn_sum.setOnClickListener(this)
        sub.setOnClickListener(this)
        multi.setOnClickListener(this)
        div.setOnClickListener(this)
        btn_sqrt.setOnClickListener(this)
        btn_square.setOnClickListener(this)
        ac.setOnClickListener(this)
        result.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero, R.id.comma-> {
            display((v as Button).text.toString())
            }
            R.id.btn_sum -> {
                sum = true
                subtract = false
                multiply = false
                divide = false
                sqrt = false
                square = false
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"

            }
            R.id.sub -> {
                sum = false
                subtract = true
                multiply = false
                divide = false
                sqrt = false
                square = false
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"
            }
            R.id.multi -> {
                sum = false
                subtract = false
                multiply = true
                divide = false
                sqrt = false
                square = false
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"
            }
            R.id.div -> {
                sum = false
                subtract = false
                multiply = false
                divide = true
                sqrt = false
                square = false
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"
            }
            R.id.btn_sqrt -> {
                sum = false
                subtract = false
                multiply = false
                divide = false
                sqrt = true
                square = false
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"
            }
            R.id.btn_square -> {
                sum = false
                subtract = false
                multiply = false
                divide = false
                sqrt = false
                square = true
                var aa: Double? = display.toDouble()
                if (aa != null) {
                    a = aa.toDouble()
                }
                b = a
                display = "0"
            }
            R.id.ac -> {
                a = 0.0
                b = 0.0
                sum = false
                subtract = false
                multiply = false
                divide = false
                sqrt = false
                square = false
                display = "0"
                listener?.showResult(display)
            }
            R.id.result -> {
                var bb: Double? = display.toDouble()
                if (bb != null) {
                    b = bb.toDouble()
                }
                if (sum) {
                    display = (a + b).toString()
                } else if (subtract) {
                    display = (a - b).toString()
                } else if (multiply) {
                    display = (a * b).toString()
                } else if (divide) {
                    display = (a / b).toString()
                } else if (sqrt) {
                    display = (Math.sqrt(a)).toString()
                } else if (square) {
                    display = (a * a).toString()
                }
                listener?.showResult(display)
            }
        }
    }

    fun display(number: String) {
        if (display == "NaN" || display == "0" || display == "Infinity") {
            display = number
            listener?.showResult(display)
        } else {
            display = display + number
            listener?.showResult(display)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            this.listener = context as FragmentInterface
        } else
            throw RuntimeException(context.toString()+ " must implement onViewSelected!")

    }
}