package DAO.Dados;

public class UserDados {
    private String nome, email, senha;
    private int id, idEnt;

    public UserDados(int id, String nome, String email, String senha, Integer idEnt){
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.idEnt = idEnt;
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }

    public Integer getIdEnt(){
        return idEnt;
    }

    public String getSenha(){
        return senha;
    }

    public String getEmail(){
        return email;
    }
}
