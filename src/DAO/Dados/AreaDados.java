package DAO.Dados;

public class AreaDados{
    private String nome;
    private int id;

    public AreaDados(int id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }
}
