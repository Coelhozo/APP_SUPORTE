package Conexao;

import java.util.ArrayList;
import DAO.Dados.AreaDados;
import DAO.Dados.UserDados;

public class GetData {
    protected ArrayList<AreaDados> areas = new ArrayList<>();
    protected ArrayList<UserDados> users = new ArrayList<>();
    
    public void setAreas(ArrayList<AreaDados> areas){
        this.areas = areas;
    }

    public void setUsers(ArrayList<UserDados> users){
        this.users = users;
    }

    public ArrayList<AreaDados> getAreas() {
        return areas;
    }

    public ArrayList<UserDados> getUsers(){
        return users;
    }
}
