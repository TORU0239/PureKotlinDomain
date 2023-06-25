package kr.toru.purekotlindomain.feature.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kr.toru.purekotlindomain.feature.R
import kr.toru.purekotlindomain.feature.viewmodel.FeatureViewModel

class FeatureFragment : Fragment() {

    private val viewModel: FeatureViewModel by lazy {
        ViewModelProvider(this@FeatureFragment).get(FeatureViewModel::class.java)
    }

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.tvResult)
        viewLifecycleOwner.lifecycleScope.launch {
            val result = viewModel.getInfo("Toru")
            Log.e("Toru", "age: ${result.age} | name: ${result.name} | count: ${result.count}")
            textView.text = "age: ${result.age} | name: ${result.name} | count: ${result.count}"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeatureFragment()
    }
}