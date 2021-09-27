# Update Customer

Updates a Customer.

**URL** : `/api/customers`

**Method** : `PUT`

**Sample Request Body**

```json
{
  "customerName": "Harun Murat Bulut",
  "customerPhoneNumber": "05310123456",
  "customerSalary": 6000,
  "ssid": 12345678902
}
```

## Success Response

**Code** : `200`

**Sample Response Body** :

```json
{
  "ssid": 12345678902,
  "customerName": "Harun Murat Bulut",
  "customerSalary": 6000,
  "customerPhoneNumber": "05310123456",
  "creditRequestResponse": []
}
```

