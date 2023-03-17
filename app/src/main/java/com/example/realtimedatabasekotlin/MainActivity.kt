package com.example.realtimedatabasekotlin

import android.R.id
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realtimedatabasekotlin.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {

            val name = binding.name.text.toString()
            val number = binding.number.text.toString()
            val age = binding.age.text.toString()
            val address = binding.address.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Consultants")
            val User = User(name,number,age,address)
            database.child(number).setValue(User).addOnSuccessListener {

                binding.name.text.clear()
                binding.number.text.clear()
                binding.age.text.clear()
                binding.address.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

//                startActivity(Intent(this, ReadData::class.java))
                val intent = Intent(this@MainActivity, ReadData::class.java)
                intent.putExtra("number", number)
                startActivity(intent)

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }


        }

    }
}