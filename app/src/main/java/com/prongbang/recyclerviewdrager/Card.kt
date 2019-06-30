package com.prongbang.recyclerviewdrager

data class Card(var name: String = "", var phone: String)

object CardGenerator {

    fun toList(size: Int): List<Card> {
        val list = arrayListOf<Card>()
        for (i in 1 until size) {
            list.add(Card(name = "Card $i", phone = "089-455-555$i"))
        }
        return list
    }
}