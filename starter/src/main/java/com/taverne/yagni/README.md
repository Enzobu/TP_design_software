# TP YAGNI - Reponse aux questions

## 1) Constat global sur le code de depart

Le code de depart contenait beaucoup d'éléments inutile.
Le besoin est : créer et lister des reservations.
Pourtant, il y avait des routes, des champs et des services qui n'étaient pas utilisés.

## 2) Tout etait-il utile et justifie ?

Non.
Exemples de code non justifié pour le besoin actuel:

- routes `/api/reservations/vip` et `/api/reservations/weather-check`,
- champs de réservation non utilisés (`vipTier`, `cryptoCurrency`, etc.),
- interfaces sans implémentation,
- services non reliés a reservation,
- module menu hors scope du besoin.

## 3) Reponse a "plus on anticipe, mieux c'est"

Anticiper trop tôt complique le systeme sans valeur immédiate.
Approche YAGNI: implementer seulement ce qui est attendu dans le besoin.

## 4) Solution finale retenue

Fonctionnalités conservées:

- `POST /api/reservations` : cree une réservation,
- `GET /api/reservations` : liste les réservations en mémoire,
- validation métier: `guestCount` doit être entre 1 et 10, sinon HTTP 400.

Nettoyage appliqué:

- suppression des routes non demandées,
- suppression des champs inutiles de `Reservation`,
- suppression des interfaces/services/classes non utilisés.

## 5) Fichiers Java restants et justification

La solution finale YAGNI repose sur 2 fichiers dans `com.taverne.yagni`:

1. `controller/ReservationController.java`
2. `model/Reservation.java`

Ils sont suffisants pour couvrir le besoin.
