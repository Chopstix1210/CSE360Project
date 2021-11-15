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

public class patientController extends PatientHomeController{


    public VBox newPatient, returnPatient, mainPatient;
    public Button saveInfo, signIn;
    public TextField fName, lName, birthday, email, phoneNumber, password;
    public TextField logEmail, logPassword;
    String Email;



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

    public void handleSaveInfo() throws IOException {
        //going to save the information to a text file

        String pEmail = email.getText();
        try{
            String firstName = fName.getText();
            String lastName = lName.getText();
            String bDay = birthday.getText();
            String phone = phoneNumber.getText();
            String pass = password.getText();
            FileWriter myFile = new FileWriter("PatientInformation.txt", true);
            BufferedWriter patientFile = new BufferedWriter(myFile);
            patientFile.write(pEmail + "," + pass + "\n");
            patientFile.close();
            myFile.close();

            String openFile = pEmail + ".txt";
            File check = new File(openFile);
            if(check.exists()){
                System.out.println("File Exists! Can't create duplicate! Exiting....");
            }
            else{
                FileWriter newFile = new FileWriter(openFile);
                newFile.write(
                        "FirstName:" + firstName + "\n" +
                            "MiddleName:" + " " + "\n" +
                            "LastName:" + lastName + "\n" +
                            "DOB:" + bDay + "\n" +
                            "Phone:" + phone + "\n" +
                            "Email:" + pEmail + "\n" +
                            "Pharmacy:" + " " + "\n" +
                            "Insurance:" + " " + "\n" +
                            "Health:" + " " + "\n" +
                            "Meds:" + " " + "\n" +
                            "Imm:" + " " + "\n" +
                            "Rec:" + " " + "\n" +
                            "Visits:" + " " + "\n");
                newFile.close();
            }
        }
        catch(IOException exception){
            System.out.println("ERROR");
            exception.printStackTrace();
        }

        Stage closeScene = (Stage) signIn.getScene().getWindow();
        closeScene.close();
        PatientHomeController.Email = pEmail;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientHomePage.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.close();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.setTitle("Welcome!");
        stage.show();

    }
    public void handleLogIn(){
        Email = logEmail.getText().toLowerCase();
        String pass = logPassword.getText();

        try{
            File myFile = new File("PatientInformation.txt");
            Scanner searcher = new Scanner(myFile);
            while(searcher.hasNextLine()){
                String[] array = searcher.nextLine().split(",");
                if(array[0].equals(Email)){
                    if(array[1].equals(pass)){

                        Stage closeScene = (Stage) signIn.getScene().getWindow();
                        closeScene.close();
                        PatientHomeController.Email = Email;
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientHomePage.fxml"));
                        Parent root = loader.load();

                        Stage stage = new Stage();
                        stage.close();
                        Scene newScene = new Scene(root);
                        stage.setScene(newScene);
                        stage.setTitle("Welcome!");
                        stage.show();



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
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
