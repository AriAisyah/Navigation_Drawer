package com.muzaaz.navigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.muzaaz.navigationdrawer.Fragment.Friend_Fragment
import com.muzaaz.navigationdrawer.Fragment.Message_Fragment
import com.muzaaz.navigationdrawer.Fragment.Profile_Fragment
import com.muzaaz.navigationdrawer.Fragment.Update_Fragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerlayout : DrawerLayout
    lateinit var navigationView: NavigationView

    lateinit var friendFragment: Friend_Fragment
    lateinit var messageFragment: Message_Fragment
    lateinit var profileFragment: Profile_Fragment
    lateinit var updateFragment: Update_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerlayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        val toogle = ActionBarDrawerToggle(
            this, drawerlayout, toolbar, 0, 0
        )

        drawerlayout.addDrawerListener(toogle)
        toogle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_provile -> {
                profileFragment = Profile_Fragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, profileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.nav_message ->{
                messageFragment = Message_Fragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, messageFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.nav_friend ->{
                friendFragment = Friend_Fragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, friendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.nav_update ->{
                updateFragment = Update_Fragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, updateFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.nav_signout ->{
                Toast.makeText(this,"Signout Clicked", Toast.LENGTH_SHORT).show()
            }
        }

        drawerlayout.closeDrawer(GravityCompat.START)
        return true

    }

}
