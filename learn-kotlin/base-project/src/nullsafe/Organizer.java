package nullsafe;

public class Organizer {

    boolean closeMeeting(Meeting m) {
        if (m.canClose) return m.close();

        return false;
    }

    public static void main(String... args) {
        Organizer org = new Organizer();
        org.closeMeeting(null);
    }
}

class Meeting {

    public boolean canClose;

    public boolean close() {
        return false;
    }
}
