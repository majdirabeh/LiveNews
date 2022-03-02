package fr.com.tn.majdi.livenews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import fr.com.tn.majdi.livenews.R
import fr.com.tn.majdi.livenews.databinding.ActivityMainBinding

/**
 * Created by Majdi RABEH on 27/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}