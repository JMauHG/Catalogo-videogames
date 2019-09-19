/*
 * To change this license header, chooseconsola License Headers in Project Properties.
 * To change this template file, chooseconsola Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Game;
import Persistencia.DataAdapters.tblGamesAdapter;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JOptionPane;

public class SceneGamesController implements Initializable {

    ObservableList chooseconsola = FXCollections.observableArrayList();
    ObservableList choosegenero = FXCollections.observableArrayList();

    tblGamesAdapter tblgameadapter = new tblGamesAdapter();
    Game gameActual;
    boolean registroNuevo = false;
    SelectionModel tpgames;
    SelectionModel tpaccion;
    SelectionModel tpaisparos;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Game> tvHorror;

    @FXML
    private TableColumn<Game, String> colNombreHorror;

    @FXML
    private TableView<Game> tvAccion;

    @FXML
    private TableColumn<Game, String> colNombreAccion;

    @FXML
    private TableView<Game> tvDisparos;

    @FXML
    private TableColumn<Game, String> colNombreDisparos;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtImgURL;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblValor;

    @FXML
    private TextArea txtMostrardescripcion;

    @FXML
    private Label lblGenero;

    @FXML
    private TabPane tpGames;

    @FXML
    private Tab tabLista;

    @FXML
    private Tab tabDetalle;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnBuscar;

    @FXML
    private ChoiceBox<String> chooseConsola;

    @FXML
    private ChoiceBox<String> chooseGenero;

    @FXML
    private ImageView ivwPortada;

    @FXML
    private ImageView ivwConsola;

    @FXML
    void select(MouseEvent event) {
        Game datoHorror = tvHorror.getSelectionModel().getSelectedItem();
        if (datoHorror == null) {
            lblNombre.setText("Noting Selected");
        } else {
            lblNombre.setText(datoHorror.getNombre());
            lblValor.setText("$" + (Double.toString(datoHorror.getValor())));

            txtMostrardescripcion.setText(datoHorror.getDescripcion());

            lblGenero.setText(datoHorror.getGenero());
            File file = new File(datoHorror.getImgURL());
            Image image = new Image(file.toURI().toString());
            ivwPortada.setImage(image);

            File filexbox = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\xbox.jpg");
            Image xbox = new Image(filexbox.toURI().toString());

            File fileps4 = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\ps4.jpg");
            Image ps4 = new Image(fileps4.toURI().toString());

            if ("XBOX".equals(datoHorror.getConsola())) {
                ivwConsola.setImage(xbox);
            } else {
                ivwConsola.setImage(ps4);
            }
        }
    }

    @FXML
    void selectAccion(MouseEvent event) {
        Game datoAccion = tvAccion.getSelectionModel().getSelectedItem();
        if (datoAccion == null) {
            lblNombre.setText("Noting Selected");
        } else {
            lblNombre.setText(datoAccion.getNombre());
            lblValor.setText("$" + (Double.toString(datoAccion.getValor())));

            txtMostrardescripcion.setText(datoAccion.getDescripcion());

            lblGenero.setText(datoAccion.getGenero());
            File file = new File(datoAccion.getImgURL());
            Image image = new Image(file.toURI().toString());
            ivwPortada.setImage(image);

            File filexbox = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\xbox.jpg");
            Image xbox = new Image(filexbox.toURI().toString());

            File fileps4 = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\ps4.jpg");
            Image ps4 = new Image(fileps4.toURI().toString());

            if ("XBOX".equals(datoAccion.getConsola())) {
                ivwConsola.setImage(xbox);
            } else {
                ivwConsola.setImage(ps4);
            }
        }
    }

    @FXML
    void selectDisparos(MouseEvent event) {
        Game datoDisparos = tvDisparos.getSelectionModel().getSelectedItem();
        if (datoDisparos == null) {
            lblNombre.setText("Noting Selected");
        } else {
            lblNombre.setText(datoDisparos.getNombre());
            lblValor.setText("$" + (Double.toString(datoDisparos.getValor())));

            txtMostrardescripcion.setText(datoDisparos.getDescripcion());

            lblGenero.setText(datoDisparos.getGenero());
            File file = new File(datoDisparos.getImgURL());
            Image image = new Image(file.toURI().toString());
            ivwPortada.setImage(image);

            File filexbox = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\xbox.jpg");
            Image xbox = new Image(filexbox.toURI().toString());

            File fileps4 = new File("C:\\Users\\Mauricio\\Desktop\\Viedogames\\img\\ps4.jpg");
            Image ps4 = new Image(fileps4.toURI().toString());

            if ("XBOX".equals(datoDisparos.getConsola())) {
                ivwConsola.setImage(xbox);
            } else {
                ivwConsola.setImage(ps4);
            }
        }
    }

    @FXML
    void mniNuevo_ActionPerformed(ActionEvent event) {
        registroNuevo = true;
        tpgames.select(tabDetalle);
        tabLista.setDisable(true);
        tabDetalle.setDisable(false);
        txtNombre.setText("");
        txtValor.setText("");
        txtDescripcion.setText("");
    }

    /*
    @FXML
    void mniNuevo_ActionPerformed(ActionEvent event) {
        nuevaVentana();
    }
     */
    @FXML
    void mniEditar_ActionPerformed(ActionEvent event) {
        if (gameActual != null) {
            tpgames.select(tabDetalle);
            tabLista.setDisable(true);
            tabDetalle.setDisable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Elija un registro para editar.");
        }
    }

    @FXML
    void mniBorrarActionPerformed(ActionEvent event) {
        if (gameActual != null) {
            if (JOptionPane.showConfirmDialog(null,
                    "¿Desea borrar " + gameActual.getNombre() + "?",
                    "A T E N C I Ó N",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                tblgameadapter.Delete(gameActual);
                reinicializarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elija un registro para borrar.");
        }

    }

    @FXML
    void btnGuardar_ActionPerformed(ActionEvent event) {
        if (registroNuevo) {
            Game nuevoGame = new Game(txtNombre.getText(), Double.parseDouble(txtValor.getText()), txtDescripcion.getText(), chooseConsola.getValue(), chooseGenero.getValue(), txtImgURL.getText());
            tblgameadapter.Insert(nuevoGame);
            registroNuevo = false;
        } else {
            gameActual.setNombre(txtNombre.getText());
            gameActual.setValor(Double.parseDouble(txtValor.getText()));
            gameActual.setDescripcion(txtDescripcion.getText());
            gameActual.setConsola(chooseConsola.getValue());
            gameActual.setGenero(chooseGenero.getValue());
            tblgameadapter.Update(gameActual);
        }

        reinicializarCampos();
    }

    @FXML
    void mniCancelar_ActionPerformed(ActionEvent event) {
        reinicializarCampos();
    }

    @FXML
    void initialize() {
        assert tpGames != null : "fx:id=\"tpGames\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert tabLista != null : "fx:id=\"tabLista\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert tvHorror != null : "fx:id=\"tvHorror\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert colNombreHorror != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert tvAccion != null : "fx:id=\"tvAccion\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert colNombreAccion != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert tvDisparos != null : "fx:id=\"tvDisparos\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert colNombreDisparos != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert tabDetalle != null : "fx:id=\"tabDetalle\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert btnNuevo != null : "fx:id=\"btnNuevo\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert btnBorrar != null : "fx:id=\"btnBorrar\" was not injected: check your FXML file 'sceneGames.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'sceneGames.fxml'.";
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chooseConsola();
        chooseGenero();
        Buscar();

        tpgames = tpGames.getSelectionModel();
        tabDetalle.setDisable(true);

        colNombreHorror.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        String Horror = "Horror";
        cargarTablaGames(Horror);
        tvHorror.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (tvHorror.getSelectionModel().getSelectedItem() != null) {
                    gameActual = tvHorror.getSelectionModel().getSelectedItem();
                    txtNombre.setText(gameActual.getNombre());
                }
            }
        });

        colNombreAccion.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        String Accion = "Accion";
        cargarTablaGames(Accion);
        tvAccion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (tvAccion.getSelectionModel().getSelectedItem() != null) {
                    gameActual = tvAccion.getSelectionModel().getSelectedItem();
                    txtNombre.setText(gameActual.getNombre());
                }
            }
        });

        colNombreDisparos.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        String Disparos = "Disparos";
        cargarTablaGames(Disparos);
        tvDisparos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (tvDisparos.getSelectionModel().getSelectedItem() != null) {
                    gameActual = tvDisparos.getSelectionModel().getSelectedItem();
                    txtNombre.setText(gameActual.getNombre());
                }
            }
        });
    }

    private void cargarTablaGames(String genero) {

        if (genero == "Horror") {
            tvHorror.getItems().clear();
            tvHorror.getColumns().clear();

            ObservableList<Game> dataHorror = FXCollections.observableArrayList(tblgameadapter.Select(genero));

            tvHorror.getColumns().addAll(colNombreHorror);

            tvHorror.setItems(dataHorror);
        } else if (genero == "Accion") {
            tvAccion.getItems().clear();
            tvAccion.getColumns().clear();

            ObservableList<Game> dataAccion = FXCollections.observableArrayList(tblgameadapter.Select(genero));

            tvAccion.getColumns().addAll(colNombreAccion);

            tvAccion.setItems(dataAccion);
        } else if (genero == "Disparos") {
            tvDisparos.getItems().clear();
            tvDisparos.getColumns().clear();

            ObservableList<Game> dataDisparos = FXCollections.observableArrayList(tblgameadapter.Select(genero));

            tvDisparos.getColumns().addAll(colNombreDisparos);

            tvDisparos.setItems(dataDisparos);
        }
    }

    private void reinicializarCampos() {

        //Recargar la información
        String Horror = "Horror";
        cargarTablaGames(Horror);
        String Accion = "Accion";
        cargarTablaGames(Accion);
        String Disparos = "Disparos";
        cargarTablaGames(Disparos);
        tabDetalle.setDisable(true);
        tabLista.setDisable(false);
        tpgames.select(tabLista);
    }

    private void chooseConsola() {
        chooseconsola.removeAll(chooseconsola);
        String a = "XBOX";
        String b = "PS4";
        chooseconsola.addAll(a, b);
        chooseConsola.getItems().addAll(chooseconsola);
    }

    private void chooseGenero() {
        choosegenero.removeAll(choosegenero);
        String a = "Horror";
        String b = "Accion";
        String c = "Disparos";
        choosegenero.addAll(a, b, c);
        chooseGenero.getItems().addAll(choosegenero);
    }

    private void Buscar() {
        btnBuscar.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );

            Window stage = null;

            // Obtener la imagen seleccionada
            File imgFile = fileChooser.showOpenDialog(stage);

            String path = imgFile.getAbsolutePath();

            txtImgURL.setText(path);
        });
    }

}
