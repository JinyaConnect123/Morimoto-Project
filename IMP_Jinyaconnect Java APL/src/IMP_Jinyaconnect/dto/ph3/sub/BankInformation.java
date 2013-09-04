package IMP_Jinyaconnect.dto.ph3.sub;

public class BankInformation {
	private String bankName;
	private String bankAccountNumber;
	private String bankBranchName;
	private String bankAccountClassification;
	private String bankAccountName;
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tBankName = " + bankName);
		r.append(lv);
		r.append("\tBankAccountNumber = " + bankAccountNumber);
		r.append(lv);
		r.append("\tBankBranchName = " + bankBranchName);
		r.append(lv);
		r.append("\tBankAccountClassification = " + bankAccountClassification);
		r.append(lv);
		r.append("\tBankAccountName = " + bankAccountName);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getBankAccountClassification() {
		return bankAccountClassification;
	}

	public void setBankAccountClassification(String bankAccountClassification) {
		this.bankAccountClassification = bankAccountClassification;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
}
