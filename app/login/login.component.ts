import {Component, OnInit} from '@angular/core';
import {User} from './user.model';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpService} from '../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  protected user: User = new User();
  protected httpService: HttpService;
  protected router: Router;

  constructor(httpService: HttpService, router: Router) {
    this.httpService = httpService;
    this.router = router;
  }

  ngOnInit() {
  }

  protected handleLogin(): void {

    this.httpService.post('/user/login', this.user).subscribe((data: any) => {
      console.log(data);
        if (data.role === 1) {
          this.router.navigate(['admin']);
        } else {
          this.router.navigate(['user']);
        }
    }, (error) => {
    });
  }

}
