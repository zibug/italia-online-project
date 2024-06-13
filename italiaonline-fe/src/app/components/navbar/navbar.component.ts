import { Component } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(private route: Router) {

  }

  routes = [
    {
      path: '',
      label: 'Home'
    },
    {
      path: '/mongodb',
      label: 'Dati MongoDb'
    },
    {
      path: '/insert',
      label: 'Inserisci Articolo'
    }
  ]

  navigateTo(path: string): void {
    this.route.navigate([path]);
  }
}
