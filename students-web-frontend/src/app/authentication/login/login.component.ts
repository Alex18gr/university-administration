import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../authentication.service";
import * as FaIcons from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  graduationCapIcon = FaIcons.faGraduationCap;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

  login() {
    this.authenticationService.login();
  }
}
