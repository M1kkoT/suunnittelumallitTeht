package Builder;

public class McDonaldsBurger {
    private String bun = "";

    private String mayo = "";

    private String patty = "";

    private String sallad = "";

    private String pickles = "";

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setMayo(String mayo) {
        this.mayo = mayo;
    }

    public void setPatty(String patty) {
        this.patty = patty;
    }

    public void setSallad(String sallad) {
        this.sallad = sallad;
    }

    public void setPickles(String pickles) {
        this.pickles = pickles;
    }

    @Override
    public String toString() {
        return "McDonaldsBurger: " +
                "bun='" + bun + '\'' +
                ", mayo='" + mayo + '\'' +
                ", patty='" + patty + '\'' +
                ", sallad='" + sallad + '\'' +
                ", pickles='" + pickles + '\'';
    }
}
