import { Component } from '@angular/core';
import { ArticoliService } from '../../service/articoli.service';
import { ArticoloModel } from '../../model/Articolo.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarComponent } from '../../common/snack-bar/snack-bar.component';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-articoli-mongodb',
  templateUrl: './articoli-mongodb.component.html',
  styleUrl: './articoli-mongodb.component.css'
})
export class ArticoliMongodbComponent {

  listaArticoli: ArticoloModel[] = [];
  filtro: string = "";

  constructor(private articoliService: ArticoliService, private _snackBar: MatSnackBar) {
    articoliService.getNewsMongo().subscribe(response => {
      this.listaArticoli = response;
    }, error => {
      this._snackBar.openFromComponent(SnackBarComponent, {
        duration: 2 * 1000,
        data: {
          messaggio: "Errore durante il caricamento dei dati"
        }
      })
      console.log(error);
    })
  }

  filter(formFilter: NgForm) {
    console.log(formFilter.value.filtro);
    this.articoliService.filtra(formFilter.value.filtro).subscribe(response => {
      this.listaArticoli = response;
    }, error => {
      this._snackBar.openFromComponent(SnackBarComponent, {
        duration: 2 * 1000,
        data: {
          messaggio: "Errore durante il caricamento dei dati"
        }
      })
      console.log(error);
    })
  }

  cancellaFiltro() {
    window.location.reload();
  }
}
