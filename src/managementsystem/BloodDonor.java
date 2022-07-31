/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;

import java.io.Serializable;

/**
 *
 * @author Hope
 */
public class BloodDonor extends DonationForm implements Serializable{
	private String bloodGroup, anydieaseRecord, hospital;

	public BloodDonor(String name, String gender, String anyDiseaseRecord, 
						 int age, String bloodGroup,String phoneNbr, String hospital) {
		super(name, gender, phoneNbr, age);
		this.bloodGroup = bloodGroup;
		this.anydieaseRecord=anyDiseaseRecord;
		this.hospital=hospital;
	}
	
	
}
