package com.mikail.sauceshopping.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mikail.sauceshopping.R
import com.mikail.sauceshopping.models.ProductsModelItem

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsAdapterViewHolder>() {


    inner class ProductsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    private val differCallback = object : DiffUtil.ItemCallback<ProductsModelItem>() {
        override fun areItemsTheSame(oldItem: ProductsModelItem, newItem: ProductsModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductsModelItem, newItem: ProductsModelItem): Boolean {
            return oldItem == newItem

        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ProductsAdapterViewHolder {
        return ProductsAdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: ProductsAdapter.ProductsAdapterViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {

            Glide.with(this).load(product.images[0]).into(product_image)
            price.text = product.price
            product_name.text = product.product_name
            setOnClickListener {
                onItemClickListener?.let {
                    it(product)

                }
            }

        }
    }

    private var onItemClickListener: ((ProductsModelItem) -> Unit)? = null
    fun setOnItemClickListener(listener: (ProductsModelItem) -> Unit) {
        onItemClickListener = listener
    }

}