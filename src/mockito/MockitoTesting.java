package mockito;

//import org.junit.Rule;
//import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MockitoTesting {

    public class educationServiceTest {

        @Rule
        public MockitoRule mockitoRule = MockitoJUnit.rule();

        @Mock
        private StudentDataObject studentDataObject;

        @Mock
        private InstructorDataObject instructorDataObject;

        @Mock
        private ClassDataObject classDataObject;

        @InjectMocks
        private ClientBusinessObjectImpl clientBusinessObjectImpl;

    }

    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJ1 = new Student("Joy", "Spanish");
        Student studentJ2 = new Student("Julia", "Algebra");
        Student studentJ3 = new Student("Joey", "Calculus");
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJ1, studentJ2));
    }


    @Test
    public void testMarkInactive() {

        // Given
        Class english = new Class("English", "Summer 2023");
        Class compSci = new Class("Computer Science", "Fall 2023");
        Class westCiv = new Class("Western Civ", "Spring 2023");
        List<Class> allClasses = Arrays.asList(english, compSci, westCiv);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(english);

        verify(classDataObject, Mockito.never()).markInactive(compSci);

        verify(classDataObject, Mockito.never()).markInactive(westCiv);

        verify(classDataObject, Mockito.times(1)).markInactive(english);

    }


    // First: Setup

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

// Next:

    @Test
    public void testMarkInactive_argumentCaptor() {
        // Given
        Class english = new Class("English", "Summer 2023");
        Class compSci = new Class("Computer Science", "Fall 2023");
        Class westCiv = new Class("Western Civ", "Spring 2023");
        List<Class> allClasses = Arrays.asList(english, compSci, westCiv);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(english, classArgumentCaptor.getValue());
    }
}
