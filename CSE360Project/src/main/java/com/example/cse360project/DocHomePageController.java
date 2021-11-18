package com.example.cse360project;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;



public class DocHomePageController implements Initializable {


    public VBox docVisitTab, HealthVboxDoc, MedVboxDoc, PrescVboxDoc, VisitsTogglesDoc, PersonalVboxDoc
            , ChatVboxDoc, ImmVboxDoc, docVitalsTab;
    public ToggleButton PersonalInfoButDoc, VitalsDoc, HistoryButtonDoc, VisitsDocButt, PhysicalDoc, PrescriptionDoc,
            ChatButtonDoc, HealthDoc, MedsDoc, ImmuneDoc, RecommendDoc;
    public TextField PFNameDoc, PLNameDoc, PMNameDoc, DOBSecDoc, PhoneSecDoc, EmailSecDoc, PharmSecDoc, InsurSecDoc,
            ChatTextFieldDoc, MedsIn, healthSave, medSave, ImmSave, VisitTextFieldDoc, PAgeDoc, PWeightDoc,
            PHeightDoc, PTempDoc, PBPDoc;
    public TextArea ChatBoardDoc;
    public Label mainLabelDoc, healthLabelDoc, MedLabelDoc, ImmLabelDoc, PrescLabelDoc, VisitsLabelThingDoc, VisitDoc;
    public Button VitSaveDoc;

    public static String Email;
    public String First, Middle, Last, DOB, Phone, Pharm, Insur, sHealth, sMeds, sImm, sRec, sVisits;



    public void docRun(){
        docVisitTab.setVisible(false);
        docVitalsTab.setVisible(false);
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

                        String[] temp = sMeds.split(":");
                        StringBuilder disp = new StringBuilder();
                        for (String s : temp) {
                            disp.append(s).append("\n");
                        }
                        MedLabelDoc.setText(String.valueOf(disp));
                        PrescLabelDoc.setText(String.valueOf(disp));
                    }
                    case "Imm" -> {
                        sImm = array[1];
                        ImmLabelDoc.setText(sImm);
                    }
                    case "Rec" -> {
                        sRec = array[1];
                    }
                    case "Visits" ->{
                        sVisits = array[1];
                        String[] temp = sVisits.split(":");
                        StringBuilder disp = new StringBuilder();
                        for (String s : temp) {
                            disp.append(s).append("\n");
                        }
                        VisitDoc.setText(String.valueOf(disp));
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
        HealthVboxDoc.setVisible(true);
        docVitalsTab.setVisible(false);
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
    public void handlePatientHistoryHealth(){
        HealthVboxDoc.setVisible(true);
        MedVboxDoc.setVisible(false);
        ImmVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);

        HealthDoc.setSelected(true);
        MedsDoc.setSelected(false);
        ImmuneDoc.setSelected(false);
        RecommendDoc.setSelected(false);
    }
    public void updatePatientHistoryHealth() throws IOException {
        String health = healthSave.getText();
        String all;
        if(healthLabelDoc.getText().equals(".")){
            all = health;
        }
        else{
            all = healthLabelDoc.getText() + "\n" + health;
        }

        healthLabelDoc.setText(all);

        String open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        StringBuilder disp = new StringBuilder();
        try {
            File readFile = new File(fileName);
            Scanner searcher = new Scanner(readFile);
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] temp = all.split("\n");
        StringBuilder other = new StringBuilder();
        for(String s: temp){
            other.append(s).append(":");
        }

        patientFile.write(
                "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n" +
                        "Health:" + String.valueOf(other) + "\n" + "Meds:" + sMeds + "\n"+
                        "Imm:" + sImm + "\n" + "Rec:" + sRec + "\n" +
                        "Visits:" + sVisits + "\n"
                        + "===============================" + "\n"
                        + String.valueOf(disp));
        patientFile.close();
        myFile.close();
    }
    public void handlePatientHistoryMeds(){
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(true);
        ImmVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);

