//import androidx.compose.material.*
import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

//import com.google.accompanist.coil.rememberCoilPainter
import com.example.instagramcloneapp.R
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramHome(){

    Scaffold(
        topBar = {
            InstagramTopAppBar()

        }
        , bottomBar = {
            BottomAppBar()
        },
        content = {padding->
            InstagramFeed()
        },
    )
    
}

@Composable
fun InstagramFeed() {

    val images = listOf(
        "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
        "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80"
    , "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
        "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80"

    );
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        items(images) { imageUrl ->

            InstagramPost(imageUrl = imageUrl)
           Spacer(modifier = Modifier.width(6.dp))
            Box(modifier = Modifier.padding(vertical = 8.dp)) {


              Row {

                  Spacer(modifier = Modifier.width(6.dp))
                  Image(
                      modifier = Modifier.height(25.dp),
                      painter =   painterResource(R.drawable.ic_filled_favorite),

                      contentDescription = "Icon favorite" // Provide a description for accessibility
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Image(
                      painter =   painterResource(R.drawable.ic_outlined_comment),
                      modifier = Modifier.height(25.dp),
                      contentDescription = "Icon favorite" // Provide a description for accessibility
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Image(
                      painter =   painterResource(R.drawable.ic_dm),
                      modifier = Modifier.height(25.dp),
                      contentDescription = "Icon favorite" // Provide a description for accessibility
                  )


                 // Spacer(modifier = Modifier.fillMaxSize())



              }
                


            }
            Spacer(modifier = Modifier
                .height(6.dp)
                .padding(10.dp))
            Text(text = "Insan paiso se nahi dil se amir hota hai ❤\uFE0F✨#prashant21\uD83D\uDCAB\uD83D\uDE0E #reels")
            Spacer(modifier = Modifier
                .height(6.dp)
                .padding(10.dp))

        }
    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun InstagramPost(imageUrl: String) {

    val painter =
        rememberImagePainter(data = imageUrl)

    Image(
        painter = painter,
        contentDescription = "Forest Image",
       modifier = Modifier
           .fillMaxWidth()
           .height(200.dp)
           .padding(horizontal = 5.dp, vertical = 5.dp)
           .background(color = Color.Blue),
        contentScale = ContentScale.Crop
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text("Instagram") },
       /* colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.wh,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),*/

         actions = {
             IconButton(onClick = { /* do something */ }) {
                 androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.ic_outlined_favorite), contentDescription = "Icons")
             }
             IconButton(onClick = { /* do something */ }) {
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.ic_dm), contentDescription = "Icons")
             }

        }
    )
}
@Composable
fun BottomAppBar(){
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf<User>(User("Home",R.drawable.ic_outlined_home),
        User("Reels",R.drawable.ic_filled_reels),
        User("Profile",R.drawable.ic_outlined_add)
        )



    NavigationBar {
       items.forEachIndexed { index, item ->

           NavigationBarItem(
               icon = { androidx.compose.material3.Icon(
                   modifier = Modifier.height(20.dp),
                   painter = painterResource(id = item.icon), contentDescription ="icons" ) },
               label = { Text(item.name) },
               selected = selectedItem == index,
               onClick = { selectedItem = index }
           )
       }
    }
}

data class User(val name: String, val icon: Int)