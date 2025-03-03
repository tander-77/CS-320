package contactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	@Test
	public void testContactCreation() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Elm St", contact.getAddress());
	}
	
	@Test
	public void testInvalidContact() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Elm St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Elm St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Elm St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
	}
}
