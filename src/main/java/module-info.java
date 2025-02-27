module com.example.projetofase2jc0301javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetofase2jc0301javafx to javafx.fxml;
    exports com.example.projetofase2jc0301javafx;
}