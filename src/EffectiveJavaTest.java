import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EffectiveJavaTest {
    private static class AndroidThing {

    }

    private static final AndroidThing[] PRIVATE_VALUES = {new AndroidThing()};

/*    public static final List<AndroidThing> PUBLIC_VALUES =
            Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));*/

    public static final List<AndroidThing> PUBLIC_VALUES = Arrays.asList(PRIVATE_VALUES);

    public static void main(String[] args) {
        PUBLIC_VALUES.set(0, null);
    }
}
