/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luan Bressanin
 */
public class ConexaoMySQL {
    
    private static final String URL = "jdbc:mysql://localhost/gestaovenda?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String USER =  "root";
    private static final String PASSWORD = "password";
    private static Connection connection;

    private ConexaoMySQL() {
 
    }
    public static Connection obterConexao() throws SQLException{
            if (connection == null){
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        }
    public static void fecharConexao() throws SQLException{
            if (connection != null){
                connection.close();
            }
    }
    public static void main(String[] args) throws SQLException{
        System.out.println(obterConexao());
    }
}
