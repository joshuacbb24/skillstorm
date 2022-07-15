import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  toggleSidebar() :void{
    
    let sidebarElement = document.querySelector(".sidebar");
    let navElement = document.querySelector("nav");
    let dashElement = document.querySelector(".home-section");
    
    console.log(navElement)

    sidebarElement ? sidebarElement.classList.toggle("active") : null;
    dashElement ? dashElement.classList.toggle("active") : null;
    navElement ? navElement.classList.toggle("active") : null;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
