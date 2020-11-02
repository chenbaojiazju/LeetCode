public class Pattern {

    private char[] pattern;
    private int plen;
    private boolean matched = false;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return;
        if (pj == plen) {
            if (ti == tlen) matched = true;
            return;
        }
        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen-ti; ++k) {
                rmatch(ti+k, pj+1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            rmatch(ti, pj+1, text, tlen);
            rmatch(ti, pj+1, text, tlen);
        } else if (tlen > ti && pattern[pj] == text[ti]) {
            rmatch(ti+1, pj+1, text, tlen);
        }

    }
}