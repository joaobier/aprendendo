package Dao;


import Model.City;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Adicionar implements DataAcessObject{


    public boolean adicionarCidade(City cidade) throws SQLException {

        Connection connection = conexao.conectar();

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO cidade (\n" +
                "    id, \n" +
                "    cidade, \n" +
                "    microregiao, \n" +
                "    estado, \n" +
                "    regiaogeografica, \n" +
                "    areakm, \n" +
                "    populacao, \n" +
                "    domicilios, \n" +
                "    pib_total, \n" +
                "    idh_geral, \n" +
                "    renda_media, \n" +
                "    renda_nominal, \n" +
                "    pea_dia, \n" +
                "    idh_educacao, \n" +
                "    idh_longevidade\n" +
                ") VALUES (" +
                cidade.getId() + ", " +
                "'" + cidade.getMunicipio() + "', " +
                "'" + cidade.getMicroregiao() + "', " +
                "'" + cidade.getEstado() + "', " +
                "'" + cidade.getRegiaoGeografica() + "', " +
                cidade.getArea() + ", " +
                (int) cidade.getPopulacao() + ", " +
                cidade.getDomicilios() + ", " +
                cidade.getPibTotal() + ", " +
                cidade.getIdh() + ", " +
                cidade.getRendaMedia() + ", " +
                cidade.getRendaNominal() + ", " +
                cidade.getPea() + ", " +
                cidade.getIdhEducacao() + ", " +
                cidade.getIdhLongevidade() +
                ")";

        int linhasAfetadas = statement.executeUpdate(sql);

        if(linhasAfetadas > 0){
            return true;
        }else return false;

    }

}
