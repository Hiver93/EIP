package com.aos.eip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.aos.eip.dto.Workbook
import com.aos.eip.retrofit.RetrofitCall
import com.aos.eip.viewmodel.WorkbookViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var idx: Int = 0
    var idxList: List<Int> = listOf()
    private val viewModel by lazy{
        ViewModelProvider(this).get(WorkbookViewModel::class.java)
    }
    private var isQ: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitCall().getWorkbookList()

        val qaCard = findViewById<TextView>(R.id.cardText)
        qaCard.movementMethod = ScrollingMovementMethod.getInstance()
        qaCard.setOnClickListener(this)
        findViewById<Button>(R.id.refresh).setOnClickListener(this)
        findViewById<LinearLayout>(R.id.card).setOnClickListener(this)
        findViewById<Button>(R.id.nextBtn).setOnClickListener(this)
        findViewById<Button>(R.id.prevBtn).setOnClickListener(this)

        viewModel.workbookList.observe(this) {
            idx = 0
            if (viewModel.workbookList.value!!.isNotEmpty()) {
                randomIdxList()
                prev()
            }
        }


    }

    override fun onClick(v: View?){
        when(v!!.id){
            R.id.refresh -> refresh()
            R.id.cardText -> flip()
            R.id.prevBtn -> prev()
            R.id.nextBtn -> next()
        }
    }

    fun refresh(){
        RetrofitCall().getWorkbookList()
    }

    fun flip(){
        val list: List<Workbook> = viewModel.workbookList.value!!
        val qaCard = findViewById<TextView>(R.id.cardText)
        if(list.isNotEmpty()) {
            if (isQ) {
                qaCard.setText("A. " + list.get(idxList.get(idx)).answer)
                isQ = false
            } else {
                qaCard.setText("Q. " + list.get(idxList.get(idx)).question)
                isQ = true
            }
        }
    }

    fun prev(){
        val list: List<Workbook> = viewModel.workbookList.value!!
        val qaCard = findViewById<TextView>(R.id.cardText)
        idx--
        if(idx < 0)
            idx = 0
        qaCard.setText("Q. " + list.get(idxList.get(idx)).question)
        isQ = true
    }

    fun next(){
        val list: List<Workbook> = viewModel.workbookList.value!!
        val qaCard = findViewById<TextView>(R.id.cardText)
        idx++
        if(list.size <= idx)
            idx = list.size-1
        qaCard.setText("Q. " + list.get(idxList.get(idx)).question)
        isQ = true
    }

    fun randomIdxList(){
        idxList = (0..viewModel.workbookList.value!!.size-1).toList()
        idxList = idxList.shuffled()
    }

}