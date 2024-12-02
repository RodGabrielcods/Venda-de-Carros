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

public class TelaMenuController {

    @FXML
    private Button btnatualizar;

    @FXML
    private Button btncadastroveiculo;

    @FXML
    private Button btnestoque;

    @FXML
    private Button btnsair;

    @FXML
    void btnatualizarclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaAtualizar.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgAtualizar = new Stage();
        stgAtualizar.setTitle("Atualizar Dados");
        stgAtualizar.setScene(new Scene (root));
        stgAtualizar.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();
    }
    @FXML
    void btncadastrarveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCadastroVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgCadastro = new Stage();
        stgCadastro.setTitle("Atualizar Dados");
        stgCadastro.setScene(new Scene (root));
        stgCadastro.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();
    }

    @FXML
    void btnestoqueclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaEstoque.fxml");
        Parent root = FXMLLoader.load(url);

        Stage sgtEstoque = new Stage();
        sgtEstoque.setTitle("Atualizar Dados");
        sgtEstoque.setScene(new Scene (root));
        sgtEstoque.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();
    }

    @FXML
    void btnsairclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCarros.fxml");
        Parent root = FXMLLoader.load(url);

        Stage sgtEstoque = new Stage();
        sgtEstoque.setTitle("Atualizar Dados");
        sgtEstoque.setScene(new Scene (root));
        sgtEstoque.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();
    }

}
