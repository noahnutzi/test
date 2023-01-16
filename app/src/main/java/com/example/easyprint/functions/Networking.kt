package com.example.easyprint.functions

import com.example.easyprint.constants.GCodeFiles
import com.example.easyprint.dataclass.UserData
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class Networking {
    fun fileUpload(file: File, fileName: String, userData: UserData) {
        val client = OkHttpClient()
        val mediaType = "application/octet-stream".toMediaType()
        val requestBody = MultipartBody.Builder()
            .setType(type = MultipartBody.FORM)
            .addFormDataPart(name = "print", value = "true")
            .addFormDataPart(name = "file", filename = fileName, body = file.asRequestBody(contentType = mediaType))
            .build()

        val request = Request.Builder()
            .header(name = "Authorization", value = "Bearer ${userData.user_apikey}")
            .url(url = "http://${userData.user_ip}/api/files/local")
            .post(body = requestBody)
            .build()
        client.newCall(request = request).execute()
    }



    fun cancelPrintJob(userData: UserData) {
        val client = OkHttpClient()
            .newBuilder()
            .build()
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody = RequestBody.create(mediaType, content = "{\r\n  \"command\": \"cancel\"\r\n}")
        val request = Request.Builder()
            .url(url = "http://${userData.user_ip}/api/job")
            .method(method = "POST", body = requestBody)
            .addHeader(name = "Authorization", value = "Bearer ${userData.user_apikey}")
            .addHeader(name = "Content-Type", value = "application/json")
            .build()
        client.newCall(request = request).execute()
    }



    fun deleteFile(userData: UserData){
        for (item in list){
            val client = OkHttpClient()
                .newBuilder()
                .build()
            val mediaType = "text/plain".toMediaTypeOrNull()
            val requestBody = RequestBody.create(mediaType, content = "")
            val request = Request.Builder()
                .url(url = "http://${userData.user_ip}/api/files/local/${item}")
                .method(method = "DELETE", body =  requestBody)
                .addHeader(name = "Authorization", value = "Bearer ${userData.user_apikey}")
                .build()
            client.newCall(request = request).execute()
        }
    }


    private val list = listOf<String>(
        GCodeFiles.Benchy,
        GCodeFiles.Lego_duplo,
        GCodeFiles.Lego,
        GCodeFiles.Yoda
    )

}