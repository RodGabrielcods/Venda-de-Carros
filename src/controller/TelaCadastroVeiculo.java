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

public class TelaCadastroVeiculo {

    @FXML
    private Button btncadastro;

    @FXML
    private Button btnsaircadastro;

    @FXML
    private TextField tfAno;

    @FXML
    private TextField tfCor;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfPlaca;

    @FXML
    void btnsaircadastro(ActionEvent event) throws IOException  {
        
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
    void tbncadastrar(ActionEvent event) {

    }

}
