/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luan Bressanin
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal preco;
    private long usuarioId;
    private long categoriaId;
    private LocalDateTime dataCriacao;
}
