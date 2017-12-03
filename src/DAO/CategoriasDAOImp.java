package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categoria;
import models.Pregunta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manel
 */
public class CategoriasDAOImp implements CategoriasDAO {

    @Override
    public ArrayList<Categoria> cargarTodas() {
        Path path = Paths.get("preguntas");
        ArrayList<Path> arrayPaths = new ArrayList();
        ArrayList<Categoria> categorias = null;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            for (Path file : stream) {
                arrayPaths.add(file);

            }
            categorias = crearCategorias(arrayPaths);
        } catch (IOException ex) {
            Logger.getLogger(CategoriasDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }

    /**
     * coger el nombre del fichero y crear una categoria a partir de el
     */
    public ArrayList<Categoria> crearCategorias(ArrayList<Path> paths){

        ArrayList<Categoria> categorias = new ArrayList<>();
        int idCategoria = 0;
        for (Path file : paths) {
            BufferedReader br = null;
            try {

                br = Files.newBufferedReader(file);

                String linea;
                String[] aux;
                HashMap<Integer, Pregunta> preguntas = new HashMap<>();
                int counter = 0;
                
                while ((linea = br.readLine()) != null) {
                    //añadimos al array aux el valos de linea dividido por ";"
                    aux = linea.split(";");
                    //añadimos los datos que se encuentran el la posicion 1,2,3 del array aux en respostes
                    String[] respostes = {aux[1], aux[2], aux[3]};
                    //creamos una pregunta
                    Pregunta pregunta = new Pregunta(counter, aux[0], respostes, Integer.parseInt(aux[4]),Integer.parseInt(aux[5]));
                      
                    preguntas.put(counter, pregunta);
                    counter++;

                }

                String nombreFichero = file.getFileName().toString();
                String nombreCategoria = nombreFichero.substring(0, nombreFichero.lastIndexOf("."));

                Categoria categoriaNueva = new Categoria(idCategoria, nombreCategoria, preguntas);
                categorias.add(categoriaNueva);
                idCategoria++;

            } catch (IOException ex) {
                System.out.println("--------");
            } 
                
        }
        return categorias;

    }
}
