package com.example.pinterest_style

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_botton.view.*

class ButtonAdapter(val btnList: ArrayList<String>, val btnColor: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_botton, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = this.btnColor.count()


    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val colorList = listOf("#FF0000","#FFBB00","#FF0000","#FF0000","#FF0000","#FF0000","#0000FF")
//        val colorArray = holder.itemView.context.resources.getStringArray(R.array.colors)
//        println("******${colorArray[position]}")
//        holder.itemView.btn_.setBackgroundColor(Color.parseColor(btnColor[position]))
        holder.itemView.btn_.text = btnList[position]
        val backgroundDrawable =
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.shape)
        backgroundDrawable?.let {
            Log.d("test ", "hello")
            it.setTint(Color.parseColor(colorList[position]))
//            it.setTint(ContextCompat.getColor(holder.itemView.context, Color.parseColor(colorArray[position])))
            holder.itemView.btn_.background = it
        } ?: kotlin.run {
            holder.itemView.btn_.setBackgroundResource(R.drawable.shape)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}