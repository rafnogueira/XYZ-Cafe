package com.orion.cafexyz.ui.main.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orion.cafexyz.R
import com.orion.cafexyz.models.Product
import kotlinx.android.synthetic.main.product_item_cart.view.*


class ProductCartAdapter(
    val context: Context,
    val productList: MutableList<Product>,
    val clickCallback: CartClickCallback
) : RecyclerView.Adapter<ProductCartAdapter.CartViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewModel {

        return CartViewModel(
            LayoutInflater.from(context).inflate(R.layout.product_item_cart, parent, false),
            clickCallback
        )
    }

    override fun onBindViewHolder(holder: CartViewModel, position: Int) {
        holder.bind(productList.get(position))
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    inner class CartViewModel(itemView: View, val clickCallback: CartClickCallback) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.cart_item_name.text = product.productName
            itemView.cart_item_image.setImageResource(R.drawable.ic_baseline_coffee_24)
            itemView.cart_item_price.text = product.productPrice.toString()
            itemView.cart_item_qnty

            itemView.cart_item_add_btn.setOnClickListener { clickCallback.addProductQnt(product) }
            itemView.cart_item_subtract_btn.setOnClickListener {
                clickCallback.subtractProduct(
                    product
                )
            }
            itemView.cart_item_remove_btn.setOnClickListener { clickCallback.deleteProduct(product) }
        }
    }

    companion object {
        interface CartClickCallback {
            fun addProductQnt(product: Product)
            fun subtractProduct(product: Product)
            fun deleteProduct(product: Product)
        }
    }

}
