# TP SOLID - Reponse aux questions

## 1) Appreciation globale de la base de depart

La base fonctionne, mais elle n'était pas maintenable.
`TavernManager` cumulait trop de responsabilites (stock, prix, regles horaires, notification, endpoints).

## 2) Evaluation principe par principe

- **S (SRP)**: non respecté : Une seule classe faisait plusieurs metiers.
- **O (OCP)**: non respecté : Les regles de prix étaient en `if` dans le controleur.
- **L (LSP)**: non respecté : `PoisonousDrink` levait une exception.
- **I (ISP)**: non respecté : `IItemActions` imposait des méthodes inutiles selon les objets.
- **D (DIP)**: non respecté : Le code dépendait directement d'une implementation concrete avec `new SqlNotificationRepository()`.

## 3) Difficultes d'evolution anticipees (avant refactoring)

Ajouter une règle de prix, changer la persistence ou faire des tests unitaires était couteux.
Chaque changement risquait d'impacter plusieurs parties de la meme classe et de casser des comportements existants.

## 4) Refactoring appliqué

### SRP

- `OrderService` gére le traitement de commande.
- `InventoryService` gére le stock.
- `PricingService` gére le calcul du total.
- `TavernManager` orchestre uniquement les endpoints.

### OCP

- Creation de `PricingRule`.
- Règles séparées: `KingTaxRule`, `NightSurchargeRule`, `WeekendDiscountRule`.
- `PricingService` applique une liste de règles injectées, sans connaitre leurs details.

### LSP

- `PoisonousDrink` retourne `false` dans `isSafeToConsume()` au lieu de lever une exception.

### ISP

- Suppression de `IItemActions`.
- Interfaces ciblées: `ICookable` et `IPourable`.
- Classes d'exemple: `Bread implements ICookable`, `Ale implements IPourable`.

### DIP

- Création de `INotificationRepository`.
- Implémentation `InMemoryNotificationRepository`.
- `OrderService` dépend de l'interface par injection de constructeur.
