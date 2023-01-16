@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.easyprint.functions

import android.content.Context
import android.os.Looper
import android.widget.Toast
import androidx.compose.ui.res.stringResource
import com.example.easyprint.R
import com.example.easyprint.dataclass.UserData
import kotlinx.coroutines.*
import java.io.File
import java.io.IOException


@OptIn(DelicateCoroutinesApi::class)
fun fileBackground(file: File, fileName: String, userData: UserData, context: Context){
    GlobalScope.launch {
        try {
            val networkRequest = Networking()
            networkRequest.cancelPrintJob(userData = userData)
            networkRequest.deleteFile(userData = userData)
            networkRequest.fileUpload(file = file, fileName = fileName, userData = userData)
            Looper.prepare()
            Toast.makeText(context, R.string.succeeded_message, Toast.LENGTH_LONG).show()
            Looper.loop()}
        catch (e: IOException){
            Looper.prepare()
            Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show()
            Looper.loop()
        }
    }
}



@OptIn(DelicateCoroutinesApi::class)
fun stopBackground( userData: UserData, context: Context){
    GlobalScope.launch {
        try {
            val networkRequest = Networking()
            networkRequest.cancelPrintJob(userData = userData)
            networkRequest.deleteFile(userData = userData)
            Looper.prepare()
            Toast.makeText(context, R.string.cancel_message, Toast.LENGTH_LONG).show()
            Looper.loop()}
        catch (e: IOException) {
            Looper.prepare()
            Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show()
            Looper.loop()
        }
    }
}




fun fileSelection(fileName: String, context: Context, userData: UserData){
    val file = File(context.cacheDir, "file")
    file.createNewFile()
    file.outputStream().use {stream ->
        context.assets.open(fileName).copyTo(stream)}
    fileBackground(file = file, fileName = fileName, userData = userData, context = context)
}