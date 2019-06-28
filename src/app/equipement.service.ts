import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Equipement } from './equipement';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class EquipementService {
  private equipementsUrl = 'api/equipements';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
 
  getEquipements(): Observable<Equipement[]> {
    return this.http.get<Equipement[]>(this.equipementsUrl)
      .pipe(
        tap(_ => this.log('fetched equipements')),
        catchError(this.handleError<Equipement[]>('getEquipements', []))
      );
  }

  getEquipementNo404<Data>(idEquipement: number): Observable<Equipement> {
    const url = `${this.equipementsUrl}/?idEquipement=${idEquipement}`;
    return this.http.get<Equipement[]>(url)
      .pipe(
        map(equipements => equipements[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} equipement idEquipement=${idEquipement}`);
        }),
        catchError(this.handleError<Equipement>(`getEquipement idEquipement=${idEquipement}`))
      );
  }

  getEquipement(idEquipement: number): Observable<Equipement> {
    const url = `${this.equipementsUrl}/${idEquipement}`;
    return this.http.get<Equipement>(url).pipe(
      tap(_ => this.log(`fetched equipement idEquipement=${idEquipement}`)),
      catchError(this.handleError<Equipement>(`getEquipement idEquipement=${idEquipement}`))
    );
  }
 
  /* GET equipements whose name contains search term */
  searchEquipements(term: string): Observable<Equipement[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Equipement[]>(`${this.equipementsUrl}/?nameEquipement=${term}`).pipe(
      tap(_ => this.log(`found equipements matching "${term}"`)),
      catchError(this.handleError<Equipement[]>('searchEquipements', []))
    );
  }
 
  //////// Save methods //////////
 
  /** POST: add a new equipement to the server */
  addEquipement (equipement: Equipement): Observable<Equipement> {
    return this.http.post<Equipement>(this.equipementsUrl, equipement, httpOptions).pipe(
      tap((newEquipement: Equipement) => this.log(`added equipement w/ idEquipement=${newEquipement.idEquipement}`)),
      catchError(this.handleError<Equipement>('addEquipement'))
    );
  }
 
  /** DELETE: delete the equipement from the server */
  deleteEquipement (equipement: Equipement | number): Observable<Equipement> {
    const idEquipement = typeof equipement === 'number' ? equipement : equipement.idEquipement;
    const url = `${this.equipementsUrl}/${idEquipement}`;
 
    return this.http.delete<Equipement>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted equipement idEquipement=${idEquipement}`)),
      catchError(this.handleError<Equipement>('deleteEquipement'))
    );
  }
 
  /** PUT: update the equipement on the server */
  updateEquipement (equipement: Equipement): Observable<any> {
    return this.http.put(this.equipementsUrl, equipement, httpOptions).pipe(
      tap(_ => this.log(`updated equipement idEquipement=${equipement.idEquipement}`)),
      catchError(this.handleError<any>('updateEquipement'))
    );
  }
 
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
 
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
 
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
 
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
 
  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`EquipementService: ${message}`);
  }
}