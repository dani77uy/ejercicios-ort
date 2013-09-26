package examen0212.ej1.estructura;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class EstructuraDirectorioImpl implements IEstructuraDirectorio {

	private static final String DIR_BASE = "ejemplos/ej01";

	private Stack<LogFuncionImplementada> funcionesImplementadas = new Stack<LogFuncionImplementada>();

	public class LogFuncionImplementada {
		private int id;
		private String carpeta;
		private String subCarpetaOArchivo;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCarpeta() {
			return carpeta;
		}

		public void setCarpeta(String carpeta) {
			this.carpeta = carpeta;
		}

		public String getSubCarpetaOArchivo() {
			return subCarpetaOArchivo;
		}

		public void setSubCarpetaOArchivo(String subCarpetaOArchivo) {
			this.subCarpetaOArchivo = subCarpetaOArchivo;
		}

		public LogFuncionImplementada(int id, String carpeta, String subCarpetaOArchivo) {
			this.id = id;
			this.carpeta = carpeta;
			this.subCarpetaOArchivo = subCarpetaOArchivo;
		}

	}

	@Override
	public void crearEstructuraDirectorios() {
		File file = new File(DIR_BASE);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directorio creado!");
				funcionesImplementadas.push(new LogFuncionImplementada(1, "", ""));
			} else {
				System.out.println("Directorio no se puede crear!");
			}
		}
	}

	@Override
	public void nuevaCarpeta(String padre, String carpeta) {
		File file = new File(DIR_BASE + "/" + padre + "/" + carpeta);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directorio creado!");
				funcionesImplementadas.push(new LogFuncionImplementada(2, padre, carpeta));
			} else {
				System.out.println("Directorio no se puede crear!");
			}
		}
	}

	public Stack<LogFuncionImplementada> getFuncionesImplementadas() {
		return funcionesImplementadas;
	}

	@Override
	public void nuevoDocumento(String padre, String documento) {
		try {
			File file = new File(DIR_BASE + "/" + padre + "/" + documento);
			if (file.createNewFile()) {
				System.out.println("Archivo creado!");
				funcionesImplementadas.push(new LogFuncionImplementada(3, padre, documento));
			} else {
				System.out.println("El archivo ya existe.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LogFuncionImplementada deshacerAccion(){
		return this.funcionesImplementadas.pop();
	}

}
