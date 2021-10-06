package junit.java;
import java.util.Date;

public class Usuario {
	static int nextID;
	int id;
	String nombreYApellido;
	int tipoUsuario;
	float saldoCuenta;
	Date ultimaRecarga;
	String email;
	public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.tipoUsuario = tipoUsuario;
		this.saldoCuenta = saldoCuenta;
		this.email=email;
	}
	
	public void cargarCredito(float cuanto) {
		saldoCuenta+=cuanto;
		
	}
	
	public float descontarSaldo(float cuanto) throws SinSaldoException {
		if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
		else
			saldoCuenta-= cuanto;
		return saldoCuenta;
	}
	
	public float getSaldo() {
		return saldoCuenta;
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
