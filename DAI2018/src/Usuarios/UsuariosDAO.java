package Usuarios;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;

public class UsuariosDAO {
	private Connection c=null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String usr = "root";
	private String contra="AAEJ990706HDG1999";
	private String sql="";
	
public boolean agregarUsuario(Usuario usuario) {
	
	boolean respuesta=false;
	
	try {
		Class.forName(driver);
		c = DriverManager.getConnection("jdbc:mysql://localhost/enfermeria", usr, contra);
		sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?)";
		pstm = c.prepareStatement(sql);
		pstm.setString(1, usuario.getMatricula());
		pstm.setString(2, usuario.getNombre());
		pstm.setString(3, usuario.getDireccion());
		pstm.setString(4, usuario.getTelefono());;
		pstm.setString(5, usuario.getTelefono_contacto());
		pstm.setBoolean(6, usuario.isSexo());
		pstm.setString(7, ""+usuario.getTipo_sangre());
		FileInputStream streamEntrada = new FileInputStream(usuario.getFoto());
		pstm.setBinaryStream(8, streamEntrada);
		
		pstm.executeUpdate();
		pstm.close();
		streamEntrada.close();
		c.close();
		respuesta=true;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
}
public boolean modificarUsuario(Usuario usuario) {
	
	boolean respuesta=false;
	
	try {
		Class.forName(driver);
		c = DriverManager.getConnection("jdbc:mysql://localhost/enfermeria", usr, contra);
		sql = "UPDATE usuarios SET nombre=?, direccion=?, telefono=?,"
				+ "telefono_contacto=?, sexo=?, tipo_sangre=?, imagen=? WHERE matricula=?";
		pstm = c.prepareStatement(sql);
		
		pstm.setString(1, usuario.getNombre());
		pstm.setString(2, usuario.getDireccion());
		pstm.setString(3, usuario.getTelefono());;
		pstm.setString(4, usuario.getTelefono_contacto());
		pstm.setBoolean(5, usuario.isSexo());
		pstm.setString(6, ""+usuario.getTipo_sangre());
		FileInputStream streamEntrada = new FileInputStream(usuario.getFoto());
		pstm.setBinaryStream(7, streamEntrada);
		pstm.setString(8, usuario.getMatricula());
		
		pstm.executeUpdate();
		pstm.close();
		streamEntrada.close();
		c.close();
		respuesta=true;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
}

public ArrayList<Usuario> traerUsuarios() {
	ArrayList<Usuario> respuesta= new ArrayList<Usuario>();
	
	try {
		Class.forName(driver);
		c = DriverManager.getConnection("jdbc:mysql://localhost/enfermeria", usr, contra);
		sql = "SELECT * FROM usuarios";
		pstm = c.prepareStatement(sql);
		rs =pstm.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setMatricula(rs.getString("matricula"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setDireccion(rs.getString("direccion"));
			usuario.setTelefono(rs.getString("telefono"));
			usuario.setTelefono_contacto(rs.getString("telefono_contacto"));
			usuario.setSexo(rs.getBoolean("sexo"));
			usuario.setTipo_sangre((rs.getString("tipo_sangre").equals("a")) ? 'a' : 'b');
			InputStream in = rs.getBinaryStream("imagen");
			Image image;
			try {
				image = ImageIO.read(in);
				usuario.setImagen(image);
				try {
				    BufferedImage bi = toBufferedImage(image);
				    File outputfile = new File("saved.png");
				    ImageIO.write(bi, "png", outputfile);
				    usuario.setFoto(outputfile);
				} catch (IOException e) {
				    
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			respuesta.add(usuario);
		}	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return respuesta;
	
}
public Vector traerNombres() {
	Vector respuesta= new Vector();
	
	try {
		Class.forName(driver);
		c = DriverManager.getConnection("jdbc:mysql://localhost/enfermeria", usr, contra);
		sql = "SELECT nombre FROM usuarios";
		pstm = c.prepareStatement(sql);
		rs =pstm.executeQuery();
		
		while(rs.next()) {
			respuesta.add(rs.getString("nombre"));
		}	
		rs.close();
		pstm.close();
		c.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return respuesta;
	
}



public static BufferedImage toBufferedImage(Image img)
{
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
}
}