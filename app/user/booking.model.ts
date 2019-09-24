export class Booking {
  public id: string;
  public idRoom: string;
  public idHotel: string;

  constructor(id?: string, idRoom?: string, idHotel?: string) {
    this.id = id;
    this.idRoom = idRoom;
    this.idHotel = idHotel;
  }
}
