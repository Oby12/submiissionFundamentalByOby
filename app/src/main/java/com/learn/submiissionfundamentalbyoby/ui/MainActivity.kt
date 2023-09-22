package com.learn.submiissionfundamentalbyoby.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.submiissionfundamentalbyoby.R
import com.learn.submiissionfundamentalbyoby.data.response.ItemsItem
import com.learn.submiissionfundamentalbyoby.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainViewModel by viewModels<MainUserModel>()

    companion object{
        private const val TAG = "MainActivity"
        private const val USER_ID = "104689136"
    }
    /*private lateinit var userViewModel : MainUserModel
    private lateinit var userAdapater : userAdapter*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        //lis user
        mainViewModel.listUser.observe(this) { consumerReviews ->
            setReviewData(consumerReviews)
        }

    }

    //loading
    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    //adapter
    private fun setReviewData(consumerReviews: List<ItemsItem>) {
        val adapter = userAdapter()
        adapter.submitList(consumerReviews)
        binding.rvUser.adapter = adapter
    }



    }
