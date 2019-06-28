import { Component, OnInit } from '@angular/core';
 
import { Observable, Subject } from 'rxjs';
 
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';
 
import { Personnage } from '../personnage';
import { PersonnageService } from '../personnage.service';
 
@Component({
  selector: 'app-personnage-search',
  templateUrl: './personnage-search.component.html',
  styleUrls: [ './personnage-search.component.css' ]
})
export class PersonnageSearchComponent implements OnInit {
  personnages$: Observable<Personnage[]>;
  private searchTerms = new Subject<string>();
 
  constructor(private personnageService: PersonnageService) {}
 
  // Recherche des propositions 
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.personnages$ = this.searchTerms.pipe(
      // attente de 300ms après chaque frappe au clavier pour modifier les propositions
      debounceTime(300),
 
      // ne pas modifier les propositions si la saisie est la même que la précédente
      distinctUntilChanged(),
 
      // modifier les propositions à chaque nouvelle recherche
      switchMap((term: string) => this.personnageService.searchPersonnages(term)),
    );
  }
}
