package controller;

import java.io.IOException;
import java.net.URL;

import dao.FuncionarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Funcionario;

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

    private Funcionario funcionario;

    @FXML
    void btnatualizarFunclick(ActionEvent event) {

        try {
            funcionario.setNome(tfatualizarNome.getText());
            funcionario.setEndereco(tfatualizarEndereco.getText());
            funcionario.setTelefone(tfatualizarTelefone.getText());
            funcionario.setCpf(tfatualizarCPF.getText());
            funcionario.setDt_nascimento(dtatualizarData.getValue());

            boolean sucesso = FuncionarioDao.atualizar(funcionario);

            if (sucesso) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Atualização realizada");
                alert.setContentText("Funcionário atualizado com sucesso!");
                alert.show();

                Stage stage = (Stage) btnatualizarFun.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setContentText("Não foi possível atualizar o funcionário.");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro de Validação");
            alert.setContentText("Preencha todos os campos corretamente!");
            alert.show();
        }
    }

    @FXML
    void btnsairatualizarFunclick(ActionEvent event) throws IOException {

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
