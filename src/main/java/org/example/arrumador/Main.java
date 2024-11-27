package org.example.arrumador;

import Dao.*;
import Model.City;
import Utils.Ordenacoes;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DAO_Ordenar daoOrdenacao = new DAO_Ordenar();
        DAO_Deletar daoDeletar = new DAO_Deletar();
        DAO_Adicionar daoAdicionar = new DAO_Adicionar();
        DAO_Ler daoLer = new DAO_Ler();
        DAO_Editar daoEditar = new DAO_Editar();

        try {
            //City cidade = daoLer.lerPorId(5200050);
            //System.out.println(cidade.toString());
            //boolean isDeleted = daoDeletar.deletarId(5222302);
            //System.out.println(isDeleted);
            //daoDeletar.deletarId(1);
            List<City> cidades = daoLer.TodasCidades();
            City teste = cidades.get(0);
            teste.setId("1");
            System.out.println("ID da cidade alterada: " + teste.getId());

            teste.setMunicipio("STESTES");

            boolean isEdited = daoEditar.editarCidade(teste);


            System.out.println(isEdited);
            //City testeVolta = daoLer.lerPorId(1);
            //System.out.println(testeVolta.toString());

            //daoOrdenacao.QueryId();
            /*
            for(int i =0; i < cidades.size();i++){
                System.out.println(cidades.get(i).toString());
            }

             */
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}