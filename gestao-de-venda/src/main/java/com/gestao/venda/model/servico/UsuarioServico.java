package com.gestao.venda.model.servico;

import com.gestao.venda.model.entidade.Usuario;
import com.gestao.venda.model.repositorio.impl.UsuarioRepositorioImpl;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioServico {
    private UsuarioRepositorioImpl usuarioRepositorio;

    public UsuarioServico() {
        usuarioRepositorio = new new usuarioRepositorio;
    }

    public String login(String email, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.buscarPeloEmail(email);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            if (validaSenha(senha, usuario.getSenha())) {
                if (!usuario.getEstado()) {
                    return "Usuário bloqueado";
                } else {
                    return "Login bem-sucedido";
                }
            } else {
                return "Senha incorreta";
            }
        } else {
            return "Usuário não existe";
        }
    }

    public boolean validaSenha(String senhaInserida, String senhaUsuario) {
        return new BCryptPasswordEncoder().matches(senhaInserida, senhaUsuario);
    }
}