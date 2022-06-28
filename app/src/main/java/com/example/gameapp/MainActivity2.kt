package com.example.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.builder.SayBuilder

class MainActivity2 : AppCompatActivity(), RobotLifecycleCallbacks {
    // stores player name
    private var personName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main2)
        QiSDK.register(this, this)
    }


    override fun onRobotFocusGained(qiContext: QiContext?) {

        val nameText: EditText = findViewById(R.id.textName)
        val btnSubmit: Button = findViewById(R.id.button_submit)
        val btnHome: Button = findViewById(R.id.button_home)
        val btnPlay: Button = findViewById(R.id.button_play)
        val nameView: TextView = findViewById(R.id.nameView)
        val infoBtn: ImageButton = findViewById(R.id.button_info)

        // robot speech for the submit button click
        val say = SayBuilder.with(qiContext)

            .withText("Hello, $personName. I am very Pleased to meet you." +
                    "Would you like to play a quick English Language game." +
                    "Please press \"Play\" or \"Home\" button. For more information about " +
                    "the game please press the \"Info\" button on the top right corner")
            .build()

        // robot speech for the game info button click
        val sayInfo = SayBuilder.with(qiContext)

            .withText("The game is quite simple. In German we have two basic words \"machen\" and \"tun\" which are " +
                    "used to indicate the performance of an action. In English the words we use are \"make\" and \"do\"." +
                    "Depending on what we want to say, we use either \"make\" or \"do\". I have some sentences stored in my memory banks." +
                    "Some of these are \"make\" sentences and some are \"do\" sentences. When you press the play button" +
                    "I'll display a sentence with blanks and you have to choose the answer either \"make\" or \"do\" within 20 seconds." +
                    "pay attention to the tense. The word could be in the present or past tense, or another tense such as the present perfect." +
                    "For instance, I \"d0\" my homework every evening, I \"did\" my homework last night, I \"make\" important decisions as part of my job, " +
                    "I have \"made\" a cake for your birthday. $personName, you can play the game by pressing the play button.")
            .build()

        val sayHome = SayBuilder.with(qiContext)
            .withText("Have a great day. See you soon $personName.")
            .build()

        val sayPlay = SayBuilder.with(qiContext)
            .withText("Great, Then let’s get started. Here we go with the first sentence.")
            .build()

        btnSubmit.setOnClickListener {
            personName = nameText.text.toString()
            nameView.text = "Hello! $personName" // displays person name
            say.async().run()
        }

        infoBtn.setOnClickListener {
            sayInfo.async().run()
        }
        btnHome.setOnClickListener {
            // home button switches to the home view layout
            sayHome.async().run()
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, 3000)
        }

        btnPlay.setOnClickListener {
            // play button switches to the game view layout
            sayPlay.async().run()
            Handler().postDelayed({
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }, 5000)
        }
    }

    override fun onRobotFocusLost() {

    }

    override fun onRobotFocusRefused(reason: String?) {

    }
}