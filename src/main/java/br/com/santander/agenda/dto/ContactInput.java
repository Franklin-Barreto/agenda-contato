package br.com.santander.agenda.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.santander.agenda.model.Address;
import br.com.santander.agenda.model.Contact;
import br.com.santander.agenda.model.Phone;

public class ContactInput {

	private String name;
	private String surname;
	private LocalDate birthday;
	private List<AddressInputDto> address;
	private List<PhoneInputDto> phones;

	public ContactInput(String name, String surname, LocalDate birthday, List<AddressInputDto> address,
			List<PhoneInputDto> phones) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.address = address;
		this.phones = phones;
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

	public List<AddressInputDto> getAddress() {
		return address;
	}

	public List<PhoneInputDto> getPhone() {
		return phones;
	}

	public Contact convert() {
		Contact contact = new Contact(name, surname, birthday);
		address.stream().forEach(a -> {
			Address address = a.convert(contact);
			contact.addAddress(address);
		});
		phones.stream().forEach(p -> {
			Phone phone = p.convert(contact);
			contact.addPhone(phone);
		});

		return contact;
	}
}
