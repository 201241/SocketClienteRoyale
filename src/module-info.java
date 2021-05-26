module ClientSocket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens Main;
    opens Main.Controller;
}