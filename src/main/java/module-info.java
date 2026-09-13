module com.example.rep1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rep1 to javafx.fxml;
    exports com.example.rep1;
}