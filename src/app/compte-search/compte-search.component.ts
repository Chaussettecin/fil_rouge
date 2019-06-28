import { Component, OnInit } from '@angular/core';
 
import { Observable, Subject } from 'rxjs';
 
import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';
 
import { Compte } from '../compte';
import { CompteService } from '../compte.service';
 
@Component({
  selector: 'app-compte-search',
  templateUrl: './compte-search.component.html',
  styleUrls: [ './compte-search.component.css' ]
})
export class CompteSearchComponent implements OnInit {
  comptes$: Observable<Compte[]>;
  private searchTerms = new Subject<string>();
 
  constructor(private compteService: CompteService) {}
 
  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.comptes$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),
 
      // ignore new term if same as previous term
      distinctUntilChanged(),
 
      // switch to new search observable each time the term changes
      switchMap((term: string) => this.compteService.searchComptes(term)),
    );
  }
}
