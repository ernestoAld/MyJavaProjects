package Java.Lists.ArrayLists;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {

        //Creacion de ArrayList
        ArrayList<String> listaColores = new ArrayList<>();

        //Creacion mediante la clase Arrays
        String [] nombres = {"Ernesto","Aldana","Llamas"};
        List<String> listaNombres = Arrays.asList(nombres);

        //añadir elementos individualmente
        listaColores.add("rojo".toLowerCase());
        listaColores.add("verde".toLowerCase());
        listaColores.add("Azul".toLowerCase());

        //Construir lista a partir de otra lista
        List<String> nuevosColores = new ArrayList<>(listaColores);

        //Adicion de elementos desde otra coleccion
        List<String> nombreHermana = Arrays.asList("Fernanda","Maria","Andrea","Beatriz");
        //listaNombres.addAll(nombreHermana);

        //Iterar ArrayList
        //listaNombres.forEach(System.out::println);

        //Creacion de un ListIterator
        System.out.println("Iterando de izquierda a derecha");
        ListIterator<String> iteradorColores = listaColores.listIterator();
        while(iteradorColores.hasNext()){
            System.out.println("Color "+iteradorColores.next());
        }

        System.out.println("Iterando de derecha a izquierda(Inverso)");
        while(iteradorColores.hasPrevious()){
            System.out.println("imprimiendo a la inversa: "+iteradorColores.previous());
        }

        //Borrado dinamico mientras iteramos
        System.out.println("Borrado de elementos dinamicos");
        while(iteradorColores.hasNext()){
            if(iteradorColores.next().equals("rojo")){
                iteradorColores.remove();
            }
        }

        while(iteradorColores.hasPrevious()){
            System.out.println("imprimiendo a la inversa: "+iteradorColores.previous());
        }

        for (ListIterator<String> listIterator = listaColores.listIterator(); listIterator.hasNext();){
            System.out.println("Imprimiendo con ciclo for: "+listIterator.next());
        }





    }



}

