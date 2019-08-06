package abika.dicodingdeveloperexpert.myviewmodel.ui

import abika.dicodingdeveloperexpert.myviewmodel.R
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieItem
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.getStatus().observe(this, Observer { t ->
            if (t ?: true) {
                rvMain.visibility = View.GONE
            }
        })

        mainViewModel.setData().observe(this, Observer { t ->
            t?.results?.let { showData(it) }
        })
    }

    private fun showData(data: List<MovieItem>) {
        rvMain.adapter = MovieResponse(data)

    }

}