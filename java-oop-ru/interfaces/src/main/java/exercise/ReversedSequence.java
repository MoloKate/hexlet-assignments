package exercise;

import java.util.List;

// BEGIN
public class ReversedSequence implements CharSequence{

    private StringBuilder seq;

    public ReversedSequence(String sequence) {
        this.seq = new StringBuilder(sequence).reverse();
    }

    @Override
    public String toString() {
        return this.seq.toString();
    }

    @Override
    public int length() {
        return this.seq.length();
    }

    @Override
    public char charAt(int i) {
        return this.seq.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int j) {
        return this.seq.subSequence(i, j);
    }

}

// END
