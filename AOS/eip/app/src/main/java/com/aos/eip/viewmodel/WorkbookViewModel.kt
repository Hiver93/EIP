package com.aos.eip.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aos.eip.dto.Workbook

object WorkbookViewModel: ViewModel() {
    private var _workbookList = MutableLiveData<List<Workbook>>()

    val workbookList: LiveData<List<Workbook>>
        get() = _workbookList

    init{
        _workbookList.value = listOf()
    }

    fun updateWorkbookList(workbookList: List<Workbook>){
        _workbookList.value = workbookList
    }

}