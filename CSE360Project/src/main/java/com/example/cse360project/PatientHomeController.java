package com.example.cse360project;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ResourceBundle;
import java.util.Scanner;


public class PatientHomeController implements Initializable {

    public Button changeInfoButton, SendChatButton;
    public ToggleButton Visits, PersonalInfoBut, HistoryButton, ChatButton;
    public ToggleButton Health, Meds, Immune, Recommend;
    public TextField PFName, PMName, PLName,DOBSec, PhoneSec, EmailSec,PharmSec, InsurSec, ChatTextField;
    public String First, Middle, Last, DOB, Phone, Pharm, Insur, sHealth, sMeds, sImm, sRec;
    public static String Email;
    public Label mainLabel, healthLabel, MedLabel, ImmLabel, RecLabel, MainVisitsLabel, VisitsLabelThing;
    public patientController patientController;
    public VBox PersonalVbox, VisitsToggles, HealthVbox, MedVbox, ImmVbox, RecVbox, ChatVbox, MessageVbox;
    public Rectangle topRec, botRec, personalRec, VisitRec;
    public HBox ChatHbox;
    public TextArea ChatBoard;

    //runs on init of the scene to display the information of the patient
    public void firstRun(){

        PersonalInfoBut.setSelected(true);
        Visits.setSelected(false);
        HistoryButton.setSelected(false);
        ChatButton.setSelected(false);

        PersonalVbox.setVisible(true);
        VisitsToggles.setVisible(false);
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        topRec.setVisible(false);
        botRec.setVisible(false);
        personalRec.setVisible(true);
        VisitRec.setVisible(false);

        VisitsLabelThing.setVisible(false);
        MainVisitsLabel.setVisible(false);
        ChatVbox.setVisible(false);

        String fileName = Email + ".txt";

        File myFile = new File(fileName);
        try {
            Scanner searcher = new Scanner(myFile);
            while (searcher.hasNextLine()) {
                String[] array = searcher.nextLine().split(":");
                switch (array[0]) {
                    case "FirstName" -> {
                        PFName.setText(array[1]);
                        First = array[1];
                    }
                    case "MiddleName" -> {
                        PMName.setText(array[1]);
                        Middle = array[1];
                    }
                    case "LastName" -> {
                        PLName.setText(array[1]);
                        Last = array[1];
                    }
                    case "DOB" -> {
                        DOBSec.setText(array[1]);
                        DOB = array[1];
                    }
                    case "Phone" -> {
                        PhoneSec.setText(array[1]);
                        Phone = array[1];
                    }
                    case "Pharmacy" -> {
                        PharmSec.setText(array[1]);
                        Pharm = array[1];
                    }
                    case "Insurance" -> {
                        InsurSec.setText(array[1]);
                        Insur = array[1];
                    }
                    case "Email" -> EmailSec.setText(array[1]);
                    case "Health" -> {
                        sHealth = array[1];
                        healthLabel.setText(sHealth);
                    }
                    case "Meds" -> {
                        sMeds = array[1];
                        MedLabel.setText(sMeds);
                    }
                    case "Imm" -> {
                        sImm = array[1];
                        ImmLabel.setText(sImm);
                    }
                    case "Rec" -> {
                        sRec = array[1];
                        RecLabel.setText(sRec);
                    }
                }
            }
            searcher.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        mainLabel.setText("Welcome " + First + " " + Last);
    }

    //change the information of the patient
    public void handleChangeInformation() throws IOException {

        String open = Email + ".txt";

        if(!Email.equals(EmailSec.getText().toLowerCase())){
            File delFile = new File(open);
            if(delFile.delete()){
                System.out.println("File Deleted! Making New One!");
            }
            else{
                System.out.println("File now deleted! Keeping Old one");
            }
        }

        First = PFName.getText();
        Middle = PMName.getText();
        Last = PLName.getText();
        DOB = DOBSec.getText();
        Phone = PhoneSec.getText();
        Email = EmailSec.getText();
        Pharm = PharmSec.getText();
        Insur = InsurSec.getText();

        open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);
        patientFile.write(
                    "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n");
        patientFile.close();
        myFile.close();
    }

