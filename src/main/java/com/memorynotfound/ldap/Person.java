package com.memorynotfound.ldap;

public class Person {

    private String uid;
    private String fullName;
    private String lastName;
    private String mail;
    private String password;
    

    public Person() {
    }

    public Person(String fullName, String lastName) {
        this.fullName = fullName;
        this.lastName = lastName;
    }

    public Person(String uid, String fullName, String lastName,String mail,String password) {
        this.uid = uid;
        this.fullName = fullName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Person [uid=" + uid + ", fullName=" + fullName + ", lastName=" + lastName + ", mail=" + mail
				+ ", password=" + password + "]";
	}
}