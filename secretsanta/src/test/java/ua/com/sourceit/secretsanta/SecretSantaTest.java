package ua.com.sourceit.secretsanta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 2/4/14
 * Time: 7:30 PM
 */
@RunWith(Parameterized.class)
public class SecretSantaTest {
    private String input;
    private Class<? extends SecretSantaCommand> resultClass;
    private SecretSanta santa;

    public SecretSantaTest(String input, Class<? extends SecretSantaCommand> resultClass) {
        this.input = input;
        this.resultClass = resultClass;
    }

    @Before
    public void setUp() throws Exception {
        santa = new SecretSanta();
    }

    @Test
    public void testCreateCommand() throws Exception {
        SecretSantaCommand command = santa.createCommand(input);
        assertEquals(command.getClass(), resultClass);
//        assertTrue(command instanceof AddGroupCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCommand_fail() throws Exception {
        santa.createCommand("wronginput");
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"1", AddGroupCommand.class},
                {"2", AddUserCommand.class},
                {"0", ExitCommand.class}
        });
    }
}
