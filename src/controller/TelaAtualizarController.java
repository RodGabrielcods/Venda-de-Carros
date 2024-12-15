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
import model.Funcionario;
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
        try {
            veiculo.setAno(Integer.parseInt(tfatualizarAno.getText()));
            veiculo.setCor(tfatualizarCor.getText());
            veiculo.setMarca(tfatualizarMarca.getText());
            veiculo.setPlaca(tfatualizarPlaca.getText());
            veiculo.setModelo(tfModel.getText());

            boolean sucesso = VeiculoDao.atualizarVeiculo(veiculo);

            if (sucesso) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Atualização realizada");
                alert.setContentText("Veiculo atualizado com sucesso!");
                alert.show();

                Stage stage = (Stage) btnsairatualizar.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setContentText("Não foi possível atualizar o veiculo.");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro de Validação");
            alert.setContentText("Preencha todos os campos corretamente!");
            alert.show();
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
