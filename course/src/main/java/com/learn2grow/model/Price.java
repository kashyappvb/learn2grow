package com.learn2grow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int priceId;
	private double basePrice;
	private String pricingStratergy;

	@Transient
	private double tax;
	
	@Transient
	private double conversionFee;
	
	
	@OneToOne(mappedBy="price")
	private Course course;
	
	public Price() {}
	
	public Price(double basePrice, double tax, String pricingStratergy) {
		super();
		this.basePrice = basePrice;
		this.tax = tax;
		this.pricingStratergy = pricingStratergy;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public String getPricingStratergy() {
		return pricingStratergy;
	}
	public void setPricingStratergy(String pricingStratergy) {
		this.pricingStratergy = pricingStratergy;
	}

	public double getConversionFee() {
		return conversionFee;
	}

	public void setConversionFee(double conversionFee) {
		this.conversionFee = conversionFee;
	}
}
