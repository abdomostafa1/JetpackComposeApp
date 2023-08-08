package com.example.myapplication

import android.content.Context
import android.widget.Toast


inline val String.abdo :String get() = "abdo"

val Int.abdo :Int get()=55

fun Toast.showLongToast(context:Context,message:String){
    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
}