package abika.dicodingdeveloperexpert.myviewmodel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import abika.dicodingdeveloperexpert.myviewmodel.R
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieItem
import abika.dicodingdeveloperexpert.myviewmodel.model.MovieResponse
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        with(viewModel) {
            getStatus().observe(this@MovieFragment, Observer { status ->
                if (status ?: true) {
                    list.visibility = View.GONE
                    textStatus.visibility = View.VISIBLE
                } else {
                    list.visibility = View.VISIBLE
                    textStatus.visibility = View.GONE
                }
            })
            viewModel.setData().observe(this@MovieFragment, Observer { status ->
                status?.results?.let { showData(it) }
            })
        }
    }

    private fun showData(data: List<MovieItem>) {
        list.adapter = MovieResponse(data)

    }

}