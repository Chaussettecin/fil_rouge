import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Ennemi } from './ennemi';
import { MessageService } from './message.service';
 

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class EnnemiService {
  private ennemisUrl = 'api/ennemis';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
 
  getEnnemis(): Observable<Ennemi[]> {
    return this.http.get<Ennemi[]>(this.ennemisUrl)
    .pipe(
      tap(_ => this.log('fetched ennemis')),
      catchError(this.handleError<Ennemi[]>('getEnnemis', []))
    );
  }

  getHeroNo404<Data>(idEnnemi: number): Observable<Ennemi> {
    const url = `${this.ennemisUrl}/?idEnnemi=${idEnnemi}`;
    return this.http.get<Ennemi[]>(url)
      .pipe(
        map(ennemis => ennemis[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} hero idEnnemi=${idEnnemi}`);
        }),
        catchError(this.handleError<Ennemi>(`getEnnemi idEnnemi=${idEnnemi}`))
      );
  }

  getEnnemi(idEnnemi: number): Observable<Ennemi> {
    const url = `${this.ennemisUrl}/${idEnnemi}`;
    return this.http.get<Ennemi>(url).pipe(
      tap(_ => this.log(`fetched ennemi idEnnemi=${idEnnemi}`)),
      catchError(this.handleError<Ennemi>(`getEnnemi idEnnemi=${idEnnemi}`))
    );
  }
 
  /* GET ennemis whose name contains search term */
  searchEnnemis(term: string): Observable<Ennemi[]> {
    if (!term.trim()) {
      // if not search term, return empty ennemi array.
      return of([]);
    }
    return this.http.get<Ennemi[]>(`${this.ennemisUrl}/?nameEnnemi=${term}`).pipe(
      tap(_ => this.log(`found enemis matching "${term}"`)),
      catchError(this.handleError<Ennemi[]>('searchEnnemis', []))
    );
  }
 
  //////// Save methods //////////
 
  /** POST: add a new ennemi to the server */
  addEnnemi (ennemi: Ennemi): Observable<Ennemi> {
    return this.http.post<Ennemi>(this.ennemisUrl, ennemi, httpOptions).pipe(
      tap((newEnnemi: Ennemi) => this.log(`added ennemi w/ idEnnemi=${newEnnemi.idEnnemi}`)),
      catchError(this.handleError<Ennemi>('addEnnemi'))
    );
  }
 
  /** DELETE: delete the ennemi from the server */
  deleteEnnemi (ennemi: Ennemi | number): Observable<Ennemi> {
    const idEnnemi = typeof ennemi === 'number' ? ennemi : ennemi.idEnnemi;
    const url = `${this.ennemisUrl}/${idEnnemi}`;
 
    return this.http.delete<Ennemi>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted ennemi idEnnemi=${idEnnemi}`)),
      catchError(this.handleError<Ennemi>('deleteEnnemi'))
    );
  }
 
  /** PUT: update the ennemi on the server */
  updateEnnemi (ennemi: Ennemi): Observable<any> {
    return this.http.put(this.ennemisUrl, ennemi, httpOptions).pipe(
      tap(_ => this.log(`updated ennemi idEnnemi=${ennemi.idEnnemi}`)),
      catchError(this.handleError<any>('updateEnnemi'))
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
 
  /** Log a EnnemiService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`EnnemiService: ${message}`);
  }
}