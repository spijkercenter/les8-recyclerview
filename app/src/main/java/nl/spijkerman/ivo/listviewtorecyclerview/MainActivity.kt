package nl.spijkerman.ivo.listviewtorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter(layoutInflater)

        val userList = findViewById<RecyclerView>(R.id.main_userList_recyclerView)
        userList.setHasFixedSize(true)
        userList.layoutManager = LinearLayoutManager(this)
        userList.adapter = adapter

        adapter.setData(dummyUsers)
    }
}