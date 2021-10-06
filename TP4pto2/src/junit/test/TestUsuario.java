package junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import junit.java.Usuario;

public class TestUsuario {
	
	List<Usuario> testList = new ArrayList<Usuario>();
	
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeAll
	public void setUpBeforeClass() throws Exception {
		this.testList = new ArrayList<Usuario>();
	}
	
	/**
	 * Comprueba que no haya usuarios repetidos
	 */
	@Test
	public void testUsuariosRepetidos() {
		System.out.println("testUsuariosRepetidos");
		
		Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);
		testList.add(u4);
		
		for (int i = 0; i < testList.size()-1; i++) {
			String nombre = testList.get(i).getNombreYApellido();
			for (int j = i+1; j < testList.size(); j ++) {
				assertEquals(nombre, testList.get(j));
			}
		}
	}
	
	/**
	 * Comprueba que los mails contengan @
	 */
	@Test
	public void testMailsValidos() {
		System.out.println("testMailsValidos");
		
		Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);
		testList.add(u4);
		
		for (int i = 0; i < testList.size(); i++) {
			String mail = testList.get(i).getEmail();
			Assert.assertTrue(mail.contains("@"));
		}
	}
	
	@TestFactory
    Iterator<DynamicTest> dynamicTestMailsValidos() {
		System.out.println("dynamicTestMailsValidos");
		
		Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);
		testList.add(u4);
		
	    return Arrays.asList(DynamicTest.dynamicTest("El mail no contiene @", () -> {
        	Iterator<Usuario> i = testList.iterator();
        	while(i.hasNext()) 
    			assertTrue(i.next().getEmail().contains("@"));
        }
    	), DynamicTest.dynamicTest("Multiply Test", () -> assertEquals(4, Math.multiplyExact(2, 2))))
        .iterator();
    }
	
}
