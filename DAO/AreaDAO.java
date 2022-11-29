package DAO;

import java.util.ArrayList;

import DAO.Dados.AreaDados;
import Conexao.Conexao;

public class AreaDAO{
    private Conexao con;

    public AreaDAO(String nome, int p, Integer id) {
        
        try{
            if (id != null){
                con = new Conexao(criarComando(p, id), p, nome, id);
            }else{
                con = new Conexao(criarComando(p), p, nome, id);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    } 

    public String criarComando(int p) {
        String cmd = null;

        if (p == 1) {
            cmd = "insert into area (nome) values (?);";
        } else if(p == 2) {
            cmd = "select * from area;";
        }

        return cmd;
    }

    public String criarComando(int p, Integer id) {
        String cmd = null;

        if (p == 3) {
            cmd = "delete from area where idArea = ?";
        } else if(p == 4){
            cmd = "update area set nome = ? where idArea = ?";
        }

        return cmd;
    }

    public ArrayList<AreaDados> getAreas(){
        return con.getAreas();
    }
}
