package com;

import java.time.LocalDate;

import com.model.Combinacion;
import com.model.Historial;

public class Principal {

	public static void main(String[] args) {
	    // Crear una combinación aleatoria
        Combinacion comb1 = new Combinacion();
        System.out.println("Combinación generada aleatoriamente:");
        System.out.println(comb1.toString());

        // Crear una combinación específica
        Combinacion comb2 = new Combinacion();
        System.out.println("Combinación generada aleatoriamente:");
        System.out.println(comb2.toString());

        // Comparar las combinaciones
        int aciertos = comb1.comprobarCombinacion(comb2);
        System.out.println("Aciertos entre ambas combinaciones: " + aciertos);
        
        Combinacion comb3 = new Combinacion(3, 7, 12, 28, 45, 4, 9);
        System.out.println("Combinación específica:");
        System.out.println(comb3.toString());
        
        Combinacion comb4 = new Combinacion(3, 7, 12, 28, 45, 4, 9);
        System.out.println("Combinación específica:");
        System.out.println(comb4.toString());
        
        int aciertos2 = comb3.comprobarCombinacion(comb4);
        System.out.println("Aciertos entre ambas combinaciones: " + aciertos2);
        
        
        
        Historial hist1 = new Historial();
        
        System.out.println(hist1.addSorteo(LocalDate.of(2007, 3, 2), comb4));
        System.out.println(hist1.addSorteo(LocalDate.of(2007, 3, 2), comb4));
        
        System.out.println(hist1.comprobarAciertos(LocalDate.of(2007, 3, 2), comb4));
	}

}
