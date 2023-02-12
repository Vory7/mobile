package com.example.calculator2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signCheck = 0
        var dotCheck = 0
        var numCheck = 0
        btn_0.setOnClickListener {
            setTextFields("0")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_1.setOnClickListener {
            setTextFields("1")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_2.setOnClickListener {
            setTextFields("2")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_3.setOnClickListener {
            setTextFields("3")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_4.setOnClickListener {
            setTextFields("4")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_5.setOnClickListener {
            setTextFields("5")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_6.setOnClickListener {
            setTextFields("6")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_7.setOnClickListener {
            setTextFields("7")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_8.setOnClickListener {
            setTextFields("8")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_9.setOnClickListener {
            setTextFields("9")
            if (dotCheck == 0)
                dotCheck = 1
        }
        btn_dot.setOnClickListener {
            if (dotCheck == 1) {
                setTextFields(".")
                dotCheck = 2
            }
        }
        btn_minus.setOnClickListener {
            if (signCheck == 0) {
                setTextFields("-")
                signCheck = 1
                dotCheck = 0
            }
        }
        btn_plus.setOnClickListener {
            if (signCheck == 0) {
                setTextFields("+")
                signCheck = 2
                dotCheck = 0
            }
        }
        btn_multi.setOnClickListener {
            if (signCheck == 0) {
                setTextFields("*")
                signCheck = 3
                dotCheck = 0
            }
        }
        btn_div.setOnClickListener {
            if (signCheck == 0) {
                setTextFields("/")
                signCheck = 4
                dotCheck = 0
            }
        }
        btn_AC.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
            dotCheck = 0
            signCheck = 0
        }
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if (str[str.length - 1] == '.') dotCheck = 1
            if (str[str.length - 1] == '+' ||
                str[str.length - 1] == '-' ||
                str[str.length - 1] == '*' ||
                str[str.length - 1] == '/') signCheck = 0
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
        }
        btn_equal.setOnClickListener {
            var ind = 0
            var sign : Char
            for (sign in math_operation.text) {
                if (sign == '+' || sign == '-' || sign == '*' || sign == '/')
                    break
                ind += 1
            }
            var num1 : Double
            var num2 : Double
            var num = math_operation.text.substring(0, ind)
            var zero = 0
            num1 = num.toDouble()
            num = math_operation.text.substring(ind + 1, math_operation.text.length)
            num2 = num.toDouble()
            when(signCheck) {
                1 -> num1 -= num2
                2 -> num1 += num2
                3 -> num1 *= num2
                4 ->  {
                    if (num2 != 0.0)
                        num1 /= num2
                    else {
                        result_text.text = "error"
                        zero = 1
                    }
                }
            }
            var num3 = num1.toLong()
            if (zero == 0) {
                if (num3.toDouble() == num1) {
                    result_text.text = num3.toString()
                } else {
                    result_text.text = num1.toString()
                }
            }
        }
    }

    fun setTextFields(str: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
}