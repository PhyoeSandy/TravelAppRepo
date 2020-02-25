package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.dataagents

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.responses.GetAllToursResponse
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.BASE_URL
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.GET_TOURS
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
object HttpUrlConnectionDataAgentImpl : ToursDataAgent {
    override fun getAllTours(onSuccess: (DataVO) -> Unit, onFailure: (String) -> Unit) {
        GetToursTask(
            onSuccess = onSuccess,
            onFailure = onFailure).execute()
    }

    // AsyncTask has not for connect Data Layer so put param in Primary Constructor
    class GetToursTask(val onSuccess: (DataVO) -> Unit,
                       val onFailure: (String) -> Unit) : AsyncTask<Void,Void,GetAllToursResponse>(){

        override fun doInBackground(vararg params: Void?): GetAllToursResponse? {
            // background work ( work in background thread )
            val url : URL
            var reader: BufferedReader? =null
            val stringBuilder: StringBuilder

            try{
                // create httpurl connection
                url = URL(BASE_URL + GET_TOURS ) //1.

                val connection = url.openConnection() as HttpURLConnection // 2.

                // just want to do an HTTP GET here
                connection.requestMethod = "GET" //3.

                //give it 15 sec to respond
                connection.readTimeout = 15 * 1000  //4. millisec

                connection.doInput = true       //5.
                connection.doOutput = true

               /* if exist parm on API
               // put the request param into NameValuePair list.
                val params = ArrayList<NameValuePair>()   // 6.
                params.add(
                    BasicNameValuePair(
                        PARAM_ACCESS_TOKEN, // const value
                        accessToken // from constructor
                    )
                )*/

                //write the parameters from NameValuePair list into connection obj
                val outputStream = connection.outputStream
                val writer = BufferedWriter(
                    OutputStreamWriter(outputStream,"UTF-8")
                )
                writer.write("")
                writer.flush()
                writer.close()
                outputStream.close()

                connection.connect()  //7.

                // read the output from Server
                reader = BufferedReader(InputStreamReader(connection.inputStream))  //8.
                stringBuilder = StringBuilder()

                for(line:String in reader.readLines()){
                    stringBuilder.append(line + "\n")
                }

                val responseString = stringBuilder.toString()
                return Gson().fromJson(responseString,GetAllToursResponse::class.java)

            }catch (e: Exception){
                e.printStackTrace()
                Log.e("NewsError",e.message ?: "")
            }finally {
                // close reader, this can throw an exception too, so wrap it in another try / catch block.
                if(reader != null){
                    try {
                        reader.close()
                    }catch (ioe: IOException){
                        ioe.printStackTrace()
                    }
                }
            }
            return null
        }

        override fun onPostExecute(result: GetAllToursResponse?) {
            super.onPostExecute(result)
            if(result != null){

            }else{

            }
        }



    }


}