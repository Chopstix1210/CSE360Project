package com.example.cse360project;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;



public class DocHomePageController implements Initializable {


    public VBox docVisitTab, HealthVboxDoc, MedVboxDoc, PrescVboxDoc, VisitsTogglesDoc, PersonalVboxDoc, ChatVboxDoc;
    public ToggleButton PersonalInfoButDoc, VitalsDoc, HistoryButtonDoc, VisitsDocButt, PhysicalDoc, PrescriptionDoc,
            ChatButtonDoc;
    public TextField PFNameDoc, PLNameDoc, PMNameDoc, DOBSecDoc, PhoneSecDoc, EmailSecDoc, PharmSecDoc, InsurSecDoc,
            ChatTextFieldDoc;
    public TextArea ChatBoardDoc;
    public Label mainLabelDoc, healthLabelDoc, MedLabelDoc, ImmLabelDoc, PrescLabelDoc;

    public static String Email;
    public String First, Middle, Last, DOB, Phone, Pharm, Insur, sHealth, sMeds, sImm, sRec;



    public void docRun(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        docVisitTab.setVisible(false);
        VisitsTogglesDoc.setVisible(false);
        PersonalVboxDoc.setVisible(true);

        PersonalInfoButDoc.setSelected(true);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);

        String fileName = Email + ".txt";

        File myFile = new File(fileName);
        try {
            Scanner searcher = new Scanner(myFile);
            while (searcher.hasNextLine()) {
                String[] array = searcher.nextLine().split(":");
                switch (array[0]) {
                    case "FirstName" -> {
                        PFNameDoc.setText(array[1]);
                        First = array[1];
                    }
                    case "MiddleName" -> {
                        PMNameDoc.setText(array[1]);
                        Middle = array[1];
                    }
                    case "LastName" -> {
                        PLNameDoc.setText(array[1]);
                        Last = array[1];
                    }
                    case "DOB" -> {
                        DOBSecDoc.setText(array[1]);
                        DOB = array[1];
                    }
                    case "Phone" -> {
                        PhoneSecDoc.setText(array[1]);
                        Phone = array[1];
                    }
                    case "Pharmacy" -> {
                        PharmSecDoc.setText(array[1]);
                        Pharm = array[1];
                    }
                    case "Insurance" -> {
                        InsurSecDoc.setText(array[1]);
                        Insur = array[1];
                    }
                    case "Email" -> EmailSecDoc.setText(array[1]);
                    case "Health" -> {
                        sHealth = array[1];
                        healthLabelDoc.setText(sHealth);
                    }
                    case "Meds" -> {
                        sMeds = array[1];
                        MedLabelDoc.setText(sMeds);
                    }
                    case "Imm" -> {
                        sImm = array[1];
                        ImmLabelDoc.setText(sImm);
                    }
                    case "Rec" -> {
                        sRec = array[1];
                        PrescLabelDoc.setText(sRec);
                    }
                }
            }
            searcher.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        mainLabelDoc.setText("Welcome Doctor");


    }

    public void handlePatientPersonalInformation(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        VisitsTogglesDoc.setVisible(false);
        docVisitTab.setVisible(false);
        PersonalVboxDoc.setVisible(true);

        PersonalInfoButDoc.setSelected(true);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);
    }

    public void handlePatientVisits(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        VisitsTogglesDoc.setVisible(false);
        docVisitTab.setVisible(true);
        PersonalVboxDoc.setVisible(false);

        PersonalInfoButDoc.setSelected(false);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(true);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);
    }

    public void handlePatientHistory(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        VisitsTogglesDoc.setVisible(true);
        docVisitTab.setVisible(false);
        PersonalVboxDoc.setVisible(false);

        PersonalInfoButDoc.setSelected(false);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(true);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);
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
        ChatBoardDoc.setText(String.valueOf(disp));
    }
        catch(FileNotFoundException e){
        e.printStackTrace();
    }
}

    public void handleSendMessage(ActionEvent event) throws IOException {
        String fileName = Email + ".txt";
        try {
            String message = ChatTextFieldDoc.getText();
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
            ChatBoardDoc.setText(String.valueOf(disp));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ChatButtonDoc!=null) {
            docRun();
        }

    }
}

