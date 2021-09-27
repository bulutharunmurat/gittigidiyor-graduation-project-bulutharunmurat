# Find Credit Responses Of Customer

Returns a list of Credit Responses of Customer.

**URL** : `/api/credit-request/{ssid}`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/credit-request/12345678900`

**Sample Response Body** :

```json
[
  {
    "id": 47,
    "creditResponseType": "Approve",
    "creditLimit": 40000
  },
  {
    "id": 46,
    "creditResponseType": "Approve",
    "creditLimit": 20000
  }
]
```
