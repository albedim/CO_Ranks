package it.craftopoly.co_ranks.schema;

public class Rank {

    private Integer rank_id;
    private String name;
    private boolean staffer;


    public Integer getRank_id() {
        return rank_id;
    }
    public void setRank_id(Integer rank_id) {
        this.rank_id = rank_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getStaffer() {
        return staffer;
    }
    public void setStaffer(boolean staffer) {
        this.staffer = staffer;
    }

}
