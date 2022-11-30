package Conexao;
import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.*;

public class EntrevistadorCon extends GetData{
    private String nome, rg, cpf, cmd, dataNasc, matricula;
    private Integer id;
    private Connection con;
    private ArrayList<EntrevistadorDados> entrevistadores = new ArrayList<>();

    public EntrevistadorCon(String cmd, Connection con, String nome, String cpf, String rg, String dataNasc, String matricula, int p, Integer id){
        this.cmd = cmd;
        this.nome = nome;
        this.con = con;
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.matricula = matricula;
        
        switch (p) {
            case 1:
                inserir();
                break;
        
            case 2:
            
                selecionar();
                break;
            case 3:
                deletar();
                break;
            case 4:
                editar();
                break;
        }
    }

    public void inserir(){
        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, dataNasc);
            stmt.setString(5, matricula);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println("Impossivel inserir: "+e.getMessage());
        }
    }

    public void selecionar(){
        try {

            PreparedStatement stmt = con.prepareStatement(cmd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                EntrevistadorDados entre = new EntrevistadorDados(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6));
                entrevistadores.add(entre);
            }
            super.setEntrevistadores(entrevistadores);

        } catch (Exception e) {
            System.out.println("Impossível selecionar: "+e);
        }
    }

    
    public void deletar(){
        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println("Impossível deletar: "+e);
        }
    }
    
    public void editar(){
        String[] cols = {"Nome", "CPF", "RG", "Data Nascimento", "Matrícula"};
        String[] values = {nome, cpf, rg, dataNasc, matricula};

        try{
            PreparedStatement stmt = null;
            for (int c = 0; c < cols.length; c++){
                stmt = con.prepareStatement(String.format(cmd, cols[c]));
                if(values[c] != null){
                    stmt.setString(1, values[c]);
                }
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   

    public ArrayList<EntrevistadorDados> getAllEntrevistadores(){
        return super.getEntrevistadores();
    }
}
