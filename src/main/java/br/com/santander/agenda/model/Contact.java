package br.com.santander.agenda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String surname;
	private LocalDate birthday;
	@JsonManagedReference
	@OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	@JsonManagedReference
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();
	private String photoUrl;

	public Contact(String name, String surname, LocalDate birthday) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}
	
	protected Contact() {}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public List<Address> getAddresses() {
		return Collections.unmodifiableList(addresses);
	}

	public List<Phone> getPhones() {
		return Collections.unmodifiableList(phones);
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public void addPhone(Phone phone) {
		this.phones.add(phone);
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
