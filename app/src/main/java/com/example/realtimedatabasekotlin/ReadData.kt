package com.example.realtimedatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.realtimedatabasekotlin.databinding.ActivityReadDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ReadData : AppCompatActivity() {

    private lateinit var binding : ActivityReadDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val number = intent.getStringExtra("number")
        if  (number !=null){
            readData(number)

        }else{
//            Toast.makeText(this,"you Dont Have Mobile Number",Toast.LENGTH_SHORT).show()
            binding.readdataBtn.setOnClickListener {
            val typenumber : String = binding.etnumber.text.toString()
//                val number = intent.getStringExtra("number")

                if(typenumber.isNotEmpty()){
                    readData(typenumber)
                }
                else
                {
                    Toast.makeText(this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
    private fun readData(userName: String) {

        database = FirebaseDatabase.getInstance().getReference("Consultants")
        database.child(userName).get().addOnSuccessListener {

            if (it.exists()){

                val name = it.child("name").value
                val number = it.child("number").value
                val age = it.child("age").value
                val address=it.child("address").value
//                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.etnumber.text.clear()
                binding.viewname.text = name.toString().trim();
                binding.viewnumber.text = number.toString()
                binding.viewage.text = age.toString()
                binding.viewaddress.text=address.toString()

            }else{

                Toast.makeText(this,"Invalid Mobile Number",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }


    }


    private fun updateData(userName: String) {

        database = FirebaseDatabase.getInstance().getReference("Consultants")
        database.child(userName).get().addOnSuccessListener {

            if (it.exists()){

                val name = it.child("name").value
                val number = it.child("number").value
                val age = it.child("age").value
                val address=it.child("address").value
//                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.etnumber.text.clear()
                binding.viewname.text = name.toString().trim();
                binding.viewnumber.text = number.toString()
                binding.viewage.text = age.toString()
                binding.viewaddress.text=address.toString()

            }else{

                Toast.makeText(this,"Invalid Mobile Number",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }



    }
}