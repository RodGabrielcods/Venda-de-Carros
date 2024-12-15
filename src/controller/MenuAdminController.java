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
        
        URL url = getClass().getResource("/view/TelaAtualizar.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgAtualizar = new Stage();
        stgAtualizar.setTitle("Tela Atualizar");
        stgAtualizar.setScene(new Scene(root));
        stgAtualizar.setResizable(false);
        stgAtualizar.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadcadastrarveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCadastroVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgCadastroVeiculo = new Stage();
        stgCadastroVeiculo.setTitle("Tela Cadastro Veiculo");
        stgCadastroVeiculo.setScene(new Scene(root));
        stgCadastroVeiculo.setResizable(false);
        stgCadastroVeiculo.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadlistarveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaEstoque.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgEstoque = new Stage();
        stgEstoque.setTitle("Tela Estoque");
        stgEstoque.setScene(new Scene(root));
        stgEstoque.setResizable(false);
        stgEstoque.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadremoverveiculoclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaRemoverVeiculo.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgRemover = new Stage();
        stgRemover.setTitle("Tela Remover veiculo");
        stgRemover.setScene(new Scene(root));
        stgRemover.setResizable(false);
        stgRemover.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnadvoltarclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCarros.fxml");
        Parent root = FXMLLoader.load(url);

        Stage StgLogin = new Stage();
        StgLogin.setTitle("Login");
        StgLogin.setScene(new Scene(root));
        StgLogin.setResizable(false);
        StgLogin.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

    @FXML
    void btnatualizarfunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaAtualizarFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgAtualizarFuncionario = new Stage();
        stgAtualizarFuncionario.setTitle("Atualizar Dados");
        stgAtualizarFuncionario.setScene(new Scene(root));
        stgAtualizarFuncionario.setResizable(false);
        stgAtualizarFuncionario.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnlistarfunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaListarFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgListaFun = new Stage();
        stgListaFun.setTitle("Lista de Funcionario");
        stgListaFun.setScene(new Scene(root));
        stgListaFun.setResizable(false);
        stgListaFun.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnnovofunclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaCadastrarFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgCadastrarFun = new Stage();
        stgCadastrarFun.setTitle("Tela Cadastrar Funcionario");
        stgCadastrarFun.setScene(new Scene(root));
        stgCadastrarFun.setResizable(false);
        stgCadastrarFun.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();


    }

    @FXML
    void btnremoverfunclick(ActionEvent event) throws IOException {
        
        URL url = getClass().getResource("/view/TelaRemoverFuncionario.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgRemoverFun = new Stage();
        stgRemoverFun.setTitle("Tela Remover Funcionario");
        stgRemoverFun.setScene(new Scene(root));
        stgRemoverFun.setResizable(false);
        stgRemoverFun.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();



    }

}
