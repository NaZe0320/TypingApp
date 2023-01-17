package com.naze.typingapp.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naze.typingapp.databinding.ItemListHeaderBinding

class MainExpandableListAdapter: RecyclerView.Adapter<MainExpandableListAdapter.ExpandView>() {
    val data = mapOf(
        "문장 연습" to listOf("긴 글 연습","짧은 글 연습"),
        "설정" to listOf("설정1", "설정2")
    )
    inner class ExpandView(private val binding: ItemListHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnExpand.setOnClickListener {
                if (binding.llExpandDetail.visibility == View.VISIBLE) {
                    binding.llExpandDetail.visibility = View.GONE
                    binding.btnExpand.animate().apply {
                        duration = 200
                        rotation(0f)
                    }
                } else {
                    binding.llExpandDetail.visibility = View.VISIBLE
                    binding.btnExpand.animate().apply {
                        duration = 200
                        rotation(180f)
                    }
                }
            }

            binding.expandedMenu.setOnClickListener {
                if (binding.llExpandDetail.visibility == View.VISIBLE) {
                    binding.llExpandDetail.visibility = View.GONE
                    binding.btnExpand.animate().apply {
                        duration = 200
                        rotation(0f)
                    }
                } else {
                    binding.llExpandDetail.visibility = View.VISIBLE
                    binding.btnExpand.animate().apply {
                        duration = 200
                        rotation(180f)
                    }
                }
            }
        }

        fun bind(pos: Int) {
            binding.tvExpand.text = data.keys.elementAt(pos)
            data.values.elementAt(pos).forEach {
                val view = TextView(binding.root.context).apply {
                    text = "$it"
                    textSize = 14f
                    setPadding(10,10,5,10)
                }
                binding.llExpandDetail.addView(view)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandView {
        val view = ItemListHeaderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ExpandView(view)
    }

    override fun onBindViewHolder(holder: ExpandView, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int {
       return data.size
    }

}