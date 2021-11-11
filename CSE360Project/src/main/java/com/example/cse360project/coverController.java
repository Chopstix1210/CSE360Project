package com.example.cse360project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class coverController {

    public Button patientButton;
    public Button doctorButton;

    public Label mainLabel,patLabel,docLabel;

    public void handlePatientButtonClick() throws IOException {
        System.out.println("Patient Button Clicked!");

        //trying to get main stage to close
        Stage closeScene = (Stage) patientButton.getScene().getWindow(); // get main scene
        closeScene.close(); //close main scene

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientLogIn.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.close();
        stage.setScene(new Scene(root));
        stage.setTitle("Patient Portal");
        stage.show();
    }

    public void handleDoctorButtonClick() throws IOException {
        System.out.println("Doctor Button Clicked!");

        //copy of main stage close
        Stage closeScene = (Stage) patientButton.getScene().getWindow(); // get main scene
        closeScene.close(); //close main scene

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorLogIn.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.close();
        stage.setScene(new Scene(root));
        stage.setTitle("Doctor Portal");
        stage.show();
        //random comment
    }

}
