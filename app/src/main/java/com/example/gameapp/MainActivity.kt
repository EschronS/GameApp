package com.example.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.builder.SayBuilder

class MainActivity : AppCompatActivity(), RobotLifecycleCallbacks{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // fullscreen view
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide() // hides the action bar
        setContentView(R.layout.activity_main)
        QiSDK.register(this, this)
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        // speech for the start button
        val bt1: Button = findViewById(R.id.button_start)
        val say = SayBuilder.with(qiContext)
            .withText("Hello, my name is Pepper. I am very Pleased to meet you." +
                    "Perhaps you’d like to tell me your name. Please type your name and press the submit button.")
            .build()

        bt1.setOnClickListener {
            // onclick robot speech
            say.async().run()
            // waiting for the finishing of speech
            Handler().postDelayed({
                // switching to the MainActivity2
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }, 8000)
        }

    }

    override fun onRobotFocusLost() {

    }

    override fun onRobotFocusRefused(reason: String?) {

    }
}