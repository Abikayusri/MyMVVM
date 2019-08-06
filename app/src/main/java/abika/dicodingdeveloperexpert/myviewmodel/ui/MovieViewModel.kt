package abika.dicodingdeveloperexpert.myviewmodel.ui

import abika.dicodingdeveloperexpert.myviewmodel.model.Movie
import abika.dicodingdeveloperexpert.myviewmodel.network.NetworkConfig
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var data = MutableLiveData<Movie>()
    private var status = MutableLiveData<Boolean>()
    val TAG = "MovieViewModel"

    init {

        getData()
    }

    private fun getData() {
        status.value = true

        NetworkConfig().api().movie().enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d(TAG, "onFailure")
                status.value = true
                data.value = null
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                Log.d(TAG, "onRespone")
                status.value = false
                if(response.isSuccessful){
                    Log.d(TAG, "onRespone isSuccessful")
                    data.value = response.body()
                }
                else{
                    Log.d(TAG, "onRespone isNotSuccessful")
                    status.value = true
                }
            }
        })
    }

    fun setData() : MutableLiveData<Movie> {
        return data
    }

    fun getStatus():MutableLiveData<Boolean>{
        status.value = true
        return status
    }
}