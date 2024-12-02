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
    void btnadautualizarveiculoclick(ActionEvent event) throws IOException {
        
        URL url = getClass().getResource("/view/TelaAtualizarVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadcadastrarveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCadastroVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadlistarveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaEstoque.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadremoverveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaRemoverVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadvoltarclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCarros.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

    @FXML
    void btnatualizarfunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaAtualizarFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Atualizar Dados");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnlistarfunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaLIstaFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Lista deFuncionario");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnnovofunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCadastrarFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnremoverfunclick(ActionEvent event) throws IOException {
        
        URL url = getClass().getResource("/view/TelaRemoverFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Tela Remover Funcionario");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();



    }

}
