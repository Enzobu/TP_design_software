# TP DRY - Reponse aux questions

## 1) Avis sur la qualite du code de depart

Le code de depart fonctionnait, mais il ne respectait pas le DRY.
La formule `price * quantity` et le calcul de taxe étaient répétés dans plusieurs routes du controleur.
Ce type de duplication augmente le risque d'incoherence lors des evolutions.

## 2) Si la taxe ou la formule change, que se passe-t-il ?

Dans la version de depart, il fallait modifier plusieurs methodes.
Concretement, un changement de taux (ex: 5% -> 6%) pouvait obliger a toucher plusieurs endroits, avec risque d'oublier un cas (`warrior`, `rogue`, etc.).
Ce n'est pas maintenable.

## 3) Refactoring propose pour rendre le code maintenable

Refactoring applique:

- extraction de la logique metier vers `service/PaymentService.java`,
- centralisation de la formule de base dans `calculateBase`,
- centralisation de la taxe standard dans `calculateTax`,
- conservation des 3 routes et de leurs regles metier specifiques.

Resultat: le controleur ne contient plus de calcul en dur et la logique.

## 4) Fichiers de la solution finale et justification

- `controller/PaymentController.java` : exposition des routes HTTP, sans logique metier
- `service/PaymentService.java` : regles de calcul
- `model/PaymentRequest.java` : DTO de requete partage par les 3 routes

## 5) Verifications attendues

- La formule `price * quantity` apparait une seule fois (dans `PaymentService`).
- Le taux de taxe est centralise dans `KING_TAX_RATE`.
- Les routes retournent les memes resultats metier:
  - `/warrior` -> base + taxe + surcharge,
  - `/mage` -> base sans taxe,
  - `/rogue` -> base + taxe.
