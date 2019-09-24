package spring.demo.dto;

public class RoomDTO {

    private Integer id;
    private String cost;
    private Integer availability;

    public RoomDTO(){}

    public RoomDTO(Integer id, String cost, Integer availability) {
        this.id = id;
        this.cost = cost;
        this.availability = availability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public static class Builder {
        private Integer nestedid;
        private String nestedcost;
        private Integer nestedavailability;


        public Builder id(Integer id) {
            this.nestedid = id;
            return this;
        }

        public Builder cost(String cost) {
            this.nestedcost= cost;
            return this;
        }

        public Builder availability(Integer availability) {
            this.nestedavailability = availability;
            return this;
        }


        public RoomDTO create() {
            return new RoomDTO(nestedid, nestedcost,nestedavailability);
        }

    }
}
