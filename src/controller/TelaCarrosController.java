package controller;

import java.io.IOException;
import java.net.URL;

import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.SessaoUsuario;

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

        if (UsuarioDao.verificarUsuario(tfuser.getText(), tfsenha.getText())) {
            SessaoUsuario.setNomeUsuario(tfuser.getText());

            if (tfuser.getText().equals("admin") && tfsenha.getText().equals("admin")) {
                URL url = getClass().getResource("/view/MenuAdmin.fxml");
                Parent root = FXMLLoader.load(url);

                Stage stgVendas = new Stage();
                stgVendas.setTitle("Menu Admin");
                stgVendas.setScene(new Scene(root));
                stgVendas.setResizable(false);
                stgVendas.show();
            } else {
                URL url = getClass().getResource("/view/TelaMenu.fxml");
                Parent root = FXMLLoader.load(url);

                Stage stgMenu = new Stage();
                stgMenu.setTitle("Menu");
                stgMenu.setScene(new Scene(root));
                stgMenu.setResizable(false);
                stgMenu.show();
            }

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        } else {
            Alert alertErro = new Alert(AlertType.ERROR);
            alertErro.setHeaderText("Erro de validação");
            alertErro.setContentText("Usuário ou senha inválidos!");
            alertErro.show();
        }
    }

    @FXML
    void btnadminclick(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/MenuAdmin.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgVendas = new Stage();
        stgVendas.setTitle("Menu");
        stgVendas.setScene(new Scene(root));
        stgVendas.setResizable(false);
        stgVendas.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
