package junit.test;

import org.junit.Test;

import junit.java.Cocina;
import junit.java.ItemPedido;
import junit.java.Mostrador;
import junit.java.Pedido;
import junit.java.Producto;
import junit.java.ProductoBasico;
import junit.java.ProductoElaborado;
import junit.java.SinSaldoException;
import junit.java.Usuario;

public class TestPedido {
	
	@Test
	public void TestReducirSaldo() {
		
		Usuario u1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		
		Producto p1 = new ProductoBasico("Lata Coca Cola", 10, 20);
		Producto p3 = new ProductoElaborado("Retorti", 120);
	
		Mostrador m1 = new Mostrador();
		m1.setNombreOperador("Jose");
		Mostrador m2 = new Mostrador();
		m2.setNombreOperador("Maria");
		
		Cocina c = new Cocina();
		c.start();
		
		Pedido p = new Pedido();
		p.setUsuario(u1);
		p.agregarItem(new ItemPedido(1, p1));
		p.agregarItem(new ItemPedido(1, p3));
		
		try {
			p.solicitarPedido();
			p.prepararPedido();
			p.terminarPedido();
			u1.descontarSaldo(p1.getPrecioUnitarioCompra());
			u1.descontarSaldo(p3.getPrecioUnitarioCompra());
			p.entregarPedido();

		} catch (SinSaldoException ex) {
			System.out.println("No posee saldo suficiente");
		}
		
		System.out.println("Saldo Usuario: "+u1.getSaldo());		
	}

}
