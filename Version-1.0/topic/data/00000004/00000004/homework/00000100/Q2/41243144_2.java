/**
 * Project Name: ShowChineseName
 * Author: 41243144 温博鈞
 * Description:
 *      This program shows the author's Chinese name, 
 *      the school, and the department they attended.
 * Functionality:
 *      Displays the information using println().
 *      to_unicode() uses for loop and string formatting to convert strings into Unicode encoding
 * Last Edit Date: 2024-09-27
 */
package September.sep_27;

public class ShowChineseName {
    public static void main(String[] args) {
        String ch_name = "温博鈞"; // Chinese name
        String school = "國立虎尾科技大學"; // school
        String department = "資訊工程系"; // department
        System.out.println(String.format("School and department: %s %s \nMy name: %s", to_unicode(school), to_unicode(department), to_unicode(ch_name)));
    }

    // Convert string to unicode form
    public static String to_unicode(String str){
        // StringBuilder is a changeable string type
        StringBuilder unicode = new StringBuilder();

        for(int i=0; i < str.length(); i++){
            unicode.append(String.format("%c(%d)", str.charAt(i), (int) str.charAt(i)));
        }
        return unicode.toString();
    }
}