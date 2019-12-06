import org.json.simple.JSONObject;

public class Accounting_Director_Candidate extends Accounting_Employee_Candidate {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_accounting;
	private double[] master_in_other_field;
	private double[] phd_in_accounting;
	private double[] phd_in_other_field;
	private int total_points;

	public Accounting_Director_Candidate() {
		super();
	}

	public Accounting_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_accounting = findDegreeAndField(candidate, "Master", "Accounting", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "Accounting", false);
		this.phd_in_accounting = findDegreeAndField(candidate, "PhD", "Accounting", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "Accounting", false);
		setTotal_points();
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
		for(double i : master_in_accounting) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_accounting) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}