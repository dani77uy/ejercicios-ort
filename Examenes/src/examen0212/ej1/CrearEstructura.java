package examen0212.ej1;

import java.util.Collections;
import java.util.List;

import examen0212.ej1.estructura.Estructura;
import examen0212.ej1.estructura.EstructuraDirectorioImpl;
import examen0212.ej1.estructura.IEstructuraDirectorio;

public class CrearEstructura {

	private IEstructuraDirectorio ed = new EstructuraDirectorioImpl();
	

	private class Carpeta implements Estructura<Carpeta,Archivo>{

		private boolean carpeta;
		private List<Archivo> archivos = Collections.emptyList();
		private List<Carpeta> subCarpetas = Collections.emptyList();
		private Carpeta padre;
		private String nombre;
		
		Carpeta(String nombre){
			this.nombre = nombre;
		}

		@Override
		public boolean isCarpeta() {
			return this.carpeta;
		}

		@Override
		public void setCarpeta() {
			this.carpeta = true;
		}

		@Override
		public void agregarSubCarpeta(Carpeta carpeta) {
			this.subCarpetas.add(carpeta);
		}

		@Override
		public void agregarArchivo(Archivo archivo) {
			this.archivos.add(archivo);

		}

		@Override
		public Carpeta getPadre() {
			return this.padre;
		}

		@Override
		public void setPadre(Carpeta padre) {
			this.padre = padre;
		}

		@Override
		public List<Archivo> getArchivos() {
			return this.archivos;
		}

		@Override
		public List<Carpeta> getSubCarpetas() {
			return this.subCarpetas;
		}

		@Override
		public String getNombre() {
			return this.nombre;
		}

		@Override
		public void setNombre(String nombre) {
			this.nombre = nombre;
			
		}

	}
	
	private class Archivo implements Estructura<Carpeta, Archivo>{

		@Override
		public boolean isCarpeta() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setCarpeta() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void agregarSubCarpeta(Carpeta carpeta) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void agregarArchivo(Archivo archivo) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Carpeta getPadre() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setPadre(Carpeta padre) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Archivo> getArchivos() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Carpeta> getSubCarpetas() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getNombre() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setNombre(String nombre) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
