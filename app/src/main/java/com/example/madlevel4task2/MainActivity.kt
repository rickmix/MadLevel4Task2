package com.example.madlevel4task2

import android.app.ActionBar
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id in
                arrayOf(R.id.FirstFragment)) {
                menu.findItem(R.id.delete_history).setVisible(false);
                menu.findItem(R.id.check_history).setVisible(true);
                menu.findItem(R.id.go_back).setVisible(false);
            } else {
                menu.findItem(R.id.delete_history).setVisible(true);
                menu.findItem(R.id.check_history).setVisible(false);
                menu.findItem(R.id.go_back).setVisible(true);
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.check_history -> {
                navController.navigate(
                    R.id.action_FirstFragment_to_SecondFragment
                )
                true
            }
            R.id.delete_history -> {
                // TODO DELETE ALL HISTORY ITEMS
                true
            }
            R.id.go_back -> {
                navController.navigate(
                    R.id.action_SecondFragment_to_FirstFragment
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun fabToggler() {

    }
}