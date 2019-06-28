import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Personnage } from './personnage';
import { MessageService } from './message.service';
 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class PersonnageService {
  private personnagesUrl = 'api/personnages';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
 
  getPersonnages(): Observable<Personnage[]> {
    return this.http.get<Personnage[]>(this.personnagesUrl)
      .pipe(
        tap(_ => this.log('fetched personnages')),
        catchError(this.handleError<Personnage[]>('getPersonnages', []))
      );
  }

  getPersonnageNo404<Data>(idPersonnage: number): Observable<Personnage> {
    const url = `${this.personnagesUrl}/?id=${idPersonnage}`;
    return this.http.get<Personnage[]>(url)
      .pipe(
        map(personnages => personnages[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} personnage idPersonnage=${idPersonnage}`);
        }),
        catchError(this.handleError<Personnage>(`getPersonnage idPersonnage=${idPersonnage}`))
      );
  }
  getPersonnage(idPersonnage: number): Observable<Personnage> {
    const url = `${this.personnagesUrl}/${idPersonnage}`;
    return this.http.get<Personnage>(url).pipe(
      tap(_ => this.log(`fetched personnage idPersonnage=${idPersonnage}`)),
      catchError(this.handleError<Personnage>(`getPersonnage idPersonnage=${idPersonnage}`))
    );
  }
 
  /* GET heroes whose name contains search term */
  searchPersonnages(term: string): Observable<Personnage[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Personnage[]>(`${this.personnagesUrl}/?namePersonnage=${term}`).pipe(
      tap(_ => this.log(`found personnages matching "${term}"`)),
      catchError(this.handleError<Personnage[]>('searchPersonnages', []))
    );
  }
 
  //////// Save methods //////////
 
  /** POST: add a new personnage to the server */
  addPersonnage (personnage: Personnage): Observable<Personnage> {
    return this.http.post<Personnage>(this.personnagesUrl, personnage, httpOptions).pipe(
      tap((newPersonnage: Personnage) => this.log(`added personnage w/ idPersonnage=${newPersonnage.idPersonnage}`)),
      catchError(this.handleError<Personnage>('addPersonnage'))
    );
  }
 
  /** DELETE: delete the personnage from the server */
  deletePersonnage (personnage: Personnage | number): Observable<Personnage> {
    const idPersonnage = typeof personnage === 'number' ? personnage : personnage.idPersonnage;
    const url = `${this.personnagesUrl}/${idPersonnage}`;
 
    return this.http.delete<Personnage>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted personnage idPersonnage=${idPersonnage}`)),
      catchError(this.handleError<Personnage>('deletePersonnage'))
    );
  }
 
  /** PUT: update the personnage on the server */
  updatePersonnage (personnage: Personnage): Observable<any> {
    return this.http.put(this.personnagesUrl, personnage, httpOptions).pipe(
      tap(_ => this.log(`updated personnage idPersonnage=${personnage.idPersonnage}`)),
      catchError(this.handleError<any>('updatePersonnage'))
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
    this.messageService.add(`PersonnageService: ${message}`);
  }
}