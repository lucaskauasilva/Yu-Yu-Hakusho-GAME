module com.example.yuyuhakushogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yuyuhakushogame to javafx.fxml;
    exports com.example.yuyuhakushogame;
    exports core;
}