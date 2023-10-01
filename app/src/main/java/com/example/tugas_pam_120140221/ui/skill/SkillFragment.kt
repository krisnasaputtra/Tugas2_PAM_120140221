package com.example.tugas_pam_120140221.ui.skill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_pam_120140221.R
import kotlin.collections.ArrayList

private const val t10 = "t1"
private const val t20 = "t2"

class SkillFragment : Fragment() {
    private var t1: String? = null

    private lateinit var adapter : SkillAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var skillArrayList : ArrayList<Skill>
    private lateinit var imageSkill : Array<Int>
    private lateinit var textImageSkill : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            t1 = it.getString(t10)
            t1 = it.getString(t20)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerview_skill)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        dataInitialize()
        adapter = SkillAdapter(skillArrayList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            navigateToDetail(it.textImageSkill)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        t1 = null
    }

    private fun navigateToDetail(extraName: String){
        findNavController().navigate(SkillFragmentDirections.actionNavSkillToNavSkillDetail(extraName))
    }

    private fun dataInitialize(){
        skillArrayList = arrayListOf<Skill>()

        imageSkill = arrayOf(
            R.drawable.ic_skill_cpp,
            R.drawable.ic_skill_python,
            R.drawable.ic_skill_javascript,
            R.drawable.ic_skill_typescript
        )

        textImageSkill = arrayOf(
            getString(R.string.text_cpp),
            getString(R.string.text_python),
            getString(R.string.text_javascript),
            getString(R.string.text_typescript),
        )

        getUserData()

    }

    private fun getUserData() {

        for (i in imageSkill.indices){
            val skill = Skill(imageSkill[i],textImageSkill[i])
            skillArrayList.add(skill)

        }

    }

}