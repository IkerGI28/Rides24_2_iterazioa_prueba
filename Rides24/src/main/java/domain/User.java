package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String email;
	private String name;
	private String pasahitza;
	private String mota;
	private int dirukopurua;
	
	public User() {
		this.email = "";
		this.name = "";
		this.pasahitza = "";
		this.mota = "";
		this.dirukopurua = 0;
	}
	
	public User(String email, String name) {
		this.email = email;
		this.name = name;
		this.pasahitza = "";
		this.mota = "";
		this.dirukopurua = 0;
	}
	
	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.pasahitza = password;
		this.mota = "";
		this.dirukopurua = 0;
	}
	
	public User(String email, String name, String pasahitza, String mota, int dirukopurua) {
		this.email = email;
		this.name = name;
		this.pasahitza = pasahitza;
		this.mota = mota;
		this.dirukopurua = dirukopurua;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getDirukopurua() {
		return dirukopurua;
	}

	public void setDirukopurua(int dirukopurua) {
		this.dirukopurua = dirukopurua;
	}	
	
	public String toString() {
		return email+";"+name+";"+pasahitza+";"+mota+";"+dirukopurua;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (!email.equals(other.email))
			return false;
		return true;
	}
}
