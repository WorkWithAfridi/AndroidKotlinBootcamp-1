package com.example.testapone

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekbar : SeekBar

    private lateinit var runnable: Runnable
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())
        mediaPlayer = MediaPlayer.create(this, R.raw.applauding)
        seekbar = findViewById<SeekBar>(R.id.audioSeekbar)

        val playBtn = findViewById<FloatingActionButton>(R.id.playBtn)
        playBtn.setOnClickListener(){
            if(mediaPlayer==null){
                mediaPlayer = MediaPlayer.create(this, R.raw.applauding)
            }
            mediaPlayer?.start()
            initSeekbar()
        }

        val pauseBtn = findViewById<FloatingActionButton>(R.id.pauseBtn)
        pauseBtn.setOnClickListener(){
            if(mediaPlayer!=null){
                mediaPlayer?.pause()
            }
        }

        val stopBtn = findViewById<FloatingActionButton>(R.id.stopBtn)
        stopBtn.setOnClickListener(){
            if(mediaPlayer!=null){
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer?.release()
                mediaPlayer=null

                handler.removeCallbacks(runnable)
                seekbar.progress=0
            }
        }
    }

    private fun initSeekbar(){
        seekbar.setOnSeekBarChangeListener(
          object:  SeekBar.OnSeekBarChangeListener{
              override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                  if(fromUser){
                      mediaPlayer?.seekTo(progress)
                  }
              }

              override fun onStartTrackingTouch(seekBar: SeekBar?) {
              }

              override fun onStopTrackingTouch(seekBar: SeekBar?) {
                  TODO("Not yet implemented")
              }
          }
        )
        val playTimeTV = findViewById<TextView>(R.id.playTimeTV)
        val audioDurationTV = findViewById<TextView>(R.id.audioDurationTV)
        if(mediaPlayer!=null){
            seekbar.max=mediaPlayer!!.duration
        }
        runnable = Runnable {
            seekbar.progress=mediaPlayer!!.currentPosition

            val playTime = mediaPlayer!!.currentPosition/1000 //Returns time in milli seconds. Therefore we need to divide it by 1000
            playTimeTV.text = "$playTime sec."

            val duration = mediaPlayer!!.duration/1000
            audioDurationTV.text = "${duration.toString()} sec."

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

}


//Done till 4:26:00
//Link https://www.youtube.com/watch?v=BCSlZIUj18Y&t=44s&ab_channel=AppDevNotes