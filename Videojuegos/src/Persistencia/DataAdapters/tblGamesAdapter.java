/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.DataAdapters;

import Beans.Game;
import Persistencia.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Proyectos
 */
public class tblGamesAdapter {

    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.conectar();

    /**
     * Select general para el catálogo de divisas
     *
     * @return List tipo Game
     */
    public List<Game> Select(String Genero) {
        List<Game> lsGame = new ArrayList<Game>();

        try {
            PreparedStatement verificarStmt
                    = c.prepareStatement(" SELECT                  "
                            + "   ID                               "
                            + "   ,nombre                          "
                            + "   ,valor                           "
                            + "   ,descripcion                     "
                            + "   ,consola                         "
                            + "   ,genero                          "
                            + "   ,imgURL                          "
                            + " FROM VideoJuegos                   "
                            + " WHERE genero =                     "
                            + "'" + Genero + "'");

            ResultSet rs = verificarStmt.executeQuery();

            while (rs.next()) {
                Game game = new Game(rs.getString("nombre"), rs.getDouble("valor"), rs.getString("descripcion"), rs.getString("consola"), rs.getString("genero"), rs.getString("imgURL"), rs.getInt("ID"));
                lsGame.add(game);
            }

            return lsGame;

        } catch (SQLException e) {
            Logger.getLogger(tblGamesAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return null;
    }

    /**
     * Inserta un nuevo registro de divisa
     *
     * @param game
     */
    public void Insert(Game game) {
        try {

            PreparedStatement insert
                    = c.prepareStatement(" INSERT INTO VideoJuegos  "
                            + "   (nombre                           "
                            + "   ,valor                            "
                            + "   ,descripcion                      "
                            + "   ,consola                          "
                            + "   ,genero                          "
                            + "   ,imgURL)                          "
                            + "   VALUES (?, ?, ?, ?, ?, ?)");

            insert.setString(1, game.getNombre());
            insert.setDouble(2, game.getValor());
            insert.setString(3, game.getDescripcion());
            insert.setString(4, game.getConsola());
            insert.setString(5, game.getGenero());
            insert.setString(6, game.getImgURL());

            insert.execute();

        } catch (SQLException e) {
            Logger.getLogger(tblGamesAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }

    }

    /**
     * Actualiza un registro de divisa
     *
     * @param game
     */
    public void Update(Game game) {
        try {

            PreparedStatement update
                    = c.prepareStatement(" UPDATE VideoJuegos  "
                            + "   SET nombre = ?               "
                            + "   ,valor = ?                   "
                            + "   ,descripcion = ?             "
                            + "   ,consola = ?                 "
                            + "   ,genero = ?                  "
                            + "   ,imgURL = ?                  "
                            + "   WHERE ID = ?                 ");

            update.setString(1, game.getNombre());
            update.setDouble(2, game.getValor());
            update.setString(3, game.getDescripcion());
            update.setString(4, game.getConsola());
            update.setString(5, game.getGenero());
            update.setString(6, game.getImgURL());
            update.setInt(7, game.getID());

            update.execute();

        } catch (SQLException e) {
            Logger.getLogger(tblGamesAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
    }

    /**
     * Borra un registro de divisa
     *
     * @param game
     */
    public void Delete(Game game) {
        try {

            PreparedStatement update
                    = c.prepareStatement(" DELETE FROM VideoJuegos  "
                            + "   WHERE ID = ?                      ");

            update.setInt(1, game.getID());

            update.execute();

        } catch (SQLException e) {
            Logger.getLogger(tblGamesAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
    }

}
