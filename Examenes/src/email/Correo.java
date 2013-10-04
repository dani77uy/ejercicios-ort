package email;

import java.util.Date;

public class Correo implements Comparable<Correo> {

	private Date fecha;
	private String remitente;
	private String asunto;
	private String cuerpo;

	private Correo izquierda;
	private Correo derecha;

	public Correo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Correo izquierda) {
		this.izquierda = izquierda;
	}

	public Correo getDerecha() {
		return derecha;
	}

	public void setDerecha(Correo derecha) {
		this.derecha = derecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public Correo setFecha(Date fecha) {
		this.fecha = fecha;
		return this;
	}

	public String getRemitente() {
		return remitente;
	}

	public Correo setRemitente(String remitente) {
		this.remitente = remitente;
		return this;
	}

	public String getAsunto() {
		return asunto;
	}

	public Correo setAsunto(String asunto) {
		this.asunto = asunto;
		return this;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public Correo setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
		return this;
	}

	@Override
	public int compareTo(Correo c) {
		String remitente = c.getRemitente();
		Date fecha = c.getFecha();
		if (this.remitente.equalsIgnoreCase(remitente)) return this.fecha.compareTo(fecha);
		else return this.remitente.compareToIgnoreCase(remitente);
	}

	public Correo(Correo correo) {
		this.asunto = correo.asunto;
		this.fecha = correo.fecha;
		this.remitente = correo.remitente;
		this.cuerpo = correo.cuerpo;
	}

	public Correo() {
	}

	public Correo(Date fecha, String remitente, String asunto, String cuerpo) {
		this.fecha = fecha;
		this.remitente = remitente;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	public String toString() {
		return this.fecha.getDay() + this.fecha.getMonth() + this.fecha.getYear() + " - " + this.remitente;
	}

}
