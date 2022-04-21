package com.example.myapplication

class CircularIterator (
    var currentPosition: Int,
    var maxPosition: Int
){
    fun nextPosition() {
        currentPosition += 1
        if(currentPosition > maxPosition){
            currentPosition = 0
        }
    }
}