package com.test;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.test.view.ViewFactory;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();

//        viewFactory.showOptionsWindow();
        viewFactory.updateAllStyles();

//        viewFactory.showMainWindow();

//        Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
//
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//
//        stage.show();



    }
}