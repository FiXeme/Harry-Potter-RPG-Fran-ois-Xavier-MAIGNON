module com.example.harry {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens sorcier to javafx.fxml;
    exports sorcier;
}