package com.example.tugas_pam_1_120140221.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tugas_pam_1_120140221.databinding.FragmentSkillDetailBinding

class SkillFragmentDetail : Fragment() {

    private var _binding: FragmentSkillDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val skillViewModel =
            ViewModelProvider(this).get(SkillViewModel::class.java)

        _binding = FragmentSkillDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSkillDetail
        skillViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}