package com.example.labor5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.labor5.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class QuestionFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            if((binding.radioElso.isChecked && question.correct == 0)
                || (binding.radioMasodik.isChecked && question.correct == 1)
                || (binding.radioHarmadik.isChecked && question.correct == 2)
                || (binding.radioNegyedik.isChecked && question.correct == 3)
            ){
                findNavController().navigate(R.id.action_Question_to_QuizEnd)
            } else {
                findNavController().navigate(R.id.action_Question_to_Question)
            }

        }
        val viewModel: QuestionViewModel by viewModels()
        question = viewModel.nextQuestion()
        binding.radioElso.text = question.a1
        binding.radioMasodik.text = question.a2
        binding.radioHarmadik.text = question.a3
        binding.radioNegyedik.text = question.a4
        binding.textviewSecond.text = question.question
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}