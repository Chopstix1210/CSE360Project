package com.example.cse360project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class patientController {


    public VBox newPatient, returnPatient, mainPatient;

    //keeping this here for testing
/*
    public void handleTestingButton(){
        returnPatient.setVisible(true);
        newPatient.setVisible(true);
    }
*/

    //the mainPage patient buttons
    public void handleNewPatientButtonClick() {
        mainPatient.setVisible(false);
        newPatient.setVisible(true);
    }
    public void handleReturnPatientButtonClick(){
        mainPatient.setVisible(false);
        returnPatient.setVisible(true);
    }

    //the back buttons
    public void handleBackButtonToCover() throws IOException {

        //closing this scene
        Stage closeScene = (Stage) mainPatient.getScene().getWindow();
        closeScene.close();

        //System.out.println("Back Button pressed");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cover.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.close();
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome to the Portal!");
        stage.show();
    }
    public void handleBackButtonToMainPatient(){
        mainPatient.setVisible(true);
        returnPatient.setVisible(false);
        newPatient.setVisible(false);
    }
}
