import java.util.Random;

public class Requirement {
    int charMin;
    boolean capsOrNo;
    boolean SpecialChar;

    public Requirement(int minChar, boolean caps, boolean sC) {
        this.charMin = minChar;
        this.capsOrNo = caps;
        this.SpecialChar = sC;

    }
    public int getCharMin() {
        return this.charMin;
    }
    public boolean capsOrNo() {
        return this.capsOrNo;
    }
    public boolean isSpecialChar() {
        return this.SpecialChar;
    }


}
