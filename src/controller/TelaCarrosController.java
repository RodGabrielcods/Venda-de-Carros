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

public class TelaCarrosController {

    @FXML
    private Button btnadmin;

    @FXML
    private Button btnvai;

    @FXML
    private TextField tfsenha;

    @FXML
    private TextField tfuser;

    @FXML
    void btncadastrar(ActionEvent event) throws IOException {


        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenu = new Stage();
        stgMenu.setTitle("Menu");
        stgMenu.setScene(new Scene(root));
        stgMenu.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

    @FXML
    void btnadminclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/MenuAdmin.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
