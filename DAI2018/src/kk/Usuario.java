package kk;

import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class Usuario 
{
	private String matricula;
	private String nombre;
	private String direccion;
	private String telefono;
	private String telefono_contacto;
	private boolean sexo;
	private char tipo_sangre;
	private Image imagen;
	private File foto;
	
	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getTelefono_contacto() {
		return telefono_contacto;
	}



	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}



	public boolean isSexo() {
		return sexo;
	}



	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}



	public char getTipo_sangre() {
		return tipo_sangre;
	}



	public void setTipo_sangre(char tipo_sangre) {
		this.tipo_sangre = tipo_sangre;
	}



	public Image getImagen() {
		return imagen;
	}




	public File getFoto() {
		return foto;
	}



	public void setFoto(File foto) {
		
		
		try
		{
			this.foto = foto;
			Image imagen= ImageIO.read(this.foto);
			this.imagen=imagen;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}



	@Override
	public String toString() {
		return "Usuario [matricula=" + matricula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", telefono_contacto=" + telefono_contacto + ", sexo=" + sexo + ", tipo_sangre="
				+ tipo_sangre + "]";
	}



}
