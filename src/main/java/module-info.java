module org.openjfx {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}
