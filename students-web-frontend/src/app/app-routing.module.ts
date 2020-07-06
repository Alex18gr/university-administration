import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./authentication/login/login.component";
import {MainApplicationComponent} from "./home/main-application/main-application.component";
import {AuthGuard} from "./authentication/auth.guard";
import {HomePageComponent} from "./home/home-page/home-page.component";
import {StudentPageComponent} from "./student/student-page/student-page.component";


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: MainApplicationComponent, canActivate: [AuthGuard], children: [
      {path: '', component: HomePageComponent, pathMatch: 'full'},
      {path: 'student', component: StudentPageComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
