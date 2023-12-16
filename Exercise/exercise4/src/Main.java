
import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class Main {

            public static void main(String[] args) {
                // Below are the five regular expressions created
                /* Matches anything that  one or more letters followed by a single digit charcter */
                String pattern1 = "^[A-Za-z]+[0-9]";
                /* Matches any word that starts and ends with the word boundary followed by another
                word and ending with a word boundary */
                String pattern2 = "\\b[A-Za-z]{5}\\b";
                /* Matches any word that starts with h or e followed by zero or one e
                and followed by art followed by zero or one h */
                String pattern3 = "^[h/e]e?(art)h?$";
                //Matches pincodes
                String pattern4 = "\\d{3}-\\d{3}";
                //Matches a sentence of three words of 4 alphabets each seperated by a space
                String pattern5 = "\\w{4}\\s\\w{4}\\s\\w{4}";

                // Sample subject strings
                String positivecase1 = "Class7";  // Positive case for pattern1
                String negativecase1="Class seven"; //Negative case for pattern1

                String positivecase2 = "Hello World";  // Positive case for pattern2
                String negativecase2 = "Java is fun!";  // Negative case for pattern2

                String positivecase3 = "heart";  // Positive case for pattern3
                String negativecase3 = "eeearthh";  // negative case for pattern3

                String positivecase4="400-068";
                String negativecase4="94536";

                String positivecase5="woah woah woah";
                String negativecase5="hi hi hi";



                String[] pattern_list= {pattern1,pattern2,pattern3,pattern4,pattern5};
                String[][] cases_list={ {positivecase1, negativecase1}, {positivecase2, negativecase2},
                        {positivecase3, negativecase3},{positivecase4,negativecase4},{positivecase5,negativecase5}};

                // Test each pattern
                for(int i=0;i<5;i++) {
                    testPattern(pattern_list[i],cases_list[i][0],"Positive case matches pattern");
                    testPattern(pattern_list[i],cases_list[i][1], "Negative case does not match pattern");
                    System.out.println();
                }

            }

            private static void testPattern(String regex, String subject, String description) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(subject);

                if (matcher.find()) {
                    System.out.println(description);
                    System.out.println("Positive Case : Pattern matched in the subject: " + subject);
                    System.out.println("Matched text : " + matcher.group());
                } else {
                    System.out.println(description);
                    System.out.println("Negative Case : Pattern did not match in the subject: " + subject);
                }

            }
        }

