module dabdaddy.mmm.modpackmaker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.google.gson;
    requires java.net.http;

    opens dabdaddy.mmm.modpackmaker to javafx.fxml;
    exports dabdaddy.mmm.modpackmaker;
}