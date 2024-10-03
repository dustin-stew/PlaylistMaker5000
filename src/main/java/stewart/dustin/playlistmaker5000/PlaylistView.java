package stewart.dustin.playlistmaker5000;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlaylistView {
    private GridPane view;
    private PlaylistController controller;
    private PlaylistModel model;

    public PlaylistView(PlaylistController controller, PlaylistModel model) {
        this.controller = controller;
        this.model = model;

        createAndConfigurePane();

        createAndLayoutControls();


    }

    public Parent asParent() {
        return view;
    }



    private void updateList(String playlist, Text playlistOutput) {
        playlistOutput.setText(playlist);
    }


    private void createAndLayoutControls() {
        TextField songEntry = new TextField();
        TextField artistEntry = new TextField();
        TextField durationEntry = new TextField();
        Text playlistOutput = new Text();

        Button submitButton = new Button("Submit Song");
        Button exportButton = new Button("Export Playlist");
        submitButton.setOnAction(e ->{
            controller.update(songEntry.getText(), artistEntry.getText(), Integer.parseInt(durationEntry.getText()));
            songEntry.clear();
            artistEntry.clear();
            durationEntry.clear();
            updateList(model.getListAsString(), playlistOutput);

        });
        exportButton.setOnAction(e ->{
            exportPlaylistCSV();

        });
        view.addColumn(0, new Label("Song Name:"), songEntry);
        view.addColumn(1, new Label("Artist:"), artistEntry, submitButton);
        view.addColumn(2, new Label("Duration:"), durationEntry);
//        view.addRow(0, new Label("Song Name:"), songEntry,
//                new Label("Artist:"), artistEntry,
//                new Label("Duration(s):"), durationEntry);

        // view.addRow(2, submitButton);
        view.addRow(3, new Label("Your Playlist: "), playlistOutput);
        view.addRow(4, exportButton);
//        RowConstraints rc = new RowConstraints();
//        rc.setVgrow(Priority.ALWAYS);
//        view.getRowConstraints().add(rc);
    }

    private void createAndConfigurePane() {
        view = new GridPane();

        ColumnConstraints cols1 = new ColumnConstraints();
        cols1.setPercentWidth(30);
        ColumnConstraints cols2 = new ColumnConstraints();
        cols2.setPercentWidth(30);
        ColumnConstraints cols3 = new ColumnConstraints();
        cols3.setPercentWidth(30);

        RowConstraints row1 = new RowConstraints();


        view.getColumnConstraints().addAll(cols1, cols2, cols3);

        view.setAlignment(Pos.CENTER);
        view.setHgap(10);
        view.setVgap(15);
    }
    private void exportPlaylistAsCSV() {
        // first create file object for file placed at location
        // specified by filepath

    }
    public void exportPlaylistCSV () {
        try {
            File dir = new File("data");
            dir.mkdir();
            File myObj = new File (dir, "output.csv");
            myObj.createNewFile();
            System.out.println("File created: " + myObj.getName());
            String str = "Title,Artist,Duration\r\n";
            ArrayList<Song> playlist = model.getList();
            for (int i = 0; i < playlist.size(); i++) {
                Song track = playlist.get(i);
                String trackString = String.join(",", track.getTitle(), track.getArtist(), String.valueOf(track.getDuration()))+"\r\n";
                str += trackString;
            }

            Path path = Paths.get(myObj.getPath());
            byte[] strToBytes = str.getBytes();

            Files.write(path, strToBytes);

            String read = Files.readAllLines(path).get(0);
            str.equals(read);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

}







