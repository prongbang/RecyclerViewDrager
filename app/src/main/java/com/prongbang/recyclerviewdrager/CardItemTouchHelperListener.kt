package com.prongbang.recyclerviewdrager

interface CardItemTouchHelperListener {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean
}