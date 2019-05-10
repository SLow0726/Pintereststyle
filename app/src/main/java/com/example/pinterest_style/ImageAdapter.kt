package com.example.pinterest_style

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.adapter_images.view.*
import java.util.*

class ImageAdapter(var list: List<ShopModel>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_images, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount() = this.list.count()


    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.bindView(list[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bindView(shopModel: ShopModel) {
            itemView.tv2_shop.text = shopModel.productName
            itemView.tv_shop.text = shopModel.productPrice
            itemView.tv_curr.text = shopModel.currency
            itemView.iv_shop.layoutParams.height = shopModel.height
//            Glide.with(itemView.context).load(shopModel.imageUrl).into(itemView.iv_shop)
            Glide.with(itemView)
                .load(shopModel.imageUrl)
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(itemView.iv_shop)
        }

    }

    fun setShopList(listOfShop: List<ShopModel>) {
        this.list = listOfShop
        notifyDataSetChanged()
    }


}