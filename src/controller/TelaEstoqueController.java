package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import dao.VeiculoDao;
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
import model.SessaoUsuario;
import model.Veiculo;

public class TelaEstoqueController {

    @FXML
    private Button btnRemoverCar;

    @FXML
    private Button btnatualizarCar;

    @FXML
    private Button btnpesquisa;

    @FXML
    private Button btnsairpesquisa;

    @FXML
    private TableColumn<Veiculo, Integer> colAno;

    @FXML
    private TableColumn<Veiculo, String> colCor;

    @FXML
    private TableColumn<Veiculo, Integer> colIDCar;

    @FXML
    private TableColumn<Veiculo, String> colMarca;

    @FXML
    private TableColumn<Veiculo, String> colModelo;

    @FXML
    private TableColumn<Veiculo, String> colPlaca;

    @FXML
    private TableView<Veiculo> tbestoque;

    @FXML
    private TextField tfFiltro;

    ObservableList<Veiculo> obscar;

    @FXML
    private void initialize() {
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colIDCar.setCellValueFactory(new PropertyValueFactory<>("idVeiculo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));

        obscar = FXCollections.observableArrayList();

        tbestoque.setItems(obscar);
    }

    @FXML
    void btnRemoverFunclick(ActionEvent event) {
        Veiculo veiculoSelecionado = tbestoque.getSelectionModel().getSelectedItem();

        if (veiculoSelecionado != null) {
            boolean sucesso = VeiculoDao.excluir(veiculoSelecionado.getIdVeiculo());

            if (sucesso) {
                obscar.remove(veiculoSelecionado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Exclusão realizada");
                alert.setContentText("Veiculo excluído com sucesso!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setContentText("Não foi possível excluir o Veiculo.");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Seleção inválida");
            alert.setContentText("Selecione um Veiculo para excluir.");
            alert.show();
        }

    }

    @FXML
    void btnatualizarFunclick(ActionEvent event) throws IOException {
        Veiculo funcionarveiculooSelecionado = tbestoque.getSelectionModel().getSelectedItem();
        if (funcionarveiculooSelecionado != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaAtualizar.fxml"));
            Parent root = loader.load();

            TelaAtualizarController controller = loader.getController();
            controller.setVeiculo(funcionarveiculooSelecionado);

            Stage stage = new Stage();
            stage.setTitle("Atualizar Veiculo");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Seleção inválida");
            alert.setContentText("Selecione um Veiculo para editar.");
            alert.show();
        }
    }

    @FXML
    void btnpesquisar(ActionEvent event) {
        String termo = tfFiltro.getText().toLowerCase();

        obscar.clear();

        for (Veiculo veiculo : VeiculoDao.listar()) {
            if (veiculo.getPlaca().toLowerCase().contains(termo)) {
                obscar.add(veiculo);
            }
        }

        tbestoque.setItems(obscar);
    }

    @FXML
    void btnsairpesquisaclick(ActionEvent event) throws IOException {
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
            stgMenu.show();

            Stage telaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            telaAtual.close();
        }
    }

}
