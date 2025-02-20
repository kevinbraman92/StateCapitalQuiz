public class State {
    private String abbr;
    private String name;
    private String capital;

    public State(String abbr, String name, String capital) {
        this.abbr = abbr;
        this.name = name;
        this.capital = capital;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.abbr = capital;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
