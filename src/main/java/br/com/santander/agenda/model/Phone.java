package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;
	private String phoneCode;
	private String areaCode;
	private String number;
	@Enumerated(EnumType.STRING)
	private PhoneType type;

	public Phone(Contact contact, String phoneCode, String number,PhoneType type, String areaCode) {
		this.contact = contact;
		this.phoneCode = phoneCode;
		this.number = number;
		this.type = type;
		this.areaCode =areaCode;
	}

	public Integer getId() {
		return id;
	}

	public Contact getContact() {
		return contact;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getNumber() {
		return number;
	}
	
	public PhoneType getType() {
		return type;
	}

}
