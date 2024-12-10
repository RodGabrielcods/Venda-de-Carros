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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    void btnpesquisar(ActionEvent event) {
        List<Veiculo> veiculoCadastrado = VeiculoDao.listar();

        for (Veiculo veiculo : veiculoCadastrado) {
            obscar.add(veiculo);
        }
    }

    @FXML
    void btnsairpesquisaclick(ActionEvent event) throws IOException {

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
    void btnRemoverCarclick(ActionEvent event) {

    }

    @FXML
    void btnatualizarCarclick(ActionEvent event) {

    }

}
