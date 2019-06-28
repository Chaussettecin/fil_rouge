import { InMemoryDbService } from 'angular-in-memory-web-api';
import {Compte} from './compte';
import {Personnage} from './personnage';
import {Ennemi} from './ennemi';
import {Equipement} from './equipement';
import {Quete} from './quete';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class InMemoryDataService implements InMemoryDbService {
  
  createDb() {
    const comptes = [
      { idCompte: 1, nameCompte: 'Dr Nice', firstNameCompte: 'Arthur', loginCompte: 'xote', mailCompte:'xote1@oo.fr', actifCompte:'TRUE', dateCreationCompte:'10/12/2018' },
      { idCompte: 2, nameCompte: 'Narco', firstNameCompte: 'Xavier', loginCompte: 'volo', mailCompte:'xote2@oo.fr', actifCompte:'TRUE', dateCreationCompte:'06/12/2018' },
      { idCompte: 3, nameCompte: 'Bombasto', firstNameCompte: 'Léa', loginCompte: 'lea', mailCompte:'xote3@oo.fr', actifCompte:'TRUE', dateCreationCompte:'10/11/2018' },
      { idCompte: 4, nameCompte: 'Celeritas', firstNameCompte: 'Thibaut', loginCompte: 'Boti', mailCompte:'xote4@oo.fr', actifCompte:'TRUE', dateCreationCompte:'17/05/2018' },
      { idCompte: 5, nameCompte: 'Magneta', firstNameCompte: 'Léo', loginCompte: 'lolo', mailCompte:'xote5@oo.fr', actifCompte:'TRUE', dateCreationCompte:'18/10/2017' },
      { idCompte: 6, nameCompte: 'RubberMan', firstNameCompte: 'Anne', loginCompte: 'Nini', mailCompte:'xote6@oo.fr', actifCompte:'TRUE', dateCreationCompte:'15/08/2018' },
      { idCompte: 7, nameCompte: 'Dynama', firstNameCompte: 'Eva', loginCompte: 'Eva', mailCompte:'xote7@oo.fr', actifCompte:'TRUE', dateCreationCompte:'22/02/2018' },
      { idCompte: 8, nameCompte: 'Dr IQ', firstNameCompte: 'Carl', loginCompte: 'K', mailCompte:'xote8@oo.fr', actifCompte:'FALSE', dateCreationCompte:'06/09/2018' },
      { idCompte: 9, nameCompte: 'Magma', firstNameCompte: 'Nino', loginCompte: 'Carlo', mailCompte:'xote9@oo.fr', actifCompte:'TRUE', dateCreationCompte:'30/12/2018' },
      { idCompte: 10, nameCompte: 'Tornado', firstNameCompte: 'Mo', loginCompte: 'Momo', mailCompte:'xote10@oo.fr', actifCompte:'TRUE', dateCreationCompte:'28/01/2019' }
    ];

    return {comptes};
  }

  createDbPersonnages() {
    const personnages = [
      { idPersonnage: 1, namePersonnage: 'Dr Nice' },
      { idPersonnage: 2, namePersonnage: 'Narco' },
      { idPersonnage: 3, namePersonnage: 'Bombasto' },
      { idPersonnage: 4, namePersonnage: 'Celeritas' },
      { idPersonnage: 5, namePersonnage: 'Magneta' },
      { idPersonnage: 6, namePersonnage: 'RubberMan' },
      { idPersonnage: 7, namePersonnage: 'Dynama' },
      { idPersonnage: 8, namePersonnage: 'Dr IQ' },
      { idPersonnage: 9, namePersonnage: 'Magma' },
      { idPersonnage: 10, namePersonnage: 'Tornado' }
    ];
    
    return {personnages};
  }

  createDbEnnemis() {
    const ennemis = [
      { idEnnemi: 1, nameEnnemi: 'Dr Nice' },
      { idEnnemi: 2, nameEnnemi: 'Narco' },
      { idEnnemi: 3, nameEnnemi: 'Bombasto' },
      { idEnnemi: 4, nameEnnemi: 'Celeritas' },
      { idEnnemi: 5, nameEnnemi: 'Magneta' },
      { idEnnemi: 6, nameEnnemi: 'RubberMan' },
      { idEnnemi: 7, nameEnnemi: 'Dynama' },
      { idEnnemi: 8, nameEnnemi: 'Dr IQ' },
      { idEnnemi: 9, nameEnnemi: 'Magma' },
      { idEnnemi: 10, nameEnnemi: 'Tornado' }
    ];
    
    return {ennemis};
  }
 
  createDbEquipements() {
    const equipements = [
      { idEquipement: 1, nameEquipement: 'Dr Nice' },
      { idEquipement: 2, nameEquipement: 'Narco' },
      { idEquipement: 3, nameEquipement: 'Bombasto' },
      { idEquipement: 4, nameEquipement: 'Celeritas' },
      { idEquipement: 5, nameEquipement: 'Magneta' },
      { idEquipement: 6, nameEquipement: 'RubberMan' },
      { idEquipement: 7, nameEquipement: 'Dynama' },
      { idEquipement: 8, nameEquipement: 'Dr IQ' },
      { idEquipement: 9, nameEquipement: 'Magma' },
      { idEquipement: 10, nameEquipement: 'Tornado' }
    ];
    
    return {equipements};
  }

  createDbQuetes() {
    const quetes = [
      { idQuete: 1, nameQuete: 'Dr Nice' },
      { idQuete: 2, nameQuete: 'Narco' },
      { idQuete: 3, nameQuete: 'Bombasto' },
      { idQuete: 4, nameQuete: 'Celeritas' },
      { idQuete: 5, nameQuete: 'Magneta' },
      { idQuete: 6, nameQuete: 'RubberMan' },
      { idQuete: 7, nameQuete: 'Dynama' },
      { idQuete: 8, nameQuete: 'Dr IQ' },
      { idQuete: 9, nameQuete: 'Magma' },
      { idQuete: 10, nameQuete: 'Tornado' }
    ];
    
    return {quetes};
  }
  
  genIdCompte(comptes: Compte[]): number {
    return comptes.length > 0 ? Math.max(...comptes.map(compte => compte.idCompte)) + 1 : 1;
  }

  genIdPersonnage(personnages: Personnage[]): number {
    return personnages.length > 0 ? Math.max(...personnages.map(personnage => personnage.idPersonnage)) + 1 : 1;
  }

  genIdEnnemi(ennemis: Ennemi[]): number {
    return ennemis.length > 0 ? Math.max(...ennemis.map(ennemi => ennemi.idEnnemi)) + 1 : 1;
  }

  genIdEquipement(equipements: Equipement[]): number {
    return equipements.length > 0 ? Math.max(...equipements.map(equipement => equipement.idEquipement)) + 1 : 1;
  }

  genIdQuete(quetes: Quete[]): number {
    return quetes.length > 0 ? Math.max(...quetes.map(quete => quete.idQuete)) + 1 : 1;
  }
}
