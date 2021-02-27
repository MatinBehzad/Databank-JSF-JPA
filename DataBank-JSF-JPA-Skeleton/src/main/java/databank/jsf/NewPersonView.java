/*****************************************************************
 * File: PersonPojo.java Course materials (21W) CST8277
 *
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.io.Serializable;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Version;

import databank.model.PersonPojo;

/**
 * This class represents the scope of adding a new person to the DB.
 * 
 * TODO 09 - This class is a managed been. Use the name "newPerson".<br>
 * TODO 10 - Unlike previous assignment where PersonPojo was view scoped, now this class is.<br>
 * TODO 11 - Add the missing variables and their getters and setters. Have in mind dates and version are internal
 * only.<br>
 * 
 */
@ViewScoped
@Named(value = "newPerson")
public class NewPersonView implements Serializable {
	/** explicit set serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String firstName;
	
	protected String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	
   
	

	@Inject
	@ManagedProperty( "#{personController}")
	protected PersonController personController;

	public NewPersonView() {
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName firstName to set
	 */
	public void setFirstName( String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		
		this.lastName=lastName;
	}

	
	public void setEmail( String email) {
		this.email = email;
	}
	
	public void setPhoneNumber( String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	


	public void addPerson() {
		if ( allNotNullOrEmpty( firstName, lastName , email, phoneNumber )) {
			PersonPojo theNewPerson = new PersonPojo();
			theNewPerson.setFirstName( getFirstName());
			theNewPerson.setLastName( getLastName());
			theNewPerson.setEmail(getEmail());
			theNewPerson.setPhoneNumber(getPhoneNumber());
			//TODO 12 - call other setters
			personController.addNewPerson( theNewPerson);
			//clean up
			personController.toggleAdding();
			setFirstName( null);
			setLastName( null);
			setEmail(null);
			setPhoneNumber(null);
			//TODO 13 - set everything to null
		}
	}

	static boolean allNotNullOrEmpty( final Object... values) {
		if ( values == null) {
			return false;
		}
		for ( final Object val : values) {
			if ( val == null) {
				return false;
			}
			if ( val instanceof String) {
				String str = (String) val;
				if ( str.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}