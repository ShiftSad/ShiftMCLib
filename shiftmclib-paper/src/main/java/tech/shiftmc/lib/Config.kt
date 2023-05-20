package tech.shiftmc.lib

import com.google.gson.Gson
import tech.shiftmc.lib.ShiftMcLib.Companion.instance
import java.io.File
import java.io.FileReader

/**
 * Saves the object to a file in JSON format.
 *
 * ```
 * MyDataClass().saveToFile(File("data.json"))
 * ```
 *
 * @param file    The file to save the object to.
 * @param replace Whether to replace the file if it already exists.
 * @throws IOException if an error occurs while writing to the file.
 */
inline fun <reified T : Any> T.saveToFile(file: File = instance.dataFolder, replace: Boolean = false) {
    if (file.exists() && !replace) return
    file.parentFile.mkdirs()
    file.createNewFile()
    file.writeText(Gson().toJson(this))
}

/**
 * Loads an object from the specified file in JSON format.
 *
 * ```
 * val data = MyDataClass().loadFromFile(File("data.json"))
 * ```
 *
 * @param file The file to load the object from.
 * @param <T>  The type of the object to load.
 * @return The loaded object, or null if an error occurs while reading the file.
 * @throws FileNotFoundException if an error occurs while reading the file.
 */
inline fun <reified T : Any> T.loadFromFile(file: File): T? {
    return runCatching {
        val gson = Gson()
        val reader = FileReader(file)
        val data = gson.fromJson(reader, T::class.java)
        reader.close()
        data
    }.getOrElse { error ->
        error.printStackTrace()
        null
    }
}
