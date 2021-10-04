package com.orion.cafexyz.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.orion.cafexyz.R
import com.orion.cafexyz.ViewModels.MainViewModel
import com.orion.cafexyz.models.Product
import com.orion.cafexyz.ui.main.Adapters.ProductCartAdapter
import com.orion.cafexyz.ui.main.Adapters.ProductCatalogAdapter
import kotlinx.android.synthetic.main.cart_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrdersFragment : Fragment() {

    companion object {
        fun newInstance() = OrdersFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_cart_recycler_view.layoutManager = LinearLayoutManager(requireContext())
        home_product_catalog.adapter = ProductCartAdapter(requireContext(), viewModel.fetchCatalog(),
            object : ProductCartAdapter.Companion.CartClickCallback{
                override fun addProductQnt(product: Product) {
                    viewModel.addProductCart(product)
                    Toast.makeText(requireContext(), "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                }

                override fun deleteProduct(product: Product) {
                    viewModel.deleteProductCart(product)
                    Toast.makeText(requireContext(), "Produto removido do carrinho!", Toast.LENGTH_SHORT).show()
                }

                override fun subtractProduct(product: Product) {
                    viewModel.removeProductCart(product)
                    Toast.makeText(requireContext(), "Quantidade removida do carrinho!", Toast.LENGTH_SHORT).show()
                }
            })

        viewModel.fetchCatalog()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.orders_history_fragment, container, false)
    }

}