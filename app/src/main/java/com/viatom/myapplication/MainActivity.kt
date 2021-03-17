package com.viatom.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainActivity : AppCompatActivity() {
    private val flutterEngine:FlutterEngine by lazy {
        FlutterEngine(this.applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flutterEngine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put("my flutter engine",flutterEngine)
    }
    fun launchFlutter(view: View){
        startActivity(FlutterActivity.withCachedEngine("my flutter engine").build(this))
    }
}