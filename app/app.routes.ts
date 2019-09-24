import {Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AdminComponent} from './admin/admin.component';
import {UserComponent} from './user/user.component';

export const ROUTES: Routes = [
  {
  path: 'login', component: LoginComponent,},
  {
  path: 'admin',
  component: AdminComponent
}, {
  path: 'user',
  component: UserComponent
}];
