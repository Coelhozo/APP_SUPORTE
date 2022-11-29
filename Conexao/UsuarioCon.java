package Conexao;

import java.sql.*;
import java.util.ArrayList;
import DAO.Dados.*;
public class UsuarioCon extends GetData{

    private String nome, email, senha, cmd;
    private Integer id, idEnt;
    private Connection con;
    private ArrayList<UserDados> users = new ArrayList<>();

    public UsuarioCon(String cmd, Connection con, String nome, String senha, Integer idEnt, String email, int p, Integer id){
        this.cmd = cmd;
        this.nome = nome;
        this.con = con;
        this.id = id;
        this.senha = senha;
        this.email = email;
        this.idEnt = idEnt;
        
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
            stmt.setString(2, senha);
            stmt.setString(3, email);
            stmt.setInt(4, idEnt);
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
                UserDados user = new UserDados(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getInt(5));
                users.add(user);
            }
            super.setUsers(users);

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
        String[] cols = {"nombreDeUsuario", "contrasena", "email", "idEntrevistador"};
        String[] values = {nome, senha, email, ""+idEnt};
        ArrayList<UserDados> usuarios = super.getUsers();
        UserDados dados = null;

        for(int c = 0; c < usuarios.size(); c++){
            if (usuarios.get(c).getID() == id){
                dados = usuarios.get(c);
            }
        }

        try{
            PreparedStatement stmt = con.prepareStatement(cmd);
            for (int c = 0; c < cols.length; c++){
                stmt.setString(1, cols[c]);
                if(values[c] != null){
                    if(c == 3){
                        stmt.setInt(2, Integer.parseInt(values[c]));
                    }else{
                        stmt.setString(2, values[c]);
                    }
                }else{
                    String col = null;

                    switch (c){
                        case 1:
                            col = dados.getNome();
                            break;
                        case 2:
                            col = dados.getSenha();
                            break;
                        case 3:
                            col = dados.getEmail();
                            break;
                        case 4:
                            col = dados.getIdEnt().toString();
                            break;
                    }

                    if(c == 3){
                        stmt.setInt(2, Integer.parseInt(col));
                    }else{
                        stmt.setString(2, col);
                    }   
                }
            }
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }   

    public ArrayList<UserDados> getUsuarios(){
        return super.getUsers();
    }
}
