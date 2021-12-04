package com.example.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var mBtn0:Button
    lateinit var mBtn1:Button
    lateinit var mBtn2:Button
    lateinit var mBtn3:Button
    lateinit var mBtn4:Button
    lateinit var mBtn5:Button
    lateinit var mBtn6:Button
    lateinit var mBtn7:Button
    lateinit var mBtn8:Button
    lateinit var mBtn9:Button
    lateinit var mBtnp:Button

    lateinit var mEditDisplay:EditText

    var StringBuilder:StringBuilder= StringBuilder()

    lateinit var mbtnaddition:Button
    lateinit var mbtnsubtraction:Button
    lateinit var mbtnmultiplication:Button
    lateinit var mbtndivision:Button
    lateinit var mbtnmodulus:Button
    lateinit var mbtnequal:Button

    var LEFT_HAND_SIDE_VALUE:Double=0.0
    var RIGHT_HAND_SIDE_VALUE:Double=0.0
    var operator:Char = '\u0000'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mBtn0=findViewById(R.id.btn0)
        mBtn1=findViewById(R.id.btn1)
        mBtn2=findViewById(R.id.btn2)
        mBtn3=findViewById(R.id.btn3)
        mBtn4=findViewById(R.id.btn4)
        mBtn5=findViewById(R.id.btn5)
        mBtn6=findViewById(R.id.btn6)
        mBtn7=findViewById(R.id.btn7)
        mBtn8=findViewById(R.id.btn8)
        mBtn9=findViewById(R.id.btn9)
        mBtnp=findViewById(R.id.btnp)

        mEditDisplay=findViewById(R.id.etext)

        mbtnaddition=findViewById(R.id.btnadd)
        mbtnsubtraction=findViewById(R.id.btnsub)
        mbtnmultiplication=findViewById(R.id.btnmul)
        mbtndivision=findViewById(R.id.btndiv)
        mbtnmodulus=findViewById(R.id.btnmod)
        mbtnequal=findViewById(R.id.btneq)

        initalizeViews()



    }

    private fun initalizeViews(){
        initalizeNumberButtons()
        initalizeOperationalButtons()
        initalizeActionButtons()
    }

    private fun initalizeActionButtons() {
        mbtnequal.setOnClickListener{
            performaction()
        }
    }

    private fun performaction() {
        RIGHT_HAND_SIDE_VALUE= StringBuilder.toString().toDouble()
        StringBuilder.clear()
        var artithFun=ArithmeticFunctions()
        when(operator){
            'A' ->{
                StringBuilder.append(artithFun.add(LEFT_HAND_SIDE_VALUE,RIGHT_HAND_SIDE_VALUE))
            }
            'S' ->{
                StringBuilder.append(artithFun.sub(LEFT_HAND_SIDE_VALUE,RIGHT_HAND_SIDE_VALUE))
            }
            'X' ->{
                StringBuilder.append(artithFun.mul(LEFT_HAND_SIDE_VALUE,RIGHT_HAND_SIDE_VALUE))
            }
            'D' ->{
                StringBuilder.append(artithFun.div(LEFT_HAND_SIDE_VALUE,RIGHT_HAND_SIDE_VALUE))
            }
            'M' ->{
                StringBuilder.append(artithFun.mod(LEFT_HAND_SIDE_VALUE,RIGHT_HAND_SIDE_VALUE))
            }
        }
        mEditDisplay.setText(StringBuilder)

    }

    private fun initalizeNumberButtons() {

        mBtn0.setOnClickListener{
            DisplayDigitOnEditText(digit = "0")
        }
        mBtn1.setOnClickListener{
            DisplayDigitOnEditText(digit = "1")
        }
        mBtn2.setOnClickListener{
            DisplayDigitOnEditText(digit = "2")
        }
        mBtn3.setOnClickListener{
            DisplayDigitOnEditText(digit = "3")
        }
        mBtn4.setOnClickListener{
            DisplayDigitOnEditText(digit = "4")
        }
        mBtn5.setOnClickListener{
            DisplayDigitOnEditText(digit = "5")
        }
        mBtn6.setOnClickListener{
            DisplayDigitOnEditText(digit = "6")
        }
        mBtn7.setOnClickListener{
            DisplayDigitOnEditText(digit = "7")
        }
        mBtn8.setOnClickListener{
            DisplayDigitOnEditText(digit = "8")
        }
        mBtn9.setOnClickListener{
            DisplayDigitOnEditText(digit = "9")
        }
        mBtnp.setOnClickListener{
            DisplayDigitOnEditText(digit = ".")
        }
    }

    private fun initalizeOperationalButtons() {
        mbtnaddition.setOnClickListener{
            StoreLeftHandValue('A')
        }
        mbtnsubtraction.setOnClickListener{
            StoreLeftHandValue('S')
        }
        mbtnmultiplication.setOnClickListener{
            StoreLeftHandValue('X')
        }
        mbtndivision.setOnClickListener{
            StoreLeftHandValue('D')
        }
        mbtnmodulus.setOnClickListener{
            StoreLeftHandValue('M')
        }
    }

    private fun DisplayDigitOnEditText(digit: String) {

        StringBuilder.append(digit)
        mEditDisplay.setText(StringBuilder)
    }

    private fun StoreLeftHandValue(char: Char){
        LEFT_HAND_SIDE_VALUE=StringBuilder.toString().toDouble()
        operator=char
        StringBuilder.clear()
        mEditDisplay.setText("")
    }
}