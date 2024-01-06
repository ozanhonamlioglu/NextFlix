package tech.eightbits.core.utils

import android.content.Context
import tech.eightbits.core.R
import java.util.Properties

/**
 * Created by ozan on 6.01.2024
 */
class AppConfig(private val context: Context) {
    fun getConfigValue(key: String): String {
        val resource = context.resources

        return try {
            val rawResource = resource.openRawResource(R.raw.config)
            val properties = Properties()
            properties.load(rawResource)
            properties.getProperty(key) ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    companion object {
        const val API_KEY = "API_KEY"
    }
}