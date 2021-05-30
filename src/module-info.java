module ClientSocket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens main;
    //opens Main.Modelo;
    opens main.Controller;
}