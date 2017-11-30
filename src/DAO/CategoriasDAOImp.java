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
         ArrayList<Categoria> categorias= null ;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            for (Path file : stream) {
                arrayPaths.add(file);
          
            }
            categorias= crearCategorias(arrayPaths);
        } catch (IOException ex) {
            Logger.getLogger(CategoriasDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }

    /**
     * coger el nombre del fichero y crear una categoria a partir de el
     */
    public ArrayList<Categoria> crearCategorias(ArrayList<Path> paths) {

        ArrayList<Categoria> categorias = new ArrayList<>();
        for (Path file : paths) {
            BufferedReader br = null;
            try {

                br = Files.newBufferedReader(file);

                String linea;
                String[] aux = null;
                HashMap<Integer, Pregunta> preguntas = new HashMap<>();
                int counter = 0;
                while ((linea = br.readLine()) != null) {
                    aux = linea.split(";");
                    String[] respostes = {aux[1], aux[2], aux[3]};
                    Pregunta pregunta = new Pregunta(counter, aux[0], respostes, Integer.parseInt(aux[4]));
                    counter++;
                    preguntas.put(counter, pregunta);

                }

                String nombreFichero = file.getFileName().toString();
                String nombreCategoria = nombreFichero.substring(0, nombreFichero.lastIndexOf("."));

                Categoria categoriaNueva = new Categoria(nombreCategoria, preguntas);
                categorias.add(categoriaNueva);

            } catch (IOException ex) {
                System.out.println("--------");
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        System.out.println("---------");
                    }

                }
            }
        }
        return categorias;

    }
}
