package com.example.superhero

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.Model.Superhero
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroView()
                    SuperHeroView()
                }
            }
        }
    }
}

@Composable
fun SuperHeroView(){
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        items(GetSuperheroes()){
            ItemHero (superhero = it, onItemSelected = {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit){
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }
    ) {
        Column {
            Image(painter = painterResource(id = superhero.photo), contentDescription = "foto superheroe",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = superhero.superheroName,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.TopCenter))
            Text(text = superhero.realName,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center))
            Text(text = superhero.publisher,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomCenter))
        }
    }
}

fun GetSuperheroes(): List<Superhero>{
    return listOf<Superhero>(
        Superhero("Spiderman", "Petter Parker", "Marve", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wyne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Maevel", R.drawable.thor),
        Superhero("Flahs", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Grennlatern", "Alan Scott", "DC", R.drawable.green_lantern)
    )
}
