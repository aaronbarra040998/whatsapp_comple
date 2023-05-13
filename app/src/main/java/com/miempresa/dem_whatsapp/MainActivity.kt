package com.miempresa.dem_whatsapp

// Importamos las librerías necesarias
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.view.Menu

// Declaramos una clase llamada MainActivity que extiende de la clase AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Declaramos las variables que vamos a utilizar para el TabLayout y ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: myViewAdapter

    // Función que se ejecuta cuando se crea la actividad principal
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecemos el layout de la actividad
        setContentView(R.layout.activity_main)

        // Configuramos el ActionBar de la actividad
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple)))

        // Configuramos el TabLayout y el ViewPager2
        tabLayout = findViewById(R.id.tab)
        viewPager2 = findViewById(R.id.view)
        adapter = myViewAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Call"
                }
                1 -> {
                    tab.text = "Chats"
                }
                2 -> {
                    tab.text = "Contacts"
                }
            }
        }.attach()
    }

    // Función que se ejecuta cuando se crea el menú de opciones de la actividad
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflamos el layout del menú
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }
}
