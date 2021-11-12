package com.example.cse360project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class patientController {


    public VBox newPatient, returnPatient, mainPatient;
    public Button saveInfo, signIn;
    public TextField fName, lName, birthday, email, phoneNumber, password;
    public TextField logEmail, logPassword;

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

    //save information button and login button
    public void handleSaveInfo(){
        //going to save the information to a text file

        try{
            String firstName = fName.getText();
            String lastName = lName.getText();
            String bDay = birthday.getText();
            String pEmail = email.getText();
            String phone = phoneNumber.getText();
            String pass = password.getText();
            FileWriter myFile = new FileWriter("PatientInformation.txt", true);
            BufferedWriter patientFile = new BufferedWriter(myFile);
            patientFile.write(firstName + "," + lastName + "," + bDay + "," + pEmail + "," + phone + "," + pass + "\n");
            patientFile.close();
            myFile.close();
        }
        catch(IOException exception){
            System.out.println("ERROR");
            exception.printStackTrace();
        }
    }
    public void handleLogIn(){
        String email = logEmail.getText().toLowerCase();
        String pass = logPassword.getText();

        try{
            File myFile = new File("PatientInformation.txt");
            Scanner searcher = new Scanner(myFile);
            while(searcher.hasNextLine()){
                String[] array = searcher.nextLine().split(",");
                if(array[3].equals(email)){
                    if(array[5].equals(pass)){
                        System.out.println("USER FOUND!");
                        return;
                    }
                }
            }
            System.out.println("USER NOT FOUND!");
            searcher.close();
        }
        catch(FileNotFoundException exception){
            System.out.println("ERROR");
            exception.printStackTrace();
        }

    }

}
