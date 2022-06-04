module ru.nsu.spooky.oop.snakegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.spooky.oop.snakegame to javafx.fxml;
    exports ru.nsu.spooky.oop.snakegame;
}