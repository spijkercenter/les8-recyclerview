package nl.spijkerman.ivo.listviewtorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val nameView = findViewById<TextView>(R.id.userDetail_name_textView)
        val name = intent.getStringExtra("name")

        nameView.text = name
    }
}