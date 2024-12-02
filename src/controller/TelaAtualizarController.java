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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAtualizarController {

    @FXML
    private Button btnatualizar;

    @FXML
    private Button btnsairatualizar;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfatualizarAno;

    @FXML
    private TextField tfatualizarCor;

    @FXML
    private TextField tfatualizarMarca;

    @FXML
    private Label tfatualizarModel;

    @FXML
    private TextField tfatualizarPlaca;

    @FXML
    void btnatualizarclick(ActionEvent event) {

    }

    @FXML
    void btnsairatualizar(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenu = new Stage();
        stgMenu.setTitle("Menu");
        stgMenu.setScene(new Scene(root));
        stgMenu.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
