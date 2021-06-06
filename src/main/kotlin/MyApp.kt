import View.MyAppView
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import javafx.scene.control.Button
import tornadofx.*

    class MyApp: App(MyAppView::class)
    {
        fun main(arg: Array<String>)
        {
            tornadofx.launch<MyApp>(arg)
        }
    }

