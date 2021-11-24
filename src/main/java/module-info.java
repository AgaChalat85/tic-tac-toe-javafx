module com.kodilla.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.apache.logging.log4j;
    requires javafx.base;


    opens com.kodilla.tictactoe.game to javafx.fxml, javafx.base;
    exports com.kodilla.tictactoe;
}