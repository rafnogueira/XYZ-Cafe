package com.orion.cafexyz.ViewModels

import androidx.lifecycle.ViewModel
import com.orion.cafexyz.models.Product

class MainViewModel : ViewModel() {


    fun fetchCatalog(): MutableList<Product> {
        val productCatalog: MutableList<Product> = mutableListOf(
            Product(1, "Café expresso 1", 10.0, 1),
            Product(1, "Café Comum", 5.0, 1),
            Product(1, "Café Com Leite e Creme", 15.0, 1),
            Product(1, "Café Premium", 17.0, 1),
            Product(1, "Café Moído na hora", 14.0, 1)
        )

        return productCatalog
    }

    private val cart: MutableList<Product> = mutableListOf()

    fun addProductCart(product: Product) {


    }


}