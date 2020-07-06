import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';
import {AuthenticationService} from "../../authentication/authentication.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  notificationIcon = FaIcons.faBell;
  userIcon = FaIcons.faUserCircle;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

  logoutUser() {
    this.authenticationService.logout();
  }


}
