module cwiczenia.lab2b {
    requires javafx.controls;
    requires javafx.fxml;


    opens cwiczenia.lab2b to javafx.fxml;
    exports cwiczenia.lab2b;
}