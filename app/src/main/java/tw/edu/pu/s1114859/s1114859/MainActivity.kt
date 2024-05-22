package tw.edu.pu.s1114859.s1114859

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tw.edu.pu.s1114859.s1114859.ui.theme.S1114859Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S1114859Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    Main()
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController){
    var appear by remember { mutableStateOf(true) }
    Column(modifier = Modifier
        .fillMaxSize()) {
        Text(text = "瑪利亞基金會服務總覽", color = Color.Blue)
        AnimatedVisibility(
            visible = appear,
            enter = fadeIn(
                initialAlpha = 0.1f,
                animationSpec = tween(1000))

                    + slideInVertically(
                animationSpec = tween(durationMillis = 5000)){ fullHeight ->
                fullHeight/3
            },
            exit=fadeOut(
                animationSpec = tween(durationMillis = 5000))
                    + slideOutVertically(
                animationSpec = tween(durationMillis = 5000)){fullHeight ->
                fullHeight/3
            }
        ) {
            Image(painter = painterResource(id = R.drawable.service), contentDescription = "服務")
        }

        Button(onClick = {
            navController.navigate("JumpSecond")
        }) {
            Text(text = "作者:資傳系邱家妤")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController){
    val context = LocalContext.current
    var appear by remember { mutableStateOf(true) }
    Column(modifier = Modifier
        .fillMaxSize()) {
        Text(text = "關於APP作者", color = Color.Blue)
        AnimatedVisibility(
            visible = appear,
            enter= fadeIn(
                initialAlpha = 0.1f,
                animationSpec = tween(durationMillis = 5000))
                    + slideInVertically(
                animationSpec = tween(durationMillis = 5000)){ fullHeight ->
                fullHeight/3
            },
            exit = fadeOut(
                animationSpec = tween(durationMillis = 5000))
                    + slideOutVertically(
                animationSpec = tween(durationMillis = 5000)){fullHeight ->
                fullHeight/3
            }
        ) {
            Image(painter = painterResource(id = R.drawable.chiusjennifer), contentDescription = "人像")
        }

        Button(onClick = {
            navController.navigate("JumpFirst")
        }) {
            Text(text = "服務總覽")
        }
    }
}
@Composable
fun OtherScreen(navController: NavController) {
    val context = LocalContext.current
    Column {
        Text(text = "主要機構", color = Color.Red)
        Row {
            Button(onClick = {
            }) {
                Text(text = "台中愛心家園")
            }
            Button(onClick = {navController.navigate("JumpForth")
            }) {
                Text(text = "瑪利亞學園")
            }
        }
        Box {
            Text(
                text = "[台中市愛心家園]經市政府公開評選後，委託瑪利亞基金會經營管理，於91年啟用，整棟建築物" +
                        "有四個樓層，目前開辦就醫、就養、就學、就業四大領域的實向業務，提供身心障礙者全方位的服務。"
            )
        }
        Text(text = "長按以下圖片，可以觀看瑪利亞學園地圖", color = Color.Blue )
        Image(painter = painterResource(id = R.drawable.lovehome), contentDescription ="愛心家園",
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit){
                    detectTapGestures(
                        onLongPress = {var it= Intent(Intent.ACTION_VIEW)
                            it.data= Uri.parse("geo:0,0?q=台中市愛心家園")
                            context.startActivity(it)
                        }
                    )
                })
    }
}
@Composable
fun fourScreen(navController: NavController){
    val context = LocalContext.current
    Column {
        Text(text = "主要機構", color = Color.Red)
        Row {
            Button(onClick = {navController.navigate("JumpOther")
            }) {
                Text(text = "台中愛心家園")
            }
            Button(onClick = {navController.navigate("JumpForth")
            }) {
                Text(text = "瑪利亞學園")
            }
        }
        Box {
            Text(
                text = "[瑪利亞學園]提供重度以及極重度多重障礙者日間照顧服務，以健康照護為基礎，支持生活多面向參予極學習概念，輔助發展重度身心障礙者自我概念為最終服務目的"
            )
        }
        Text(text = "雙擊以下圖片，可以觀看瑪利亞學園地圖", color = Color.Blue)
        Image(painter = painterResource(id = R.drawable.campus), contentDescription ="瑪利亞學園",
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit){
                    detectTapGestures(
                        onDoubleTap = {var it= Intent(Intent.ACTION_VIEW)
                            it.data= Uri.parse("geo:0,0?q=瑪利亞學園")
                            context.startActivity(it)

                        }
                    )
                })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(){
    val navController= rememberNavController()
    val context= LocalContext.current
    var showMenu by remember{ mutableStateOf(false) }
    Column {
        TopAppBar(title = { Image(painter = painterResource(id = R.drawable.maria), contentDescription ="logo" )},
            actions = {
                IconButton(
                    onClick = { showMenu = true }
                ) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                }

                DropdownMenu(
                    expanded = showMenu, onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("簡介") },
                        onClick = { navController.navigate("JumpFirst")})

                    DropdownMenuItem(
                        text = { Text("主要機構") },
                        onClick = { navController.navigate("JumpOther")})
                }


            })
        NavHost(navController = navController, startDestination = "JumpFirst")
        {
            composable("JumpFirst"){
                FirstScreen(navController=navController)
            }
            composable("JumpSecond"){
                SecondScreen(navController=navController)
            }
            composable("JumpOther"){
                OtherScreen(navController = navController)
            }
            composable("JumpForth"){
                fourScreen(navController = navController)
            }

        }
    }
}
