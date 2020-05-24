package uvsq.pglp_5_2;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Personnels person1 = new Personnels
        		.Builder("ismail", "ben", LocalDateTime.now())
        		.add_tel(3)
        		.function("directeur")
        		.build();
    	
    	CompositePersonnels g1 = new CompositePersonnels(1);
        g1.add(person1);
    	
    	DAO<Personnels> personneDAO = DAOFactory.getPersonneDAO();
    	
    	personneDAO.create(person1);

    	personneDAO.read("ismail").print();;
    }
}
