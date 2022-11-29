package DAO;

import java.util.ArrayList;

import DAO.Dados.UserDados;
import Conexao.Conexao;

public class UsuarioDAO {
    private Conexao con;

    private String nome = null, senha = null, email = null;
    private Integer idEnt = null, id = null;

    public UsuarioDAO(String nome, int p, Integer id, String senha, String email, Integer idEnt) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.idEnt = idEnt;
        System.out.println("email");
        try{
            if (id != null){
                con = new Conexao(criarComando(p, id), p, this.nome, this.senha, this.idEnt, this.email, id);
            }else{
                con = new Conexao(criarComando(p), p, this.nome, this.senha, this.idEnt, this.email, id);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    } 

    public String criarComando(int p) {
        String cmd = null;

        if (p == 1) {
            cmd = "insert into user (nombreDeUsuario, contrasena, email, idEntrevistador) values (?,?,?,?);";
        } else if(p == 2) {
            cmd = "select * from user;";
        }

        return cmd;
    }

    public String criarComando(int p, Integer id) {
        String cmd = null;

        if (p == 3) {
            cmd = "delete from user where idUser = ?";
        } else if(p == 4){
            cmd = "update user set %s = ? where idUser = ?";
        }

        return cmd;
    }

    public ArrayList<UserDados> getUsers(){
        return con.getUsuarios();
    }
}