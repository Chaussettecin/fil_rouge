import { Component, OnInit } from '@angular/core';
 
import { Observable, Subject } from 'rxjs';
 
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';
 
import { Ennemi } from '../ennemi';
import { EnnemiService } from '../ennemi.service';
 
@Component({
  selector: 'app-ennemi-search',
  templateUrl: './ennemi-search.component.html',
  styleUrls: [ './ennemi-search.component.css' ]
})
export class EnnemiSearchComponent implements OnInit {
  ennemis$: Observable<Ennemi[]>;
  private searchTerms = new Subject<string>();
 
  constructor(private ennemiService: EnnemiService) {}
 
  // Recherche d'une partie du nom de l'ennemi
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.ennemis$ = this.searchTerms.pipe(
      // attente de 300ms après chaque frappe pour actualiser les propositions
      debounceTime(300),
 
      // la recherche ne se relance pas si le terme frappé est le même que le précédent
      distinctUntilChanged(),
 
      // change les propositions a chaque fois que la recherche est modifiée
      switchMap((term: string) => this.ennemiService.searchEnnemis(term)),
    );
  }
}
