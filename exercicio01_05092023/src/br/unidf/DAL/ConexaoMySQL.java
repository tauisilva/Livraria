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
 * @author carla
 */
public class ConexaoMySQL {

    public static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static String SQL;

    public static void abrirBD() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/livros_db";
        String user = "root";//Seu nome de usuário.
        String password = "hakka";  //Sua senha.
        con = DriverManager.getConnection(url, user, password);
    }

    public static void fecharBD() throws Exception {
        if (con != null) {
            con.close();
        }
    }
    

}
