package com.example.cse360project;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class chatboxController<newScene> {

    TextField  textField;
    String message;
    Label messageLabel;
    Button sendMessage;

    public void handleButtonChatBox() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cover.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.close();
        Scene newScene = new Scene(root);
    }

    public chatboxController() throws IOException {

    }

    //takes message from textfield and writes it to a file
    public void handleSendMessage(ActionEvent event) throws IOException {
        try {
            String message = textField.getText();
            FileWriter myFile = new FileWriter("MessageHistory.txt" , true);
            BufferedWriter messageFile = new BufferedWriter(myFile);
            messageFile.write("Patient:" + message + "\n");
            messageFile.close();
            myFile.close();
        }
        catch(IOException exception) {
            System.out.println("ERROR");
            exception.printStackTrace();
        }
    }

    //take file of messages reads it and displays it in chatbox
    public void displayMessage() throws FileNotFoundException {
        File myFile = new File("MessageHistory.txt");
        Scanner fileReader = new Scanner(myFile);
        while(fileReader.hasNextLine()){
            String[] array = fileReader.nextLine().split("~");

        }
        messageLabel.setText(message);
    }
}
