package kr.toru.purekotlindomain

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.toru.purekotlindomain.domain.HttpClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    private fun test() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = HttpClient.getTest(name = "Toru")
            CoroutineScope(Dispatchers.Main).launch {
                findViewById<TextView>(R.id.text).text = "${result.name}, ${result.count}, ${result.age}"
            }
        }
    }
}