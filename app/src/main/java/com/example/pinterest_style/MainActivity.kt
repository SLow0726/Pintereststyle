package com.example.pinterest_style

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showImage()
//        showButton()

    }


    fun showImage() {
        val shopModelList =  getMockShopItemList()
        rv_image.layoutManager = GridLayoutManager(this,3, RecyclerView.VERTICAL,false)

        rv_image.adapter = ImageAdapter(shopModelList)
    }

    private fun getMockShopItemList(): List<ShopModel> {
        val list = ArrayList<ShopModel>()
        for(i in 0..getRandomIntInRange(50,10)){
            val h =  getRandomIntInRange(600,200)
            list.add(ShopModel(getRandImage(h),"Item $i","$",h,"${i*100}"))
        }
        return list
    }

    private fun getRandImage(height:Int) = "https://dummyimage.com/200x$height"

//    fun showButton() {
//
//        rv_title.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
//        val ButtonList = Object().buttonList
//        val adapter = ButtonAdapter(ButtonList,Object().btnColorList)
//        rv_title.adapter = adapter
//    }
fun getRandomIntInRange(max: Int, min: Int): Int {
    val mRandom = Random()
    return mRandom.nextInt(max - min) + min
}
}
