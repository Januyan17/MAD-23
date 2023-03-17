package com.example.realtimedatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.realtimedatabasekotlin.databinding.ActivityUpdateDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateData : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lastname = intent.getStringExtra("lastname")

        binding.updateBtn.setOnClickListener {

            val name = binding.name.text.toString()
            val number = binding.address.text.toString()
            val address = binding.number.text.toString()
            val age = binding.age.text.toString()

            updateData(name,number,age,address)

        }

    }

    private fun updateData(name: String, address: String, number: String, age: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
                "name" to name,
                "age" to address,
                "address" to age
        )

        database.child(number).updateChildren(user).addOnSuccessListener {

            binding.name.text.clear()
            binding.address.text.clear()
            binding.number.text.clear()
            binding.age.text.clear()
            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{

            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

        }}
}