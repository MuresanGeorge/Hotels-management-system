package spring.demo.dto;

public class HotelDTO {

    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public HotelDTO(){}

    public static class Builder {
        private int nestedid;
        private String nestedname;


        public Builder id(Integer id) {
            this.nestedid = id;
            return this;
        }

        public Builder name(String name) {
            this.nestedname= name;
            return this;
        }

        public HotelDTO create() {
            return new HotelDTO(nestedid, nestedname);
        }

    }
}
