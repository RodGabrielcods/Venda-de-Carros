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
import javafx.stage.Stage;

public class MenuAdminController {

    @FXML
    private Button btnadautualizarveiculo;

    @FXML
    private Button btnadcadastrarveiculo;

    @FXML
    private Button btnadlistarveiculo;

    @FXML
    private Button btnadremoverveiculo;

    @FXML
    private Button btnadvoltar;

    @FXML
    private Button btnatualizarfun;

    @FXML
    private Button btnlistarfun;

    @FXML
    private Button btnnovofun;

    @FXML
    private Button btnremoverfun;

    @FXML
    void btnadautualizarveiculoclick(ActionEvent event) {

    }

    @FXML
    void btnadcadastrarveiculoclick(ActionEvent event) {

    }

    @FXML
    void btnadlistarveiculoclick(ActionEvent event) {

    }

    @FXML
    void btnadremoverveiculoclick(ActionEvent event) {

    }

    @FXML
    void btnadvoltarclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

    @FXML
    void btnatualizarfunclick(ActionEvent event) {

    }

    @FXML
    void btnlistarfunclick(ActionEvent event) {

    }

    @FXML
    void btnnovofunclick(ActionEvent event) {

    }

    @FXML
    void btnremoverfunclick(ActionEvent event) {

    }

}
