package edu.mswiate.konstytucja;

public class TextParser {
	
	private Constitution constitution;
	
	public TextParser(Constitution constitution){
		
	}
	
	// zamienia forme tekstowa na obiektowa 
	public void parse(){
		/*
		 * odczytywanie pliku po linii
		 * jak trafi na wzorzec "Rozdzia� " to zapisuje jego numer(String) , tytu�
		 * i numer pierwszego artyku�u
		 * jak trafi na kolejny taki wzorzec to zapisuje numer ostatniego przetworzonego artyku�u
		 * i tworzy obiekt klasy Chapter i dodaje go do constitution
		 * 
		 * jak trafi na wzorzec "Kancelaria Sejmu" lub data to przechodzi do nastepnej linii
		 * 
		 * jak trafi na wzorzec Art. to zapisuje jego numer, tworzy obiekt klasy Article 
		 *  i dodaje kolejne punkty artyku�u
		 * nastepnie dodaje go do constitution
		 * 
		 * je�li parsuje artyku� a odczytywana linia jest pierwsza odczytywana,
		 * lub zaczyna sie od wzorca "[cyfra]. " lub "[Cyfra]) " z danego artykulu to zaczyna budowa� napis contents
		 * je�li nastepna linia zaczyna sie od wzorca "Art. " lub "[cyfra]. " lub "[Cyfra]) " to tworzy oiekt klasy
		 * Point(contents)
		 * jesli linia nie zaczyna sie od tych wzorcow to dopisuje do stringa contents  tresc danej linii contents+" "+ aktualna linia,
		 * chyba ze poprzednia linia skonczyla sie wzorcem "*-" wtedy usuwa ostatni znak z contents
		 * i dopisuje tresc danej linii contents  + aktualna linia
		 * 
		 * 
		 * 
		 */
	}
	
	//otwiera plik
	public void openFile(String filePath) throws IOException{
		
	}
}
