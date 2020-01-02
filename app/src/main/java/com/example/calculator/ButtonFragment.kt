package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ButtonFragment : Fragment() {

    var mainActivity : MainActivity? = null
    var display : String = "0"

    var a = 0.0
    var b = 0.0
    var sum = false
    var subtract = false
    var multiply = false
    var divide = false
    var sqrt = false
    var square = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_button, container, false)

        val zeroButton = view.findViewById(R.id.zero) as Button
        val oneButton = view.findViewById(R.id.one) as Button
        val twoButton = view.findViewById(R.id.two) as Button
        val threeButton = view.findViewById(R.id.three) as Button
        val fourButton = view.findViewById(R.id.four) as Button
        val fiveButton = view.findViewById(R.id.five) as Button
        val sixButton = view.findViewById(R.id.six) as Button
        val sevenButton = view.findViewById(R.id.seven) as Button
        val eightButton = view.findViewById(R.id.eight) as Button
        val nineButton = view.findViewById(R.id.nine) as Button
        val commaButton = view.findViewById(R.id.comma) as Button
        val resultButton = view.findViewById(R.id.result) as Button
        val sumButton = view.findViewById(R.id.sum) as Button
        val subButton = view.findViewById(R.id.sub) as Button
        val multiButton = view.findViewById(R.id.multi) as Button
        val divButton = view.findViewById(R.id.div) as Button
        val sqrtButton = view.findViewById(R.id.sqrt) as Button
        val squareButton = view.findViewById(R.id.square) as Button
        val acButton = view.findViewById(R.id.ac) as Button

        zeroButton.setOnClickListener{
            display =  "0"
            this.mainActivity?.showResult(display!!)
        }

        oneButton.setOnClickListener{
            display("1")
        }

        twoButton.setOnClickListener{
            display("2")
        }

        threeButton.setOnClickListener{
            display("3")
        }

        fourButton.setOnClickListener{
            display("4")
        }

        fiveButton.setOnClickListener{
            display("5")
        }

        sixButton.setOnClickListener{
            display("6")
        }

        sevenButton.setOnClickListener{
            display("7")
        }

        eightButton.setOnClickListener{
            display("8")
        }

        nineButton.setOnClickListener{
            display("9")
        }

        commaButton.setOnClickListener{
            display(".")
        }

        sumButton.setOnClickListener{
            sum = true
            subtract = false
            multiply = false
            divide = false
            sqrt = false
            square = false
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"

        }
        subButton.setOnClickListener{
            sum = false
            subtract = true
            multiply = false
            divide = false
            sqrt = false
            square = false
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"
        }

        multiButton.setOnClickListener{
            sum = false
            subtract = false
            multiply = true
            divide = false
            sqrt = false
            square = false
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"
        }

        divButton.setOnClickListener{
            sum = false
            subtract = false
            multiply = false
            divide = true
            sqrt = false
            square = false
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"
        }

        sqrtButton.setOnClickListener{
            sum = false
            subtract = false
            multiply = false
            divide = false
            sqrt = true
            square = false
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"
        }

        squareButton.setOnClickListener{
            sum = false
            subtract = false
            multiply = false
            divide = false
            sqrt = false
            square = true
            var aa : Double? = display?.toDouble()
            if (aa != null) {
                a = aa.toDouble()
            }
            b = a
            display = "0"
        }

        acButton.setOnClickListener{
            a = 0.0
            b = 0.0
            sum = false
            subtract = false
            multiply = false
            divide = false
            sqrt = false
            square = false
            display =  "0"
            this.mainActivity?.showResult(display!!)
        }

        resultButton.setOnClickListener{
            var bb : Double? = display?.toDouble()
            if (bb != null) {
                b = bb.toDouble()
            }
            if(sum){
                display =  (a + b).toString()
            } else if (subtract){
                display = (a - b).toString()
            } else if (multiply){
                display = (a * b).toString()
            } else if (divide){
                display = (a / b).toString()
            } else if (sqrt){
                display = (Math.sqrt(a)).toString()
            } else if (square){
                display = (a * a).toString()
            }
            this.mainActivity?.showResult(display!!)
        }

        return view
    }

    fun display (number : String){
        if(display == "NaN" || display =="0" || display == "Infinity"){
            display = number
            this.mainActivity?.showResult(display!!)
        }else{
            display = display + number
            this.mainActivity?.showResult(display!!)
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as? MainActivity
        if (mainActivity == null) {
            throw ClassCastException("$context must implement MainActivity")
        }
    }
}