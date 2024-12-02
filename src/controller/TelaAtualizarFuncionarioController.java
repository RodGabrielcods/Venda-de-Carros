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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAtualizarFuncionarioController {

    @FXML
    private Button btnatualizarFun;

    @FXML
    private Button btnsairatualizarFun;

    @FXML
    private DatePicker dtatualizarData;

    @FXML
    private TextField tfatualizarCPF;

    @FXML
    private TextField tfatualizarEndereco;

    @FXML
    private TextField tfatualizarNome;

    @FXML
    private TextField tfatualizarTelefone;

    @FXML
    void btnatualizarFunclick(ActionEvent event) {

    }

    @FXML
    void btnsairatualizarFunclick(ActionEvent event) throws IOException {

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