# Show Customers

Returns a list of Customers.

**URL** : `/api/customers`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/customers`

**Sample Response Body** :

```json
{
    [
      {
        "ssid": 24523621888,
        "customerName": "Bulut",
        "customerSalary": 5000.0,
        "customerPhoneNumber": "5555555555",
        "creditRequestResponse": [
          {
            "id": 44,
            "creditResponseType": "Approve",
            "creditLimit": 20000.0
          },
          {
            "id": 45,
            "creditResponseType": "Approve",
            "creditLimit": 20000.0
          }
        ]
      },
      {
        "ssid": 12345678902,
        "customerName": "Murat",
        "customerSalary": 10000.0,
        "customerPhoneNumber": "53122244466",
        "creditRequestResponse": [
          {
            "id": 43,
            "creditResponseType": "Approve",
            "creditLimit": 20000.0
          }
        ]
      }
    ]
}
```