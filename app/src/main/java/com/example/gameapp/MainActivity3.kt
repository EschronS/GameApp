package com.example.gameapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.builder.SayBuilder

class MainActivity3 : AppCompatActivity(), RobotLifecycleCallbacks {

    // List of questions
    private var questions = mutableListOf(
        "Many people __ more than the 30 kilometre per hour speed limit in this area",
        "Jane has just applied to __ a further education course to help her acquire new skills for her job",
        "Jack __ the newspaper crossword every day and usually completes it",
        "Jennifer __ a drawing of me that really captures my likeness",
        "He always __ his job well he is a very competent employee",
        "Did you __ your exam in that subject yet, or do you still have it ahead of you",
        "Keefer __ rather badly in his exam and will have to repeat it",
        "I am very happy to __ business with you as I think we will make a lot of money in this venture",
        "I had a bad car accident which __ some terrible damage to my car. I luckily escaped uninjured",
        "I am Pepper. I come in peace and wish to __ you no harm",
        "My son has so much homework to __, it will take the poor fellow all weekend",
        "I’ve __ a big change in my life by finding a new job and moving to a new city",
        "You have a hard choice to __ between the two excellent jobs you’ve been offered",
        "John __ a negative comment about my new suit, which I din’t like",
        "I was’t happy about receiving my package two weeks late, so I __ a complaint to the delivery company about it",
        "I’ve __ a decision about which of the two jobs I want to take",
        "Jeff Bezos and Elon Musk have __ huge fortunes in business",
        "Sophie __ a joke about Harald Schmidt which was really funny",
        "I have so many things to do, I’ll have to __ a long to-do list just to start dealing with them",
        "Our company __ a huge loss of five billion Euros last year",
        "I __ a mistake in my calculations and therefore the solution to the equation is wrong",
        "The kids are fast asleep. Don’t __ any noise or you’ll wake them up",
        "What do you mean the bill is unpaid? I __ the payment three weeks ago!",
        "Ok, I think you’ve __ your point, there’s no need to keep repeating why you feel the project will be a failure"

    )
    // List of answers according to questions list sequence
    private var answer = mutableListOf(
        "make", "do", "does", "did" , "does" , "do", "did", "do", "did", "do", "do", "made", "make", "made", "made", "made", "made", "made",
        "make", "made", "made", "make", "made", "made"
    )

    var quesIndex = 0
    var counter = 0 // used for the timer visualization
    var min = 0

    var qNum = 1 // change the question numbers
    var score = 0 // stores individual team/group score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main3)
        changeQuestions()
        QiSDK.register(this, this)
    }

    private fun changeQuestions(){
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                questions()
                handler.postDelayed(this, 19000)
                val scoreView:TextView = findViewById(R.id.score)
                scoreView.text = score.toString()
                qNum++
                quesIndex++

                if (qNum > 10){
                    qNum = 1
                    score = 0
                    handler.removeCallbacksAndMessages(null)

                }
            }
        }, 0)
    }

    fun questions() {
        // refresh question views
        setContentView(R.layout.activity_main3)
        QiSDK.register(this, this)
        timer(17000)
        val quesView: TextView = findViewById(R.id.questions)
        val quesNumView: TextView = findViewById(R.id.quesNumber)
        quesView.text = questions[quesIndex]
        quesNumView.text = qNum.toString()


         val btnName = mutableListOf(
            "make", "do", "does", "did", "done", "made"
        )

        val ansBtn = mutableListOf<Button>(
            findViewById(R.id.button_1), findViewById(R.id.button_2),
            findViewById(R.id.button_3), findViewById(R.id.button_5),
            findViewById(R.id.button_4), findViewById(R.id.button_6)
        )

        for (i in ansBtn.indices) {
            ansBtn[i].text = btnName[i]

        }
            val qns = answer[quesIndex] // result "make"
            val inAns = btnName.indexOf(qns) // gives index of "make" from ans button

        val ansView: TextView = findViewById(R.id.answer)

        ansBtn[0].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[0]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[0].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[0].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        ansBtn[1].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[1]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[1].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[1].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        ansBtn[2].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[2]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[2].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[2].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        ansBtn[3].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[3]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[3].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[3].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        ansBtn[4].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[4]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[4].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[4].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        ansBtn[5].setOnClickListener {
            //ansBtn[i].setTextColor(0xFFFFFF)


            if (qns == btnName[5]) {
                ansView.text = "Correct answer"
                // text set to green color
                ansBtn[5].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false
                score++
            }
            else {
                ansView.text = "Wrong answer"
                // text set to red color
                ansBtn[5].setBackgroundColor(Color.RED)
                ansBtn[inAns].setBackgroundColor(Color.GREEN)
                ansBtn[0].isEnabled = false
                ansBtn[1].isEnabled = false
                ansBtn[2].isEnabled = false
                ansBtn[3].isEnabled = false
                ansBtn[4].isEnabled = false
                ansBtn[5].isEnabled = false

            }

        }

        }


    override fun onRobotFocusGained(qiContext: QiContext?) {

        val btnExit:Button = findViewById(R.id.Exit)
        val sayFarewell = SayBuilder.with(qiContext)

            .withText("You got a few wrong, but otherwise did pretty well." +
                    "You can’t make an omelette without breaking eggs." +
                    "You’ll do even better next time. All the best for now and see you later.")
            .build()

        val sayMake = SayBuilder.with(qiContext)

            .withText("you are doing very well")
            .build()

        btnExit.setOnClickListener {
            sayFarewell.async().run()
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, 8000)
        }


    }

    override fun onRobotFocusLost() {

    }

    override fun onRobotFocusRefused(reason: String?) {

    }

    private fun timer(x:Long){
        /*
        This function used to show the timer for more cautions
        for this experiment
         */

        val countTime: TextView = findViewById(R.id.textTime)
        countTime.setTextColor(Color.parseColor("black"))
        object : CountDownTimer(x, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (counter == 60){
                    min++
                    counter = 0
                }

                val zeit = "$min:$counter"
                countTime.text = zeit
                counter++

            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                countTime.text = "Finished"
                countTime.setTextColor(Color.parseColor("red"))
                counter = 0
                min = 0
            }
        }.start()
    }
}