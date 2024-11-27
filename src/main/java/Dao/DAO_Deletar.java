package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Deletar implements DataAcessObject{

    public boolean deletarId(int id) throws SQLException{

        Connection connection = conexao.conectar();

        Statement statement = connection.createStatement();

        String sql ="DELETE FROM "+"cidade WHERE "+"cidade.id ="+id;

        int linhasAfetadas = statement.executeUpdate(sql);

        if(linhasAfetadas > 0){
            return true;
        }else return false;

    }

}
