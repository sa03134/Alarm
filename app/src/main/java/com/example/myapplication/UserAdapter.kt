package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter(val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        val time = view.findViewById<TextView>(R.id.tv_time)
        val task = view.findViewById<TextView>(R.id.tv_task)
        val lock = view.findViewById<TextView>(R.id.tv_lock)
        val alarm = view.findViewById<ImageView>(R.id.iv_alarm)

        val user = UserList[position]

        alarm.setImageResource(user.alarm)

        time.text = user.time
        task.text = user.task
        lock.text = user.lock


        return view
    }

}
