module com.example.cse360project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cse360project to javafx.fxml;
    exports com.example.cse360project;
}