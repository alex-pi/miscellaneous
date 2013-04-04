package code.tests.problems;

/**
 * User: pi
 * Date: 3/27/13
 * Time: 4:51 PM
 */
class CeaserCipher extends Thread {

    public static void main(String[] s) throws Exception{
        String original = "abcde xyz";
        int positions = 3;
        System.out.println("original: " + original);

        int limit = positions < 0? 'z':'a';
        String encrypted = "";
        for(int i = 0; i < original.length(); i++) {
            int c = original.charAt(i);
            if(Character.isAlphabetic(c))
                c = (c + positions - limit) % 26 + limit;
            encrypted += (char)c;
        }

        System.out.println("encrypted: " + encrypted);
    }
}
