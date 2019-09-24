import {Component, OnInit} from '@angular/core';
import {Booking} from './booking.model';
import {HttpService} from '../http.service';
import * as jsPDF from 'jspdf';
import {Email} from '../admin/email.model';


@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  protected booking: Booking = new Booking();
  protected httpService: HttpService;
  protected email: Email = new Email();
  protected bookings: Array<Booking> = new Array<Booking>();
  protected showBookings: boolean = false;

  constructor(httpService: HttpService) {
    this.httpService = httpService;
  }

  ngOnInit() {
    this.httpService.get('/user/allReservations').subscribe((data) => {
      this.bookings = data;
    }, (error) => {

    });
  }

  protected addBooking(): void {
    this.httpService.post('/user/addReservation', this.booking).subscribe((data) => {
    this.bookings.push(new Booking(data.id, data.idRoom, data.idHotel));
    const doc = new jsPDF();
    doc.text('Congrats ! Room ' + data.idRoom.toString() + ' in our hotel ' + 'is all yours !', 10 , 10 );
    doc.save('Reservation.pdf');
      console.log(data);
    }, (error) => {

    });

  }

  protected updateBooking(): void {
    this.httpService.put(`/user/updateReservation/${this.booking.id}`, this.booking).subscribe((data) => {
      console.log(data);
    }, (error) => {

    });
  }

  protected removeBooking(): void {
    this.httpService.post(`/user/removeReservation/${this.booking.id}`, this.booking).subscribe((data) => {
      console.log(this.booking.id);

    }, (error) => {

    });
  }

  protected sendMail(): void {
    this.httpService.post(`/user/sendEmail`, this.email).subscribe((data) => {
    console.log(this.email.to);
    }, (error) => {

    });
  }


  protected toggleBooking(): void {
    this.httpService.get('/user/allReservations').subscribe((data) => {
      this.bookings = data;
    }, (error) => {

    });
    this.showBookings = !this.showBookings;
  }
}
