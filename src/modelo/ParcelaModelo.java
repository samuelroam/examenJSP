package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ParcelaModelo extends Conector {
	
	public ArrayList<Parcela> selectAll() {

		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from parcelas");
			while (rs.next()) {
				Parcela parcela = new Parcela();
				parcela.setId(rs.getInt("id"));
				parcela.setNumero(rs.getString("numero"));
				parcela.setM_cuadrados(rs.getInt("m_cuadrados"));
				parcela.setPrecio_dia(rs.getDouble("precio_dia"));

				parcelas.add(parcela);
			}
			return parcelas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return parcelas;
	}

}