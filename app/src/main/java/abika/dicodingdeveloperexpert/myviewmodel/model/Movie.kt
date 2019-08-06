package abika.dicodingdeveloperexpert.myviewmodel.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Movie(
    val results: List<MovieItem>? = null
)