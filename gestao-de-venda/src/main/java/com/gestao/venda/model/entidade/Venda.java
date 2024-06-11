/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Luan Bressanin
 */
public class Venda {
    private Long id;
    private BigDecimal totalVenda;
    private BigDecimal desconto;
    private BigDecimal troco;
    private Long cienteId;
    private Long usuarioId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
}
