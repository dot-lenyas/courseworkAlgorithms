package Controller
import Model.KnutMorrisPratt
import Model.RabinKarpAlgorithm
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.control.*
import tornadofx.*
import java.io.File
import kotlin.system.measureTimeMillis


public fun OnGenerationButtonClick(listView: ListView<String>, langsSelectionModel: MultipleSelectionModel<String>, textForCount: TextField, counter: Int)
{
    langsSelectionModel.selectedItems
    val count: Int = textForCount.getText().toInt()
    val name: String = "$counter.txt"
    val fileToWrite = File("src/main/kotlin/Controller/Files/$name").bufferedWriter()
    val rand = (97..122).random()
    fileToWrite.write(rand)
    for (i in 0..count-2)
    {
        val rand = (97..122).random()
        fileToWrite.write(rand)
    }
    listView.items.add(name)
    fileToWrite.close()

}



private fun generationSubsset(str: String): String
{
    var tempString = str
    var subset = ""
    var index = tempString.length/2
    var length = tempString.length/4
    for (i in index..index + length)
    {
        subset += tempString[i]
    }
    return subset
}

public fun OnButtonCompareSearching(listView: ListView<String>, langsSelectionModel: MultipleSelectionModel<String>, bar: BarChart<String, Number>)
{
    bar.data.clear()
    var listOfSel = langsSelectionModel.selectedItems
    var series1 = XYChart.Series<String, Number>()
    var series2 = XYChart.Series<String, Number>()

    series1.name = "Knut-Morris-Pratt"

    series2.name = "Rabin-Karp"
    for (i in 0..listOfSel.size-1)
    {
        var inputFile = File("src/main/kotlin/Controller/Files/${listOfSel[i]}")
        var line = inputFile.readLines().toString()
        var knut = KnutMorrisPratt()
        var rabin = RabinKarpAlgorithm()
        var subset = generationSubsset(line)
        var timeKnut = measureTimeMillis {
            knut.Searching(subset, line, 101)
        }
        var timeRabin = measureTimeMillis {
            rabin.Searching(subset, line, 101)
        }
        timeKnut = timeKnut * 10 + 10
        timeRabin = timeRabin * 10 + 10
        series1.data.add(XYChart.Data(listOfSel[i], timeKnut))
        series2.data.add(XYChart.Data(listOfSel[i], timeRabin))
    }
    bar.data.addAll(series1, series2)


}

