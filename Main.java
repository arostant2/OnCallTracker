

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.TextArea;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    Stage window;
    Scene mainScene, outputScene;

    File teacherRoster, absentTeachers, tallyReader;

      public static void main(String[] args) {

        launch(args);
      }

      public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        primaryStage.setTitle("On-Call Assigner");

        Button button1 = new Button("Find Teacher Roster");
        Button button2 = new Button("Find Absent Teachers");
        Button button3 = new Button("Find Tally Reader");


        Label label1 = new Label("Input Files:");
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label label2 = new Label("Teacher Roster File: null");
        Label label3 = new Label("Absent Teacher File: null");
        Label label4 = new Label("Tally Reader File: null");


        Button buttonOnCalls = new Button("Assign On-Calls");
        buttonOnCalls.setPrefSize(150, 50);

        Button buttonSettings = new Button("Settings");
        Button buttonExit = new Button("Exit");

        Button backButton = new Button("Go Back");



        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().addAll(label1, button1, button2, button3);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(label2, label3, label4, buttonOnCalls);
        AnchorPane anchorpane1 = new AnchorPane();
        anchorpane1.getChildren().add(vbox);
        AnchorPane.setBottomAnchor(vbox, 8.0);
        AnchorPane.setLeftAnchor(vbox, 5.0);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(0, 10, 10, 10));
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(buttonSettings, buttonExit);
        AnchorPane anchorpane2 = new AnchorPane();
        anchorpane2.getChildren().add(hbox2);
        AnchorPane.setBottomAnchor(hbox2, 8.0);
        AnchorPane.setRightAnchor(hbox2, 5.0);

        Label outputText = new Label();
        outputText.setWrapText(true);

        outputText.setText("yoyoyoyoyoyoyo"); //put text here

        BorderPane layout1 = new BorderPane();
        layout1.setTop(hbox);
        layout1.setLeft(anchorpane1);
        layout1.setRight(anchorpane2);

        BorderPane layout2 = new BorderPane();
        layout2.setBottom(backButton);
        layout2.setCenter(outputText);


        mainScene = new Scene(layout1, 600, 300);
        outputScene = new Scene(layout2, 500, 500);

        primaryStage.setScene(mainScene);
        primaryStage.show();

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        button1.setOnAction(e -> {

          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Open Teacher Roster File");
          fileChooser.getExtensionFilters().add( new ExtensionFilter("Excel Files", "*.xlsx"));
          teacherRoster = fileChooser.showOpenDialog(window);

          if (teacherRoster != null) label2.setText("Teacher Roster File: check");
        });

        button2.setOnAction(e -> {

          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Open Absent Teacher File");
          fileChooser.getExtensionFilters().add( new ExtensionFilter("Excel Files", "*.xlsx"));
          absentTeachers = fileChooser.showOpenDialog(window);

          if (absentTeachers != null) label3.setText("Absent Teacher File: check");
        });

        button3.setOnAction(e -> {

          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Open Tally Reader File");
          fileChooser.getExtensionFilters().add( new ExtensionFilter("Excel Files", "*.xlsx"));
          tallyReader = fileChooser.showOpenDialog(window);

          if (tallyReader != null) label4.setText("Tally Reader File: check");
        });

        buttonOnCalls.setOnAction(e -> {

          if ((teacherRoster != null) & (absentTeachers != null) & (tallyReader != null)) {

              //put driver code here

            window.setScene(outputScene);
          }
        });

        backButton.setOnAction(e -> {

          window.setScene(mainScene);
        });

        buttonExit.setOnAction(e -> Platform.exit());



      }
}
