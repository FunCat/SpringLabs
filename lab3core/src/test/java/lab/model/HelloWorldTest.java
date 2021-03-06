package lab.model;

import static org.junit.Assert.* ;
import org.junit.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorldTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = HelloWorldTest.class.getClassLoader().getResource("application-context.xml").toString();

	private UsualPerson expectedPerson;

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
				new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("person", Person.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		return person;
	}
	
	@After
	public void tearDown() throws Exception{
		if (context != null)
			context.close();
	}
}
