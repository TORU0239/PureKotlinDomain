package kr.toru.purekotlindomain.feature.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kr.toru.purekotlindomain.feature.R
import kr.toru.purekotlindomain.feature.viewmodel.FeatureViewModel

class FeatureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeatureFragment()
    }
}