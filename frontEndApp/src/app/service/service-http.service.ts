import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Excursie } from '../interface/excursie';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ServiceHttpService {

  private URI: string = 'http://localhost:8080/excursie';

  constructor(private http: HttpClient) { }

  getAll() : Observable<Excursie[]> {
    return this.http.get<Excursie[]>(this.URI);
  }

  getById(id: string) : Observable<Excursie> {
    return this.http.get<Excursie>(this.URI + '/' + id);
  }

  createExcursie(excursie: Excursie): Observable<Excursie> {
    return this.http.post<Excursie>(this.URI, excursie);
  }

  updateExcursie(excursie: Excursie): Observable<Excursie> {
    const url = `${this.URI}/${excursie.id}`;
    return this.http.put<Excursie>(url, excursie);
  }

  deleteExcursie(id: string): Observable<void> {
    const url = `${this.URI}/${id}`;
    return this.http.delete<void>(url);
  }

  filterExcursie(obiectiv: string, ora: string): Observable<Excursie[]> {
    const url = `${this.URI}/filter`;
    const params = new HttpParams().set('obiectiv', obiectiv).set('ora', ora);
  
    return this.http.get<Excursie[]>(url, { params });
  }

}
