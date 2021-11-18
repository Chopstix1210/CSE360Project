package com.example.cse360project;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;



public class DocHomePageController implements Initializable {

    public Button ChatButtonDoc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ChatButtonDoc!=null) {
            firstRun();
        }

    }




    public void SendMessageDoc(){
    String fileName = Email + ".txt";
    boolean chatEnable = false;

        try {
        File myFile = new File(fileName);
        Scanner searcher = new Scanner(myFile);
        String[] chatArray = new String[1];
        StringBuilder disp = new StringBuilder();
        while (searcher.hasNextLine()) {
            String[] array = searcher.nextLine().split(":");
            if (array[0].equals("===============================")) {
                chatEnable = true;
            }
            else if(chatEnable){
                for(String s : array){
                    disp.append(s).append("\n");
                }
            }
        }
        searcher.close();
        ChatBoard.setText(String.valueOf(disp));
    }
        catch(FileNotFoundException e){
        e.printStackTrace();
    }
}

    public void handleSendMessage(ActionEvent event) throws IOException {
        String fileName = Email + ".txt";
        try {
            String message = ChatTextField.getText();
            FileWriter myFile = new FileWriter(fileName , true);
            BufferedWriter messageFile = new BufferedWriter(myFile);
            messageFile.write("Patient: " + message + "\n");
            messageFile.close();
            myFile.close();
        }
        catch(IOException exception) {
            System.out.println("ERROR");
            exception.printStackTrace();
        }
        boolean chatEnable = false;

        try {
            File myFile = new File(fileName);
            Scanner searcher = new Scanner(myFile);
            String[] chatArray = new String[1];
            StringBuilder disp = new StringBuilder();
            while (searcher.hasNextLine()) {
                String array = searcher.nextLine();
                if (array.equals("===============================")) {
                    chatEnable = true;
                }
                else if(chatEnable){
                    disp.append(array).append("\n");
                }
            }
            searcher.close();
            ChatBoard.setText(String.valueOf(disp));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

