/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.repositorio.impl;

import com.gestao.venda.model.entidade.Categoria;

/**
 *
 * @author Luan Bressanin
 */
public class CategoriaRepositorio extends CrudRepositorioImpl{

    public CategoriaRepositorio() {
        super(Categoria.class);
    }
    
    public static void main(String[] args) {
        Categoria categoria = Categoria.builder()
            .id(2L)
            .nome("Livro")
            .descricao("Conhecimento e poder")
            .build();
        CategoriaRepositorio repositorio = new CategoriaRepositorio();
        
        System.out.println("RESULTADO: " + repositorio.removerPeloId(4L));
    }
    
}
