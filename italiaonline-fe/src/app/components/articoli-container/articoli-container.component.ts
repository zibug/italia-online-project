import { Component } from '@angular/core';
import { ArticoliService } from '../../service/articoli.service';
import { Articolo, ArticoloModel } from '../../model/Articolo.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarComponent } from '../../common/snack-bar/snack-bar.component';

@Component({
  selector: 'app-articoli-container',
  templateUrl: './articoli-container.component.html',
  styleUrl: './articoli-container.component.css'
})
export class ArticoliContainerComponent {

  listaArticoli: ArticoloModel[] | null = null;

  constructor(private articoloService: ArticoliService, private _snackBar: MatSnackBar) {
    articoloService.getNews().subscribe(response => {
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
}
