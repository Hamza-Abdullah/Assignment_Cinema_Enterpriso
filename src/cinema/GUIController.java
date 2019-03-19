package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class GUIController {
    public Button bookButton;
    public Button browseButton;
    public Button homeButton;

    public void home(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("gui.fxml"));
        Scene homeScene = new Scene(homeParent);

        //Set stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    public void browse(ActionEvent event) throws IOException {
        Parent browseParent = FXMLLoader.load(getClass().getResource("browse.fxml"));
        Scene browseScene = new Scene(browseParent);

        //Set stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(browseScene);
        window.show();
    }

    public void book(ActionEvent event) throws IOException {
        Parent bookParent = FXMLLoader.load(getClass().getResource("book.fxml"));
        Scene bookScene = new Scene(bookParent);

        //Set stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookScene);
        window.show();
    }
}
