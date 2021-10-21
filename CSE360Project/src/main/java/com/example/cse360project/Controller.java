package com.example.cse360project;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public Button patientButton;
    public Button doctorButton;

    public Label mainLabel,patLabel,docLabel;

    public void handlePatientButtonClick(){
        System.out.println("Patient Button Clicked!");
        mainLabel.setVisible(false);
        docLabel.setVisible(false);
        patLabel.setVisible(true);
    }

    public void handleDoctorButtonClick(){
        System.out.println("Doctor Button Clicked!");
        mainLabel.setVisible(false);
        patLabel.setVisible(false);
        docLabel.setVisible(true);
    }

}
