# Show Customer

Returns a Customer with specified ssid.

**URL** : `/api/customers`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/customers/24523621888`

**Sample Response Body** :

```json
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
}
```

## Error Responses

**Code** : `404 OK`

**Request URL** : `/api/customer/24523621887`

**Sample Response Body** :

```json
{
    "status": 400,
    "message": "Customer with SSID: 24523621887 could not found!",
    "timestamp": 1632755460318
}
```