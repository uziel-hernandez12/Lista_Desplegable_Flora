
package com.example.flora.data

import com.example.affirmations.R
import com.example.flora.model.Flora


class Datasource() {
    fun loadFloras(): List<Flora> {
        return listOf<Flora>(
            Flora(R.string.flora1, R.drawable.image1),
            Flora(R.string.flora2, R.drawable.image2),
            Flora(R.string.flora3, R.drawable.image3),
            Flora(R.string.flora4, R.drawable.image4),
            Flora(R.string.flora5, R.drawable.image5),
            Flora(R.string.flora6, R.drawable.image6),
            Flora(R.string.flora7, R.drawable.image7),
            Flora(R.string.flora8, R.drawable.image8))
    }
}
