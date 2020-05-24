package uvsq.pglp_5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PersonneDAO implements DAO<Personnels>{

	String filename = "Personnes.ser";
	private static String dbURL = "jdbc:derby:jdbcDB;";//create=true";
	public static Connection connect = null;

	
	public PersonneDAO(){
		
		System.out.println("-----------------");
		try {
			connect = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		try {
			connect.createStatement().executeUpdate("create table  "
					+ "personne( nom varchar(20), prenom varchar(20),fonction varchar(20))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}

	
	
	public Personnels create(Personnels obj) {

		try{
			PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(
				"INSERT INTO personne ( nom, prenom, fonction) VALUES (?, ?, ?)");
			prepare.setString(1, obj.nom);
			prepare.setString(2, obj.prenom);
			prepare.setString(3, obj.fonction);

			boolean i = prepare.execute();
						
			prepare.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return obj;
	}

	public Personnels read(String nom) {
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM personne where nom = '"+nom+"'");
			while (rs.next()) {
				
				return new Personnels
		        		.Builder(rs.getString("nom"), rs.getString("prenom"), LocalDateTime.now())
		        		.add_tel(3)
		        		.function(rs.getString("fonction"))
		        		.build();
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public Personnels update(Personnels obj) {
		return null;
	}

	public void delete(CompositePersonnels obj) {

		
	}



	public void delete(Personnels obj) {
		// TODO Auto-generated method stub
		
	}

}
