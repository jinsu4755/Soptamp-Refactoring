package org.sopt.android.stamp

import android.app.Application
import com.facebook.flipper.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary2.FlipperLeakEventListener
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp
import leakcanary.LeakCanary

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpLeakCanaryConfig()
        setUpFlipper()
    }

    private fun setUpLeakCanaryConfig() {
        LeakCanary.config = LeakCanary.config.run {
            copy(eventListeners = eventListeners + FlipperLeakEventListener())
        }
    }

    private fun setUpFlipper() {
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).apply {
                addPlugin(InspectorFlipperPlugin(this@App, DescriptorMapping.withDefaults()))
                addPlugin(NetworkFlipperPlugin())
                addPlugin(LeakCanary2FlipperPlugin())
            }.start()
        }
    }
}
