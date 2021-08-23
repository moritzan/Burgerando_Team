package Klassen;

public class Restaurant {
	private String Name = "";
	public KontaktInformationen kontaktinformationen;

	public Restaurant() {
		kontaktinformationen = new KontaktInformationen();
	}

	public Restaurant(String name, KontaktInformationen kontaktinformationen) {
		Name = name;
		this.kontaktinformationen = kontaktinformationen;
	}
	
	//equals override
	@Override
	public boolean equals(Object other) {
		//System.out.println("Override");
        if (this == other)
    	{
        	return true;
    	}
        
        if (other == null || getClass() != other.getClass())
    	{
    		//System.out.println("Klassen Fehler");
        	return false;
    	}
		//System.out.println("Klassen ok");

        Restaurant that = (Restaurant) other;

        //jetzt kommt der spaﬂ
		//System.out.println("that: " + that.getName());
		//System.out.println("this: " + this.getName());

        if (this.getName().equals(that.getName()))
        {
        	//System.out.println("Name ok");
            if (this.getKontaktinformationen().getEMail().equals(that.getKontaktinformationen().getEMail()))
            {
            	//System.out.println("EMAIL ok");
                if (this.getKontaktinformationen().getHausnummer().equals(that.getKontaktinformationen().getHausnummer()))
                {
                	//System.out.println("Hausnummer ok");

                    if (this.getKontaktinformationen().getNachname().equals(that.getKontaktinformationen().getNachname()))
                    {
                    	//System.out.println("Nachname ok");

                        if (this.getKontaktinformationen().getVorname().equals(that.getKontaktinformationen().getVorname()))
                        {
                        	//System.out.println("Vorname ok");

                            if (this.getKontaktinformationen().getPostleitzahl() == (that.getKontaktinformationen().getPostleitzahl()))
                            {
                            	//System.out.println("plz ok");

                                if (this.getKontaktinformationen().getStraﬂe().equals(that.getKontaktinformationen().getStraﬂe()))
                                {
                                	//System.out.println("Strasse ok");

                                    if (this.getKontaktinformationen().getTelefonnummer().equals(that.getKontaktinformationen().getTelefonnummer()))
                                    {
                                    	//System.out.println("Telefon ok");

                                    	//alles stimmt, return turue
                                    		return true;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }
        
        return false;
    }


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * @return the kontaktinformationen
	 */
	public KontaktInformationen getKontaktinformationen() {
		return kontaktinformationen;
	}

	/**
	 * @param kontaktinformationen the kontaktinformationen to set
	 */
	public void setKontaktinformationen(KontaktInformationen kontaktinformationen) {
		this.kontaktinformationen = kontaktinformationen;
	}
}
