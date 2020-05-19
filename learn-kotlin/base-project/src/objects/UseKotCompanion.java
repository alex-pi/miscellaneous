package objects;

public class UseKotCompanion {

    public static void main(String... args) {
        Student pipo = Student.Companion.createPostGrad("Pipo");

        System.out.println(pipo.getName());
    }
}
