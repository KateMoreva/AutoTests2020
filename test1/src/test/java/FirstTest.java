import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class FirstTest {

    private static final List<String> inputs = new ArrayList<>();
    private static final String CHECK = "Volan";
    private static final int numberOfLines = 5;
    private static final int numberOfChecks = 5;
    private static final int stringLength = 5;
    private static final List<String> checkLinesSame = new ArrayList<>(numberOfLines);
    private static final List<String> checkLinesDifferent = new ArrayList<>(numberOfLines);

    @BeforeAll
    public static void read() {
        filCheckLinesSame();
        filCheckLinesDifferent();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numberOfLines; i++) {
            inputs.add(input.next());
        }
    }

    @DisplayName("Test to check whether line 'Volan' is in the lines")
    @Test
    public void checkHasLine() {
        assumeTrue(inputs.size() == 5);
        assertTrue(inputs.contains(CHECK));
    }

    @DisplayName("Test to check the length of the first line")
    @Test
    public void checkFirstLineLength() {
        assumeFalse(inputs.get(1) == null);
        assertEquals(inputs.get(1).length(), stringLength);
    }

    @Disabled
    @DisplayName("Lines match test")
    @Test
    public void linesMath() {
        assumingThat(inputs.size() == 5, (Executable) () -> assertAll("inputs",
                () -> assertLinesMatch(inputs, checkLinesSame),
                () -> assertNotSame(inputs, checkLinesDifferent)
        ));
    }

    @Disabled
    @DisplayName("Random string containing check")
    @RepeatedTest(numberOfChecks)
    public void repeated() {
        int leftLimit = 48;
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(generatedString));
        assertTrue(inputs.contains(generatedString));
    }

    @AfterAll
    public static void clearInputs() {
        inputs.clear();
    }

    private static void filCheckLinesSame() {
        checkLinesSame.add("a");
        checkLinesSame.add("b");
        checkLinesSame.add("c");
        checkLinesSame.add("d");
        checkLinesSame.add("e");
    }

    private static void filCheckLinesDifferent() {
        checkLinesDifferent.add("k");
        checkLinesDifferent.add("l");
        checkLinesDifferent.add("m");
        checkLinesDifferent.add("n");
        checkLinesDifferent.add("o");
    }

}
