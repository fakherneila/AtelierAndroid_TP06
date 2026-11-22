package tn.tp.atelierandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class FicheTechniqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiche_technique)
        Log.d("AtelierCycle", "FicheTechniqueActivity.onCreate")
    }
}