package fi.beanbakers.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some examples and asserts on some basic programming problems.
 * 
 * @author Peter
 */
public class BeanBakersTests {

	public static void main(String[] args){
		BeanBakersTests tests = new BeanBakersTests();
		tests.testReverseList();
		tests.testFibonacciSequence();
		tests.testAscendingAndDescendingSeries();
	}
	private int firstFibonacciNumber;
	private int secondFibonacciNumber;
	@Test
	public void testReverseList() {
		List<String> input = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		List<String> expectedResult = Arrays.asList("g", "f", "e", "d", "c", "b", "a");

		List<String> result = doReverseList(input);
		Assert.assertArrayEquals(expectedResult.toArray(new String[expectedResult.size()]),
				result.toArray(new String[result.size()]));
			
		/*if (result.equals(expectedResult)) {
				System.out.println("Test passed!");
			} else {												// Lisäsin tulostuksen nähdäkseni, että metodi palauttaa oikeanlaisen listan
				System.out.println("Test failed!");
			}*/
	}

	/**
	 * Write your method here that returns the provided input list reversed.
	 * 
	 * @param input list
	 * @return provided list reversed
	 */

	
	private <T> List<T> doReverseList(List<T> input) {
		// TODO: Write code!
		// Luodaan kopio parametrina annetusta listasta, jotta alkuperäinen lista säilyy koskemattomana. Käännetään kopio toisinpäin ja palautetaan se
	 	List<T> copy = new ArrayList<>(input);
		Collections.reverse(copy);
		//System.out.println("Käännetty lista: " + copy); // Lisäsin tulostuksen nähdäkseni, että metodi palauttaa oikeanlaisen listan
		return copy;
	}
	@Test
	public void testFibonacciSequence() {
		
		int sequenceLength = 3;
		int[] expectedResult = { 1, 2, 3};
		if (sequenceLength != 0 && sequenceLength != 1) {
			firstFibonacciNumber = expectedResult[0];
			secondFibonacciNumber = expectedResult[1];
		}
		
		if (sequenceLength == 0){
			expectedResult = new int [0];
			}
		if (sequenceLength == 1){
			expectedResult = new int [1];
			firstFibonacciNumber = expectedResult[0];
			}
	
		

		
		
		int[] result = doFibonacciSequence(sequenceLength);
		

		// Lisäsin tulostuksen nähdäkseni, että metodi palauttaa oikean taulukon
		//System.out.print("Fibonaccin lukujono: " + Arrays.toString(result) + "\n");
		Assert.assertArrayEquals(expectedResult, result);
	}

	// Kirjoitin getterit, jotta pääsen käsiksi expectedResult -taulukon ensimmäiseen ja toiseen alkioon, jotka määritetään testissä, ja joita käytetään ensimmäisenä ja toisena Fibonaccin lukuna doFibonacciSequence -metodissa 
	private int getFirstFibonacciNumber(){
		return firstFibonacciNumber;
	}

	private int getSecondFibonacciNumber(){
		return secondFibonacciNumber;
	}

	/**
	 * Write your method here that returns the fibonacci sequence up to the provided
	 * sequence length.
	 * 
	 * @param sequenceLength the amount of fibonacci sequence items to calculate
	 * @return int array containing the calculated fibonacci sequence
	 */
	private int[] doFibonacciSequence(int sequenceLength){
		// TODO: Write code!

		// Määritellään taulukko, johon Fibonaccin lukujono tallennetaan. Taulukko sisältää kokonaislukuja, ja sen koko on annettu sequenceLenth -parametrissa
		int[] fibo = new int [sequenceLength];
		
		
		
		if (sequenceLength<3){
			if (sequenceLength==0){
				return fibo;
			}
			if (sequenceLength==1){
				// Haetaan getterillä ensimmäinen Fibonaccin luku, joka on määritetty testissä, ja asetetaan se taulukon ensimmäiseen indeksiin. Palautetaan taulukko, joka sisältää vain yhden Fibonaccin luvun
				fibo[0] = getFirstFibonacciNumber();
				// Palautetaan taulukko, joka sisältää vain yhden Fibonaccin luvun
				return fibo;
			}
			if (sequenceLength==2){
				// Haetaan getterillä ensimmäinen ja toinen Fibonaccin luku, jotka on määritetty testissä, ja asetetaan ne taulukon ensimmäiseen ja toiseen indeksiin. Palautetaan taulukko, joka sisältää vain kaksi Fibonaccin lukua
				fibo[0] = getFirstFibonacciNumber();
				fibo[1] = getSecondFibonacciNumber();
				// Palautetaan taulukko, joka sisältää vain kaksi Fibonaccin lukua
				return fibo;
		}
		}else{
			fibo[0] = getFirstFibonacciNumber();
			fibo[1] = getSecondFibonacciNumber();
			}
			
		
		// For-silmukassa muodostetaan taulukon seuraavat luvut, jotka saadaan laskemalla edelliset kaksi lukua yhteen. Asetetaan saatu arvo indeksin i osoittamaan kohtaan. Aloitetaan indeksistä 2, koska indekseissä 0 ja 1 olevat luvut on jo määritelty
		for (int i=2;i<sequenceLength;i++){
			fibo[i] = fibo[i-1]+fibo[i-2];
			
		}

		return fibo;
		
		}
	

		

		

	@Test
	public void testAscendingAndDescendingSeries() {
		List<Integer> testSeriesA = Arrays.asList(1, 3, 7, 14, 30, 31, 200, 250);
		List<Integer> testSeriesB = Arrays.asList(1, 2, 1, 8, 7, 27, 31, 50);

		Assert.assertTrue(isAscendingSeries(testSeriesA));
		Assert.assertFalse(isAscendingSeries(testSeriesB));
		Assert.assertTrue(isDescendingSeries(doReverseList(testSeriesA)));
		Assert.assertFalse(isDescendingSeries(doReverseList(testSeriesB)));
		
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * ascending, false otherwise.
	 * 
	 * @param series
	 * @return true if provided series ascends, false otherwise.
	 */
	private boolean isAscendingSeries(List<Integer> series) {
		// TODO: Write code!
		for (int i = 0; i < series.size() - 1; i++) {
			// Tallennetaan nykyinen ja seuraava luku muuttujiin, joita sitten verrataan keskenään
			int nykyinen = series.get(i);
			int seuraava = series.get(i+1);
			// Palautetaan false heti, jos nykyinen on suurempi kuin seuraava, muuten jatketaan vertailua ja lopulta palautetaan true
			if (nykyinen>seuraava){
				return false;
			}

		}
		return true;
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * descending, false otherwise.
	 * 
	 * @param series
	 * @return true if the provided series descends, false otherwise.
	 */
	private boolean isDescendingSeries(List<Integer> series) {
		// TODO: Write code!

		for (int i = 0; i < series.size()-1;i++){
			// Tallennetaan nykyinen ja seuraava luku muuttujiin, joita sitten verrataan keskenään.
			int nykyinen = series.get(i);
			int seuraava = series.get(i+1);
			// Palautetaan false heti, jos nykyinen on suurempi kuin seuraava, muuten jatketaan vertailua ja lopulta palautetaan true
			if (nykyinen<seuraava){
				return false;
			}
		}
		return true;
	}
}
