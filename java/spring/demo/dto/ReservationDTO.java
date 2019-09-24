package spring.demo.dto;

public class ReservationDTO {

    private Integer id;
    private Integer idRoom;
    private Integer idHotel;

    public ReservationDTO(){}

    public ReservationDTO(Integer id, Integer idRoom, Integer idHotel) {
        this.id = id;
        this.idRoom = idRoom;
        this.idHotel = idHotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public static class Builder {
        private Integer nestedid;
        private Integer nestedidroom;
        private Integer nestedidhotel;


        public Builder id(Integer id) {
            this.nestedid = id;
            return this;
        }

        public Builder cost(Integer idRoom) {
            this.nestedidroom= idRoom;
            return this;
        }

        public Builder availability(Integer idHotel) {
            this.nestedidhotel = idHotel;
            return this;
        }


        public ReservationDTO create() {
            return new ReservationDTO(nestedid, nestedidroom,nestedidhotel);
        }

    }
}
