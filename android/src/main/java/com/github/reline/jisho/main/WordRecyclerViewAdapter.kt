/*
 * Copyright 2020 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.reline.jisho.R
import com.github.reline.jisho.models.Result

class WordRecyclerViewAdapter(
        private var wordList: List<Result> = emptyList()
) : RecyclerView.Adapter<WordViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_word, viewGroup, false)
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun updateData(wordList: List<Result>?) {
        val oldSize = itemCount
        this.wordList = wordList.orEmpty()
        val newSize = itemCount

        when {
            newSize > oldSize -> {
                notifyItemRangeInserted(oldSize, newSize)
                notifyItemRangeChanged(0, oldSize)
            }
            newSize < oldSize -> {
                notifyItemRangeRemoved(newSize, oldSize)
                notifyItemRangeChanged(0, newSize)
            }
            else -> notifyItemRangeChanged(0, newSize)
        }
    }
}
