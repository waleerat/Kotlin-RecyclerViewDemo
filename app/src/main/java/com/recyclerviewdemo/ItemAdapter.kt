package com.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_row.view.*

// items: ArrayList<String> : what data want to display

class ItemAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    /**
     *
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.items_row, //* refer to layout file name -> items_row.xml
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */

    //* holder: ViewHolder -> refer to function  ViewHolder
    //* cell in swift ,Lazy in swift

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
        // assign to fun ViewHolder
        holder.tvItem.text = item


        //* Optional : rows style
        // Updating the background color according to the odd/even positions in list.
        if (position % 2 == 0) {
            holder.tvItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGray
                )
            )
        } else {
            holder.tvItem.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite))
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    //* Extra Class
    //* tvItem  -> in item_row.xml
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //* Holds the TextView that will add each item to
        val tvItem = view.tvItem
    }
}