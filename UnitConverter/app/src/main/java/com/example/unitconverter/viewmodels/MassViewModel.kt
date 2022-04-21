package com.example.unitconverter.viewmodels

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unitconverter.R


class MassViewModel : ViewModel() {
    private val _mass: MutableLiveData<Int> = MutableLiveData(R.string.kilograms)

    val mass: LiveData<Int>
        get() = _mass

    fun setMass(value: Int) {
        _mass.value = value
    }

    private val _kilograms: MutableLiveData<String> = MutableLiveData("")

    val kilograms: LiveData<String>
        get() = _kilograms

    fun getMassAsFloat(): Float = (_kilograms.value ?: "").let {
        return try {
            it.toFloat()
        } catch (e: NumberFormatException) {
            Float.NaN
        }
    }

    fun setWeight(value: String) {
        _kilograms.value = value
    }

    fun convert() = getMassAsFloat().let {
        if (!it.isNaN())
            if (_mass.value == R.string.kilograms)
                it * 2.20462262F
            else
                it / 2.20462262F
        else
            Float.NaN
    }
}