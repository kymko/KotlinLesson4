package com.example.kotlinlesson4.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinlesson4.databinding.ActivityMainBinding
import com.example.kotlinlesson4.ui.fragments.FirstFragment
import com.example.kotlinlesson4.ui.fragments.SecondFragment
import com.example.kotlinlesson4.ui.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments: ArrayList<Fragment> = arrayListOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        binding.viewPager.adapter = adapter

    }

}

//Добавить ViewPager из 3 фрагментов в MainActivity
//- 1 фрагмент кнопки ‘+’ и ‘-’, при нажатии вызывать соответствующие методы у ViewModel и выполнять необходимую логику
//- 2 фрагмент отображает текущее значение LiveData счетчика
//- 3 фрагмент отображает список выполненных операций (просто список строковых значений, который наблюдаются у ViewModel-a)
//- Для всех задач использовать один ViewModel