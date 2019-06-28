import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Quete } from './quete';
import { MessageService } from './message.service';
 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class QueteService {
  private quetesUrl = 'api/quetes'; 

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
 
  getQuetes(): Observable<Quete[]> {
    return this.http.get<Quete[]>(this.quetesUrl)
      .pipe(
        tap(_ => this.log('fetched quetes')),
        catchError(this.handleError<Quete[]>('getQuetes', []))
      );
  }

  getQueteNo404<Data>(idQuete: number): Observable<Quete> {
    const url = `${this.quetesUrl}/?idQuete=${idQuete}`;
    return this.http.get<Quete[]>(url)
      .pipe(
        map(quetes => quetes[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} quete iQuete=${idQuete}`);
        }),
        catchError(this.handleError<Quete>(`getQuete idQuete=${idQuete}`))
      );
  }

  getQuete(idQuete: number): Observable<Quete> {
    const url = `${this.quetesUrl}/${idQuete}`;
    return this.http.get<Quete>(url).pipe(
      tap(_ => this.log(`fetched quete idQuete=${idQuete}`)),
      catchError(this.handleError<Quete>(`getQuete idQuete=${idQuete}`))
    );
  }
 
  /* GET quetes whose name contains search term */
  searchQuetes(term: string): Observable<Quete[]> {
    if (!term.trim()) {
      // if not search term, return empty quete array.
      return of([]);
    }
    return this.http.get<Quete[]>(`${this.quetesUrl}/?nameQuete=${term}`).pipe(
      tap(_ => this.log(`found quetes matching "${term}"`)),
      catchError(this.handleError<Quete[]>('searchQuetes', []))
    );
  }
 
  //////// Save methods //////////
 
  /** POST: add a new quete to the server */
  addQuete (quete: Quete): Observable<Quete> {
    return this.http.post<Quete>(this.quetesUrl, quete, httpOptions).pipe(
      tap((newQuete: Quete) => this.log(`added quete w/ idQuete=${newQuete.idQuete}`)),
      catchError(this.handleError<Quete>('addQuete'))
    );
  }
 
  /** DELETE: delete the quete from the server */
  deleteQuete (quete: Quete | number): Observable<Quete> {
    const idQuete = typeof quete === 'number' ? quete : quete.idQuete;
    const url = `${this.quetesUrl}/${idQuete}`;
 
    return this.http.delete<Quete>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted quete idQuete=${idQuete}`)),
      catchError(this.handleError<Quete>('deleteQuete'))
    );
  }
 
  /** PUT: update the quete on the server */
  updateQuete (quete: Quete): Observable<any> {
    return this.http.put(this.quetesUrl, quete, httpOptions).pipe(
      tap(_ => this.log(`updated quete idQuete=${quete.idQuete}`)),
      catchError(this.handleError<any>('updateQuete'))
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
 
  /** Log a QueteService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`QueteService: ${message}`);
  }
}