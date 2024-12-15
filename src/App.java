import java.net.URL;

import dao.UsuarioDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Usuario;

public class App extends Application {

    
    public static void main(String[] args) throws Exception {

        Usuario usuario = new Usuario();

        if (!UsuarioDao.verificarAdministrador()) {
            usuario.setNome_usuario("admin");
            usuario.setSenha("admin");
            UsuarioDao.cadastrar(usuario);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("/view/TelaCarros.fxml");
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
