//This is a comment

package com.example.cse360project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class doctController {

    public Button docBack;

    public void handledocBackButton() throws IOException {
        System.out.println("YEP BACK YEP.");

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

}
