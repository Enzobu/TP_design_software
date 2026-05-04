# TP KISS - Reponse aux questions

## 1) Avis sur l'architecture de depart

L'architecture de depart etait trop complexe pour le besoin reel.
Le besoin metier est simple: calculer un total et appliquer 10% de remise s'il y a au moins un `MEAL` et un `DRINK`.
L'usage de Strategy, Decorator et Factory ajoutait de la complexite accidentelle, sans benefice ici.

## 2) Les fichiers du package etaient-ils justifies ?

### Fichiers utiles (solution finale)

- `controller/TabController.java` : expose l'endpoint `POST /api/tab/calculate`.
- `service/TabCalculationService.java` : contient la logique metier de calcul.
- `model/OrderRequest.java` : represente la requete entrante (liste d'items).
- `model/Item.java` : represente un article (nom, prix, type).
- `model/CalculationResult.java` : represente la reponse (montant calcule).

### Fichiers non justifies pour ce besoin (supprimes)

- `service/ICalculationStrategy.java`
- `service/AbstractOrderCalculatorDecorator.java`
- `service/DiscountStrategyFactory.java`
- `service/AdventurerMenuDiscountDecorator.java`
- `service/BaseOrderCalculator.java`

Ces fichiers introduisaient des couches supplementaires qui ne repondaient pas au besoin actuel.

## 3) Comment je structurerais la solution depuis zero

Structure simple :

- un controleur `TabController` pour l'exposition de l'endpoint,
- un service `TabCalculationService` pour la logique metier,
- trois modeles (`OrderRequest`, `Item`, `CalculationResult`) pour les entrees/sorties.

## 4) Nombre de fichiers Java et justification

Pour le cas KISS de calcul d'addition, la solution finale repose sur **5 fichiers Java** :

1. `controller/TabController.java`
2. `service/TabCalculationService.java`
3. `model/OrderRequest.java`
4. `model/Item.java`
5. `model/CalculationResult.java`

Chaque fichier est necessaire et justifie: un point d'entree HTTP, une classe metier dediee, deux modeles de requete, un modele de reponse.
