package java_think;

public class BaseObject {
    static {
        System.out.println("Base Object static code snippet");
    }
    private static int baseIndex = 10;
    private static int baseIndexStatic = -10;

    private Stuff stuffObject = new Stuff(baseIndex);
    private static Stuff stuffStaticObject = new Stuff(-10);


    private static String identifier = "base-object";

    public BaseObject() {
        System.out.println("BaseObject constructor");
    }

    public static void testPrint(){
        System.out.println(identifier);
    }

}
