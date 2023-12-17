package com.olgunbingol.landmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.olgunbingol.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList()

        val kiz = Landmark("Kiz kulesi", "Turkey", R.drawable.kiz)
        val galata = Landmark("Galata kulesi", "Turkey", R.drawable.galata)
        val eyfel = Landmark("Eyfel kulesi", "Turkey", R.drawable.eyfel)

        landmarkList.add(kiz)
        landmarkList.add(galata)
        landmarkList.add(eyfel)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map {Landmark -> Landmark.name


        })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("Landmark",landmarkList.get(position))
            startActivity(intent)
        }
    }
}
