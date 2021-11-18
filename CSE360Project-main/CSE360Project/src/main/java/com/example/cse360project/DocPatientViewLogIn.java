package com.example.cse360project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class DocPatientViewLogIn extends DocHomePageController{

    public Button enterButton;
    public TextField LastNameField, DOBField;



    public void handleEnterButton(){
        String lastName = LastNameField.getText();
        String bDay = DOBField.getText();

        try {
            File myFile = new File("PatientInformation.txt");
            Scanner searcher = new Scanner(myFile);
            while(searcher.hasNextLine()){
                String[] array = searcher.nextLine().split(",");
                if(array[2].equals(lastName)){
                    if(array[3].equals(bDay)){
                        Stage closeScene = (Stage) enterButton.getScene().getWindow();
                        closeScene.close();

                         DocHomePageController.Email = array[0];

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorHomePage.fxml"));
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

        }
        catch(FileNotFoundException exception){
            System.out.println();
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
