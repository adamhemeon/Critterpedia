package com.critterpedia.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.critter_list_item.view.*

import com.critterpedia.R
import com.critterpedia.models.CritterItem


/**
 * Retrieved from: https://www.youtube.com/watch?v=Jo6Mtq7zkkg&ab_channel=CodingWithMitch
 */
class CritterRecyclerAdapter(private var clickListener : OnCritterItemClickListener)
                                : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<CritterItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CritterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.critter_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CritterViewHolder ->{
                holder.bind(items[position],clickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): CritterItem {
        return items[position]
    }

    fun submitList(critterList: List<CritterItem>){
        items = critterList
    }

//    fun getImageFromURI(): Image {
//
//
//        return new Image()
//    }

    class CritterViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val critterIcon = itemView.critter_icon;
        val content = itemView.content;

        fun bind(critterItem: CritterItem, action: OnCritterItemClickListener){

            // Set icon and name for list items
            critterIcon.setImageResource(R.drawable.nh_icon_anchovy) // TODO: Get image from URL
            content.text = critterItem.fileName

            // Set onItemClick with the critter item and it's position.
            itemView.setOnClickListener{
                action.onItemClick(critterItem, adapterPosition)
            }
        }
    }

    /**
     * onCritterClickListener interface must implement onItemClick method
     */
    interface OnCritterItemClickListener{

        fun onItemClick(critterItem: CritterItem, position: Int)
    }
}