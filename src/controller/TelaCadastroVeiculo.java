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
import model.SessaoUsuario;
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
        if (SessaoUsuario.getNomeUsuario().equals("admin")) {
            URL url = getClass().getResource("/view/MenuAdmin.fxml");
            Parent root = FXMLLoader.load(url);

            Stage stgMenuAdmin = new Stage();
            stgMenuAdmin.setTitle("Menu Admin");
            stgMenuAdmin.setScene(new Scene(root));
            stgMenuAdmin.show();

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        } else {
            URL url = getClass().getResource("/view/TelaMenu.fxml");
            Parent root = FXMLLoader.load(url);

            Stage stgMenu = new Stage();
            stgMenu.setTitle("Menu");
            stgMenu.setScene(new Scene(root));
            stgMenu.setResizable(false);
            stgMenu.show();

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        }
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
                return;
            }

            if (tfPlaca.getText().length()!= 7) {
                veiculo.setPlaca(null);
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("A placa do veículo deve ter 7 digitos.");
                alertErro.show();
                return;
            }

            if (!tfAno.getText().matches("\\d+")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O ano do veículo deve conter apenas números.");
                alertErro.show();
                return;
            }

            int ano = Integer.parseInt(tfAno.getText());

            if (ano > java.time.LocalDate.now().getYear()) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O ano do veículo não pode ser maior que o ano atual.");
                alertErro.show();
                return;
            }

            if (tfMarca.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("A marca do veiculo deve conter apenas letras.");
                alertErro.show();
                return;
            }

            if (tfCor.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("A cor do veiculo deve conter apenas letras.");
                alertErro.show();
                return;
            }

            if (tfModel.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O modelo do veiculo deve conter apenas letras.");
                alertErro.show();
                return;
            }


        } catch (NumberFormatException e) {
            veiculo.setPlaca(null);
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
