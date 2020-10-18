package com.example.madlevel4task2

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var gameRepository: GameRepository

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)
    private val mainScope = CoroutineScope(Dispatchers.Main)

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
                false
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
}