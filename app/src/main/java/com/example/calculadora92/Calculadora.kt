package com.example.calculadora92

class Calculadora {

    var num1: Float = 0.0F
    var num2: Float = 0.0F

    constructor(num1: Float, num2: Float){
        this.num1 = num1
        this.num2 = num2
    }

    fun suma(): Float{
        return num1 + num2
    }

    fun resta(): Float{
        return num1 - num2
    }

    fun multiplicacion(): Float{
        return num1 * num2
    }

    fun division(): Float{
        var total = 0.0f
        if (num2 != 0.0f){
            total = num1 / num2
        }
        return total
    }
}