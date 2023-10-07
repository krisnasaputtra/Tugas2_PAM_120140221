package com.example.tugas_pam_120140221.ui.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_pam_120140221.R
import com.example.tugas_pam_120140221.model.Skill

class SkillAdapter(private var list: ArrayList<Skill>) : RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {

    var onItemClick : ((Skill) -> Unit)? = null

    fun setFilteredList(list: ArrayList<Skill>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_skill , parent , false)
        return SkillViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val currentItem = list[position]
        holder.imageSkill.setImageResource(currentItem.imageSkill)
        holder.textImageSkill.text = currentItem.textImageSkill

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    class SkillViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imageSkill : AppCompatImageView = itemView.findViewById(R.id.image_skill)
        val textImageSkill : TextView = itemView.findViewById(R.id.text_skill)

    }
}