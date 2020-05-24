package uvsq.pglp_5_2;

public class DAOFactory {

	public static DAO<Personnels> getPersonneDAO(){
		return new PersonneDAO();
	}

}
