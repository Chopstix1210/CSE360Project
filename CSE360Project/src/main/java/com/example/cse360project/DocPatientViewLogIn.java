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

public class DocPatientViewLogIn {

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

            }

        }
        catch(FileNotFoundException exception){
            System.out.println();
            exception.printStackTrace();
        }
    }

}
