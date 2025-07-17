package com.example.ozinsheexample1.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.ozinsheexample1.R
import com.example.ozinsheexample1.data.OnboardingInfoList
import com.example.ozinsheexample1.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnboardingAdapter()
        adapter.submitList(OnboardingInfoList.onboardingModelList)
        binding.viewPager2OnboardingFragment.adapter = adapter


        val viewPagerCallBack = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == OnboardingInfoList.onboardingModelList.size - 1) {
                    binding.btnSkipOnboardingFragment.visibility = View.INVISIBLE
                    binding.btnNextOnboardingFragment.visibility = View.VISIBLE
                } else {
                    binding.btnSkipOnboardingFragment.visibility = View.VISIBLE
                    binding.btnNextOnboardingFragment.visibility = View.INVISIBLE
                }
            }
        }
        binding.dotsIndicator.setViewPager2(binding.viewPager2OnboardingFragment)
        binding.viewPager2OnboardingFragment.registerOnPageChangeCallback(viewPagerCallBack)

        binding.btnSkipOnboardingFragment.setOnClickListener {

            findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
        }

    }

}