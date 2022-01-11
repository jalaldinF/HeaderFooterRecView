package com.example.headerfooterrecview.moduls

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.headerfooterrecview.R
import java.security.AccessController.getContext


class CustomAdapter(val member: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val TYPE_AVAILABLE_YES = 1
    private val TYPE_AVAILABLE_NOT = 3
    private val TYPE_HEADER = 0
    private val TYPE_FOOTER = 4

    override fun getItemViewType(position: Int): Int {
     if(isHeader(position)) return TYPE_HEADER
     if(isFooter(position)) return TYPE_FOOTER


        return if (member[position].isAvailable){
            TYPE_AVAILABLE_YES
        } else TYPE_AVAILABLE_NOT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_HEADER -> {
                val header = LayoutInflater.from(parent.context).inflate(R.layout.header,parent,false)
                return CustomViewHeaderHolder(header)
            }
            TYPE_AVAILABLE_YES -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_yes,parent,false)
                return CustomViewYesHolder(view)
            }
            TYPE_AVAILABLE_NOT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_not,parent,false)
                return CustomViewNotHolder(view)
            }
            else -> {  val footer = LayoutInflater.from(parent.context).inflate(R.layout.footer,parent,false)
                return CustomViewFooterHolder(footer)

            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
     val member = member[position]
        if(holder is CustomViewYesHolder){
           holder.first_name.text = member.name
            holder.last_name.text = member.surname
        }
        if (holder is CustomViewNotHolder){
            holder.first_namet.text = "This name is not available"
            holder.last_namet.text = "This surname is not available"
        }
    }

    override fun getItemCount(): Int {
        return member.size
    }

    class CustomViewHeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }
    class CustomViewFooterHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }




    class CustomViewYesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewNotHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val first_namet:TextView = itemView.findViewById(R.id.first_namet)
        val last_namet:TextView = itemView.findViewById(R.id.last_namet)
    }
    fun isHeader(position: Int):Boolean{
      return position == 0
    }
    fun isFooter(position: Int):Boolean{
      return position == member.size-1
    }
}