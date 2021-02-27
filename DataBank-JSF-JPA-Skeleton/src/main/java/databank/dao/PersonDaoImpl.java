/*****************************************************************
 * File: PersonPojo.java Course materials (21W) CST8277
 *
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import databank.ejb.PersonService;
import databank.model.PersonPojo;

/**
 * Description: Implements the C-R-U-D API for the database
 * 
 * TODO 01 - some components are managed by CDI.<br>
 * TODO 02 - methods which perform DML need @Transactional annotation.<br>
 * TODO 03 - fix the syntax errors to correct methods. <br>
 * TODO 04 - refactor this class. move all the method bodies and EntityManager to a new service class which is a
 * singleton (ejb).<br>
 * TODO 05 - inject the service class using ejb.<br>
 * TODO 06 - call all the methods of service from each appropriate method here.
 */
@Named
@ApplicationScoped
public class PersonDaoImpl implements PersonDao, Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	@EJB
	protected PersonService PersonService;

	@Override
	public List<PersonPojo> readAllPeople() {
		// TODO Auto-generated method stub
		
		return PersonService.readAllPeople();
	}

	@Override
	public PersonPojo createPerson(PersonPojo person) {
		// TODO Auto-generated method stub
		return PersonService.createPerson(person);
	}

	@Override
	public PersonPojo readPersonById(int personId) {
		// TODO Auto-generated method stub
		return PersonService.readPersonById(personId);
	}

	@Override
	public PersonPojo updatePerson(PersonPojo person) {
		// TODO Auto-generated method stub
		return PersonService.updatePerson(person);
	}

	@Override
	public void deletePersonById(int personId) {
		// TODO Auto-generated method stub
		PersonService.deletePersonById(personId);
		
	}
	
	
	

	

}