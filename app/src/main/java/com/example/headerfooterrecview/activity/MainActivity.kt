package com.example.headerfooterrecview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.headerfooterrecview.R
import com.example.headerfooterrecview.moduls.CustomAdapter
import com.example.headerfooterrecview.moduls.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val members = prepareMemberList()
        refreshAdapter(members)

    }

    fun refreshAdapter(member: List<Member>){

        val adapter = CustomAdapter(member)
        only_recycler.adapter = adapter

    }

    fun prepareMemberList():List<Member>{
        val member = ArrayList<Member>()

        for (i in 0..29){
            if(i == 5||i == 16||i == 25){
                member.add(Member("Jalal-ad-Adin","Qasmi",false))
            }else member.add(Member("Nazim","Karim",true))
        }
        return member

    }
}