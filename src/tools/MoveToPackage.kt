package tools

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

/**
 * @author: Sorcerer
 * @date: 12/10/2018
 * @description:
 */
fun moveToPackage(sourceFolder: File, distFolder: File) {
    sourceFolder.listFiles()
            .filter { it.absolutePath.endsWith(".kt") }
            .forEach {
                val folder = File(distFolder, "_${it.name.split("_")[1]}_")
                if (!folder.exists()) folder.mkdir()
                println(it.absoluteFile)
                Files.copy(Paths.get(it.toURI()), Paths.get(File(folder, it.name).toURI()), StandardCopyOption.REPLACE_EXISTING)
            }
}

fun main(args: Array<String>) {
    moveToPackage(File("C:\\Users\\Sorcerer\\IdeaProjects\\Algorithms\\src"), File("C:\\Users\\Sorcerer\\IdeaProjects\\Algorithms\\src\\solution"))
}