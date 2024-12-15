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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Veiculo;

public class TelaAtualizarController {

    @FXML
    private Button btnatualizar;

    @FXML
    private Button btnsairatualizar;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfatualizarAno;

    @FXML
    private TextField tfatualizarCor;

    @FXML
    private TextField tfatualizarMarca;

    @FXML
    private Label tfatualizarModel;

    @FXML
    private TextField tfatualizarPlaca;

    private Veiculo veiculo;

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;

        tfatualizarAno.setText(String.valueOf(veiculo.getAno()));
        tfatualizarCor.setText(veiculo.getCor());
        tfatualizarMarca.setText(veiculo.getMarca());
        tfatualizarPlaca.setText(veiculo.getPlaca());
        tfModel.setText(veiculo.getModelo());
    }

    @FXML
void btnatualizarclick(ActionEvent event) {
    Alert alertErro = new Alert(Alert.AlertType.WARNING);

    try {
        if (tfatualizarAno.getText().trim().isEmpty() || tfatualizarCor.getText().trim().isEmpty()
                || tfatualizarMarca.getText().trim().isEmpty() || tfatualizarPlaca.getText().trim().isEmpty()
                || tfModel.getText().trim().isEmpty()) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
            alertErro.show();
            return;
        }

        if (tfatualizarPlaca.getText().length() != 7) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("A placa do veículo deve ter 7 dígitos.");
            alertErro.show();
            return;
        }

        if (!tfatualizarAno.getText().matches("\\d+")) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("O ano do veículo deve conter apenas números.");
            alertErro.show();
            return;
        }

        int ano = Integer.parseInt(tfatualizarAno.getText().trim());
        if (ano > java.time.LocalDate.now().getYear()) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("O ano do veículo não pode ser maior que o ano atual.");
            alertErro.show();
            return;
        }

        if (tfatualizarMarca.getText().matches(".*\\d.*")) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("A marca do veículo deve conter apenas letras.");
            alertErro.show();
            return;
        }

        if (tfatualizarCor.getText().matches(".*\\d.*")) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("A cor do veículo deve conter apenas letras.");
            alertErro.show();
            return;
        }

        if (tfModel.getText().matches(".*\\d.*")) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("O modelo do veículo deve conter apenas letras.");
            alertErro.show();
            return;
        }

        veiculo.setAno(ano);
        veiculo.setCor(tfatualizarCor.getText().trim());
        veiculo.setMarca(tfatualizarMarca.getText().trim());
        veiculo.setPlaca(tfatualizarPlaca.getText().trim());
        veiculo.setModelo(tfModel.getText().trim());

        boolean sucesso = VeiculoDao.atualizarVeiculo(veiculo);

        if (sucesso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atualização realizada");
            alert.setContentText("Veículo atualizado com sucesso!");
            alert.show();

            Stage stage = (Stage) btnsairatualizar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setContentText("Não foi possível atualizar o veículo.");
            alert.show();
        }

    } catch (NumberFormatException e) {
        alertErro.setHeaderText("Erro de Validação");
        alertErro.setContentText("O ano do veículo deve ser um número inteiro válido.");
        alertErro.show();
    } 
}


    @FXML
    void btnsairatualizar(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/TelaMenu.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenu = new Stage();
        stgMenu.setTitle("Menu");
        stgMenu.setScene(new Scene(root));
        stgMenu.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }

}
