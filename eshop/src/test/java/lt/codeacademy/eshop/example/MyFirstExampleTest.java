package lt.codeacademy.eshop.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Andrius Baltrunas
 */
//@ExtendWith(MockitoExtension.class)
public class MyFirstExampleTest {

    @Mock
    private DummyMockClass dummyMockClass;

    //  @InjectMocks
    private MyDummyClass dummyClass;

    //@BeforeEach jis kvieciama visada pries kiekviena testa
    //@BeforeAll bus iskvieciama visda pirma pries visus testus viena karta
    //@AfterEach kvieciama po kiekvieno testo
    //@AfterAll kvieciama tik karta po visu testu
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        dummyClass = new MyDummyClass(dummyMockClass);
    }

    @Test
    public void testSaveWhenThrowsException() {
        doThrow(RuntimeException.class).when(dummyMockClass).save();

        assertThrows(RuntimeException.class, () -> dummyClass.saveUser());
    }

    @Test
    public void testFindUserAgeByNameWhenUserNotExist() {
        when(dummyMockClass.getUserAge(eq("Andrius"))).thenReturn(0);

        int age = dummyClass.findUserAgeByName("Andrius");

        assertEquals(0, age, "Tokio userio nera");
        verify(dummyMockClass, times(1)).getUserAge(anyString());
    }

    @Test
    public void testSaveWhenUserSaved() {
        dummyClass.saveUser();
        verify(dummyMockClass, times(1)).save();
    }

    @Test
    public void testGetBooleanValueWhenReturnTrue() {
        assertTrue(dummyClass.getBooleanValue());
    }

    class MyDummyClass {
        private DummyMockClass dummyMockClass;

        public MyDummyClass(DummyMockClass dummyMockClass) {
            this.dummyMockClass = dummyMockClass;
        }

        public boolean getBooleanValue() {
            return true;
        }

        public void saveUser() {
            dummyMockClass.save();
        }

        public int findUserAgeByName(String name) {
            return dummyMockClass.getUserAge(name);
        }
    }

    class DummyMockClass {

        public void save() {
            //TODO
        }

        public int getUserAge(String name) {
            return 0;
        }
    }
}
