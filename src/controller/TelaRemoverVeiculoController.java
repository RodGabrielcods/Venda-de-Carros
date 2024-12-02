package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaRemoverVeiculoController {

    @FXML
    private Button btnremoverveiculo;

    @FXML
    private Button btnsairveiculo;

    @FXML
    private TextField tfremoverveiculoid;

    @FXML
    private TextField tfremoverveiculoplaca;

    @FXML
    void btnremoverveiculoclick(ActionEvent event) {

    }

    @FXML
    void btnsairveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/MenuAdmin.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenuAdmin = new Stage();
        stgMenuAdmin.setTitle("Menu Admin");
        stgMenuAdmin.setScene(new Scene(root));
        stgMenuAdmin.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
