package junit.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import junit.java.Producto;
import junit.java.ProductoBasico;
import junit.java.ProductoElaborado;

public class TestProducto {
	
	List<Producto> testList = new ArrayList<Producto>();
	
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeAll
	public void setUpBeforeClass() throws Exception {
		this.testList = new ArrayList<Producto>();
	}
	
	@Test
	public void VeintexCiertoGanacia() {
		Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
		Producto agua = new ProductoBasico("Agua", 10, 22);
		Producto p1 = new ProductoElaborado("Retorti", 120);
		Producto leche = new ProductoBasico("Leche", 10, 11);
		
		testList.add(gaseosaCola);
		testList.add(agua);
		testList.add(p1);
		testList.add(leche);
		
		// ESTE MÉTODO NO ME FUNCIONA Y NO ME DOY CUENTA DONDE ESTÁ FALLANDO.
		for (Producto p : testList) {
			assertTrue(p.getPrecioUnitarioVenta() >= (p.getPrecioUnitarioCompra() + (20/100)*p.getPrecioUnitarioCompra()));
		}
	}
	
	@TestFactory
    Iterator<DynamicTest> dynamicTestVeintexCiertoGanacia() {
		Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
		Producto agua = new ProductoBasico("Agua", 10, 22);
		Producto p1 = new ProductoElaborado("Retorti", 120);
		Producto leche = new ProductoBasico("Leche", 10, 11);
		
		testList.add(gaseosaCola);
		testList.add(agua);
		testList.add(p1);
		testList.add(leche);
		
	    return Arrays.asList(DynamicTest.dynamicTest("La ganancia no es más del 20%", () -> {
        	Iterator<Producto> i = testList.iterator();
        	while(i.hasNext()) 
    			assertTrue(i.next().getPrecioUnitarioVenta() >= (i.next().getPrecioUnitarioCompra() + (20/100)*i.next().getPrecioUnitarioCompra()));
        }
    	), DynamicTest.dynamicTest("Multiply Test", () -> assertEquals(4, Math.multiplyExact(2, 2))))
        .iterator();
    }

}
