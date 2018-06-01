package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ReservaModelo extends Conector {
	public ArrayList<Reserva> selectAll() {

		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas");
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				reserva.setNombre_usuario(rs.getString("nombre_usuario"));
				reserva.setApellido_usuario(rs.getString("apellido_usuario"));
				reserva.setDni_usuario(rs.getString("dni_usuario"));
				reserva.setNumero_usuarios(rs.getInt("numero_usuarios"));
				reserva.setInicio_reserva(rs.getDate("inicio_reserva"));
				reserva.setFin_reserva(rs.getDate("fin_reserva"));
				reserva.setFecha_reserva(rs.getDate("fecha_reserva"));
				reserva.setLuz(rs.getBoolean("luz"));

				reservas.add(reserva);
			}
			return reservas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public void guardarReserva(Reserva reserva) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("INSERT INTO reservas (nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva, fecha_reserva, luz) values(?,?,?,?,?,?,?,?)");
			pst.setString(1, reserva.getNombre_usuario());
			pst.setString(2, reserva.getApellido_usuario());
			pst.setString(3, reserva.getDni_usuario());
			pst.setInt(3, reserva.getNumero_usuarios());
			pst.setDate(3, (java.sql.Date) reserva.getInicio_reserva());
			pst.setDate(3, (java.sql.Date) reserva.getFin_reserva());
			pst.setDate(3, (java.sql.Date) reserva.getFecha_reserva());
			pst.setBoolean(3, reserva.getLuz());


			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
