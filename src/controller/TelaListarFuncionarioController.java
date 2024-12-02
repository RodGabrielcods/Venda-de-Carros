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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TelaListarFuncionarioController {

    @FXML
    private Button btnListaFun;

    @FXML
    private Button btnsairListaFun;

    @FXML
    private TableColumn<?, ?> colCPF;

    @FXML
    private TableColumn<?, ?> colDataNascimento;

    @FXML
    private TableColumn<?, ?> colEndereco;

    @FXML
    private TableColumn<?, ?> colIDFun;

    @FXML
    private TableColumn<?, ?> colNome;

    @FXML
    private TableColumn<?, ?> colTelefone;

    @FXML
    private TableView<?> tbFuncionario;

    @FXML
    void btnListaFunclick(ActionEvent event) {

    }

    @FXML
    void btnsairListaFunclick(ActionEvent event) throws IOException {

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
