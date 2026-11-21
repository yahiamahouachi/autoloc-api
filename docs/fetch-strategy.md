
# AutoLoc - JPA Fetch and Cascade Strategies

| Association | Fetch | Cascade | Explanation |
|---|---|---|---|
| Contract - Paiement | LAZY | ALL + orphanRemoval | Payments depend on their contract. |
| Agence - Vehicule | LAZY | None | Vehicles survive agency deletion. |
| Agence - Employe | LAZY | None | Employees are managed independently. |
| Vehicule - Equipement | LAZY | None | Equipment can be shared between vehicles. |
| Client - Reservation | LAZY | PERSIST | New reservations can be saved with clients. |
| Reservation - Vehicule | LAZY | None | Vehicles exist independently. |
| Reservation - Contract | LAZY | ALL | Contract belongs to its reservation. |
| Vehicule - Maintenance | LAZY | PERSIST | New maintenance records are saved with vehicles. |

## Fetch Strategies
LAZY loads related data only when needed.
EAGER loads related data automatically.

LAZY is preferred to avoid unnecessary database queries.

## Cascade
PERSIST saves new related entities.
ALL propagates all operations.
orphanRemoval deletes children removed from the parent collection.
