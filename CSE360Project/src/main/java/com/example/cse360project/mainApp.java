package com.example.cse360project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class mainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cover.fxml")));
        primaryStage.setTitle("Welcome to the Portal!");
        primaryStage.setScene(new Scene(root, 1280.0,800.0));
        primaryStage.show();
        //adding this comment to update the github and check for VCS compatibility
        //System.out.println("Random testing string; beeboop");
    }


    }