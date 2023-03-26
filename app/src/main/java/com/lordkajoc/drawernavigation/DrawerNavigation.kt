package com.lordkajoc.drawernavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.lordkajoc.drawernavigation.databinding.ActivityDrawerNavBinding

class DrawerNavigation : AppCompatActivity() {
    lateinit var binding: ActivityDrawerNavBinding
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.myDrawerLayout
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle.syncState()

        val firstFragment = FragmentPerson()
        val secondFragment = FragmentHome()

        setCurrentFragment(firstFragment)
        binding.navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)
            when (it.itemId){
                R.id.person->{
                    Toast.makeText(this, "Person", Toast.LENGTH_SHORT).show()
                    setCurrentFragment(firstFragment)
                    true}
                R.id.home->{
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    setCurrentFragment(secondFragment)
                    true}
                else -> {false}
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}