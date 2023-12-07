package utils

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import kotlin.random.Random

class PhrasesService(
    private val path: String = ""
) {

    private fun getPhrase(
        fileNumber: Int,
        lineNumber: Int
    ): String?{
        val fileName = path + "phrases$fileNumber.txt"
        val fileObject = File(fileName)

        val fileReader = BufferedReader(FileReader(fileObject))
        var index = 0
        var phrase: String? = "phrase"

        while(index != lineNumber && phrase != null){
            phrase = fileReader.readLine()
            index += 1
        }

        return phrase
    }

    fun getSentence(
        phrasesCount: Int
    ): String? {
        return try{
            var sentence = ""

            for (i in 0..phrasesCount){
                val fileNumber = Random.nextInt(1, 5)
                val lineNumber = Random.nextInt(1, 11)
                sentence += getPhrase(
                    fileNumber = fileNumber,
                    lineNumber = lineNumber
                ) + " "
            }
            sentence

        }catch(e: FileNotFoundException){
            e.message
        }
    }
}