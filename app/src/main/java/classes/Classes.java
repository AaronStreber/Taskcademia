package classes;

import java.util.ArrayList;

public class Classes {
    Profesor profesor;
    Credits credits;
    ArrayList<Assignments> assignments;

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public ArrayList<Assignments> getAssignments() {
        return assignments;
    }

    public void setAssignments(Assignments assignments) {
        this.assignments.add(assignments);

    }
}
