package com.orion.cafexyz.ui.main.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orion.cafexyz.R
import com.orion.cafexyz.models.Product
import kotlinx.android.synthetic.main.product_item.view.*
import kotlin.random.Random


class ProductCatalogAdapter(val context: Context, val productList:MutableList<Product>, val clickCallback: ProductCartAdapter.Companion.CartClickCallback): RecyclerView.Adapter<ProductCatalogAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false), clickCallback)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList.get(position))
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    inner class ProductViewHolder(itemView: View, val clickCallback: ClickCallback) : RecyclerView.ViewHolder(itemView){
        fun bind(product: Product){
            itemView.product_item_name.text = product.productName
            itemView.product_item_image.setImageResource(R.drawable.ic_baseline_coffee_24)
            itemView.product_item_price.text = product.productPrice.toString()
            itemView.product_item_add_btn.setOnClickListener { clickCallback.addProductCart(product) }
        }
    }

    companion object{
        interface ClickCallback{
            fun addProductCart(product: Product)
        }
    }

}
