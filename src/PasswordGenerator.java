import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {


    private Requirement require;
    SecureRandom ran = new SecureRandom();
    //make an array of all special characters in string
    //1+2


    private static final String Caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String Lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String Special = "!@#$%^&*()_+{}|:<>?";

    public PasswordGenerator(Requirement require) {
        this.require = require;
    }

    public String getCaps(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i<length; i++) {
            int index = ran.nextInt(Caps.length());
            char randomChar = Caps.charAt(index);
            sb = sb.append(randomChar);
        }
        return sb.toString();

    }

    public String getLower(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i<length; i++) {
            int index = ran.nextInt(Lower.length());
            char randomChar = Lower.charAt(index);
            sb = sb.append(randomChar);
        }
        return sb.toString();

    }

    public String getSpecial(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i<length; i++) {
            int index = ran.nextInt(Special.length());
            char randomChar = Special.charAt(index);
            sb = sb.append(randomChar);
        }
        return sb.toString();
    }

    public String getPassword() {
        String password = "";
        List<String> charType = new ArrayList<>();

        if (require.capsOrNo()) {
            charType.add(getCaps(require.getCharMin()));
        }

        if (require.isSpecialChar()) {
            charType.add(getSpecial(require.getCharMin()));
           // password = password + getSpecial(require.getCharMin());
        }

        charType.add(getLower(require.getCharMin()));
        Collections.shuffle(charType);
        for (int i = 0; i<charType.size(); i++) {
            password = password + charType.get(i);
        }

        return password;
    }
}
