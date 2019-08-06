package abika.dicodingdeveloperexpert.myviewmodel.network

import abika.dicodingdeveloperexpert.myviewmodel.model.Movie
import android.telecom.Call
import retrofit2.http.GET

interface ApiService {

    @GET("upcoming?api_key=c8ff8c510e74a75a3643870242745d71")
    fun movie():Call<Movie>
}