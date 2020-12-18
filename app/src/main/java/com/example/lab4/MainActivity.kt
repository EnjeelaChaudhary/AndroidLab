package com.example.lab4

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.view.View
import android.widget.*
import java.util.*
//

class MainActivity: AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var txtname:EditText
    private lateinit var post:TextView
    private lateinit var txtpost:EditText
    private lateinit var join:TextView
    private lateinit var txtjoin:EditText
    private lateinit var address:TextView
    private lateinit var txtaddress:EditText

    private val ppost = arrayOf("Manager","Accountant","Clerk")
    private lateinit var spinner:Spinner
    private lateinit var btn1:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name)
        txtname=findViewById(R.id.txtname)
        post=findViewById(R.id.post)
        spinner=findViewById(R.id.spinner)
        join=findViewById(R.id.join)
        txtjoin=findViewById(R.id.txtjoin)
        address=findViewById(R.id.address)
        txtaddress=findViewById(R.id.txtaddress)

        btn1=findViewById(R.id.btn1)

        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            ppost
        )

        //setting adapter to the spinner adapter
        spinner.adapter= adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            )
            {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity, "Selected item: $selectedItem", Toast.LENGTH_SHORT
                ).show()

            }



        }
        join.setOnClickListener {
            datePicker()
        }

        btn1.setOnClickListener {
            buttonInput()
        }

    }



    private fun datePicker(){
        val  c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view, year, monthOfYear, dayOfMonth ->
                join.setText("$dayOfMonth/${monthOfYear + 1}/$year")


            },
            year,
            month,
            day
        ).show()
    }


    private fun buttonInput(){

        var a=AlertDialog.Builder(this)
        a.setTitle("Data")
        var adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        adapter.add(name.text.toString())
        adapter.add(join.text.toString())
        adapter.add (ppost[spinner.selectedItemPosition])
        adapter.add(address.text.toString())

        a.setAdapter(
            adapter,
            object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("Not yet implemented")
                }

            }
        )
        a.create().show()


    }

}
