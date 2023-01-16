package com.example.easyprint.data

import com.example.easyprint.AppScreens
import com.example.easyprint.R
import com.example.easyprint.dataclass.DataForScreen

//store images, texts and routes for the displayed print cards on the main screen
class DatasourceMainScreen {
    fun loadData(): List<DataForScreen> {
        return listOf(
            DataForScreen(R.string.benchy, R.drawable.transparentbenchy, AppScreens.PrintObjectBenchy.name),
            DataForScreen(R.string.lego_duplo, R.drawable.transparentduplo, AppScreens.PrintObjectLegoDuplo.name),
            DataForScreen(R.string.lego, R.drawable.transparentlego, AppScreens.PrintObjectLego.name),
            DataForScreen(R.string.yoda, R.drawable.transparentyoda, AppScreens.PrintObjectYoda.name),
            DataForScreen(R.string.coming_soon, R.drawable.comingsoon, AppScreens.Main.name),
        )
    }
}