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
import com.orion.cafexyz.ui.main.Adapters.ProductCatalogAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    companion object {
        fun newInstance() = HomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home_product_catalog.layoutManager = LinearLayoutManager(requireContext())
        home_product_catalog.adapter = ProductCatalogAdapter(requireContext(), viewModel.fetchCatalog(),
            object : ProductCatalogAdapter.Companion.ClickCallback {
                override fun addProductCart(product: Product) {
                    viewModel.addProductCart(product)
                    Toast.makeText(requireContext(), "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                }
            })

         viewModel.fetchCatalog()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}