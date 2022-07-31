
package managementsystem;

import java.io.Serializable;

public class FindBloodDonor extends DonationForm implements Serializable{
	private String bloodGroup;
	
	public FindBloodDonor(String name, String gender, int age,
							String phoneNbr, String bloodGroup) {
		super(name, gender, phoneNbr, age);
		this.bloodGroup = bloodGroup;
	}
}
