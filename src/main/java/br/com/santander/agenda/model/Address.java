package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String street;
	private String city;
	private String postalCode;
	private String state;
	private String country;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;
	private AddressType type;

	public Address(String street, String city, String postalCode, String state, String country, Contact contact,
			AddressType type) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.country = country;
		this.contact = contact;
		this.type = type;
	}

	protected Address() {
	}

	public Integer getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Contact getContact() {
		return contact;
	}

	public AddressType getType() {
		return type;
	}

}
