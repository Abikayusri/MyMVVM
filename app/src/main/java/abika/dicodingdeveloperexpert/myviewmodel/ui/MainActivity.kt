package abika.dicodingdeveloperexpert.myviewmodel.ui

import abika.dicodingdeveloperexpert.myviewmodel.R
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieItem
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,MovieFragment()).commit()
    }
}
