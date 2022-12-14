package com.api.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.api.demo.database.AppDatabase
import com.api.demo.databinding.ActivityMainBinding
import com.api.demo.viewmodel.MainViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "AAA"
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel = MainViewModel(this)
        binding.viewModel = viewModel

        db = AppDatabase.getInstance(this)
        var alluser = db.userDao().getAllUser()
        Log.e(TAG, "total user before api call : ${alluser.size}")
        binding.btnstart.setOnClickListener {

            if (viewModel.userJob?.isActive == true) {
                viewModel.userJob!!.cancel()
                binding.btnstart.text = "Start"
            } else {
                viewModel.getAllUser()
                binding.btnstart.text = "Stop"
            }
        }
        viewModel.liveUser.observe(this@MainActivity, Observer { it ->
            Log.e(TAG, "onCreate: ")
            binding.btnstart.text = "Start"
            Toast.makeText(this, "Executed", Toast.LENGTH_SHORT).show()
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().clearAllData()
                db.userDao().addUser(it)
                var alluser = db.userDao().getAllUser()
                Log.e(TAG, "total user : ${alluser.size}")
            }

        })
//        viewModel.getAllUser()

    }

    override fun onDestroy() {
        viewModel.userJob?.cancel()
        super.onDestroy()
    }
}