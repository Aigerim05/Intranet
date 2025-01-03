package Users;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable{

	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;

	public Mark() {

	}

	public Mark(double firstAttestation, double secondAttestation, double finalExam) {

		this.firstAttestation = firstAttestation;
		this.secondAttestation = secondAttestation;
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

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public double getTotal() {
		return firstAttestation + secondAttestation + finalExam;
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
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
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
