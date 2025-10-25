package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID Already Exists");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID Does Not Exist");
		}
		contacts.remove(contactId);
	}
	
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact Id Does Not Exist");
		}
		if (firstName != null && !firstName.isEmpty()) {
			contact.setFirstName(firstName);
		}
		if (lastName != null && !lastName.isEmpty()) {
			contact.setLastName(lastName);
		}
		if (phone != null && !phone.isEmpty()) {
			contact.setPhone(phone);
		}
		if (address != null && !address.isEmpty()) {
			contact.setAddress(address);
		}
	}
	
	public Contact getContactById(String contactId) {
		return contacts.get(contactId);
	}
}
