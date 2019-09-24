import {Component, OnInit} from '@angular/core';
import {User} from '../login/user.model';
import {HttpService} from '../http.service';
import {b} from '@angular/core/src/render3';
import {Hotel} from './hotel.model';
import {Room} from './room.model';
import {Email} from './email.model';

@Component({
  selector: 'admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  protected user: User = new User();
  protected hotel: Hotel = new Hotel();
  protected room: Room = new Room();
  protected email: Email = new Email();
  protected httpService: HttpService;
  protected showReceptionist: boolean = false;
  protected showRooms: boolean = false;
  protected showHotels: boolean = false;
  protected users: Array<User> = new Array<User>();
  protected hotels: Array<Hotel> = new Array<Hotel>();
  protected rooms: Array<Room> = new Array<Room>();

  constructor(httpService: HttpService) {
    this.httpService = httpService;
  }

  ngOnInit() {
    this.httpService.get('/admin/getAllUsers').subscribe((data) => {
      this.users = data;
    }, (error) => {

    });
    this.httpService.get('/admin/getAllHotels').subscribe((data) => {
      this.hotels = data;
    }, (error) => {

    });
    this.httpService.get('/admin/getAllRooms').subscribe((data) => {
      this.rooms = data;
    }, (error) => {

    });

  }


  protected addReceptionist(): void {
    this.httpService.post('/admin/addUser', this.user).subscribe((data) => {
      this.users.push(new User(data.username, data.password, data.role, data.id));
      console.log(data);
    }, (error) => {

    });

  }

  protected updateReceptionist(): void {
    this.httpService.put(`/admin/updateUser/${this.user.id}`, this.user).subscribe((data) => {
      console.log(data);

    }, (error) => {

    });
  }

  protected removeReceptionist(): void {
    this.httpService.post(`/admin/deleteUser`, this.user).subscribe((data) => {
      console.log(data);

    }, (error) => {

    });
  }

  protected addHotel(): void {
    this.httpService.post('/admin/addHotel', this.hotel).subscribe((data) => {
        this.hotels.push(new Hotel(data.id, data.name));
      console.log(data);
    }, (error) => {

    });

  }

  protected updateHotel(): void {
    this.httpService.put(`/admin/updateHotel`, this.hotel).subscribe((data) => {
  console.log(data);
    }, (error) => {

    });
  }

  protected removeHotel(): void {
    this.httpService.post(`/admin/deleteHotel/${this.hotel.id}`, this.hotel).subscribe((data) => {
      console.log(data);
    }, (error) => {

    });
  }

  protected addRoom(): void {
    this.httpService.post('/admin/addRoom', this.room).subscribe((data) => {
      this.rooms.push(new Room(data.id, data.cost, data.availability));
      console.log(data);

    }, (error) => {

    });

  }

  protected updateRoom(): void {
    this.httpService.put(`/admin/updateRoom`, this.room).subscribe((data) => {
      console.log(data);

    }, (error) => {

    });
  }

  protected removeRoom(): void {
    this.httpService.post(`/admin/deleteRoom/${this.room.id}`, this.room).subscribe((data) => {
      console.log(data);

    }, (error) => {

    });
  }

  protected getEarnings(): void {
    this.httpService.post(`/admin/raportIncasari`, null).subscribe((data) => {
      console.log(data);

    }, (error) => {

    });
  }

  protected toggleReceptionist(): void {
    this.httpService.get('/admin/getAllUsers').subscribe((data) => {
      this.users = data;
    }, (error) => {

    });
    this.showReceptionist = !this.showReceptionist;
  }

  protected toggleRooms(): void {
    this.httpService.get('/admin/getAllRooms').subscribe((data) => {
      this.rooms = data;
    }, (error) => {

    });
    this.showRooms = !this.showRooms;
  }

  protected toggleHotels(): void {


    this.httpService.get('/admin/getAllHotels').subscribe((data) => {
      this.hotels = data;
    }, (error) => {

    });
    this.showHotels = !this.showHotels;
  }

}
