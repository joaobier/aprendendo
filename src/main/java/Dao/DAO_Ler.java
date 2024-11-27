package Dao;

import Model.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class DAO_Ler implements DataAcessObject{

    public City lerPorId(int idBuscar) throws SQLException {
        Connection connection = conexao.conectar();

        Statement statement = connection.createStatement();

        String sql ="SELECT * FROM cidade WHERE cidade.id="+idBuscar;

        ResultSet resultado = statement.executeQuery(sql);

        City city= null;

        while (resultado.next()){

            String id = ""+resultado.getInt(1);
            String cidade = resultado.getString(2);
            String microregiao = resultado.getString(3);
            String estado = resultado.getString(4);
            String regiaogeografica = resultado.getString(5);
            double areakm = resultado.getDouble(6);
            int populacao = resultado.getInt(7);
            double domicilios = resultado.getDouble(8);
            double pibTotal = resultado.getDouble(9);
            double idh_geral = resultado.getDouble(10);
            double renda_media = resultado.getDouble(11);
            double renda_nominal = resultado.getDouble(12);
            double pea_dia = resultado.getDouble(13);
            double idh_educacao = resultado.getDouble(14);
            double idh_longevidade = resultado.getDouble(15);

            city = new City(id,cidade,microregiao,estado,regiaogeografica,areakm,populacao,domicilios,pibTotal,idh_geral,renda_media,renda_nominal,pea_dia,idh_educacao,idh_longevidade);


        }

        return city;

    }

    public ArrayList<City> TodasCidades() throws SQLException {

        Connection connection = conexao.conectar();
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM cidade");

        ArrayList<City> cidades = new ArrayList<City>();

        //City[] cidades = new City[300];
        //int i = 0;
        while (resultado.next()){

            String id = ""+resultado.getInt(1);
            String cidade = resultado.getString(2);
            String microregiao = resultado.getString(3);
            String estado = resultado.getString(4);
            String regiaogeografica = resultado.getString(5);
            double areakm = resultado.getDouble(6);
            int populacao = resultado.getInt(7);
            double domicilios = resultado.getDouble(8);
            double pibTotal = resultado.getDouble(9);
            double idh_geral = resultado.getDouble(10);
            double renda_media = resultado.getDouble(11);
            double renda_nominal = resultado.getDouble(12);
            double pea_dia = resultado.getDouble(13);
            double idh_educacao = resultado.getDouble(14);
            double idh_longevidade = resultado.getDouble(15);

            City city = new City(id,cidade,microregiao,estado,regiaogeografica,areakm,populacao,domicilios,pibTotal,idh_geral,renda_media,renda_nominal,pea_dia,idh_educacao,idh_longevidade);

            cidades.add(city);
            //cidades[i] = city;
            //i++;

        }

        connection.close();

        resultado.close();
        statement.close();

        return cidades;
    }

}
