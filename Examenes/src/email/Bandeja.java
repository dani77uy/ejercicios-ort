package email;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Bandeja {

	private Correo inicial;

	public void agregarCorreo(Correo correo) {
		this.inicial = agregarCorreo(this.inicial, correo);
	}

	private Correo agregarCorreo(Correo correo /* nodo */, Correo nuevo /* elemento */) {
		if (correo == null) return nuevo;
		else {
			int cmp = nuevo.compareTo(correo);
			if (cmp < 0) correo.setIzquierda(agregarCorreo(correo.getIzquierda(), nuevo));
			else if (cmp > 0) correo.setDerecha(agregarCorreo(correo.getDerecha(), nuevo));
			else correo = nuevo;
		}
		return correo;
	}

	public boolean consultarCorreo(String remitente) {
		return consultarCorreo(this.inicial, remitente);
	}

	private boolean consultarCorreo(Correo correo, String remitente) {
		if (correo != null) {
			if (correo.getRemitente().equalsIgnoreCase(remitente)) return true;
			else return consultarCorreo(correo.getIzquierda(), remitente)
					|| consultarCorreo(correo.getDerecha(), remitente);
		}
		return false;
	}

	public List<Correo> listarCorreosDeDia(Date dia) {
		List<Correo> list = new LinkedList<Correo>();
		return listarCorreo(this.inicial, dia, list);
	}

	private List<Correo> listarCorreo(Correo correo, Date dia, List<Correo> list) {
		if (correo == null) return list;
		if (correo.getFecha().equals(dia)) list.add(correo);
		listarCorreo(correo.getDerecha(), dia, list);
		listarCorreo(correo.getIzquierda(), dia, list);
		return list;
	}

	public boolean hayCorreo() {
		return this.inicial != null;
	}

	public String toString() {
		return preorden();
	}

	public String preorden() {
		return preorden(this.inicial, new StringBuffer());
	}

	private String preorden(Correo correo, StringBuffer sb) {
		if (correo == null) return sb.toString();
		sb.append(correo);
		preorden(correo.getIzquierda(), sb);
		preorden(correo.getDerecha(), sb);
		return sb.toString();
	}

	public int getCantidadFecha(Date fecha) {
		if (!hayCorreo()) return 0;
		return getCantidadFecha(this.inicial, fecha);
	}

	private int getCantidadFecha(Correo correo, Date fecha) {
		if (correo.getIzquierda() == null && correo.getDerecha() == null){ 
			if (correo.getFecha().equals(fecha)) {
				return 1;
			} else {
				return 0;
			}
		}
		int n = 0, m = 0;
		if (correo.getDerecha() != null) {
			if (correo.getDerecha().getFecha().equals(fecha)) n++;
			getCantidadFecha(correo.getDerecha(), fecha);
		}
		if (correo.getIzquierda() != null) {
			if (correo.getIzquierda().getFecha().equals(fecha)) m++;
			getCantidadFecha(correo.getIzquierda(), fecha);
		}
		return n + m;
	}

}