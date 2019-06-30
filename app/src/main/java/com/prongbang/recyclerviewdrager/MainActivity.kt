package com.prongbang.recyclerviewdrager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
    }

    private fun bindView() {
        val mAdapter = CardAdapter()
        rvCard.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
        val callback = CardItemTouchHelperCallback(mAdapter)
        ItemTouchHelper(callback).apply {
            attachToRecyclerView(rvCard)
        }
        mAdapter.submitList(CardGenerator.toList(50))
    }

}
