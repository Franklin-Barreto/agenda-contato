package br.com.santander.agenda.dto;

import br.com.santander.agenda.model.Contact;
import br.com.santander.agenda.model.Phone;
import br.com.santander.agenda.model.PhoneType;

public class PhoneInputDto {
	private String phoneCode;
	private String areaCode;
	private String number;
	private PhoneType type;

	public PhoneInputDto(String phoneCode, String areaCode, String number, PhoneType type) {
		this.phoneCode = phoneCode;
		this.areaCode = areaCode;
		this.number = number;
		this.type = type;
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

	public Phone convert(Contact contact) {
		return new Phone(contact, phoneCode, number, type,areaCode);
	}

}
