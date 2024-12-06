package controller;

import java.io.IOException;
import java.net.URL;

import dao.VeiculoDao;
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
import model.Veiculo;

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
    void btnsaircadastro(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenu = new Stage();
        stgMenu.setTitle("Menu");
        stgMenu.setScene(new Scene(root));
        stgMenu.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();
    }

    @FXML
    void tbncadastrar(ActionEvent event) {
        Veiculo veiculo = new Veiculo();
        Alert alertErro = new Alert(AlertType.WARNING);

        try {
            veiculo.setMarca(tfMarca.getText().trim());
            veiculo.setModelo(tfModel.getText().trim());
            veiculo.setPlaca(tfPlaca.getText().trim());
            veiculo.setCor(tfCor.getText().trim());
            veiculo.setAno(Integer.parseInt(tfAno.getText().trim()));

            if (tfCor.getText().isEmpty() || tfMarca.getText().isEmpty() || tfPlaca.getText().isEmpty()
                    || tfModel.getText().isEmpty() || tfAno.getText().isEmpty()) {
                veiculo.setPlaca(null);
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
                alertErro.show();
            }
        } catch (NumberFormatException e) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
            alertErro.show();
        }

        Alert alertConfCadastro;
        if (VeiculoDao.cadastrar(veiculo)) {
            alertConfCadastro = new Alert(AlertType.INFORMATION);
            alertConfCadastro.setHeaderText("Situação do Cadastro");
            alertConfCadastro.setContentText("Veículo cadastrado com sucesso!");

            tfAno.clear();
            tfMarca.clear();
            tfModel.clear();
            tfPlaca.clear();
            tfCor.clear();
        } else {
            alertConfCadastro = new Alert(AlertType.ERROR);
            alertConfCadastro.setContentText("Erro ao cadastrar o Veículo!");
        }
        alertConfCadastro.show();
    }
}
