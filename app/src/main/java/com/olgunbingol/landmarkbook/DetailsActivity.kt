package com.olgunbingol.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olgunbingol.landmarkbook.databinding.ActivityDetailsBinding // Eksik import eklendi

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding // Doğru binding sınıfı kullanıldı
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater) // Doğru inflate işlemi yapıldı
        val view = binding.root
        setContentView(view)
        val intent = intent

        val selectedLandmark = intent.getSerializableExtra("Landmark") as Landmark
        binding.nameText.text = selectedLandmark.name
        binding.countryText.text = selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)


    }
}
