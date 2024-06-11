package com.gestao.venda.Controller;

import com.gestao.venda.model.servico.UsuarioServico;
import com.gestao.venda.view.componentes.Mensagem;
import com.gestao.venda.view.formulario.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class LoginControlador implements ActionListener {
    private Login login;
    private UsuarioServico usuarioServico; // Instância do serviço

    public LoginControlador(Login login) {
        this.login = login;
        this.usuarioServico = new UsuarioServico(); // Inicialização correta
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acao = e.getActionCommand().toLowerCase();
        switch (acao) {
            case "login" -> login();
        }
    }

    private void login() {
        try {
            validaCampo();

            String email = login.getCampoDeTextoEmail().getText();
            String senha = String.valueOf(login.getCampoDeSenha().getPassword());

            // Usar a instância correta do serviço
            String mensagem = usuarioServico.login(email, senha);

            if (mensagem.startsWith("Email e Senha")) {
                login.getMensagemUtil().mostraMensagem(Mensagem.TipoMensagem.SUCESSO, mensagem);
                login.getPainelCarregar().setVisible(true);

                new Thread(() -> {
                    limpaCampo();
                    SwingUtilities.invokeLater(() -> login.setVisible(false));
                }).start();
            } else {
                login.getMensagemUtil().mostraMensagem(Mensagem.TipoMensagem.ERRO, mensagem);
            }
        } catch (RuntimeException ex) {
            // Tratar exceções de validação, se necessário
        }
    }

    private void validaCampo() {
        String email = login.getCampoDeTextoEmail().getText();
        String senha = String.valueOf(login.getCampoDeSenha().getPassword());

        if (email.isBlank() || senha.isBlank()) {
            String mensagem = "Email e Senha são obrigatórios";
            login.getMensagemUtil().mostraMensagem(Mensagem.TipoMensagem.ERRO, mensagem);
            throw new RuntimeException(mensagem);
        }
    }

    private void limpaCampo() {
        login.getCampoDeTextoEmail().setText("");
        login.getCampoDeSenha().setText("");
    }
}
