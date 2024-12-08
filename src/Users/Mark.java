package Users;

import java.util.*;

public class Mark {

    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark() {
        this.firstAttestation = 0;
        this.secondAttestation = 0;
        this.finalExam = 0;
    }

    public Mark(double firstAttestation) {
        this();
        this.firstAttestation = firstAttestation;
    }

    public Mark(double firstAttestation, double secondAttestation) {
        this(firstAttestation);
        this.secondAttestation = secondAttestation;
    }

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this(firstAttestation, secondAttestation);
        this.finalExam = finalExam;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getfinalExam() {
        return finalExam;
    }

    public void setfinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    @Override
    public String toString() {
        return "Mark{"
                + "firstAttestation=" + firstAttestation
                + ", secondAttestation=" + secondAttestation
                + ", finalExam=" + finalExam
                + '}';
    }

    @Override
    public boolean equals(Object o) {
      if(this == o) return true;
      if(o == null || getClass() != o.getClass()) return false;
      Mark mark = (Mark) o;
      return firstAttestation == mark.firstAttestation
              && secondAttestation == mark.secondAttestation
              && finalExam == mark.finalExam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstAttestation, secondAttestation, finalExam);
    }
}
