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

public class TelaEstoqueController {

    @FXML
    private Button btnpesquisa;

    @FXML
    private Button btnsairpesquisa;

    @FXML
    private TableColumn<?, ?> colAno;

    @FXML
    private TableColumn<?, ?> colCor;

    @FXML
    private TableColumn<?, ?> colMarca;

    @FXML
    private TableColumn<?, ?> colModelo;

    @FXML
    private TableColumn<?, ?> colPlaca;

    @FXML
    private TableView<?> tbestoque;

    @FXML
    void btnpesquisar(ActionEvent event) {

    }

    @FXML
    void btnsairpesquisaclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
