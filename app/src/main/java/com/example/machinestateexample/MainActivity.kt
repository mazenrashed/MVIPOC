package com.example.machinestateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

data class BranchesSelectorState(
    var shown : Boolean = false,
    var text : String = "The default text"
)


sealed class Event{
    object OnNavigateToHomeScreen : Event()
}

enum class PageType{
    STATIC,
    COLLECTION,
    OTHER
}