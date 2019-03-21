package cinema;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class GUIController {
    @FXML
    public Button bookButton;
    @FXML
    public Button browseButton;
    @FXML
    public Button homeButton;
    @FXML
    public ImageView poster01;
    @FXML
    public ImageView poster02;
    @FXML
    public ImageView poster03;
    @FXML
    public ImageView poster04;
    @FXML
    public ImageView poster05;
    @FXML
    public ImageView poster06;
    @FXML
    public ImageView poster07;
    @FXML
    public ImageView poster08;
    @FXML
    public ImageView poster09;
    @FXML
    public ImageView poster10;
    @FXML
    public ComboBox<String> showingCB;
    @FXML
    public ComboBox<Integer> ticketsCB;
    @FXML
    public CheckBox dsCheck;
    @FXML
    public Label infoLabel;
    @FXML
    public Label infoLabel2;
    @FXML
    public Label infoLabel3;
    @FXML
    public Label infoLabel4;

    Film film01 = new Film("The Lord of the Rings - The Return of the King", "A", 200, "13:00", "12A", 100, "£8.00");
    Film film02 = new Film("Captain Marvel", "B", 123, "14:00", "12A", 100, "£8.00");
    Film film03 = new Film("Creed 2", "C", 130, "15:00", "12A", 100, "£8.00");
    Film film04 = new Film("Johnny English Strikes Again", "D", 89, "16:00", "PG", 50, "£8.00");
    Film film05 = new Film("The Equalizer 2", "E", 121, "17:00", "15", 100, "£8.00");
    Film film06 = new Film("Robin Hood", "F", 116, "18:00", "12A", 50, "£8.00");
    Film film07 = new Film("Master Z", "G", 108, "19:00", "N/A", 50, "£8.00");
    Film film08 = new Film("How to Train your Dragon 3", "H", 104, "13:00", "PG", 100, "£8.00");
    Film film09 = new Film("The Dark Knight", "I", 152, "20:00", "12A", 100, "£8.00");
    Film film10 = new Film("Rush Hour", "J", 98, "21:00", "15", 100, "£8.00");

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
        /*Parent bookParent = FXMLLoader.load(getClass().getResource("book.fxml"));
        Scene bookScene = new Scene(bookParent);
        //Set stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(bookScene);
        window.show();*/
        bookScreen();

    }

    public Stage bookScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));

        GUIController controller = loader.<GUIController>getController();
        controller.initData();
        stage.setTitle("Cinema Enterpriso: Book");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/logo.png")));
        stage.setResizable(false);
        stage.show();

        return stage;
    }

    //Create films

        /*Film film01 = new Film("The Lord of the Rings - The Return of the King", "A", 120, "13:00", "13A", 100, "£8.00");
        Film film02 = new Film("Captain Marvel", "B", 120, "13:00", "13A", 100, "£8.00");
        Film film03 = new Film("Creed 2", "C", 120, "13:00", "13A", 100, "£8.00");
        Film film04 = new Film("Johnny English Strikes Again", "D", 120, "13:00", "13A", 100, "£8.00");
        Film film05 = new Film("The Equalizer 2", "E", 120, "13:00", "13A", 100, "£8.00");
        Film film06 = new Film("Robin Hood", "F", 120, "13:00", "13A", 100, "£8.00");
        Film film07 = new Film("Master Z", "G", 120, "13:00", "13A", 100, "£8.00");
        Film film08 = new Film("How to Train your Dragon 3", "H", 120, "13:00", "13A", 100, "£8.00");
        Film film09 = new Film("The Dark Knight", "I", 120, "13:00", "13A", 100, "£8.00");
        Film film10 = new Film("Rush Hour", "J", 120, "13:00", "13A", 100, "£8.00");*/

    void initData() {
        ObservableList<String> showingList = FXCollections.observableArrayList(
                "A: " + film01.getTitle(),
                "B: " + film02.getTitle(),
                "C: " + film03.getTitle(),
                "D: " + film04.getTitle(),
                "E: " + film05.getTitle(),
                "F: " + film06.getTitle(),
                "G: "+ film07.getTitle(),
                "H: "+ film08.getTitle(),
                "I: " + film09.getTitle(),
                "J: " + film10.getTitle()
        );
        showingCB.setItems(showingList);

        ObservableList quantity = FXCollections.observableArrayList(1,2,3,4,5,6);
        ticketsCB.setItems(quantity);
    }

    public void selectedFilm(ActionEvent event) {
        String theatre = showingCB.getValue();
        theatre = theatre.substring(0, 1);

        if (theatre.equals("A")) {
            infoLabel.setText("Film title: " + film01.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film01.getDuration() + " mins. Rating: " + film01.getRating() + "\r\nBegins at " + film01.getTime() + ", Seats left: " + film01.getSeatsLeft() + "\r\nPrice: " + film01.getPrice());
        }
        if (theatre.equals("B")) {
            infoLabel.setText("Film title: " + film02.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film02.getDuration() + " mins. Rating: " + film02.getRating() + "\r\nBegins at " + film02.getTime() + ", Seats left: " + film02.getSeatsLeft() + "\r\nPrice: " + film02.getPrice());
        }
        if (theatre.equals("C")) {
            infoLabel.setText("Film title: " + film03.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film03.getDuration() + " mins. Rating: " + film03.getRating() + "\r\nBegins at " + film03.getTime() + ", Seats left: " + film03.getSeatsLeft() + "\r\nPrice: " + film03.getPrice());
        }
        if (theatre.equals("D")) {
            infoLabel.setText("Film title: " + film04.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film04.getDuration() + " mins. Rating: " + film04.getRating() + "\r\nBegins at " + film04.getTime() + ", Seats left: " + film04.getSeatsLeft() + "\r\nPrice: " + film04.getPrice());
        }
        if (theatre.equals("E")) {
            infoLabel.setText("Film title: " + film05.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film05.getDuration() + " mins. Rating: " + film05.getRating() + "\r\nBegins at " + film05.getTime() + ", Seats left: " + film05.getSeatsLeft() + "\r\nPrice: " + film05.getPrice());
        }
        if (theatre.equals("F")) {
            infoLabel.setText("Film title: " + film06.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film06.getDuration() + " mins. Rating: " + film06.getRating() + "\r\nBegins at " + film06.getTime() + ", Seats left: " + film06.getSeatsLeft() + "\r\nPrice: " + film06.getPrice());
        }
        if (theatre.equals("G")) {
            infoLabel.setText("Film title: " + film07.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film07.getDuration() + " mins. Rating: " + film07.getRating() + "\r\nBegins at " + film07.getTime() + ", Seats left: " + film07.getSeatsLeft() + "\r\nPrice: " + film07.getPrice());
        }
        if (theatre.equals("H")) {
            infoLabel.setText("Receipt:\nFilm title: " + film08.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film08.getDuration() + " mins. Rating: " + film08.getRating() + "\r\nBegins at " + film08.getTime() + ", Seats left: " + film08.getSeatsLeft() + "\r\nPrice: " + film08.getPrice());
        }
        if (theatre.equals("I")) {
            infoLabel.setText("Receipt:\nFilm title: " + film09.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film09.getDuration() + " mins. Rating: " + film09.getRating() + "\r\nBegins at " + film09.getTime() + ", Seats left: " + film09.getSeatsLeft() + "\r\nPrice: " + film09.getPrice());
        }
        if (theatre.equals("J")) {
            infoLabel.setText("Receipt:\nFilm title: " + film10.getTitle() + "\r\nTheatre: " + theatre + "\r\nDuration: " + film10.getDuration() + " mins. Rating: " + film10.getRating() + "\r\nBegins at " + film10.getTime() + ", Seats left: " + film10.getSeatsLeft() + "\r\nPrice: " + film10.getPrice());
        }
    }

    public void selectedTickets(ActionEvent event) {
        infoLabel2.setText(ticketsCB.getValue().toString() + " x £8.00");
        updateCost();
    }

    private void updateCost() {
        Integer total, tickets, ds;
        tickets = ticketsCB.getValue() * 8;
        if (dsCheck.isSelected()) {
            ds = 3 * ticketsCB.getValue();
            total = tickets + ds;
        }
        else {
            total = tickets;
        }
        infoLabel4.setText("£" + String.valueOf(total) + ".00");
    }

    public void addDs(ActionEvent event) {
        if (dsCheck.isSelected()) {
            infoLabel3.setText("£3.00");
            updateCost();
        }
        else {
            infoLabel3.setText("");
            updateCost();
        }
    }

    public void imageBook(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        bookScreen();
    }
}
