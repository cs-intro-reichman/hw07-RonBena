
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
	str = str.substring(1);
	return str;
	}
	public static int levenshtein(String word1, String word2) {
		if(word1.length()==0)
			return word2.length();
			if(word2.length()==0)
			return word1.length();

		word1.toLowerCase();
		word2.toLowerCase();
			int dis = 0;
			if(word1.charAt(0)== word2.charAt(0) )
			{
				return levenshtein(tail(word1), tail(word2));
			}
			else if(word1.charAt(0)!= word2.charAt(0))
			{
				dis++;
				dis = dis + Math.min(levenshtein(tail(word1), tail(word2)),Math.min(levenshtein((word1), tail(word2)),levenshtein(tail(word1), tail(word2))));
			}
			return dis;
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i=0; i < dictionary.length; i++)
		dictionary[i] =  in.readLine();
		
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
	for(int i = 0; i < dictionary.length; i++)
	{
		if(levenshtein(dictionary[i], word) <= threshold)
		return dictionary[i];
	}
	return "";
	}

}
