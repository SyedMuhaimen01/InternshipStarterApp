package com.muhaimen.internshipstarterapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhaimen.internshipstarterapp.R
import com.muhaimen.internshipstarterapp.data.Quote

class HomeViewModel:ViewModel() {

    private val _quotes=MutableLiveData<Quote>()
    val quote:MutableLiveData<Quote>
        get() = _quotes

    private val quotesList= listOf(
        Quote(R.string.quote_1),
        Quote(R.string.quote_2),
        Quote(R.string.quote_3),
        Quote(R.string.quote_4),
        Quote(R.string.quote_5),
    )

    fun showRandomQuote(){
        val randomIndex=(quotesList.indices).random()
        _quotes.value=quotesList[randomIndex]
    }
}