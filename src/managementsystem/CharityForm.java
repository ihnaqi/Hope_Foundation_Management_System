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
public class CharityForm extends DonationForm implements Serializable{
	private String cardNumber;
	private int cardCSV;
	private String amount;
	
	public CharityForm(String name, String gender, String phoneNbr, int age, String cardNr, int cSV, String amount){
		super(name, gender, phoneNbr, age);
		this.cardNumber=cardNr;
		this.cardCSV=cSV;
		this.amount=amount;
	}
	
}
