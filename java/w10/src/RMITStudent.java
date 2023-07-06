import java.util.*;

public class RMITStudent {
    private String name;
    private HashMap<String, Integer> marks = new HashMap();

    public RMITStudent(String name) {
        this.name = name;
    }

    public void updateCourse(String code, int mark) {
        if (this.marks.size() > 3) {
            throw new CourseException("You can not assign more than 3 course!");
        } else if ((mark < 0) || (mark > 100)) {
            throw new MarkException("Invalid mark!");
        }

        try {
            int newMark = this.marks.get(code) + mark;
            if ((newMark < 0) || (newMark > 100)) {
                throw new MarkException("Invalid mark!");
            }

            this.marks.put(code, newMark);
        } catch (Exception e) {
            this.marks.put(code, mark);
        }
    }

    @Override
    public String toString() {
        return "RMITStudent{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
