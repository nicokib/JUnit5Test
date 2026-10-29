package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

    Person p;

    @BeforeEach
    public void setUp() {
        p = new Person(1, "Tony", "Stark", LocalDate.of(1984,1,15));
    }

    @Test
    @Order(2)
    public void person1ShouldBe42YearsOld() {
        System.out.println("person1ShouldBe42YearsOld");

        try{
            assertEquals(42, p.calculateAge());
            assertThat(p.calculateAge(), equalTo(42));
            //assertThat(p.calculateAge(), not(equalTo(42)));
        }
        catch(PersonShouldBeAdultException e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void toStringSentenceStartsWithPerson() {
        System.out.println("toStringSentenceStartsWithPerson");
        assertThat("Test that Sentence start with \"Person\"", p.toString().startsWith("Person"));
    }

    @Test
    @Order(3)
    public void testIfPersonIsAdult() {
        System.out.println("testIfPersonIsAdult");
        Person pYoung = new Person(1, "Johnny", "Doe", LocalDate.of(2010,11,18));
        assertThrows(PersonShouldBeAdultException.class, () -> {pYoung.calculateAge();});
    }
}
