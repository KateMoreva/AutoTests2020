import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ImpostorTest {

    private static final List<Integer> list = new ArrayList<>();
    private static final Random random = new Random();
    private static int impostorCount;

    @BeforeAll
    public static void randomImpostor() {
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(2));
        }
        impostorCount = (int) list.stream().filter(elem -> elem.equals(1)).count();
    }

    @BeforeEach
    public void changeNumber() {
        list.remove(random.nextInt(list.size()));
        impostorCount = (int) list.stream().filter(elem -> elem.equals(1)).count();
    }

    @DisplayName("Repeated Impostor test")
    @RepeatedTest(10)
    public void checkImpostorNumber() {
        assertNotEquals(list.size() / 2, impostorCount);
    }

    @AfterAll
    public static void clearList() {
        list.clear();
    }
}
