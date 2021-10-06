package junit.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import junit.java.Ingrediente;
import junit.java.ItemReceta;
import junit.java.Receta;

public class RecetaTest {
	
	@Test
	public void testCantIngredientes() {
		System.out.println("testCantIngredientes");
		
		Ingrediente huevo = new Ingrediente("Huevo", "unidades", 20, 240);
		Ingrediente papa = new Ingrediente("Papa", "gramos", 20000, 180);
		Ingrediente sal = new Ingrediente("Sal", "gramos", 1000, 90);
		Ingrediente carnePicada = new Ingrediente("Carne picada", "gramos", 10000, 600);
		Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100, 500);
		
		ItemReceta ir1= new ItemReceta(huevo, 1);
		ItemReceta ir2 = new ItemReceta(carnePicada, 100);
		ItemReceta ir3 =new ItemReceta(sal, 20);
		ItemReceta ir4 = new ItemReceta(huevo, 4);
		ItemReceta ir5 = new ItemReceta(papa, 3);
		ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);
		
		Receta tortilla = new Receta("Tortilla", 15, 360);
		tortilla.addIngrediente(ir4);
		tortilla.addIngrediente(ir5);
		
		Receta hamburguesa = new Receta("hamburguesa grande", 5, 480);
		hamburguesa.addIngrediente(ir2);
		hamburguesa.addIngrediente(ir1);
		hamburguesa.addIngrediente(ir3);
		hamburguesa.addIngrediente(ir6);
		
		Receta papasFritas = new Receta("papas fritas", 7, 350);	
		papasFritas.addIngrediente(ir5);
		papasFritas.addIngrediente(ir3);
		
		assertTrue(tortilla.getIngredientes().size() > 0);
		assertTrue(hamburguesa.getIngredientes().size() > 0);
		assertTrue(papasFritas.getIngredientes().size() > 0);
	}

}
