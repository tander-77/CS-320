package contactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
		service.addContact(contact);
		assertEquals(contact, service.getContactById("12345"));
	}
	
	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
		service.addContact(contact);
		service.deleteContact("12345");
		assertNull(service.getContactById("12345"));
	}
	
	@Test
	public void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
		service.addContact(contact);
		service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Oak St");
		assertEquals("Jane", service.getContactById("12345").getFirstName());
		assertEquals("Smith", service.getContactById("12345").getLastName());
		assertEquals("0987654321", service.getContactById("12345").getPhone());
		assertEquals("456 Oak St", service.getContactById("12345").getAddress());
	}
}
