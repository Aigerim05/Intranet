package Users;

import java.util.*;

public class Mark {
  private double firstAttestation;
  private double secondAttestation;
  private double finalExam;

  public Mark(double firstAttestation, double secondAttestation, double finalExam) {
    this.firstAttestation = firstAttestation;
    this.secondAttestation = secondAttestation;
    this.finalExam = finalExam;
  }
  
  public Mark(double firstAttestation, double secondAttestation) {
    this.firstAttestation = firstAttestation;
    this.secondAttestation = secondAttestation;
    this.finalExam = 0;
  }

  public Mark(double firstAttestation) {
    this.firstAttestation = firstAttestation;
    this.secondAttestation = 0;
    this.finalExam = 0;
  }

  public Mark() {
    this.firstAttestation = 0;
    this.secondAttestation = 0;
    this.finalExam = 0;
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
    return "Mark{" +
            "firstAttestation=" + firstAttestation +
            ", secondAttestation=" + secondAttestation +
            ", finalExam=" + finalExam +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Mark mark = (Mark) o;

    if (Double.compare(mark.firstAttestation, firstAttestation) != 0) return false;
    if (Double.compare(mark.secondAttestation, secondAttestation) != 0) return false;
    return Double.compare(mark.finalExam, finalExam) == 0;
  }

  @Override
  public int hashCode(){
    return Objects.hash(firstAttestation + secondAttestation + finalExam);
  }
}
