package com.computer.inu.sqkakaotalk.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.computer.inu.sqkakaotalk.Data.FriendData
import com.computer.inu.sqkakaotalk.R

class  FriendListRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<FriendData>) : RecyclerView.Adapter<FriendListRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_friendlist, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = dataList[position].name
        holder.content.text = dataList[position].content
        holder.rl_friendlist_item.setOnLongClickListener {
            notifyItemRemoved(position)
            notifyItemRangeRemoved(position,6)
            true


        }
    }



    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.rv_tv_friend_friendname) as TextView
        val content : TextView =itemView.findViewById(R.id.rv_tv_friend_friendcontents) as TextView
        val rl_friendlist_item =itemView.findViewById(R.id.rl_friendlist_item) as RelativeLayout
    }
}