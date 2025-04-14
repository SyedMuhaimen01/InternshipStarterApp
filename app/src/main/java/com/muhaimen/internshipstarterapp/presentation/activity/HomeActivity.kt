package com.muhaimen.internshipstarterapp.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.muhaimen.internshipstarterapp.R
import com.muhaimen.internshipstarterapp.databinding.ActivityHomeBinding
import com.muhaimen.internshipstarterapp.model.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.showMotivationBtn.setOnClickListener {
            homeViewModel.showRandomQuote()
        }

       homeViewModel.quote.observe(this) { quote ->
           AlertDialog.Builder(this)
               .setTitle(getString(R.string.motivation_dialog_box_title))
               .setMessage(quote.quote)
               .setPositiveButton("ok") { dialog, _ ->
                   dialog.dismiss()
               }
               .show()
       }
    }
}