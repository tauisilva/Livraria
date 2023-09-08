/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unidf.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author carla braga && taui silva && joao victor
 */
public class ConexaoMySQL {

    public static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static String SQL;

    public static void abrirBD() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ "; // adicione seu banco ex: exercicio01_05092023
            String user = "";// Seu nome de usuário.
            String password = ""; // Sua senha.
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {

        }
    }

    public static void fecharBD() {
        try {

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }

}
