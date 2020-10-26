/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Time;

/**
 *
 * @author anderson
 */
public class TimeDAO {
    private Connection banco;

    public TimeDAO() throws SQLException {
        this.banco = (new Conexao(1/*desenvolvimento*/)).estabelecerConexao();
    }
    
    public int inserirTime(Time time) throws SQLException{
        String SQL = "INSERT INTO time (`nome`, `atleta`) VALUES (?, ?)";
        
        //Preparar o comando SQL
        PreparedStatement prepararComando = banco.prepareStatement(SQL);
        
        prepararComando.setString(1, time.getNome());
        prepararComando.setString(2, time.getAtleta());
        
        //Executar o comando SQL
        int resultado = prepararComando.executeUpdate();
        
        //Retornar a quantidade de registros alterados no banco
        return resultado;
    }
    
    public int removerTime(Time time) throws SQLException{
        String SQL = "DELETE FROM time WHERE time.nome LIKE ?";
        
        //Preparar o Comando SQL
        PreparedStatement prepararComando = banco.prepareStatement(SQL);
        prepararComando.setString(1, "%"+time.getNome()+"%");
        
        //Executar o Comando SQL
        int resultado = prepararComando.executeUpdate();
        
        //Retornar a quantidade de registros alterados no banco
        return resultado;
    }
    
    public ArrayList listarTimes() throws SQLException{
        String SQL = "SELECT * FROM time";
        Time time;
        ArrayList brasileirao = new ArrayList();
        
        //Preparar Comando SQL
        PreparedStatement prepararComando = banco.prepareStatement(SQL);
        
        //Executar Comando SQL
        ResultSet conjuntoDados = prepararComando.executeQuery();
        
        //Tratar resultado do comando SQL
        while(conjuntoDados.next()){
            time = new Time(conjuntoDados.getInt("indice"),
                            conjuntoDados.getString("nome"),
                            conjuntoDados.getString("atleta"));
            brasileirao.add(time);
        }
        
        //Retornar lista de times
        return brasileirao;
    }
}
