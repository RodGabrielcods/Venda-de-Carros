package controller;

import dao.FuncionarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;

        tfatualizarNome.setText(funcionario.getNome());
        tfatualizarEndereco.setText(funcionario.getEndereco());
        tfatualizarTelefone.setText(funcionario.getTelefone());
        tfatualizarCPF.setText(funcionario.getCpf());
        dtatualizarData.setValue(funcionario.getDt_nascimento());
    }

    @FXML
    void btnatualizarFunclick(ActionEvent event) {
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
                alertErro.setContentText("O telefone deve conter apenas números e ter 11 dígitos.");
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

                Stage stage = (Stage) btnatualizarFun.getScene().getWindow();
                stage.close();
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
    void btnsairatualizarFunclick(ActionEvent event) {
        Stage stage = (Stage) btnsairatualizarFun.getScene().getWindow();
        stage.close();
    }
}
