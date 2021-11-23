module com.example.shapesassigment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shapesassigment to javafx.fxml;
    exports com.example.shapesassigment;
}