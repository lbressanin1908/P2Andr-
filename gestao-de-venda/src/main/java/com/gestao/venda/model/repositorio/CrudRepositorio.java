
package com.gestao.venda.model.repositorio;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luan Bressanin
 */
public interface CrudRepositorio <T>{
    public boolean salvar(T t);
    public List<T> buscarTodos();
    public Optional<T>buscarPeloId(Long id);
    public boolean removerPeloId(Long id);
}
