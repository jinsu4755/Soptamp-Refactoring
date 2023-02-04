package org.sopt.android.stamp.initalizer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.sopt.android.stamp.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        val timberTree = if (BuildConfig.DEBUG) DebugTree() else ReleaseTree()
        Timber.plant(timberTree)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

    private class DebugTree : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String? {
            return "SOPTAMP:${element.fileName}:${element.methodName} - ${element.lineNumber}"
        }
    }

    private class ReleaseTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            when (priority) {
                Log.WARN, Log.ERROR -> t?.let {
                    Throwable().initCause(t).apply {
                        stackTrace = Thread.currentThread().stackTrace
                    }.let { throwable ->
                        FirebaseCrashlytics.getInstance().recordException(throwable)
                    }
                }

                else -> {
                    FirebaseCrashlytics.getInstance().log("$tag | $message")
                }
            }
        }
    }
}
