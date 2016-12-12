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
		String t ="Rozdzia³ XII\n" +
				"ZMIANA KONSTYTUCJI\n" +
				"Art. 235.\n" +
				"1. Projekt ustawy o zmianie Konstytucji mo¿e przed³o¿yæ co najmniej 1/5 ustawowej liczby pos³ów, Senat lub"
				+ " Prezydent Rzeczypospolitej. \n" +
				"2. Zmiana Konstytucji nastêpuje w drodze ustawy uchwalonej w jednakowym brzmieniu przez Sejm i nastêpnie w terminie "
				+ "nie d³u¿szym ni¿ 60 dni przez Senat. \n" +
				"3. Pierwsze czytanie projektu ustawy o zmianie Konstytucji mo¿e odbyæ siê nie wczeœniej ni¿ trzydziestego dnia od"
				+ " dnia przed³o¿enia Sejmowi projektu ustawy. \n" +
				"4. Ustawê o zmianie Konstytucji uchwala Sejm wiêkszoœci¹ co najmniej 2/3 g³osów w obecnoœci co najmniej po³owy"
				+ " ustawowej liczby pos³ów oraz Senat bezwzglêdn¹ wiêkszoœci¹ g³osów w obecnoœci co najmniej po³owy ustawowej"
				+ " liczby senatorów. \n" +
				"5. Uchwalenie przez Sejm ustawy zmieniaj¹cej przepisy rozdzia³ów I, II lub XII Konstytucji mo¿e odbyæ siê nie"
				+ " wczeœniej ni¿ szeœædziesi¹tego dnia po pierwszym czytaniu projektu tej ustawy. \n" +
				"6. Je¿eli ustawa o zmianie Konstytucji dotyczy przepisów rozdzia³u I, II lub XII, podmioty okreœlone w ust."
				+ " 1 mog¹ za¿¹daæ, w terminie 45 dni od dnia uchwalenia ustawy przez Senat, przeprowadzenia referendum "
				+ "zatwierdzaj¹cego. Z wnioskiem w tej sprawie podmioty te zwracaj¹ siê do Marsza³ka Sejmu, który zarz¹dza "
				+ "niezw³ocznie przeprowadzenie referendum w ci¹gu 60 dni od dnia z³o¿enia wniosku. Zmiana Konstytucji zostaje "
				+ "przyjêta, je¿eli za t¹ zmian¹ opowiedzia³a siê wiêkszoœæ g³osuj¹cych. \n" +
				"7. Po zakoñczeniu postêpowania okreœlonego w ust. 4 i 6 Marsza³ek Sejmu przedstawia Prezydentowi Rzeczypospolitej "
				+ "uchwalon¹ ustawê do podpisu. Prezydent Rzeczypospolitej podpisuje ustawê w ci¹gu 21 dni od dnia przedstawienia i "
				+ "zarz¹dza jej og³oszenie w Dzienniku Ustaw Rzeczypospolitej Polskiej. \n";;
		assertEquals(c.getChapter(12).toString(), t);
		
	}
	
	

}
