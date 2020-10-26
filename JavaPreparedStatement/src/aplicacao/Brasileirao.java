/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import dao.TimeDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Time;

/**
 *
 * @author anderson
 */
public class Brasileirao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ArrayList brasileirao;
        Time time;
        TimeDAO campeonato2020 = new TimeDAO();
        System.out.println("Brasileirão 2020");
        System.out.println("Listar times pré-cadastrados");
        brasileirao = campeonato2020.listarTimes();
        System.out.println(brasileirao);
        
        System.out.println("Acrescentar América");
        campeonato2020.inserirTime(new Time("América", "Romário"));
        System.out.println("Listar times do brasileirão");
        brasileirao = campeonato2020.listarTimes();
        System.out.println(brasileirao);

        System.out.println("Acrescentar Internacional");
        System.out.println("Listar times do brasileirão");
        campeonato2020.inserirTime(new Time("Internacional", "Fernandão"));
        brasileirao = campeonato2020.listarTimes();
        System.out.println(brasileirao);

        System.out.println("Remover América");
        System.out.println("Listar times do brasileirão");
        campeonato2020.removerTime(new Time("América", ""));
        brasileirao = campeonato2020.listarTimes();
        System.out.println(brasileirao);
        
    }
    
}
