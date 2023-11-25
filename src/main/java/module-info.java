module dabdaddy.mmm.modpackmaker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens dabdaddy.mmm.modpackmaker to javafx.fxml;
    exports dabdaddy.mmm.modpackmaker;
}