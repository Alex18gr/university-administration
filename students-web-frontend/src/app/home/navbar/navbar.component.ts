import { Component, OnInit } from '@angular/core';
import * as FaIcons from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  notificationIcon = FaIcons.faBell;
  userIcon = FaIcons.faUserCircle;

  constructor() { }

  ngOnInit(): void {
  }

}
