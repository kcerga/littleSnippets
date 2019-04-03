/*************************************
	file: Mini101.java
	desc: Practice for java collections. User can insert one or multiple records, 
	print the information of the records and delete specific records.
	date: 23.7.2018
	auth: Wilma C


*************************************/

/*** The ID system in this program is not perfect. If you have many elements and you delete one
from the middle, it will create a "double" of the previous ID when you make a new one.
I just used the ID system to make it easier to delete a certain record.  ***/

//Libraries for java classes
import java.util.*; 
import java.io.*;

public class Mini101 {
	
/** Class for a single CD-record **/
public static class levy {
	
	//Attributes for the record information (and a scanner)
	protected String levynimi;
	protected String artisti;
	protected int vuosi;
	protected Scanner lukija;

		//Constructor that takes no parameters
		levy() {
				Locale.setDefault(Locale.ENGLISH); 
				lukija = new Scanner(System.in);
		}
		
		
	//Method that asks the user to insert the information of a record
	public void syotaLevy() {
		
		System.out.println("Anna levyn nimi: ");
		levynimi = lukija.nextLine();
		
		System.out.println("Anna artistin nimi: ");
		artisti = lukija.nextLine();
		
		System.out.println("Syota vuosi jolloin levy ilmestyi: ");
		vuosi = lukija.nextInt();
		lukija.nextLine();	
	}
	
	//Prints the information of the previously added record
	public void levynTiedot() {
		System.out.println("Nimi: " + levynimi + "\n" + "Artisti: " + artisti +  "\n" + "Vuosi: " + vuosi);
	}
	
	//Returns the name of the record
	public String kerroNimi() {
		return levynimi;
	}
	//Returns artist name 
	public String kerroArtisti() {
		return artisti;
	}
	//Returns the year the record was made
	public int kerroVuosi() {
		return vuosi;
	}
}	
	
	
/** Class for CD-record collection(s) **/	
public static class kokoelma {
	
	//Attribute of the levy class
	protected levy uusiLevy;
	
	//Integer for amount of elements
	int elementtienMaara;
	
	//Variable to help print the elements of the list
	String alkio;
	
	//Constructor
	kokoelma() {
		uusiLevy = new levy();
	}
	
	
	//A list where all the record informations will be saved to
	ArrayList<String> levykokoelma = new ArrayList<String>();
	
	
	
	//This method has no specific meaning, 
	// it is merely here to take the space of the first element (0)
	public void tyhjaAlkio() {
		levykokoelma.add("");
	
	}
	
	//Goes to method on levy-class and adds a new CD
	public void lisaaLevy() {
		uusiLevy.syotaLevy();
	}
	
	//Calls method to print the info of the recently added CD
	public void viimeisinLevy() {
		uusiLevy.levynTiedot();
	}
	
	//Saves the CD information to the list
	public void tallennaLevy() {
		//Gets the amount of the current elements, which will be used as an ID 
		elementtienMaara = levykokoelma.size();
		levykokoelma.add("Levy #" + elementtienMaara + "\n" + "Nimi: " + uusiLevy.kerroNimi() + "\n" + "Artisti: " + uusiLevy.kerroArtisti() +  "\n" + "Vuosi: " + uusiLevy.kerroVuosi());
		
	}

	
	//Prints the whole collection
	public void tulostaKokoelma() {
		
		Iterator<String> i = levykokoelma.iterator();
			while(i.hasNext()) {
				alkio = i.next();
				System.out.println( alkio + "\n");
				
			}
			//This if statement doesnt work. I couldnt figure it out why it didnt work.
			if (elementtienMaara < 1)
			{
				System.out.println("Kokoelma on tyhja.");
			}
	}
	
	
	//Removes a record from the element that the user input
	public void poistaLevy(int elementti) {
		
		levykokoelma.remove(elementti);
	}

}	
	
	
	

/** Main program **/
public static void main(String[] args) {
	
	//Introducing a scanner and variables needed to function the program
	Scanner lukija = new Scanner(System.in);
	int toiminto = 0;
	int elementti = 0;
	
	//Object of the CD collection class
	kokoelma uusiKokoelma = new kokoelma();
	
	//Creates an empty element for the slot 0 (I found this easier to work with the ID's)
	uusiKokoelma.tyhjaAlkio();
	
	//Program first asks user to insert a CD record information
		System.out.println("Aloitetaan lisaamalla levy. ");
		
		//Calls functions from collection class
		uusiKokoelma.lisaaLevy();
		uusiKokoelma.tallennaLevy();
		
		//Loop for the program to go on, until user enters 5.
		while (toiminto != 5) {
			System.out.println("1 = Lisaa uusi levy, 2 = Viimeisimman levyn tiedot, 3 = Tulosta kokoelman sisalto, 4 = Poista levy, 5 = lopeta ohjelma");
			toiminto = lukija.nextInt();
			
			//If user enters 1, program asks user to enter a new record, and saves it to the list
			if (toiminto == 1) {
				
				uusiKokoelma.lisaaLevy();
				uusiKokoelma.tallennaLevy();
			}
			//Prints the information of the latest record
			else if  (toiminto == 2) {
				
				uusiKokoelma.viimeisinLevy();
			}
			//Prints the whole list of records
			else if  (toiminto == 3) {
				
				uusiKokoelma.tulostaKokoelma();
			}
			
			//Action to remove a specific record from the collection
			else if (toiminto == 4) {
				try{
					//Asks user to give the element(ID) number, so we know what to delete
					System.out.println("Anna poistettavan levyn numero: ");
					elementti = lukija.nextInt();
					
					//Sends the ID number for the method
					uusiKokoelma.poistaLevy(elementti);
					
					System.out.println("Levy poistettu.");
				}
				//In case user enters something else, like an ID that doesnt exist or false input.
				catch(Exception e) {
					System.out.println("Levya ei ole olemassa.");
				}
			}
			
			//Closes program
			else {
				
				System.out.println("Suljetaan ohjelma.");
			}
			
		}
	
}	
}