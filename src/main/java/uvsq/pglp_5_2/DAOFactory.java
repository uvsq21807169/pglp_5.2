package uvsq.pglp_5_2;

public class DAOFactory {

	public static DAO<CompositePersonnels> getPersonneDAO(){
		return new PersonneDAO();
	}

}
