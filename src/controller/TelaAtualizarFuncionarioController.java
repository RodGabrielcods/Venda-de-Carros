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
import model.SessaoUsuario;

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

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;

        tfatualizarNome.setText(funcionario.getNome());
        tfatualizarEndereco.setText(funcionario.getEndereco());
        tfatualizarTelefone.setText(funcionario.getTelefone());
        tfatualizarCPF.setText(funcionario.getCpf());
        dtatualizarData.setValue(funcionario.getDt_nascimento());
    }

    @FXML
    void btnatualizarFunclick(ActionEvent event) throws IOException {
        Alert alertErro = new Alert(Alert.AlertType.WARNING);

        try {
            if (tfatualizarCPF.getText().isEmpty() || tfatualizarNome.getText().isEmpty()
                    || tfatualizarTelefone.getText().isEmpty() || tfatualizarEndereco.getText().isEmpty()) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
                alertErro.show();
                return;
            }

            if (!tfatualizarTelefone.getText().matches("\\d+") || tfatualizarTelefone.getText().length() != 11) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O telefone deve conter apenas números e 11 dígitos.");
                alertErro.show();
                return;
            }

            if (tfatualizarNome.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O nome deve conter apenas letras.");
                alertErro.show();
                return;
            }

            if (!tfatualizarCPF.getText().matches("\\d+") || tfatualizarCPF.getText().length() != 11) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O CPF deve conter apenas números e ter 11 dígitos.");
                alertErro.show();
                return;
            }

            if (dtatualizarData.getValue() != null && dtatualizarData.getValue().isAfter(java.time.LocalDate.now())) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("A data de nascimento não pode ser uma data futura.");
                alertErro.show();
                return;
            }

            if (tfatualizarEndereco.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O endereço do funcionário deve conter apenas letras.");
                alertErro.show();
                return;
            }

            funcionario.setNome(tfatualizarNome.getText().trim());
            funcionario.setEndereco(tfatualizarEndereco.getText().trim());
            funcionario.setTelefone(tfatualizarTelefone.getText().trim());
            funcionario.setCpf(tfatualizarCPF.getText().trim());
            funcionario.setDt_nascimento(dtatualizarData.getValue());

            boolean sucesso = FuncionarioDao.atualizar(funcionario);

            if (sucesso) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Atualização realizada");
                alert.setContentText("Funcionário atualizado com sucesso!");
                alert.show();

                URL url = getClass().getResource("/view/TelaListarFuncionario.fxml");
                Parent root = FXMLLoader.load(url);

                Stage stgMenuAdmin = new Stage();
                stgMenuAdmin.setTitle("Listar Funcionario");
                stgMenuAdmin.setScene(new Scene(root));
                stgMenuAdmin.setResizable(false);
                stgMenuAdmin.show();

                Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                telaAtual.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setContentText("Não foi possível atualizar o funcionário.");
                alert.show();
            }
        } catch (NumberFormatException e) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("Preencha os campos corretamente.");
            alertErro.show();
        }
    }

    @FXML
    void btnsairatualizarFunclick(ActionEvent event) throws IOException {
        if (SessaoUsuario.getNomeUsuario().equals("admin")) {
            URL url = getClass().getResource("/view/MenuAdmin.fxml");
            Parent root = FXMLLoader.load(url);

            Stage stgMenuAdmin = new Stage();
            stgMenuAdmin.setTitle("Menu Admin");
            stgMenuAdmin.setScene(new Scene(root));
            stgMenuAdmin.setResizable(false);
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
}
