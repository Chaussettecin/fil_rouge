import { Component, OnInit } from '@angular/core';
 
import { Observable, Subject } from 'rxjs';
 
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';
 
import { Quete } from '../quete';
import { QueteService } from '../quete.service';
 
@Component({
  selector: 'app-quete-search',
  templateUrl: './quete-search.component.html',
  styleUrls: [ './quete-search.component.css' ]
})
export class QueteSearchComponent implements OnInit {
  quetes$: Observable<Quete[]>;
  private searchTerms = new Subject<string>();
 
  constructor(private queteService: QueteService) {}
 
  // Sélectionne les propositions correspondant à une partie des caractères saisis.
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.quetes$ = this.searchTerms.pipe(
      // attente de 300ms après chaque frappe au clavier pour rafraichir les propositions
      debounceTime(300),
 
      // ne pas rafraichir les propositions si la recherche est la même que précédemment
      distinctUntilChanged(),
 
      // Rafraichir les propositions à chaque nouvelle recherche
      switchMap((term: string) => this.queteService.searchQuetes(term)),
    );
  }
}
