module com.example.harry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.harry to javafx.fxml;
    exports com.example.harry;
}