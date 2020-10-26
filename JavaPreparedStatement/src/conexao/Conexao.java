/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anderson
 */
public class Conexao {
    
    private String servidor;
    private String porta;
    private String banco;
    private String login;
    private String senha;
    
    public Conexao(int status){
        if(status==1){//0-producao 1-desenvolvimento
            this.servidor = "127.0.0.1";
            this.porta = "3306";
            this.banco = "futebol";
            this.login = "galvaobueno";
            this.senha = "ronaldinho";
        }
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection estabelecerConexao() throws SQLException{
        String servidor = "jdbc:mysql://" + this.getServidor() + ":" +
                this.getPorta() + "/" + this.getBanco();
        return (Connection) DriverManager.getConnection(servidor, 
                this.getLogin(), this.getSenha());
    }
}