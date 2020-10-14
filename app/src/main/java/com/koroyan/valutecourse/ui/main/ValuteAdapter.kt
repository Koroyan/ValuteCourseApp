package com.koroyan.valutecourse.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.koroyan.valutecourse.R
import com.koroyan.valutecourse.model.Description
import kotlinx.android.synthetic.main.valute_layout.view.*

class ValuteAdapter : RecyclerView.Adapter<ValuteAdapter.ViewHolder>() {
    private var descriptions: ArrayList<Description> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var model: Description
        fun onBind() {
            model = descriptions[adapterPosition]
            with(itemView) {
                courseTextView.text = model.course
                valuteDescriptionTextView.text = model.description
                changedTextView.text = model.changed
                Glide.with(this).load(model.statusGif).into(statusImageView)
            }
            itemView.valuteDescriptionTextView.text = model.description

        }
    }

    fun setData(descriptions: ArrayList<Description>) {
        this.descriptions = descriptions
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.valute_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = descriptions.size
}