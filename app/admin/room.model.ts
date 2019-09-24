export class Room {
  public id: string;
  public cost: string;
  public availability: string;

  constructor(id?: string, cost?: string, availability?: string) {
    this.id = id;
    this.cost = cost;
    this.availability = availability;
  }
}
