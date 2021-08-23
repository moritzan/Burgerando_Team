package Klassen;

public class KontaktInformationen {

	//vars
	private String Vorname = "";
	private String Nachname = "";
	private int Postleitzahl;
	private String Straﬂe = "";
	private String Hausnummer = "";
	private String Telefonnummer = "";
	private String EMail = "";
	
	//konstruktor
	//leer
	public KontaktInformationen() {}


	public KontaktInformationen(String telefonnummer, String eMail, String vorname, String nachname, int postleitzahl,
			String straﬂe, String hausnummer) {
		super();
		Telefonnummer = telefonnummer;
		EMail = eMail;
		Vorname = vorname;
		Nachname = nachname;
		Postleitzahl = postleitzahl;
		Straﬂe = straﬂe;
		Hausnummer = hausnummer;
	}


	/**
	 * @return the telefonnummer
	 */
	public String getTelefonnummer() {
		return Telefonnummer;
	}


	/**
	 * @param telefonnummer the telefonnummer to set
	 */
	public void setTelefonnummer(String telefonnummer) {
		Telefonnummer = telefonnummer;
	}


	/**
	 * @return the eMail
	 */
	public String getEMail() {
		return EMail;
	}


	/**
	 * @param eMail the eMail to set
	 */
	public void setEMail(String eMail) {
		EMail = eMail;
	}


	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return Vorname;
	}


	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		Vorname = vorname;
	}


	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return Nachname;
	}


	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		Nachname = nachname;
	}


	/**
	 * @return the postleitzahl
	 */
	public int getPostleitzahl() {
		return Postleitzahl;
	}


	/**
	 * @param postleitzahl the postleitzahl to set
	 */
	public void setPostleitzahl(int postleitzahl) {
		Postleitzahl = postleitzahl;
	}


	/**
	 * @return the straﬂe
	 */
	public String getStraﬂe() {
		return Straﬂe;
	}


	/**
	 * @param straﬂe the straﬂe to set
	 */
	public void setStraﬂe(String straﬂe) {
		Straﬂe = straﬂe;
	}


	/**
	 * @return the hausnummer
	 */
	public String getHausnummer() {
		return Hausnummer;
	}


	/**
	 * @param hausnummer the hausnummer to set
	 */
	public void setHausnummer(String hausnummer) {
		Hausnummer = hausnummer;
	};

}
