package com.critterpedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {

    // Animation Control
    private lateinit var slideAnimation: Animation

    val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        // Populate the controls from the xml nav args
        rootView.detail_title.text = args.itemName
        rootView.detail_text.text = args.itemDetails
        rootView.detail_image.setImageResource(args.itemImage)

        // Animation to slide in from the left.
        slideAnimation =
            AnimationUtils.loadAnimation(context, R.anim.slide)
        rootView.detail_title.startAnimation(slideAnimation)
        rootView.detail_text.startAnimation(slideAnimation)
        rootView.detail_image.startAnimation(slideAnimation)

        return rootView
    }
}
