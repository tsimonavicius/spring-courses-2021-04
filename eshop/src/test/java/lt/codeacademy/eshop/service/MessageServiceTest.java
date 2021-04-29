package lt.codeacademy.eshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrius Baltrunas
 */
class MessageServiceTest {
    private static final String MESSAGE_KEY = "dummy.message.key";
    private static final String MESSAGE_VALUE = "Labas Andriau";

    @Mock
    private MessageSource messageSource;

    private MessageService messageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        messageService = new MessageService(messageSource);
    }

    @Test
    public void testGetMessageWhenKeyIsNull() {

        doThrow(NoSuchMessageException.class).when(messageSource).getMessage(eq(null), any(), any(Locale.class));

        String message = messageService.getMessage(null);

        assertNotNull(message);
        assertEquals("", message);
    }

    @Test
    public void testGetMessageWhenKeyNotExist() {
        doThrow(NoSuchMessageException.class).when(messageSource).getMessage(eq(MESSAGE_KEY), any(), any(Locale.class));

        String message = messageService.getMessage(MESSAGE_KEY);

        assertEquals("", message);
    }

    @Test
    public void testGetMessageWhenKeyExist() {
        when(messageSource.getMessage(eq(MESSAGE_KEY), any(), any(Locale.class))).thenReturn(MESSAGE_VALUE);

        String message = messageService.getMessage(MESSAGE_KEY);

        assertEquals(MESSAGE_VALUE, message);
    }


}
