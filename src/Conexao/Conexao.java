package Conexao;

import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.UserDados;
import DAO.Dados.AreaDados;
import DAO.Dados.EntrevistadorDados;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/entervista", user = "root", password = "pedro"; 
    private Connection con = null;
    private AreaCon areaCon;
    private UsuarioCon userCon;
    private EntrevistadorCon entreCon;
    private boolean isPossible;

    //conexao para as areas
    public Conexao(String cmd, int p, String nome, Integer id) throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            areaCon = new AreaCon(cmd, con, nome, p, id);
            con.close();
        }catch (Exception e){
            System.out.println("Não foi possível completar a conexão: erro de conexão para área");
        }
    }

    //conexao para os usuários
    public Conexao(String cmd, int p, String nome, String senha, Integer idEnt, String email, Integer id) throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            userCon = new UsuarioCon(cmd, con, nome, senha, idEnt, email, p, id);
            con.close();
        }catch (Exception e){
            System.out.println("Não foi possível completar a conexão pra usuário: "+e.getMessage());
        }
    }

    public Conexao(String cmd, int p, String nome, String cpf, String rg, String dataNasc, String matricula, Integer id) throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            entreCon = new EntrevistadorCon(cmd, con, nome, cpf, rg, dataNasc, matricula, p, id);
            con.close();
        }catch (Exception e){
            System.out.println("Não foi possível completar a conexão pra usuário: "+e.getMessage());
        }
    }

    public ArrayList<AreaDados> getAreas(){
        return areaCon.getAllAreas();
    }

    public ArrayList<UserDados> getUsuarios(){
        return userCon.getUsuarios();
    }

    public ArrayList<EntrevistadorDados> getEntrevistadores(){
        return entreCon.getAllEntrevistadores();
    }

    public boolean isPossible(){
        return isPossible;
    }
    
}

    