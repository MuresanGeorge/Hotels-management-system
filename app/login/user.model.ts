export class User {
  public id: string;
  public username: string;
  public password: string;
  public role: number;

  constructor(username?: string, password?: string, role?: number, id?: string) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
