package View
import Controller.*
import Controller.OnGenerationButtonClick
import javafx.geometry.Insets
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.control.MultipleSelectionModel
import javafx.scene.control.SelectionMode
import tornadofx.*

class MyAppView: View()
{
    override val root = borderpane()
    {
        setPrefSize(800.0, 800.0)
        left<MainView>()
    }
}

class MainView: View()
{
    override val root = vbox()
    {

        label("Введите количество элементов в сгенерируемом файле")
        val textForCount = textfield()
        textForCount.setPrefSize(100.0, 50.0)
        textForCount.padding = Insets(10.0, 10.0, 10.0, 10.0)
        val list1 = listview<String>()
        val langsSelectionModel: MultipleSelectionModel<String> = list1.selectionModel
        langsSelectionModel.selectionMode = SelectionMode.MULTIPLE


        var counter = 0
        val buttonGeneration = button("Сгенерировать")
        {
            action {
                OnGenerationButtonClick(list1, langsSelectionModel, textForCount, counter)
                counter++
            }
        }

        val buttonSearching = button("Начать сравнение")
        {

        }
        buttonSearching.setPrefSize(400.0, 100.0)

        var bar = barchart("Knut && Rabin", CategoryAxis(), NumberAxis())
        {

        }
        bar.setPrefSize(700.0, 850.0)
        buttonSearching.action {
            OnButtonCompareSearching(list1, langsSelectionModel, bar)
        }

    }
}





class ComboView: View()
{
    override val root = vbox()
    {
        val comboFiles = combobox<String>()
    }
}


