import java.util.HashMap;
/**
 * Star Wars name generator
 * 
 * @author Danny 
 * @version 1.0
 */
public class NameGenerator
{
    /**
     * Ik heb ervoor gekozen om in plaats van fields, een HashMap te gebruiken.
     * Deze HashMap houd alle benodigde details vast van een persoon. De key en values zijn strings.
     */
    private HashMap<String, String> personDetails;
    
    /**
     * Bij het aanmaken van een object wordt er gevraagd om gegevens in te vullen. Vervolgens instantieren wij de HashMap
     * en voegen we alle details toe aan de HashMap collectie en geven wij deze waardes een key mee.
     * 
     * @param   firstName           De voornaam van de persoon
     * @param   lastName            De achternaam van de persoon
     * @param   mothersMaidenName   De voornaam van de persoon zijn moeder
     * @param   city                De woonplaats van de persoon
     */
    public NameGenerator(String firstName, String lastName, String mothersMaidenName, String city)
    {
        // Instantieer het object
        this.personDetails = new HashMap<String, String>();
        
        // Wijs alle waardes van de constructor parameter toe aan de gegeven keys
        this.personDetails.put("first name", firstName);
        this.personDetails.put("last name", lastName);
        this.personDetails.put("mothers maiden name", mothersMaidenName);
        this.personDetails.put("city", city);
    }
    
    /**
     * Genereer een starwars naam, concatenate deze string en print hem vervolgens uit op het scherm. 
     * (Bewust gekozen voor een void return type ipv een String return type)
     * 
     * @return  void    Print de data uit op het scherm
     */
    public void generateStarWarsName()
    {
        // Pak alle waardes uit onze HashMap, roep de toLowerCase() method aan en pak
        // de characters uit de string d.m.v. de substring method
        String step1 = this.personDetails.get("last name").toLowerCase().substring(0, 3);
        String step2 = this.personDetails.get("first name").toLowerCase().substring(0, 2);
        String step3 = this.personDetails.get("mothers maiden name").toLowerCase().substring(0, 2);
        String step4 = this.personDetails.get("city").toLowerCase().substring(0, 3);
        
        // Voeg alle strings samen (concatenation)
        String result = step1 + step2 + " " + step3 + step4;
        
        // Print het resultaat
        System.out.println(result);
    }
}
