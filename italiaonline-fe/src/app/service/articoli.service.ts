import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticoloModel } from '../model/Articolo.model';

@Injectable({
  providedIn: 'root'
})
export class ArticoliService {

  url: string = 'http://localhost:8080/';

  constructor(private httpClient: HttpClient) { }

  public getNews(): Observable<ArticoloModel[]> {
    return this.httpClient.get<ArticoloModel[]>(`${this.url}news`);
  }

  public getNewsMongo(): Observable<ArticoloModel[]> {
    return this.httpClient.get<ArticoloModel[]>(`${this.url}list`);
  }

  public saveNews(articolo: ArticoloModel): Observable<ArticoloModel> {
    return this.httpClient.post<ArticoloModel>(`${this.url}save`, articolo);
  }

  public filtra(filtro: string): Observable<ArticoloModel[]> {
    return this.httpClient.get<ArticoloModel[]>(`${this.url}list/${filtro}`);
  }
}
