import { Component, Inject, inject } from '@angular/core';
import { Articolo, ArticoloModel } from '../../model/Articolo.model';
import { NgForm } from '@angular/forms';
import { ArticoliService } from '../../service/articoli.service';
import { MAT_SNACK_BAR_DATA, MatSnackBar, MatSnackBarLabel, MatSnackBarRef } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { SnackBarComponent } from '../../common/snack-bar/snack-bar.component';

@Component({
  selector: 'app-articoli-insert',
  templateUrl: './articoli-insert.component.html',
  styleUrl: './articoli-insert.component.css'
})
export class ArticoliInsertComponent {
  daAggiungere: ArticoloModel = new ArticoloModel();
  
  constructor(private articoliService: ArticoliService, private _snackBar: MatSnackBar) {

  }

  onSubmit(form: NgForm) {
    if(form.errors != null) {
      return;
    }
    this.articoliService.saveNews(form.value).subscribe((response) => {
      
      this.openSnackBar("Salvataggio avvenuto con successo");
    }, error => {
      this.openSnackBar();
      console.log(error);
    });
  }

  openSnackBar(messaggio: string = "Errore durante l'esecuzione della richiesta") {
    this._snackBar.openFromComponent(SnackBarComponent, {
      duration: 2 * 1000,
      data: {
        messaggio: messaggio
      }
    })
  }
}