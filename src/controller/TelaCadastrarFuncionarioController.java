package controller;

import java.io.IOException;
import java.net.URL;

import dao.FuncionarioDao;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Funcionario;
import model.Usuario;

public class TelaCadastrarFuncionarioController {

    @FXML
    private Button btncadastrarfuncionario;

    @FXML
    private Button btnsaircadastrarfuncionario;

    @FXML
    private DatePicker dtfun;

    @FXML
    private TextField tfcpffun;

    @FXML
    private TextField tfenderefun;

    @FXML
    private TextField tfnomefun;

    @FXML
    private TextField tftelefun;

    @FXML
    void btncadastrarfuncionarioclick(ActionEvent event) {
        Funcionario funcionario = new Funcionario();
        Usuario usuario = new Usuario();
        Alert alertErro = new Alert(AlertType.WARNING);

        try {
            funcionario.setNome(tfnomefun.getText().trim());
            funcionario.setEndereco(tfenderefun.getText().trim());
            funcionario.setTelefone(tftelefun.getText().trim());
            funcionario.setDt_nascimento(dtfun.getValue());
            funcionario.setCpf(tfcpffun.getText().trim());

            usuario.setNome_usuario(funcionario.getCpf().trim());
            usuario.setSenha("#Fun123");

            if (tfcpffun.getText().isEmpty() || tfnomefun.getText().isEmpty() || tftelefun.getText().isEmpty()
                    || tfenderefun.getText().isEmpty()) {
                funcionario.setNome(null);
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
                alertErro.show();
                return;
            }

            if (tftelefun.getText().trim().isEmpty() || !tftelefun.getText().matches("\\d+")
                    || tftelefun.getText().length() < 11 || tftelefun.getText().length() > 11) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O telefone deve conter apenas números deve conter 11 dígitos.");
                alertErro.show();
                return;
            }

            if (tfnomefun.getText().trim().isEmpty() || tfnomefun.getText().matches(".*\\d.*")) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O nome deve conter apenas letras.");
                alertErro.show();
                return;
            }

            if (tftelefun.getText().trim().isEmpty() || !tftelefun.getText().matches("\\d+")
                    || tfcpffun.getText().length() < 11 || tfcpffun.getText().length() > 11) {
                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("O cpf deve conter apenas números deve conter 11 dígitos.");
                alertErro.show();
                return;
            }

            if (dtfun.getValue().isAfter(java.time.LocalDate.now())) {

                alertErro.setHeaderText("Erro de Validação");
                alertErro.setContentText("A data de nascimento não pode ser uma data futura.");
                alertErro.show();
                return;

            }


        } catch (NumberFormatException e) {
            alertErro.setHeaderText("Erro de Validação");
            alertErro.setContentText("Todos os campos devem ser preenchidos corretamente!");
            alertErro.show();
        }

        Alert alertConfCadastro;
        if (FuncionarioDao.cadastrar(funcionario) && UsuarioDao.cadastrar(usuario)) {
            alertConfCadastro = new Alert(AlertType.INFORMATION);
            alertConfCadastro.setHeaderText("Situação do Cadastro");
            alertConfCadastro.setContentText("Funcionário e Usuário cadastrado com sucesso!");

            tfcpffun.clear();
            tfenderefun.clear();
            tfnomefun.clear();
            tftelefun.clear();
            dtfun.setValue(null);
        } else {
            alertConfCadastro = new Alert(AlertType.ERROR);
            alertConfCadastro.setContentText("Erro ao cadastrar o Funcionário!");
        }
        alertConfCadastro.show();
    }

    @FXML
    void btnsaircadastrarfuncionarioclick(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/MenuAdmin.fxml");
        Parent root = FXMLLoader.load(url);

        Stage stgMenuAdmin = new Stage();
        stgMenuAdmin.setTitle("Menu Admin");
        stgMenuAdmin.setScene(new Scene(root));
        stgMenuAdmin.setResizable(false);
        stgMenuAdmin.show();

        Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        telaAtual.close();

    }
}
