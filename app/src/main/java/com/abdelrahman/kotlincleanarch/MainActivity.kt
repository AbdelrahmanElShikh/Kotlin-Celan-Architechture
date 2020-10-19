package com.abdelrahman.kotlincleanarch

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.abdelrahman.kotlincleanarch.presentation.model.BlogUi
import com.abdelrahman.kotlincleanarch.presentation.resource.PresentationResource
import com.abdelrahman.kotlincleanarch.presentation.viewmodels.BlogsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private val viewModel: BlogsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeBlogs()
        viewModel.getBlogs()
    }

    private fun observeBlogs() {
        viewModel.blogs.observe(
            this,
            Observer<PresentationResource<List<BlogUi>>> { blogsResponse ->
                when (blogsResponse.status) {
                    PresentationResource.Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        Log.e(TAG, "LOADING")
                    }
                    PresentationResource.Status.SUCCESS -> {
                        for (blog in blogsResponse.data!!) {
                            txt_blogTitle.append("\n${blog.title}")
                        }
                        progressBar.visibility = View.GONE
                    }
                    PresentationResource.Status.API_ERROR -> {
                        Log.e(TAG, "observeBlogs: API ERROR")
                        txt_blogTitle.text = blogsResponse.apiError!!.errorCode.toString()
                        progressBar.visibility = View.GONE
                    }
                    PresentationResource.Status.DOMAIN_ERROR -> {
                        Log.e(TAG, "observeBlogs DOMAIN ERROR: ",blogsResponse.throwable )
                        txt_blogTitle.text = blogsResponse.throwable!!.toString()
                        progressBar.visibility = View.GONE
                    }
                }

            })
    }
}