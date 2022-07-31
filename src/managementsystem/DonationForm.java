/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;

/**
 *
 * @author Hope
 */
public abstract class DonationForm {
	private String name;
	private String gender;
	private String phoneNbr;
	private int age;

	public DonationForm(String name, String gender, String phoneNbr, int age) {
		this.name = name;
		this.gender = gender;
		this.phoneNbr = phoneNbr;
		this.age = age;
	}
	
	
	
}
