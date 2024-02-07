

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = "iloveyou";
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i=0; i < dictionary.length; i++)
		dictionary[i] =  in.readLine();
		
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		word = word.toLowerCase();
		for(int i = 0 ; i < dictionary.length; i++)
		{
			if(word.equals(dictionary[i]))
			return true;
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		String word = "";
        for (int i = 1; i <= N; i++) {
		char ch = hashtag.charAt(i-1);
		 word = word + ch;
			if(existInDictionary(word, dictionary))
			{
				System.out.println(word);
				breakHashTag(hashtag.substring(i), dictionary);
			}
        }return;
    }

}
