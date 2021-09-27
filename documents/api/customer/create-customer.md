# Create Customer

Creates a new Customer.

**URL** : `/api/customers`

**Method** : `POST`

**Sample Request Body**

```json
{
  "customerName": "Harun Murat Bulut",
  "customerPhoneNumber": "05310123456",
  "customerSalary": 5000,
  "ssid": 12345678904
}
```

## Success Response

**Code** : `200`

**Sample Response Body** :

```json
{
  "ssid": 12345678904,
  "customerName": "Harun Murat Bulut",
  "customerSalary": 5000,
  "customerPhoneNumber": "05310123456",
  "creditRequestResponse": []
}
```

## Error Responses

**Code** : `400`

**Sample Response Body** :
```json
{
  "status": 400,
  "message": "Customer with SSID : 12345678902 is already exists!",
  "timestamp": 1632755663875
}
```
