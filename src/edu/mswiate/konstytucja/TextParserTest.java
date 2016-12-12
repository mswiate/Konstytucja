package edu.mswiate.konstytucja;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextParserTest {

	@Test
	public void testParse() {
		//ZMIENIC SCIEZKE DO PLIKU !!!
		String[] args = {"sciezka","1","R2","240-243"};
		Constitution c = new Constitution();
		TextParser tp = new TextParser(c, new ArgumentsParser().parseFilePath(args));
		try{
			tp.parse();
		}
		catch(Exception ex){
			
		}
		String t ="Rozdzia� XII\n" +
				"ZMIANA KONSTYTUCJI\n" +
				"Art. 235.\n" +
				"1. Projekt ustawy o zmianie Konstytucji mo�e przed�o�y� co najmniej 1/5 ustawowej liczby pos��w, Senat lub"
				+ " Prezydent Rzeczypospolitej. \n" +
				"2. Zmiana Konstytucji nast�puje w drodze ustawy uchwalonej w jednakowym brzmieniu przez Sejm i nast�pnie w terminie "
				+ "nie d�u�szym ni� 60 dni przez Senat. \n" +
				"3. Pierwsze czytanie projektu ustawy o zmianie Konstytucji mo�e odby� si� nie wcze�niej ni� trzydziestego dnia od"
				+ " dnia przed�o�enia Sejmowi projektu ustawy. \n" +
				"4. Ustaw� o zmianie Konstytucji uchwala Sejm wi�kszo�ci� co najmniej 2/3 g�os�w w obecno�ci co najmniej po�owy"
				+ " ustawowej liczby pos��w oraz Senat bezwzgl�dn� wi�kszo�ci� g�os�w w obecno�ci co najmniej po�owy ustawowej"
				+ " liczby senator�w. \n" +
				"5. Uchwalenie przez Sejm ustawy zmieniaj�cej przepisy rozdzia��w I, II lub XII Konstytucji mo�e odby� si� nie"
				+ " wcze�niej ni� sze��dziesi�tego dnia po pierwszym czytaniu projektu tej ustawy. \n" +
				"6. Je�eli ustawa o zmianie Konstytucji dotyczy przepis�w rozdzia�u I, II lub XII, podmioty okre�lone w ust."
				+ " 1 mog� za��da�, w terminie 45 dni od dnia uchwalenia ustawy przez Senat, przeprowadzenia referendum "
				+ "zatwierdzaj�cego. Z wnioskiem w tej sprawie podmioty te zwracaj� si� do Marsza�ka Sejmu, kt�ry zarz�dza "
				+ "niezw�ocznie przeprowadzenie referendum w ci�gu 60 dni od dnia z�o�enia wniosku. Zmiana Konstytucji zostaje "
				+ "przyj�ta, je�eli za t� zmian� opowiedzia�a si� wi�kszo�� g�osuj�cych. \n" +
				"7. Po zako�czeniu post�powania okre�lonego w ust. 4 i 6 Marsza�ek Sejmu przedstawia Prezydentowi Rzeczypospolitej "
				+ "uchwalon� ustaw� do podpisu. Prezydent Rzeczypospolitej podpisuje ustaw� w ci�gu 21 dni od dnia przedstawienia i "
				+ "zarz�dza jej og�oszenie w Dzienniku Ustaw Rzeczypospolitej Polskiej. \n";;
		assertEquals(c.getChapter(12).toString(), t);
		
	}
	
	

}
