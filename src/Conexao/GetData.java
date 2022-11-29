package Conexao;

import java.util.ArrayList;
import DAO.Dados.AreaDados;
import DAO.Dados.UserDados;

public class GetData {
    protected static ArrayList<AreaDados> areas = new ArrayList<>();
    protected static ArrayList<UserDados> users = new ArrayList<>();
    
    public void setAreas(ArrayList<AreaDados> areas){
        GetData.areas = areas;
    }

    public void setUsers(ArrayList<UserDados> users){
        GetData.users = users;
    }

    public static ArrayList<AreaDados> getAreas() {
        return areas;
    }

    public static ArrayList<UserDados> getUsers(){
        return users;
    }
}
