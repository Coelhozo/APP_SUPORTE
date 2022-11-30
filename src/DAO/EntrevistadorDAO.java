package DAO;

import java.util.ArrayList;

import DAO.Dados.EntrevistadorDados;
import Conexao.Conexao;

public class EntrevistadorDAO {
    private Conexao con;

    public EntrevistadorDAO(String nome, int p, String cpf, String rg, String dataNasc, String matricula, Integer id) {
        
        try{
            if (id != null){
                con = new Conexao(criarComando(p, id), p, nome, cpf, rg, dataNasc, matricula, id);
            }else{
                con = new Conexao(criarComando(p), p, nome, cpf, rg, dataNasc, matricula, id);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String criarComando(int p) {
        String cmd = null;

        if (p == 1) {
            cmd = "insert into Entrevistador (Nome, CPF, RG, dataNascimento, matricula) values (?,?,?,?,?);";
        } else if(p == 2) {
            cmd = "select * from Entrevistador;";
        }

        return cmd;
    }

    public String criarComando(int p, Integer id) {
        String cmd = null;

        if (p == 3) {
            cmd = "delete from Entrevistador where idEntrevistador = ?";
        } else if(p == 4){
            cmd = "update Entrevistador set %s = ? where idEntrevistador = ?";
        }

        return cmd;
    }

    public ArrayList<EntrevistadorDados> getEntrevistadores(){
        return con.getEntrevistadores();
    }
}
