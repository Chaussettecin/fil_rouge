import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Compte } from './compte';
import { MessageService } from './message.service';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private comptesUrl = 'api/comptes';

  constructor(private http: HttpClient,
    private messageService: MessageService) { }
 
  getComptes(): Observable<Compte[]> {
    return this.http.get<Compte[]>(this.comptesUrl)
      .pipe(
        tap(_ => this.log('fetched comptes')),
        catchError(this.handleError<Compte[]>('getComptes', []))
      );
  }
 
  /** GET compte by id. Return `undefined` when id not found */
  getCompteNo404<Data>(idCompte: number): Observable<Compte> {
    const url = `${this.comptesUrl}/?idCompte=${idCompte}`;
    return this.http.get<Compte[]>(url)
      .pipe(
        map(comptes => comptes[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} compte idCompte=${idCompte}`);
        }),
        catchError(this.handleError<Compte>(`getCompte idCompte=${idCompte}`))
      );
  }
 
  /** GET compte by id. Will 404 if id not found */
  getCompte(idCompte: number): Observable<Compte> {
    const url = `${this.comptesUrl}/${idCompte}`;
    return this.http.get<Compte>(url).pipe(
      tap(_ => this.log(`fetched compte idCompte=${idCompte}`)),
      catchError(this.handleError<Compte>(`getCompte idCompte=${idCompte}`))
    );
  }
 
  /* GET comptes whose name contains search term */
  searchComptes(term: string): Observable<Compte[]> {
    if (!term.trim()) {
      // if not search term, return empty compte array.
      return of([]);
    }
    return this.http.get<Compte[]>(`${this.comptesUrl}/?nameCompte=${term}`).pipe(
      tap(_ => this.log(`found comptes matching "${term}"`)),
      catchError(this.handleError<Compte[]>('searchComptes', []))
    );
  }
 
  //////// Save methods //////////
 
  /** POST: add a new compte to the server */
  addCompte (compte: Compte): Observable<Compte> {
    return this.http.post<Compte>(this.comptesUrl, compte, httpOptions).pipe(
      tap((newCompte: Compte) => this.log(`added compte w/ idCompte=${newCompte.idCompte}`)),
      catchError(this.handleError<Compte>('addCompte'))
    );
  }
 
  /** DELETE: delete the compte from the server */
  deleteCompte (compte: Compte | number): Observable<Compte> {
    const idCompte = typeof compte === 'number' ? compte : compte.idCompte;
    const url = `${this.comptesUrl}/${idCompte}`;
 
    return this.http.delete<Compte>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted compte idCompte=${idCompte}`)),
      catchError(this.handleError<Compte>('deleteCompte'))
    );
  }
 
  /** PUT: update the compte on the server */
  updateCompte (compte: Compte): Observable<any> {
    return this.http.put(this.comptesUrl, compte, httpOptions).pipe(
      tap(_ => this.log(`updated compte idCompte=${compte.idCompte}`)),
      catchError(this.handleError<any>('updateCompte'))
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
 
  /** Log a CompteService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`CompteService: ${message}`);
  }
}
