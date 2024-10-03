module stewart.dustin.playlistmaker5000 {
    requires javafx.controls;
    requires javafx.fxml;


    opens stewart.dustin.playlistmaker5000 to javafx.fxml;
    exports stewart.dustin.playlistmaker5000;
}