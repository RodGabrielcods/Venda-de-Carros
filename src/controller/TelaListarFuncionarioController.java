package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import dao.FuncionarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Funcionario;

public class TelaListarFuncionarioController {

    @FXML
    private Button btnListaFun;

    @FXML
    private Button btnsairListaFun;

    @FXML
    private TableColumn<Funcionario, String> colCPF;

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
    private void inicializate() {
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dt_nascimento"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colIDFun.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        obsFun = FXCollections.observableArrayList();

        tbFuncionario.setItems(obsFun);
    }

    @FXML
    void btnListaFunclick(ActionEvent event) {
        List<Funcionario> funcionarioCadastrado = FuncionarioDao.listar();

        for (Funcionario funcionario : funcionarioCadastrado) {
            System.out.println(funcionario.getCpf());
            System.out.println(funcionario.getEndereco());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getDt_nascimento());
            System.out.println(funcionario.getTelefone());
            obsFun.add(funcionario);
        }
    }

    @FXML
    void btnsairListaFunclick(ActionEvent event) throws IOException {
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
