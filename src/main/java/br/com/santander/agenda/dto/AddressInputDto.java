package br.com.santander.agenda.dto;

import br.com.santander.agenda.model.Address;
import br.com.santander.agenda.model.AddressType;
import br.com.santander.agenda.model.Contact;

public class AddressInputDto {

	private String street;
	private String city;
	private String postalCode;
	private String state;
	private String country;
	private AddressType type;

	public AddressInputDto(String street, String city, String postalCode, String state, String country,
			AddressType type) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.country = country;
		this.type = type;
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

	public AddressType getType() {
		return type;
	}

	public Address convert(Contact contact) {
		return new Address(street, city, postalCode, state, country, contact, type);
	}
}
