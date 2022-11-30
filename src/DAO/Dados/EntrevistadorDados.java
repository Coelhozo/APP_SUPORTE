package DAO.Dados;

public class EntrevistadorDados {
    private String nome, cpf, rg, dataNascimento, matricula;
    private int id;

    public EntrevistadorDados(int id, String nome, String cpf, String rg, String dataNascimento, String matricula){
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }

    public String getRG(){
        return rg;
    }

    public String getCPF(){
        return cpf;
    }

    public String getDataNasc(){
        return dataNascimento;
    }

    public String getMatricula(){
        return matricula;
    }
}
