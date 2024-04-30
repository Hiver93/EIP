package com.aos.eip.retrofit

import android.util.Log
import com.aos.eip.dto.Workbook
import com.aos.eip.viewmodel.WorkbookViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCall {
    fun getWorkbookList(){
        ApiObject.getRetrofitService.getWorkBookList()
            .enqueue(object: Callback<List<Workbook>>{
                override fun onResponse(
                    call: Call<List<Workbook>>,
                    response: Response<List<Workbook>>
                ) {
                    if(response.isSuccessful){
                        val workbookList = response.body()
                        Log.i("get",workbookList.toString())
                        WorkbookViewModel.updateWorkbookList(workbookList!!)
                    }
                    else{
                        Log.e("Get",response.toString())
                    }
                }

                override fun onFailure(call: Call<List<Workbook>>, t: Throwable) {
                    Log.e("Get",t.message.toString())
                }
            })
    }
}