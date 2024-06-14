import { Component, Input } from '@angular/core';
import { ArticoloModel } from '../../model/Articolo.model';

@Component({
  selector: 'app-articoli-table',
  templateUrl: './articoli-table.component.html',
  styleUrl: './articoli-table.component.css'
})
export class ArticoliTableComponent {
  imgPath: string = '../../../assets/loading.gif';
  displayedColumns: string[] = ['title', 'url', 'publishDate', 'source'];
  @Input() listaArticoli: ArticoloModel[] | null = null;
}
