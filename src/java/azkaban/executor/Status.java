package azkaban.executor;

public enum Status {
	READY(10), PREPARING(20), RUNNING(30), PAUSED(40), SUCCEEDED(50), KILLED(60), FAILED(70), FAILED_FINISHING(80), SKIPPED(90), DISABLED(100), QUEUED(110);
	
	private int numVal;

	Status(int numVal) {
		this.numVal = numVal;
	}

	public int getNumVal() {
		return numVal;
	}
	
	public static Status fromInteger(int x) {
		switch (x) {
		case 10:
			return READY;
		case 20:
			return PREPARING;
		case 30:
			return RUNNING;
		case 40:
			return PAUSED;
		case 50:
			return SUCCEEDED;
		case 60:
			return KILLED;
		case 70:
			return FAILED;
		case 80:
			return FAILED_FINISHING;
		case 90:
			return SKIPPED;
		case 100:
			return DISABLED;
		case 110:
			return QUEUED;
		default:
			return READY;
		}
	}
	
	public static boolean isStatusFinished(Status status) {
		switch (status) {
		case FAILED:
		case KILLED:
		case SUCCEEDED:
		case SKIPPED:
			return true;
		default:
			return false;
		}
	}
}