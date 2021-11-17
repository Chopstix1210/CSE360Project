//This is a comment

package com.example.cse360project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class doctController {

    public Button docBack, docLogButton;
    public TextField docFullName, docPassword, docPinNum;

    public void handledocBackButton() throws IOException {
        //System.out.println("YEP BACK YEP.");

        Stage closeScene = (Stage) docBack.getScene().getWindow(); // get main scene
        closeScene.close(); //close main scene

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cover.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.close();
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome to the Portal!");
        stage.show();

    }

    public void handledocLogInButton() {
        String docName = docFullName.getText().toLowerCase();
        String docPass = docPassword.getText().toLowerCase();
        String docPin = docPinNum.getText();
        //System.out.println("yes yes yes");

        try{
            File myFile = new File("doctorInformation");
            Scanner searcher = new Scanner(myFile);
            while(searcher.hasNextLine()){
                String[] array = searcher.nextLine().split(";");
                if(array[0].equals(docName)){
                    if(array[1].equals(docPass)){
                        if(array[2].equals(docPin)){

                            Stage closeScene = (Stage) docBack.getScene().getWindow();
                            closeScene.close();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientRecordViewForDoctor.fxml"));
                            Parent root = loader.load();

                            Stage stage = new Stage();
                            stage.close();
                            Scene newScene = new Scene(root);
                            stage.setScene(newScene);
                            stage.setTitle("Welcome Doctor!");
                            stage.show();

                            return;
                        }
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
