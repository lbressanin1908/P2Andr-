/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.entidade;

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
@Data
@Builder
public class Estoque {
    private Long id;
    private Long produtoId;
    private Integer quantidade;
    private Boolean estado;
    private Long usuarioId;
    private LocalDateTime dataCriacao;
}
