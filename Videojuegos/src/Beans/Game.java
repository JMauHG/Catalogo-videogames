/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Proyectos
 */
public class Game {

    private final StringProperty nombre;
    private DoubleProperty valor;
    private IntegerProperty id;
    private final StringProperty descripcion;
    private final StringProperty consola;
    private final StringProperty genero;

    //Constructor con propiedades
    public Game(String nombre, double valor, String descripcion, String consola, String genero, int id) {
        this.nombre = new SimpleStringProperty(nombre);
        this.valor = new SimpleDoubleProperty(valor);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.consola = new SimpleStringProperty(consola);
        this.genero = new SimpleStringProperty(genero);
        this.id = new SimpleIntegerProperty(id);
    }

    public Game(String nombre, double valor, String descripcion, String consola, String genero) {
        this.nombre = new SimpleStringProperty(nombre);
        this.valor = new SimpleDoubleProperty(valor);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.consola = new SimpleStringProperty(consola);
        this.genero = new SimpleStringProperty(genero);
    }

    public void setNombre(String Nombre) {
        this.nombre.set(Nombre);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public double getValor() {
        return valor.get();
    }

    public void setValor(double Valor) {
        this.valor.set(Valor);
    }

    public DoubleProperty valorProperty() {
        return valor;
    }

    public int getID() {
        return id.get();
    }

    public void setID(int ID) {
        this.id.set(ID);
    }

    public IntegerProperty IDProperty() {
        return id;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion.set(Descripcion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setConsola(String Consola) {
        this.consola.set(Consola);
    }

    public String getConsola() {
        return consola.get();
    }

    public StringProperty consolaProperty() {
        return consola;
    }

    public void setGenero(String Genero) {
        this.genero.set(Genero);
    }

    public String getGenero() {
        return genero.get();
    }

    public StringProperty generoProperty() {
        return genero;
    }

}
