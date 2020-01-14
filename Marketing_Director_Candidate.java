package evaluationCandidate;

import org.json.simple.JSONObject;

/**
 * Counts total points for the marketing department director candidate Using
 * final static integers counts the points for the evaluation system we use to
 * evaluate each candidate This class extends the Marketing_Employee_Candidate
 * class.
 *
 * @version 3.1 14 Jan 2020
 * @author Michalis Dontas and Miltiadis Tsichlis
 */
public class Marketing_Director_Candidate extends Marketing_Employee_Candidate {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_MARKETING = 10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_MARKETING = 15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD = 5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD = 10;
	private static final double STARTING_SALARY = 120000;

	private double[] master_in_marketing;
	private double[] master_in_other_field;
	private double[] phd_in_marketing;
	private double[] phd_in_other_field;
	private int total_points;

	/**
	 * Simple constructor
	 */
	public Marketing_Director_Candidate() {
		super();
	}

	/**
	 * Constructor with @param JSONObject candidate
	 */
	public Marketing_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_marketing = findDegreeAndField(candidate, "Master", "Marketing", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "Marketing", false);
		this.phd_in_marketing = findDegreeAndField(candidate, "PhD", "Marketing", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "Marketing", false);
		setTotal_points();
	}

	@Override
	public double getSTARTING_SALARY() {
		return STARTING_SALARY;
	}

	@Override
	public int getTotal_points() {
		return total_points;
	}

	private void setTotal_points() {
		this.total_points = total_points();
	}

	@Override
	protected int total_points() {
		int sum = super.getTotal_points();
		if (master_in_marketing != null) {
			for (double i : master_in_marketing) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_MARKETING;
			}
		}
		if (master_in_other_field != null) {
			for (double i : master_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
			}
		}
		if (phd_in_marketing != null) {
			for (double i : phd_in_marketing) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_MARKETING;
			}
		}
		if (phd_in_other_field != null) {
			for (double i : phd_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
			}
		}
		return sum;
	}

}