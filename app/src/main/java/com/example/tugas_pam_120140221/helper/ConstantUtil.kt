package com.example.tugas_pam_120140221.helper

import androidx.fragment.app.Fragment
import com.example.tugas_pam_120140221.R
import com.example.tugas_pam_120140221.model.Skill
object ConstantUtil {
    fun getSkillData(fragment: Fragment):ArrayList<Skill>{
        val skillList = ArrayList<Skill>()
        val textSkills = fragment.resources.getStringArray(R.array.string_skills_array)
        val imageSkills = fragment.resources.obtainTypedArray(R.array.image_skills_array)

        for(i in textSkills.indices){
            skillList.add(Skill(imageSkills.getResourceId(i,0), textSkills[i]))
        }

        imageSkills.recycle()

        return skillList
    }
}