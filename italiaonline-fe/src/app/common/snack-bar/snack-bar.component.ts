import { Component, Inject, inject } from '@angular/core';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snack-bar',
  templateUrl: './snack-bar.component.html',
  styleUrl: './snack-bar.component.css'
})
export class SnackBarComponent {
  snackBarRef = inject(MatSnackBarRef);

  messaggio: string = "";
  constructor(@Inject(MAT_SNACK_BAR_DATA) data: any) {
    this.messaggio = data.messaggio;
  }
}