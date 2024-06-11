/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.repositorio.impl;

import com.gestao.venda.model.conexao.ConexaoMySQL;
import com.gestao.venda.model.entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Luan Bressanin
 */
public class UsuarioRepositorioImpl {

    public UsuarioRepositorioImpl() {
        super(Usuario.class);
    }
    
    public Optional<Object> buscarPeloEmail(String email){
        try {
            String SQL = "SELECT * FROM usuario WHERE email = ?";
            PreparedStatement ps = ConexaoMySQL.obterConexao().prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            
            if(resultSet.next()){
                return Optional.ofNullable(getT(resultSet));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }
    public static void main(String[] args) {
        Usuario usuario = usuario.builder();
                .nome("Andre legal")
                .email("AndreCool@email.com")
                .estado(true)
                .senha(new BCryptPasswordEncoder().encode("1234"))
                .perfil("PADRAO")
                .dataCriacao(LocalDateTime.now())        
                .build();
        
        UsuarioRepositorioImpl rep = new UsuarioRepositorioImpl();
        rep.salvar(Usuario);
    }
    
}
