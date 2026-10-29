package be.abis.exercise.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

public class Address {
	
	private String street;
	private String nr;
	private String zipCode;
	private String town;
	private String country;
	private String countryCode;
	
	public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
		this.street = street;
		this.nr = nr;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
		this.countryCode = countryCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isBelgianZipCodeNumeric() {
		if(getCountry().isEmpty() || getCountry().equalsIgnoreCase("Belgium"))
		{
			try {
				int zipCode = Integer.parseInt(getZipCode());
				return (zipCode >= 1000 && zipCode <= 9999);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		else return false;
	}


	public void write() throws IOException {
		Path path = Paths.get("Adrdresses.txt");
		try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
			writer.write(street); writer.write(";");
			writer.write(nr); writer.write(";");
			writer.write(zipCode); writer.write(";");
			writer.write(town);	writer.write(";");
			writer.write(country); writer.write(";");
			writer.write(countryCode);
			writer.newLine();
		}
		catch (IOException ex) {
			throw ex;
		}
	}

}
