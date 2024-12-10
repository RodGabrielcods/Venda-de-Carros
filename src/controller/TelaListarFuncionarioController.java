package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import dao.FuncionarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Funcionario;

public class TelaListarFuncionarioController {

    @FXML
    private Button btnRemoverFun;

    @FXML
    private Button btnatualizarFun;

    @FXML
    private Button btnpesquisa;

    @FXML
    private Button btnsairpesquisa;

    @FXML
    private TextField tfiltro;

    @FXML
    private TableColumn<Funcionario, String> colCpf;

    @FXML
    private TableColumn<Funcionario, LocalDate> colDataNascimento;

    @FXML
    private TableColumn<Funcionario, String> colEndereco;

    @FXML
    private TableColumn<Funcionario, Integer> colIDFun;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colTelefone;

    @FXML
    private TableView<Funcionario> tbFuncionario;

    ObservableList<Funcionario> obsFun;

    @FXML
    private void initialize() {
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dt_nascimento"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colIDFun.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        obsFun = FXCollections.observableArrayList();

        tbFuncionario.setItems(obsFun);
    }

    @FXML
    void btnRemoverFunclick(ActionEvent event) {
        Funcionario funcionarioSelecionado = tbFuncionario.getSelectionModel().getSelectedItem();

        if (funcionarioSelecionado != null) {
            boolean sucesso = FuncionarioDao.excluir(funcionarioSelecionado.getIdFuncionario());

            if (sucesso) {
                obsFun.remove(funcionarioSelecionado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Exclusão realizada");
                alert.setContentText("Funcionário excluído com sucesso!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setContentText("Não foi possível excluir o funcionário.");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Seleção inválida");
            alert.setContentText("Selecione um funcionário para excluir.");
            alert.show();
        }

    }

    @FXML
    void btnatualizarFunclick(ActionEvent event) throws IOException {
        Funcionario funcionarioSelecionado = tbFuncionario.getSelectionModel().getSelectedItem();
        if (funcionarioSelecionado != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaAtualizarFuncionario.fxml"));
            Parent root = loader.load();

            TelaAtualizarFuncionarioController controller = loader.getController();
            controller.setFuncionario(funcionarioSelecionado);

            Stage stage = new Stage();
            stage.setTitle("Atualizar Funcionario");
            stage.setScene(new Scene(root));
            stage.show();

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Seleção inválida");
            alert.setContentText("Selecione um funcionário para editar.");
            alert.show();
        }
    }

    @FXML
    void btnpesquisar(ActionEvent event) {
        String termo = tfiltro.getText().toLowerCase();

        obsFun.clear();

        for (Funcionario funcionario : FuncionarioDao.listar()) {
            if (funcionario.getNome().toLowerCase().contains(termo)) {
                obsFun.add(funcionario);
            }
        }

        tbFuncionario.setItems(obsFun);
    }

    @FXML
    void btnsairpesquisaclick(ActionEvent event) throws IOException {
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
