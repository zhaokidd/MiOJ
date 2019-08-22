package java_think;

public class SubObject extends BaseObject{
    static {
        System.out.println("SubObject static code snippet");
    }

    private static int subIndex = 20;
    private static int subIndexStatic = -20;

    private Stuff stuff2 = new Stuff(subIndex);
    private static Stuff stuff2Static = new Stuff(subIndexStatic);

    private static int subValue = 2;

    public SubObject() {
        System.out.println("SubObject constructor");
    }
}
