package domain;

import javax.persistence.Entity;

@Entity
public class Bidaiaria extends User{
	public Bidaiaria(String email, String name) {
		super(email, name);
	}
	
	public Bidaiaria(String email, String name, String password) {
		super(email, name, password);
	}
}
