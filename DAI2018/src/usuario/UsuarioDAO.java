package usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	private Connection c = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String usr ="root";
	private String contra ="AAEJ990706HDGNNL04";
	private String sql = "";

	public boolean agregarUsuario(Usuario usuario) {
		
		boolean respuesta=false;
		
		try {
			Class.forName(driver);
			c= DriverManager.getConnection("jdbc:mysql://localhost/enfermeria", usr, contra);
			sql = "Insert into usuarios values(?,?,?,?,?,?,?,?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, usuario.getMatricula());
			pstm.setString(2, usuario.getNombre());
			pstm.setString(3, usuario.getDireccion());
			pstm.setString(4, usuario.getTelefono());
			pstm.setString(5, usuario.getTelefono_contacto());
			pstm.setBoolean(6, usuario.isSexo());
			pstm.setString(7, String.valueOf(usuario.getTipo_sangre()));
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


}
