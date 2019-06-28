import { Component, OnInit } from '@angular/core';
 
import { Observable, Subject } from 'rxjs';
 
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';
 
import { Equipement } from '../equipement';
import { EquipementService } from '../equipement.service';
 
@Component({
  selector: 'app-equipement-search',
  templateUrl: './equipement-search.component.html',
  styleUrls: [ './equipement-search.component.css' ]
})
export class EquipementSearchComponent implements OnInit {
  equipements$: Observable<Equipement[]>;
  private searchTerms = new Subject<string>();
 
  constructor(private equipementService: EquipementService) {}
 
  // Recherche des propositions a partir d'une partie de l'équipement saisie
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.equipements$ = this.searchTerms.pipe(
      // attente de 300ms après chaque frappe pour modifier les propositions
      debounceTime(300),
 
      // ne pas modifier les propositions si la saisie est la même que précédemment
      distinctUntilChanged(),
 
      // changer les propositions à chaque changement
      switchMap((term: string) => this.equipementService.searchEquipements(term)),
    );
  }
}
