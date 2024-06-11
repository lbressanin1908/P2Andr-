/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.venda.model.util;

import java.lang.reflect.Field;
import java.util.Set;
import org.reflections.ReflectionUtils;

/**
 *
 * @author Luan Bressanin
 */
public class SQLFormatoInserir<T> implements SQLFormato{

    private Class<T> t;

    public SQLFormatoInserir(Class<T> t) {
        this.t = t;
    }
    
   @Override
   public String formato(){
       
       Set<Field> campos = ReflectionUtils.getFields(this.t, e -> true);
       StringBuilder atributos = new StringBuilder();
       StringBuilder pontos = new StringBuilder();
       
       try {
           for(Field campo : campos){
            atributos.append(campo.getName()).append(",");
            pontos.append("?,");
            }
           String atributo = removerUltimoCaracter(atributos.toString());
           String ponto = removerUltimoCaracter(pontos.toString());
           String SQL = String.format("INSERT INTO %s (%s) VALUES(%s)", t.getSimpleName(),atributo,ponto);
           return SQL;
        }catch (Exception e) {
            throw new RuntimeException(e);
    
       }
       } 
   private String removerUltimoCaracter(String texto){
       if(!texto.isBlank()){
           return texto.substring(0,texto.length() -1);
       }
       throw new RuntimeException("Texto vazio ...");
   }
   }
   
