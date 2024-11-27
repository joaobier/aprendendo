package Dao;

import Model.City;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Editar implements DataAcessObject{

    public boolean editarCidade(City cidade) throws SQLException {

        Connection connection = conexao.conectar();

        Statement statement = connection.createStatement();

        String sql = "UPDATE cidade SET " +
                "cidade = '" + cidade.getMunicipio() + "', " +
                "microregiao = '" + cidade.getMicroregiao() + "', " +
                "estado = '" + cidade.getEstado() + "', " +
                "regiaogeografica = '" + cidade.getRegiaoGeografica() + "', " +
                "areakm = " + cidade.getArea() + ", " +
                "populacao = " + (int) cidade.getPopulacao() + ", " +
                "domicilios = " + cidade.getDomicilios() + ", " +
                "pib_total = " + cidade.getPibTotal() + ", " +
                "idh_geral = " + cidade.getIdh() + ", " +
                "renda_media = " + cidade.getRendaMedia() + ", " +
                "renda_nominal = " + cidade.getRendaNominal() + ", " +
                "pea_dia = " + cidade.getPea() + ", " +
                "idh_educacao = " + cidade.getIdhEducacao() + ", " +
                "idh_longevidade = " + cidade.getIdhLongevidade() + " " +
                "WHERE id = " + cidade.getId();

        int linhasAfetadas = statement.executeUpdate(sql);

        if(linhasAfetadas > 0){
            return true;
        }else return false;

    }

}
