# Delete Customer

Delete a Customer.

**URL** : `/api/customers`

**Method** : `DELETE`

**Request URL** : `/api/customers/{ssid}`


## Success Response

**Code** : `200`

**Sample Response Body** :

```
Customer with 12345678904 SSID deleted
```

## Error Responses

**Code** : `500`

**Sample Response Body** :
```json
{
  "timestamp": "2021-09-27T15:24:44.612+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "No class dev.patika.creditscorecalculator.entity.Customer entity with id 12345678904 exists!",
  "path": "/api/customers/12345678904"
}
```
