/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Divisa;
import DataAdapters.tblDivisaAdapter;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class SceneDivisasController implements Initializable {

    tblDivisaAdapter tbldivisaadapter = new tblDivisaAdapter();
    Divisa divisaActual;
    boolean registroNuevo = false;
    SelectionModel tpdivisas;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Divisa> tvDivisas;

    @FXML
    private TableColumn<Divisa, String> colNombre;

    @FXML
    private TableColumn<Divisa, Double> colValor;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtValor;

    @FXML
    private MenuItem mniNuevo;

    @FXML
    private MenuItem mniEditar;

    @FXML
    private MenuItem mniCancelar;

    @FXML
    private TabPane tpDivisas;

    @FXML
    private Tab tabLista;

    @FXML
    private Tab tabDetalle;

    @FXML
    private Button btnGuardar;

    @FXML
    void mniNuevo_ActionPerformed(ActionEvent event) {
        registroNuevo = true;
        tpdivisas.select(tabDetalle);
        tabLista.setDisable(true);
        tabDetalle.setDisable(false);
        txtNombre.setText("");
        txtValor.setText("");

    }

    @FXML
    void mniEditar_ActionPerformed(ActionEvent event) {
        if (divisaActual != null) {
            tpdivisas.select(tabDetalle);
            tabLista.setDisable(true);
            tabDetalle.setDisable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Elija un registro para editar.");
        }
    }

    @FXML
    void btnGuardar_ActionPerformed(ActionEvent event) {
        if (registroNuevo) {
            Divisa nuevaDivisa = new Divisa(txtNombre.getText(), Double.parseDouble(txtValor.getText()));
            tbldivisaadapter.Insert(nuevaDivisa);
            registroNuevo = false;
        } else {

            //Implementar la operación de edición
            //Divisa nuevaDivisa = new Divisa(txtNombre.getText(), Double.parseDouble(txtValor.getText()));
            //tbldivisaadapter.Insert(nuevaDivisa);
        }

        reinicializarCampos();

    }

    @FXML
    void mniCancelar_ActionPerformed(ActionEvent event) {
        reinicializarCampos();
    }

    @FXML
    void initialize() {
        assert tpDivisas != null : "fx:id=\"tpDivisas\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert tabLista != null : "fx:id=\"tabLista\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert tvDivisas != null : "fx:id=\"tvDivisas\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert colValor != null : "fx:id=\"colValor\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert tabDetalle != null : "fx:id=\"tabDetalle\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert txtValor != null : "fx:id=\"txtValor\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert mniNuevo != null : "fx:id=\"mniNuevo\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert mniEditar != null : "fx:id=\"mniEditar\" was not injected: check your FXML file 'sceneDivisas.fxml'.";
        assert mniCancelar != null : "fx:id=\"mniCancelar\" was not injected: check your FXML file 'sceneDivisas.fxml'.";

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tpdivisas = tpDivisas.getSelectionModel();
        tabDetalle.setDisable(true);
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty().asObject());
        cargarTablaDivisas();

        tvDivisas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (tvDivisas.getSelectionModel().getSelectedItem() != null) {
                    divisaActual = tvDivisas.getSelectionModel().getSelectedItem();
                    txtNombre.setText(divisaActual.getNombre());
                    txtValor.setText(String.valueOf(divisaActual.getValor()));
                }
            }
        });
    }

    // CARGA INICIAL DE LA TABLA DE DIVISAS
    private void cargarTablaDivisas() {

        //REINICIALIZAR TODA LA INFORMACIÓN QUE PUEDA ALBERGAR
        tvDivisas.getItems().clear();
        tvDivisas.getColumns().clear();

        //GENERO UNA LISTA OBSERVABLE TIPEADA CON "DIVISA"
        ObservableList<Divisa> data = FXCollections.observableArrayList(tbldivisaadapter.Select());

        //AGREGO LA COLUMNA QUE NECESITO A LA TABLA
        tvDivisas.getColumns().addAll(colNombre);
        tvDivisas.getColumns().addAll(colValor);

        //AGREGO LOS ITEMS DE LA LISTA OBSERVABLE
        tvDivisas.setItems(data);

    }

    private void reinicializarCampos() {

        //Recargar la información
        cargarTablaDivisas();
        tabDetalle.setDisable(true);
        tabLista.setDisable(false);
        tpdivisas.select(tabLista);

    }

}