    //clicking on the side buttons
    public void handlePersonalInfoButton(){

        PersonalInfoBut.setSelected(true);
        Visits.setSelected(false);
        HistoryButton.setSelected(false);
        ChatButton.setSelected(false);

        PersonalVbox.setVisible(true);
        VisitsToggles.setVisible(false);
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        topRec.setVisible(false);
        botRec.setVisible(false);
        personalRec.setVisible(true);
        VisitRec.setVisible(false);

        VisitsLabelThing.setVisible(false);
        MainVisitsLabel.setVisible(false);
    }
    public void handleHistoryButton(){
        PersonalInfoBut.setSelected(false);
        Visits.setSelected(false);
        HistoryButton.setSelected(true);
        ChatButton.setSelected(false);

        PersonalVbox.setVisible(false);
        VisitsToggles.setVisible(true);
        HealthVbox.setVisible(true);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        topRec.setVisible(true);
        botRec.setVisible(true);
        personalRec.setVisible(false);
        VisitRec.setVisible(false);

        VisitsLabelThing.setVisible(false);
        MainVisitsLabel.setVisible(false);


        Health.setSelected(true);
        Meds.setSelected(false);
        Immune.setSelected(false);
        Recommend.setSelected(false);


    }
    public void handleVisitButton() throws FileNotFoundException {
        PersonalInfoBut.setSelected(false);
        Visits.setSelected(true);
        HistoryButton.setSelected(false);
        ChatButton.setSelected(false);

        PersonalVbox.setVisible(false);
        VisitsToggles.setVisible(false);
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        topRec.setVisible(false);
        botRec.setVisible(false);
        personalRec.setVisible(false);
        VisitRec.setVisible(true);

        VisitsLabelThing.setVisible(true);
        MainVisitsLabel.setVisible(true);


        Health.setSelected(false);
        Meds.setSelected(false);
        Immune.setSelected(false);
        Recommend.setSelected(false);

        String fileName = Email + ".txt";

        File myFile = new File(fileName);
        Scanner searcher = new Scanner(myFile);
        while(searcher.hasNextLine()){
            String[] array = searcher.nextLine().split(":");
            StringBuilder disp = new StringBuilder();
            if(array[0].equals("Visits")){
                for (String s : array) {
                    disp.append(s).append("\n");
                }
                VisitsLabelThing.setText(String.valueOf(disp));
            }
        }
        searcher.close();
    }

    //handle the history buttons
    public void handleHealthTab(){
        HealthVbox.setVisible(true);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        Health.setSelected(true);
        Meds.setSelected(false);
        Immune.setSelected(false);
        Recommend.setSelected(false);
    }
    public void handleMedTab(){
        HealthVbox.setVisible(false);
        MedVbox.setVisible(true);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        Health.setSelected(false);
        Meds.setSelected(true);
        Immune.setSelected(false);
        Recommend.setSelected(false);
    }
    public void handleImmTab(){
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(true);
        RecVbox.setVisible(false);

        Health.setSelected(false);
        Meds.setSelected(false);
        Immune.setSelected(true);
        Recommend.setSelected(false);
    }
    public void handleRecBox(){
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(true);

        Health.setSelected(false);
        Meds.setSelected(false);
        Immune.setSelected(false);
        Recommend.setSelected(true);
    }
    public void handleChatButton(){
        PersonalInfoBut.setSelected(false);
        Visits.setSelected(false);
        HistoryButton.setSelected(false);
        ChatButton.setSelected(true);

        PersonalVbox.setVisible(false);
        VisitsToggles.setVisible(false);
        HealthVbox.setVisible(false);
        MedVbox.setVisible(false);
        ImmVbox.setVisible(false);
        RecVbox.setVisible(false);

        topRec.setVisible(false);
        botRec.setVisible(false);
        personalRec.setVisible(false);
        VisitRec.setVisible(true);

        VisitsLabelThing.setVisible(false);
        MainVisitsLabel.setVisible(false);


        Health.setSelected(false);
        Meds.setSelected(false);
        Immune.setSelected(false);
        Recommend.setSelected(false);

        ChatVbox.setVisible(true);

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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(PFName!=null) {
            firstRun();
        }

    }
}


