package speechGenerator

import utils.PhrasesService

class SpeechGenerator(
    path: String = ""
) {
    private val phrasesService = PhrasesService(path = path)

    fun execute() {
        println("Welcome to speech generator!")
        var speech = ""

        print("Enter the sentences count: ")
        val sentencesCount = readln().toInt()
        print("Enter the phrases count: ")
        val phrasesCount = readln().toInt()


        for (i in 0..sentencesCount){
            speech += phrasesService.getSentence(phrasesCount = phrasesCount) + "\n"
        }
        println("The text:")
        println(speech)
    }
}