package OnCallSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeacherJUnitTest {

	@Test
	public void test() {
		String[] schedule = {"Math", "English", "Spare", "Lunch", "Calculus"};
		Teacher aTeacher = new Teacher("Doctor Mario", schedule, 3);
		assertEquals(3, aTeacher.getSpare());
	}

}
