package Conexao;

import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.AreaDados;

public class AreaCon extends GetData{
    private String cmd, nome;
    private Connection con;
    private Integer id;
    private ArrayList<AreaDados> areas = new ArrayList<>();

    public AreaCon(String cmd, Connection con, String nome, int p, Integer id){

        this.cmd = cmd;
        this.nome = nome;
        this.con = con;
        this.id = id;
        
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
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println("Impossivel inserir: "+e);
        }
    }

    public void selecionar(){
        try {
            areas = new ArrayList<>();

            PreparedStatement stmt = con.prepareStatement(cmd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                AreaDados area = new AreaDados(rs.getInt(1), rs.getString(2));
                areas.add(area);
            }
            super.setAreas(areas);

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
        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }   

    public ArrayList<AreaDados> getAreas(){
        return super.getAreas();
    }
}