        HealthDoc.setSelected(false);
        MedsDoc.setSelected(true);
        ImmuneDoc.setSelected(false);
        RecommendDoc.setSelected(false);
    }
    public void updatePatientHistoryMeds() throws IOException {
        String meds = medSave.getText();
        String all;
        if(MedLabelDoc.getText().equals(".")){
            all = meds;
        }
        else{
            all = MedLabelDoc.getText() + "\n" + meds;
        }

        MedLabelDoc.setText(all);

        String open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        StringBuilder disp = new StringBuilder();
        try {
            File readFile = new File(fileName);
            Scanner searcher = new Scanner(readFile);
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] temp = all.split("\n");
        StringBuilder other = new StringBuilder();
        for(String s: temp){
            other.append(s).append(":");
        }
        sMeds = String.valueOf(other);
        patientFile.write(
                "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n" +
                        "Health:" + sHealth + "\n" + "Meds:" + sMeds + "\n"+
                        "Imm:" + sImm + "\n" + "Rec:" + sRec + "\n" +
                        "Visits:" + sVisits + "\n"
                        + "===============================" + "\n"
                        + String.valueOf(disp));
        patientFile.close();
        myFile.close();
    }
    public void handlePatientHistoryImm(){
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        ImmVboxDoc.setVisible(true);
        PrescVboxDoc.setVisible(false);

        HealthDoc.setSelected(false);
        MedsDoc.setSelected(false);
        ImmuneDoc.setSelected(true);
        //RecommendDoc.setSelected(false);
    }
    public void updatePatientHistoryImm() throws IOException{
        String Imm = ImmSave.getText();
        String all;
        if(ImmSave.getText().equals(".")){
            all = Imm;
        }
        else{
            all = ImmSave.getText() + "\n" + Imm;
        }

        ImmSave.setText(all);

        String open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        StringBuilder disp = new StringBuilder();
        try {
            File readFile = new File(fileName);
            Scanner searcher = new Scanner(readFile);
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] temp = all.split("\n");
        StringBuilder other = new StringBuilder();
        for(String s: temp){
            other.append(s).append(":");
        }
        sMeds = String.valueOf(other);
        patientFile.write(
                "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n" +
                        "Health:" + sHealth + "\n" + "Meds:" + sMeds + "\n"+
                        "Imm:" + sImm + "\n" + "Rec:" + sRec + "\n" +
                        "Visits:" + sVisits + "\n"
                        + "===============================" + "\n"
                        + String.valueOf(disp));
        patientFile.close();
        myFile.close();
    }
    public void handlePatientHistoryRec(){
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        ImmVboxDoc.setVisible(false);
        //PrescVboxDoc.setVisible(true);

        HealthDoc.setSelected(false);
        MedsDoc.setSelected(false);
        ImmuneDoc.setSelected(false);
        //RecommendDoc.setSelected(true);
    }

    public void handlePrescriptionButton(){
        docVisitTab.setVisible(false);
        docVitalsTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(true);
        VisitsTogglesDoc.setVisible(false);
        docVisitTab.setVisible(false);
        PersonalVboxDoc.setVisible(false);

        PersonalInfoButDoc.setSelected(false);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(true);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);
    }
    public void updatePrescriptions() throws IOException {

        String addMeds = MedsIn.getText();
        String all;
        if(PrescLabelDoc.getText().equals(".")){
            all = addMeds;
        }
        else{
            all = PrescLabelDoc.getText() + "\n" + addMeds;
        }

        PrescLabelDoc.setText(all);

        String open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        StringBuilder disp = new StringBuilder();
        try {
            File readFile = new File(fileName);
            Scanner searcher = new Scanner(readFile);
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] temp = all.split("\n");
        StringBuilder other = new StringBuilder();
        for(String s: temp){
            other.append(s).append(":");
        }

        patientFile.write(
                "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n" +
                        "Health:" + sHealth + "\n" + "Meds:" + String.valueOf(other) + "\n"+
                        "Imm:" + sImm + "\n" + "Rec:" + sRec + "\n" +
                        "Visits:" + sVisits + "\n"
                        + "===============================" + "\n"
                        + String.valueOf(disp));
        patientFile.close();
        myFile.close();
    }

    public void updateVisits() throws IOException {

        String addVisits = VisitTextFieldDoc.getText();
        String all;
        if(VisitDoc.getText().equals(".")){
            all = addVisits;
        }
        else{
            all = VisitDoc.getText() + "\n" + addVisits;
        }

        VisitDoc.setText(all);

        String open = Email + ".txt";

        FileWriter myFile = new FileWriter(open);
        BufferedWriter patientFile = new BufferedWriter(myFile);

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        StringBuilder disp = new StringBuilder();
        try {
            File readFile = new File(fileName);
            Scanner searcher = new Scanner(readFile);
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
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] temp = all.split("\n");
        StringBuilder other = new StringBuilder();
        for(String s: temp){
            other.append(s).append(":");
        }
        sVisits=String.valueOf(other);

        patientFile.write(
                "FirstName:" + First + "\n" +
                        "MiddleName:" + Middle + "\n" +
                        "LastName:" + Last + "\n" +
                        "DOB:" + DOB + "\n" +
                        "Phone:" + Phone + "\n" +
                        "Email:" + Email + "\n" +
                        "Pharmacy:" + Pharm + "\n" +
                        "Insurance:" + Insur + "\n" +
                        "Health:" + sHealth + "\n" + "Meds:" + sMeds + "\n"+
                        "Imm:" + sImm + "\n" + "Rec:" + sRec + "\n" +
                        "Visits:" + sVisits + "\n"
                        + "===============================" + "\n"
                        + String.valueOf(disp));
        patientFile.close();
        myFile.close();
    }

    public void handlePatientVitals(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        docVitalsTab.setVisible(true);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        VisitsTogglesDoc.setVisible(false);
        docVisitTab.setVisible(false);
        PersonalVboxDoc.setVisible(false);

        PersonalInfoButDoc.setSelected(false);
        VitalsDoc.setSelected(true);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(false);

        ChatVboxDoc.setVisible(false);

    }

    public void savePatVitals(){
        String Age = PAgeDoc.getText();
        String Weight = PWeightDoc.getText();
        String Height = PHeightDoc.getText();
        String Temperature = PTempDoc.getText();
        String BloodPressure = PBPDoc.getText();

        PAgeDoc.setText(Age);
        PWeightDoc.setText(Weight);
        PHeightDoc.setText(Height);
        PTempDoc.setText(Temperature);
        PBPDoc.setText(BloodPressure);

    }



    public void sendMedstoPharm(){
        Stage popUpWindow = new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Sent!");

        Label pharmLabelSent = new Label("Medication sent to " + Pharm);
        Button exitButton = new Button("Ok");
        exitButton.setOnAction(e->popUpWindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(pharmLabelSent,exitButton);
        layout.setAlignment(Pos.CENTER);
        Scene popUpScene = new Scene(layout, 300, 250);
        popUpWindow.setScene(popUpScene);
        popUpWindow.showAndWait();
    }


    public void SendMessageDoc(){
        handlePatientChatButton();

        String fileName = Email + ".txt";
        boolean chatEnable = false;

        try {
        File myFile = new File(fileName);
        Scanner searcher = new Scanner(myFile);
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
    public void handlePatientChatButton(){
        docVisitTab.setVisible(false);
        HealthVboxDoc.setVisible(false);
        MedVboxDoc.setVisible(false);
        PrescVboxDoc.setVisible(false);
        VisitsTogglesDoc.setVisible(false);
        docVisitTab.setVisible(false);
        PersonalVboxDoc.setVisible(false);

        PersonalInfoButDoc.setSelected(false);
        VitalsDoc.setSelected(false);
        HistoryButtonDoc.setSelected(false);
        VisitsDocButt.setSelected(false);
        PhysicalDoc.setSelected(false);
        PrescriptionDoc.setSelected(false);
        ChatButtonDoc.setSelected(true);

        ChatVboxDoc.setVisible(true);
    }

    public void handleSendMessage(ActionEvent event) throws IOException {
        String fileName = Email + ".txt";
        try {
            String message = ChatTextFieldDoc.getText();
            FileWriter myFile = new FileWriter(fileName , true);
            BufferedWriter messageFile = new BufferedWriter(myFile);
            messageFile.write("Doctor: " + message + "\n");
            messageFile.close();
            myFile.close();
            ChatTextFieldDoc.setText("");
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

