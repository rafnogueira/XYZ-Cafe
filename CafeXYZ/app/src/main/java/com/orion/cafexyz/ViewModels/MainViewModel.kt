package com.orion.cafexyz.ViewModels

import androidx.lifecycle.ViewModel
import com.orion.cafexyz.models.Product

class MainViewModel : ViewModel() {

    private val cart: MutableList<Product> = mutableListOf()

    fun fetchCatalog(): MutableList<Product> {
        val productCatalog: MutableList<Product> = mutableListOf(
            Product(1, "Café expresso 1", 10.0, 1),
            Product(2, "Café Comum", 5.0, 1),
            Product(3, "Café Com Leite e Creme", 15.0, 1),
            Product(4, "Café Premium", 17.0, 1),
            Product(5, "Café Moído na hora", 14.0, 1)
        )

        return productCatalog
    }

    fun addProductCart(product: Product) {
        var productExists: Product? = cart.find{ it.productId == product.productId}

        if(productExists != null){
            cart.get(cart.indexOf(product)).quantity ++
        }else{
            cart.add(product)
        }
    }

    fun removeProductCart(product: Product) {
        var productExists: Product? = cart.find{ it.productId == product.productId}

        if(productExists != null){
            cart.get(cart.indexOf(product)).quantity --
        }else{
            cart.remove(product)
        }
    }

    fun deleteProductCart(product: Product)
    {
        cart.remove(product)
    }

}