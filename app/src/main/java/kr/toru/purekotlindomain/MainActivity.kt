package kr.toru.purekotlindomain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.toru.purekotlindomain.feature.ui.FeatureFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initScreen()
    }

    private fun initScreen() {
        supportFragmentManager.beginTransaction().replace(R.id.container, FeatureFragment.newInstance()).commit()
    }
}